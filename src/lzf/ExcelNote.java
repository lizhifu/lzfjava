package lzf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取注释
 * Author: li_zhf
 * Date: 2016/10/14  Time: 17:24
 */
public class ExcelNote {
    public static void main(String[] args) {
        ExcelNote excelNote = new ExcelNote();
        String excelPath  =  "C:/Users/lzf/Desktop/商户基本信息表.xls";
        //excelNote.getNote(excelPath);
        String txtPath = "G:/note/table.txt";
        String resultPath = "G:/note/result.sql";
        excelNote.getNote(txtPath,excelPath,resultPath);
    }

    /**
     * 获取注释
     * @param txtPath txt文件路径
     * @param excelPath excel文件路径
     * @param resultPath 结果文件路径
     * @return
     */
    public int getNote(String txtPath, String excelPath,String resultPath) {
        List<String> listTxt =  TxtReader.read(txtPath);
        List<String> listResult = new ArrayList<String>();
        Map<String,String> map =  getMap(excelPath);  //得到数据库对应的字段和注释

        for ( String data : listTxt) {
            String dataTmp = data.trim(); //去除前后空格
            if (null == dataTmp || "".equals(dataTmp)) {
                continue;
            }
            String key = dataTmp.split(" ")[0].toLowerCase(); //获取数据库字段

            String value = map.get(key); //获取对应注释
            String dataNew = dataTmp.substring(0,dataTmp.length()-1) + " comment '" + value + "',";
            listResult.add(dataNew);
        }

        try {
            write(listResult,resultPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 从excel中获取第一列和第二列作为键值对
     * @param excelPath
     * @return
     */
    public Map<String,String> getMap(String excelPath) {
        List<List<String>> lists = ExcelReader.readExcel(excelPath);

        if ( null == lists) {
            return null;
        }

        Map map = new HashMap();

        for ( List<String> list : lists ) {
            if ( list.get(0) != null && list.get(1) != null)
            map.put(list.get(0).trim().toLowerCase(),list.get(1).trim());
            System.out.println(list.get(0) + "   "+list.get(1));

        }
        return map;
    }

    /**
     * 把最终数据写入文件夹
     * @param resultPath 结果文件路径
     * @return
     */
    public int write(List<String> data,String  resultPath) throws IOException {
        if (null == data) {
            return -1;
        }

        File file = new File (resultPath);
        if ( !file.exists()) {
            file.createNewFile();
        }

        FileWriter fwNewSql = new FileWriter(resultPath);      //用于写sql执行脚本
        BufferedWriter bwNewSql = new BufferedWriter(fwNewSql);

        for (String sql : data ){
            bwNewSql.write(sql + "\n");
        }

        bwNewSql.flush();
        bwNewSql.close();
        fwNewSql.close();
        return 0;
    }
}
