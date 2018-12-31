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



import com.entities.Teacher;
public class TeacherImport {
	public void importTeacher(String srcPath) throws ClassNotFoundException, SQLException {
		TeacherDao teacherDao = new TeacherDao();
		
	    try {
	      FileInputStream excelFile = new FileInputStream(new File(srcPath));
	      Workbook workbook = new XSSFWorkbook(excelFile);
	      Sheet datatypeSheet = workbook.getSheetAt(0);
	      DataFormatter fmt = new DataFormatter();
	      Iterator<Row> iterator = datatypeSheet.iterator();
	      Row firstRow = iterator.next();
	      Cell firstCell = firstRow.getCell(0);
	      System.out.println(firstCell.getStringCellValue());
	      List<Teacher> listOfTeacher = new ArrayList<Teacher>();
	      
	      while (iterator.hasNext()) {
	        Row currentRow = iterator.next();
	        if(fmt.formatCellValue(currentRow.getCell(0)).equals("")) {break;}
	        Teacher teacher = new Teacher(); 
	        teacher.setId(1);
	       // teacher.setId(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(0)))); 
	        teacher.setUserName(fmt.formatCellValue(currentRow.getCell(1)));
	        teacher.setPassWord(fmt.formatCellValue(currentRow.getCell(2)));
	        teacher.setFullName(fmt.formatCellValue(currentRow.getCell(3)));
	        teacher.setEmail(fmt.formatCellValue(currentRow.getCell(4)));
	        listOfTeacher.add(teacher);
	      }
	      for (Teacher teacher : listOfTeacher) {
	        if(teacherDao.checkName(teacher.getUserName())) {
	    	  System.out.println(teacher.getId() +" "+ 	teacher.getUserName() +"  "+teacher.getPassWord()+"  "+teacher.getFullName()+"  "+teacher.getEmail());
	    	  teacherDao.insertTeacher(teacher.getUserName(),teacher.getPassWord(),teacher.getFullName(),teacher.getEmail());
	        }
	      }
	      
	      System.out.println("\n");
	      System.out.println(listOfTeacher.size());
	    
	      workbook.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		
		
	}
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 
  }
}
