package org.acoe.com.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderWithExcel {

    @Test(dataProvider = "getData1")
    public void test1(HashMap<String, String> map) {
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data/TestDataExcel.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("TestData");

        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[][]  data = new Object[rowNum][colNum];
        for(int i = 1; i <= rowNum; i++){
            for(int j = 0; j < colNum; j++) {
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;
    }

    @DataProvider
    public Object[] getData1() throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data/TestDataExcel.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("TestData");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String, String> map;
        for(int i = 1; i <= rowNum; i++){
            map = new HashMap<>();
            for(int j = 0; j < colNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i - 1] = map;
            }
        }
        return data;
    }
}
