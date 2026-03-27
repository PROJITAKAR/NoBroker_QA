package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    private static final String BASE_PATH = "src/test/resources/TestData/";

    public static Map<String, String> getTestData(String fileName, String sheetName, String tcId) {

        Map<String, String> data = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(BASE_PATH + fileName + ".xlsx");
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);
            DataFormatter formatter = new DataFormatter();

            boolean found = false;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String currentTcId = formatter.formatCellValue(row.getCell(0));

                if (currentTcId.equalsIgnoreCase(tcId)) {

                    found = true;

                    for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                        String key = formatter.formatCellValue(headerRow.getCell(j));
                        String value = formatter.formatCellValue(row.getCell(j));

                        data.put(key, value);
                    }
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("Test data not found for TC_ID: " + tcId);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + fileName, e);
        }

        return data;
    }
}