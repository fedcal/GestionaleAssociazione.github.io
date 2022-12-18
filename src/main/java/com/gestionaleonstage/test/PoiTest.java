package com.gestionaleonstage.test;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiTest {
    @Test
    public void readXlsxFile() throws IOException {
        String filePath = "./FileTest/SociEstratti.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        XSSFWorkbook fileExcel = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = fileExcel.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r=0; r<=rows;r++){
            XSSFRow row = sheet.getRow(r);
            for(int c=0;c<cols;c++){
                XSSFCell cell = row.getCell(c);
                switch(cell.getCellType()) {
                    case STRING:
                        System.out.print(" " + cell.getStringCellValue() + " ");
                        break;
                    case NUMERIC:
                        System.out.print(" " + cell.getNumericCellValue() + " ");
                        break;
                    case BOOLEAN:
                        System.out.print(" " + cell.getBooleanCellValue() + " ");
                        break;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void writeExcel() throws IOException {
        /*
            1. Create a Workbook
            2. Create a Sheet
            3. Create Rows
            4. Create Cells
         */

        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Sheet1");

        Object data[][]={{"Nome","Cognome"}, {"Federico","Calò"}};

        int rows = data.length;
        int cols = data[0].length;

        for (int r=0; r<rows; r++){

            XSSFRow row=sheet.createRow(r);

            for (int c=0; c<cols;c++){

                XSSFCell cell=row.createCell(c);
                Object varData=data[r][c];

                if(varData instanceof String){
                    cell.setCellValue((String) varData);
                }
                if(varData instanceof Integer){
                    cell.setCellValue((Integer) varData);
                }
            }
        }

        String outPath="./FileTest/SociEstrattiOut.xlsx";
        FileOutputStream outputStream= new FileOutputStream(outPath);

        workbook.write(outputStream);
    }
}
