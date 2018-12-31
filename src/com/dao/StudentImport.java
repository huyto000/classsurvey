package com.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class StudentImport {
  public void importStudent(String srcPath) throws ClassNotFoundException, SQLException {
	 StudentDao studentDao = new StudentDao();
	
    try {
      FileInputStream excelFile = new FileInputStream(new File(srcPath));
      Workbook workbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(0);
      DataFormatter fmt = new DataFormatter();
      Iterator<Row> iterator = datatypeSheet.iterator();
      Row firstRow = iterator.next();
      Cell firstCell = firstRow.getCell(0);
      System.out.println(firstCell.getStringCellValue());
      List<Student> listOfStudent = new ArrayList<Student>();   
      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        Student student = new Student(); 
        student.setId(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(0))));      
        student.setUserName(fmt.formatCellValue(currentRow.getCell(1)));
        student.setPassWord(fmt.formatCellValue(currentRow.getCell(2)));
        student.setFullName(fmt.formatCellValue(currentRow.getCell(3)));
        student.setEmail(fmt.formatCellValue(currentRow.getCell(4)));
        student.setClassName(fmt.formatCellValue(currentRow.getCell(5)));
        listOfStudent. add(student);        
      }
      for (Student student : listOfStudent) {
        if(studentDao.checkName(studentDao.getUserNameByStudentId(student.getId()))) {
    	  System.out.println(student.getId() +" "+ 	student.getUserName() +"  "+student.getPassWord()+"  "+student.getFullName()+"  "+student.getEmail()+"  "+student.getClassName());
        studentDao.insertStudent(student.getUserName(),student.getPassWord(),student.getFullName(),student.getEmail(),student.getClassName());
        
        }
      }     
      System.out.println("\n");
      System.out.println(listOfStudent.size()); 
      workbook.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
	StudentImport st = new StudentImport();
	try {
		String src = "D:\\classsurvey\\ds_tai_khoan_sinh_vien.xlsx";
		st.importStudent(src);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
