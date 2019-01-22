package com.certificate.Taekwondo.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// 读取excel，将每一行赋值给实体对象，存入数据库
public class ExcelUtil {
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    // 读取Excel文件信息
    public static List<List> readExcel(MultipartFile file) {
        Workbook workbook = getWorkBook(file);
        List<List> list = new ArrayList<List>();
        if(workbook != null) {
            for(int sheetNum=0; sheetNum < workbook.getNumberOfSheets(); ++sheetNum) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null) {
                    continue;
                }
                int firstRowNum = sheet.getFirstRowNum();
                int lastRowNum = sheet.getLastRowNum();
                for(int rowNum=firstRowNum + 1; rowNum <= lastRowNum; ++rowNum) {   // 处理文件的每一行，第一行为表名
                    Row row = sheet.getRow(rowNum);
                    if(row == null) {
                        continue;
                    }
                    int firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum();
                    List<String> cells = new ArrayList<String>();
                    for(int cellNum=firstCellNum; cellNum < lastCellNum; ++cellNum) {   // 处理每一行的每一列
                        Cell cell = row.getCell(cellNum);
                        cells.add(getCellValue(cell));
                    }
                    list.add(cells);   // 每循环一行加入list中
                }
            }
        }
        try{
            workbook.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return list;
    }


    // 根据不同的文件后缀生成不同的workbook对象
    public static Workbook getWorkBook(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            InputStream is = file.getInputStream();
            if(fileName.endsWith(xls)) {
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)) {
                workbook = new XSSFWorkbook(is);
            }
        }catch (IOException e) {
            e.getMessage();
        }
        return workbook;
    }


    // 根据Cell获取对应的值，将数字改为字符串处理
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if(cell == null) {
            return cellValue;
        }
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:   // 数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:   // 字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:   // 布尔
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:   // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK:   // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR:   // 错误
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}
