package com.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.entities.Student;
import com.entities.StudentCourse;
import com.utils.DatabaseUtils;
public class StudentCourseImport {
  

public void importStudentCourse(String srcPath) throws ClassNotFoundException, SQLException {
	 List<StudentCourse> listOfStudentCourse = new ArrayList<>();
	 StudentCourseDao studentCourseDao = new StudentCourseDao();
	 TeacherDao teacherDao = new TeacherDao();
	 CourseDao courseDao = new CourseDao();
	 StudentDao studentDao = new StudentDao();
	 
	String courseId;
	 String courseName;
	String teacherName;
   try {
      FileInputStream excelFile = new FileInputStream(new File(srcPath));
      Workbook workbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(0);
      DataFormatter fmt = new DataFormatter();
      Iterator<Row> iterator = datatypeSheet.iterator();
      
      Row teacherNameRow = datatypeSheet.getRow(6);
      Row courseNameRow = datatypeSheet.getRow(9);
      Row courseIdRow = datatypeSheet.getRow(8);
      Row firstRowOfTable = datatypeSheet.getRow(10);
      Cell teacherIdCell = teacherNameRow.getCell(4);
      Cell courseNameCell = courseNameRow.getCell(2);
      Cell courseIdCell = courseIdRow.getCell(2);
     
      teacherName = teacherIdCell.getStringCellValue();
      courseId = courseIdCell.getStringCellValue();
      courseName = courseNameCell.getStringCellValue();
      int teacherId = teacherDao.getIdByUserName(teacherName);
      System.out.println("Ten giang vien:"+ teacherName);
      System.out.println("Ma mon hoc:"+courseId);
      System.out.println("Mon hoc:"+courseName);
      List<StudentCourse> listOfStudentCourse1 = new ArrayList<>();   
      boolean x = false;
      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
    	 // Row currentRow  = datatypeSheet.getRow(z+11);
        if(!x) {
        for(int i=0;i<10;i++) {
        	currentRow = iterator.next();
        	System.out.println(x);
        	System.out.println(fmt.formatCellValue(currentRow.getCell(0)));
        	
        }
        x=true;
        System.out.println("ket thuc");
        }
        
        if(fmt.formatCellValue(currentRow.getCell(0)).equals("")) break;
        StudentCourse studentCourse = new StudentCourse(); 
        studentCourse.setStudentCourseId((Integer.parseInt(fmt.formatCellValue(currentRow.getCell(0)))));      
        studentCourse.setCourseId(courseIdCell.getStringCellValue());
        studentCourse.setStudentId(studentDao.getIdNameByStudentName((fmt.formatCellValue(currentRow.getCell(1)))));
        
        listOfStudentCourse1.add(studentCourse);        
        
      }
      courseDao.insertCourse(courseId, courseName, teacherId);
      //chu y toi cai nay
      for (StudentCourse studentCourse : listOfStudentCourse1) {
        if(studentCourseDao.checkNameStudentCourse(studentCourse.getCourseId(),studentCourse.getStudentId())) {
    	  System.out.println(studentCourse.getCourseId() +" "+ 	studentCourse.getStudentId());
        studentCourseDao.insertStudentCourse(studentCourse.getCourseId(),studentCourse.getStudentId());
        
        }
      }    
      
      
      
      System.out.println("\n");
      System.out.println(listOfStudentCourse1.size()); 
      
      workbook.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

	

public int getNumberStudent(String courseId) throws ClassNotFoundException, IOException, SQLException{
	  List<Student> listStudent = new ArrayList<>();
	  Connection connection = DatabaseUtils.getConnection();
	    String sql = "SELECT count(*) FROM studentcourse where course_id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   
	    
	    preparedStatement.setString(1,courseId);
		   ResultSet resultSet = preparedStatement.executeQuery();
		   try {
			      if (resultSet.next()) {
			        return resultSet.getInt(1);
			      }
			      return 0;
			    } finally {
			      DatabaseUtils.closeConnection(connection);
			    }
	
	    
	
}


  public static void main(String[] args) {
	StudentCourseImport st = new StudentCourseImport();
	try {
		String src = "D:\\classsurvey\\INT3305.xlsx";
		st.importStudentCourse(src);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
