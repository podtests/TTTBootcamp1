package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManager {

    public static Logger logger = LogManager.getLogger(ExcelManager.class.getName());

    public static void main(String[] args) {
        ExcelManager em = new ExcelManager();
        em.readFile();
    }
    //"src/test/resources/testdata.xlsx"


    public String[][] readFile() {
        logger.info("readFile method started");
        File file = new File(ConfigReader.getProperty("exceltestdatafile"));
        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        try {
          fis = new FileInputStream(file);

           wb  = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            logger.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }

        //Row Count
        XSSFSheet ws = wb.getSheet("Sheet1");
        int rowCount = ws.getLastRowNum();  //2  : 0based : 0 , 1,2  //3

        //System.out.println("rowCoungt is:"+rowCount);
        logger.debug("Count of Rows in excel sheet is: "+rowCount);

        //Column count of First Row
        XSSFRow row = ws.getRow(0);
        int columnCount  = row.getLastCellNum();  //2, 1 based: 1,2  //2

        logger.debug("Count of Cells in First Row in excel sheet is: "+columnCount);
        String[][] dataSource = new String[rowCount][columnCount];

        XSSFRow r1 = null;
        for(int r=1; r<=rowCount; r++ ) {
            r1 = ws.getRow(r);
            for(int c = 0; c<columnCount; c++ ){
                if (r1.getCell(c) == null){
                    dataSource[r-1][c] = "";
                }else {
                    dataSource[r-1][c] = r1.getCell(c).toString();
                }


            }
        }

/*
        System.out.println("columnCount is:"+columnCount);

        String col1 = row.getCell(0).toString();
        String col2 = row.getCell(1).toString();

        System.out.println("Col1 is:"+col1);
        System.out.println("Col2 is:"+col2);
*/

        /*
        for(int x=0; x<dataSource.length; x++ ) {
            System.out.print("| ");
            for(int y = 0; y <dataSource[x].length; y++  ){
                System.out.print(dataSource[x][y]+ " | ");
            }
            System.out.println();
        }
        */

        try {
            wb.close();
            fis.close();

        } catch (IOException e) {
            logger.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }
        logger.info("readFile method completed");
        return dataSource;

    }



}
