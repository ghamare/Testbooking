package TestScript;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class Executeclock {
	
@Test
	public void leadtest() throws Exception{
	
		ArrayList data = new ArrayList();
		keywords key = new keywords();
	
		FileInputStream file = new FileInputStream("D://Test cases//Clickify.xlsx");	
	
	XSSFWorkbook wbks = new XSSFWorkbook(file);
	XSSFSheet s = wbks.getSheet("Sheet1");
	
	DataFormatter formatter = new DataFormatter(); 
	
	Iterator row = s.iterator();
	while(row.hasNext()){
	Row rowitr= (Row)row.next();	
	
	Iterator cellitr =rowitr.cellIterator();
	while(cellitr.hasNext()){
	Cell cell1 = (Cell)cellitr.next();	
	String val = "";  
	
	switch(cell1.getCellType()){
	
	case STRING:
			
			data.add(cell1.getStringCellValue());
			
			break;
	case NUMERIC:
		
		data.add(cell1.getNumericCellValue());
		
//	case BOOLEAN:
			
//			data.add(cell1.getBooleanCellValue());
			
	System.out.println(data);
	
	}
	}
	}
	
	
	for(int i=0;i<data.size();i++){
	if(data.get(i).equals("openbrowser")){	
		String keyword =(String) data.get(i);
		String testdata = (String) data.get(i+1);
		String objectName = (String) data.get(i+2);
		System.out.println(keyword);
		System.out.println(testdata);
		System.out.println(objectName);
		key.openbrowser();
	}
	
	if (data.get(i).equals("navigate")){
	String keyword = (String)data.get(i);
	String testdata = (String)data.get(i+1);
	String objectName = (String)data.get(i+2);
	System.out.println(keyword);
	System.out.println(testdata);	
	System.out.println(objectName);
	key.navigate(testdata);
	}
	
	if(data.get(i).equals("input")){
	String keyword = (String)data.get(i);
	String testdata = (String)data.get(i+1);
	String objectName = (String)data.get(i+2);
	System.out.println(keyword);
	System.out.println(testdata);
	System.out.println(objectName);
	key.input(testdata,objectName);
	}
	
	if (data.get(i).equals("click")){
	String keyword = (String)data.get(i);
	String testData = (String)data.get(i+1);
	String objectName = (String)data.get(i+2);
	System.out.println(keyword);
	System.out.println(testData);
	System.out.println(objectName);
	key.click(objectName);
	}
	
	if(data.get(i).equals("verifypagetitle")){
		String keyword = (String)data.get(i);
		String testData = (String)data.get(i+1);
		String objectName = (String)data.get(i+2);
		System.out.println(keyword);
		System.out.println(testData);
		System.out.println(objectName);
		
		String actual = key.verifypagetitle();
		org.junit.Assert.assertEquals(testData, actual);
		
		
	}
	if(data.get(i).equals("verifyeditbox")){
		String keyword = (String)data.get(i);
		String testData = (String)data.get(i+1);
		String objectName = (String)data.get(i+2);
		System.out.println(keyword);
		System.out.println(testData);
		System.out.println(objectName);
	
		String actual = key.verifyeditbox(objectName);
		org.junit.Assert.assertEquals(testData,actual);
	
	
	
	}
	
	if(data.get(i).equals("dropdown")){
		
		String keyword = (String)data.get(i);
		String testData = (String)data.get(i+1);
		String objectName = (String)data.get(i+2);
		System.out.println(keyword);
		System.out.println(testData);
		System.out.println(objectName);
		
		key.dropdown(objectName,testData);
		
	}
	
	if(data.get(i).equals("verifydropdown")){

		String keyword = (String)data.get(i);
		String testData = (String)data.get(i+1);
		String objectName = (String)data.get(i+2);
		System.out.println(keyword);
		System.out.println(testData);
		System.out.println(objectName);
		
	String av = key.verifydropdown(objectName);
	org.junit.Assert.assertEquals(av,testData);
	
	
	
	
	}
	
	
	
	
	
	
	
		if(data.get(i).equals("closebrowser")){
	String keyword = (String)data.get(i);
	String testData = (String)data.get(i+1);
	String objectName = (String)data.get(i+2);
	System.out.println(keyword);
	System.out.println(testData);	
	System.out.println(objectName);	
	key.closebrowser();	
	}
	
		
	}
		
	
	
	
	
	//
	
	
}	
	
	

}
