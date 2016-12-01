package lzf;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 读取excel文件
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/13.
 * Time: 11:41
 */
public class ExcelReader {
    public static void main(String[] args) {
        String excelPath  =  "C:/Users/lzf/Desktop/商户系统_应用改造功能清单&开发计划_20161014.xls";

        ExcelReader er =  new ExcelReader();
        int i = listExcel(excelPath);
        System.out.println("i:" + i);
    }

    public static List<List<String>> readExcel(String excelPath) {
        if ( excelPath.endsWith("xls") ) {
            return readXls(excelPath);
        }

        if ( excelPath.endsWith("xlsx") ) {
            return readXlsx(excelPath);
        }
        return null;
    }

    /**
     * 获取excel2007版以后的数据，后缀为xlsx
     * @param excelPath 07版excel文件路径
     * @return
     */
    private static List<List<String>> readXlsx(String excelPath) {
        File fileExcel = new File(excelPath);
        if ( !fileExcel.exists()) {
            return null;
        }

        List<List<String>> result = new ArrayList<List<String>>();

        try {
            FileInputStream fis = new FileInputStream(fileExcel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // HSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
                XSSFSheet hssfSheet = wb.getSheetAt(sheetIndex);
                if ( null == hssfSheet) {
                    continue;
                }

                for (int rowNum = 1 ; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                    int minCol = xssfRow.getFirstCellNum();
                    int maxCol = xssfRow.getLastCellNum();
                    List<String> rowList = new ArrayList<String>();
                    for (int col =  minCol ; col < maxCol ; col++ ) {
                        XSSFCell cell = xssfRow.getCell(col);
                        if ( null == cell ) {
                            continue;
                        }
                        rowList.add(ExcelUtils.getStringVal(cell));
                    }
                    result.add(rowList);
                }

            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取excel2003版以前的数据，后缀为xls
     * @param excelPath 03版excel文件路径
     * @return
     */
    private static List<List<String>> readXls(String excelPath) {
        File fileExcel = new File(excelPath);
        if ( !fileExcel.exists()) {
            return null;
        }

        List<List<String>> result = new ArrayList<List<String>>();

        try {
            FileInputStream fis = new FileInputStream(fileExcel);
            POIFSFileSystem fs = new POIFSFileSystem(fis);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

            // HSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
                HSSFSheet hssfSheet = wb.getSheetAt(sheetIndex);
                if ( null == hssfSheet) {
                    continue;
                }

                for (int rowNum = 1 ; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    int minCol = hssfRow.getFirstCellNum();
                    int maxCol = hssfRow.getLastCellNum();
                    List<String> rowList = new ArrayList<String>();
                    for (int col =  minCol ; col < maxCol ; col++ ) {
                        HSSFCell cell = hssfRow.getCell(col);
                        if ( null == cell ) {
                            continue;
                        }
                        rowList.add(ExcelUtils.getStringVal(cell));
                    }
                    result.add(rowList);
                }

            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 列出excel文件数据
     * @param excelPath
     * @return
     */
    public static int listExcel(String excelPath) {
        if ( excelPath.endsWith("xls") ) {
            return listXls(excelPath);
        }

        if ( excelPath.endsWith("xlsx") ) {
            return listXlsx(excelPath);
        }
        return -1;
    }

    /**
     * 列出excel2007版以后的数据，后缀为xlsx
     * @param excelPath 07版excel文件路径
     * @return
     */
    private static int listXlsx(String excelPath) {

        File fileExcel = new File(excelPath);
        if ( !fileExcel.exists()) {
            return -2;
        }

        try {
            FileInputStream fis = new FileInputStream(fileExcel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // HSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
                XSSFSheet hssfSheet = wb.getSheetAt(sheetIndex);
                if ( null == hssfSheet) {
                    continue;
                }

                for (int rowNum = 1 ; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                    int minCol = xssfRow.getFirstCellNum();
                    int maxCol = xssfRow.getLastCellNum();
                    for (int col =  minCol ; col < maxCol ; col++ ) {
                        XSSFCell cell = xssfRow.getCell(col);
                        if ( null == cell ) {
                            continue;
                        }
                        System.out.printf(cell + "     ");
                    }
                    System.out.println();
                }

            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 列出excel2003版以前的数据，后缀为xls
     * @param excelPath 03版excel文件路径
     * @return
     */
    private static int listXls(String excelPath) {
        File fileExcel = new File(excelPath);
        if ( !fileExcel.exists()) {
            return -2;
        }

        try {
            FileInputStream fis = new FileInputStream(fileExcel);
            POIFSFileSystem fs = new POIFSFileSystem(fis);
            HSSFWorkbook wb = new HSSFWorkbook(fs);

           // HSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
                HSSFSheet hssfSheet = wb.getSheetAt(sheetIndex);
                if ( null == hssfSheet) {
                    continue;
                }

                for (int rowNum = 1 ; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    int minCol = hssfRow.getFirstCellNum();
                    int maxCol = hssfRow.getLastCellNum();
                    for (int col =  minCol ; col < maxCol ; col++ ) {
                        HSSFCell cell = hssfRow.getCell(col);
                        if ( null == cell ) {
                            continue;
                        }
                        System.out.printf(cell + "     ");
                    }
                    System.out.println();
                }

            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
