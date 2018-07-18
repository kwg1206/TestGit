import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import org.apache.poi.ss.formula.functions.Sumif;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelFile {

	public static void main(String[] args) throws IOException {



		// File location

		String path = new File("src").getAbsolutePath();

	    String a[] = new String[5];
	    
	    String b[] = new String[5];
	    
	    String c[] = new String[5];

		String fileName = path + "/order.xlsx";

		float num[] = new float[6];
		
		float num1[] = new float[5];
		
		float num2[] = new float[5];

		// Order class lists 

		List<Order> orderList = new ArrayList<>();



		// Initial needed values

		XSSFWorkbook inputWorkbook = null;

		XSSFRow incurRow;

		XSSFCell incurCell;

		XSSFSheet incurSheet;



		int rowCount = 0;



		// Open file & get file data

		FileInputStream fis = new FileInputStream(fileName);

		inputWorkbook = new XSSFWorkbook(fis);

		fis.close();



		// Process sheet data



		// Get 1ST sheet

		incurSheet = inputWorkbook.getSheetAt(0);



		// Get 1ST sheet number of rows

		rowCount = incurSheet.getPhysicalNumberOfRows();



		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {

			// Get row

			incurRow = incurSheet.getRow(rowIndex);

			

			String invalue[] = new String[4];



			int cellCount = incurRow.getPhysicalNumberOfCells();

			for (int cellIndex = 0; cellIndex < cellCount; cellIndex++) {

				// Get every cell data

				incurCell = incurRow.getCell(cellIndex);



				switch (incurCell.getCellTypeEnum()) {



				case STRING:

					invalue[cellIndex] = incurCell.getStringCellValue() + "";

					break;



				case NUMERIC:

					invalue[cellIndex] = incurCell.getNumericCellValue() + "";

					break;



				default:

					System.out.println(incurCell.getCellTypeEnum());

				}
				
			}



			Order order = new Order();

			order.setTableNumber((int) Float.parseFloat(invalue[0]));

			order.setOrderedMenu(invalue[1]);

			order.setMenuPrice((int) Float.parseFloat(invalue[2].substring(0, invalue[2].length() - 1)));

			order.setOrderedNumber((int) Float.parseFloat(invalue[3]));

			

			orderList.add(order);
			a[rowIndex-1]=invalue[0];
			b[rowIndex-1]=invalue[2].substring(0, invalue[2].length() - 1);
			c[rowIndex-1]=invalue[3];
		}



		inputWorkbook.close();

		

		for (Order order : orderList) {

			System.out.println(order.toString());

		}
		
		int j = 0;
		for (int i = 0 ; i<5;i++) {
			num[i] = Float.parseFloat(a[i]);
			num1[i] = Float.parseFloat(b[i]);
			num2[i] = Float.parseFloat(c[i]);
		}
		int sum=0,sum1=0,sum2=0;
		for (int i = 0 ; i<5;i++) {
			if(num[i]==1){
				sum+=num1[i]*num2[i];
			}
			else if(num[i]==2){
				sum1+=num1[i]*num2[i];
			}
			else if(num[i]==3){
				sum2+=num1[i]*num2[i];
			}
			
		}
		System.out.println("Order [tableNumber= 1"+" , totalPrice"+sum+"]");
		System.out.println("Order [tableNumber= 2"+" , totalPrice"+sum1+"]");
		System.out.println("Order [tableNumber= 3"+" , totalPrice"+sum2+"]");



		

		

	}

}