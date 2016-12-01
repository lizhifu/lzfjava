package lzf;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取文本文件
 * Author: li_zhf
 * Date: 2016/10/14  Time: 18:32
 */
public class TxtReader {
    public static void main(String[] args) {
        String txtPath = "G:/note/table.txt";
        List<String> list = read(txtPath);

        for( String data : list ) {
            System.out.println(data);
        }
    }

    /**
     * 读取txt文件中的内容，以List返回
     * @param txtPath  txt文件路径
     * @return
     */
    public static List<String> read(String txtPath)  {
        File file = new File(txtPath);
        if( !file.exists()) {
            return null;
        }

        List<String> listResult = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(txtPath) ) );
            String line = br.readLine();
            if ( null == line ) {
                return null;
            }

            while (line != null ) {
                listResult.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }
}
