

import java.sql.*;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Insert_into {
	public static void main(String[] args) throws IOException {



		// File location

		String path = new File("src").getAbsolutePath();

	    

		String fileName = path + "/orde.xlsx";

		

		// Order class lists 

		List<Order> orderList = new ArrayList<>();

		int a[] = new int[5];

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

        try {  
            Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序     
            //Class.forName("org.gjt.mm.mysql.Driver");  
           System.out.println("数据库驱动加载成功！");  
          }  
          catch (Exception e) {  
            System.out.print("Error loading Mysql Driver!");  
            e.printStackTrace();  
          }  
          try {  
            Connection connect = DriverManager.getConnection(  
                "jdbc:mysql://localhost/sys?useSSL=false&user=root&password=123456");  
                 //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码  
            
            System.out.println("mysql数据库已连接成功！"); 
            Statement stmt=connect.createStatement();//创建一个Statement对象
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {

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

//			order.setOrderedMenu(invalue[1]);
//
//			order.setMenuPrice((int) Float.parseFloat(invalue[2].substring(0, invalue[2].length() - 1)));
//
//			order.setOrderedNumber((int) Float.parseFloat(invalue[3]));
			a[rowIndex]=(int) Float.parseFloat(invalue[0]);
			System.out.println(a[rowIndex]);

			orderList.add(order);

		}
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
			stmt.executeUpdate("insert into b(id)values("+a[i]+");");
		}
        System.out.println("插入到数据库成功");
        connect.close();
        System.out.println("关闭数据库成功");
        System.out.println("Success connect Mysql server!"); 
      }  
      catch (Exception e) {  
        System.out.print("get data error!");  
        e.printStackTrace();  
      } 


		inputWorkbook.close();

		

		for (Order order : orderList) {

			System.out.println(order.toString());

		}

            
 

		

		

	}

}
