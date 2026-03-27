package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Search_Filtering_TestData {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String fileName, String sheetName) {

        try {
            String path = System.getProperty("user.dir")
                    + "/src/test/resources/TestData/"
                    + fileName;

            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("❌ Sheet not found: " + sheetName);
            }

        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load Excel file: " + e.getMessage());
        }
    }

    public static String getData(int rowNum, int colNum) {

        try {
            DataFormatter formatter = new DataFormatter();

            Row row = sheet.getRow(rowNum);
            if (row == null) return "";

            Cell cell = row.getCell(colNum);
            if (cell == null) return "";

            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    public static void closeExcel() {
        try {
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}