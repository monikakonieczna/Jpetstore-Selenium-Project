package com.jpetstore.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Arrays;

/**
 * Util ExcelDataReader class which helps to access data from Excel files.
 */
public class ExcelDataReader {

    /**
     *
     * @param fileName
     * @return XSSFWorkbook or null value
     */
    private static XSSFWorkbook readExcelFile(String fileName) {

        try {
            return new XSSFWorkbook(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Returns testdata as 2D array object.
     *
     * @param fileName Excel file name
     * @param sheetName Sheet name in Excel file
     * @return test data used for parametrized tests
     */
    public static Object[][] getData(String fileName, String sheetName) {

        XSSFSheet sheet;
        XSSFRow singleRow;

        //Get sheet
        sheet = readExcelFile(fileName).getSheet(sheetName);

        //Needed to get cell count
        singleRow = sheet.getRow(0);

        //Initialize a 2D array object
        Object[][] testData = new Object[sheet.getLastRowNum()][singleRow.getLastCellNum()];

        for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {

            singleRow = sheet.getRow(rowCount);

            for (int cell = 0; cell < singleRow.getLastCellNum(); cell++) {
                testData[rowCount - 1][cell] = singleRow.getCell(cell)
                                                        .toString();
            }

        }
        return testData;
    }
}
