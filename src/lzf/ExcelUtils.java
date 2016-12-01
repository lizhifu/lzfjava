package lzf;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/13.
 * Time: 14:08
 */
public class ExcelUtils {
    public static String getStringVal(Cell cell) {
        switch ( cell.getCellType() ) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().toString();
            case Cell.CELL_TYPE_ERROR:
                //return ErrorEval.getText(cell.getErrorCellValue());
                return "";
            default:
                return "";
        }
    }
}
