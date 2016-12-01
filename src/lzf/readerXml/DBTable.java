package lzf.readerXml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lzf on 2016/7/7.
 */
public class DBTable {
    private List<String> tableList = new ArrayList<String>();
    private String DBName;

    public List<String> getTableList() {
        return tableList;
    }

    public void setTableList(List<String> tableList) {
        this.tableList = tableList;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    DBTable(File file) throws Exception {
//        File file = new File(path);
//        if ( !file.exists()) {
//            System.out.println("error! no found dbTable file");
//            return;
//        }
        DBName = file.getName();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        while ( line != null ) {
            tableList.add( line.trim());
            line = reader.readLine();
        }
    }

}
