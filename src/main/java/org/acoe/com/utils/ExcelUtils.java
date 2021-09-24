package org.acoe.com.utils;

import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.exceptions.FrameworkExceptions;
import org.acoe.com.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils() { }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = null;
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getExcelDataPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);


            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;
            list = new ArrayList<>();

            for(int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for(int j = 0; j < lastColNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        }catch(FileNotFoundException e1) {
            throw new InvalidPathForExcelException("Excel file that you are trying to read is not found", e1);
        }
        catch (IOException e2) {
            throw new FrameworkExceptions("Some io exception happened while reading the excel file");
        }
        return list;
    }
}
