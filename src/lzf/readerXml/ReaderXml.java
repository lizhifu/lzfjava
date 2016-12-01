package lzf.readerXml;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ɨ��XML�ļ����sql
 *
 * @author lizhifu
 * @date 2016/11/24 11:14
 */
public class ReaderXml {

    /* ������Ϣ */
    static String [] flagIndex = {"drop","delete"};   //�����ҵ�sql���ͣ������ִ�Сд
    static String filePath = "G:/del/resource/";     //Դ�ļ�
    static String saveSqlPath = "G:/del/result/";    //�������ļ���
    static String resultSql = "result.sql";          //����ļ�

    static final String fileType = "XML";

    static private FileWriter fwInfo;
    static private BufferedWriter bwInfo ;

    public static void main(String[] args) throws IOException {
        init();

        ReaderXml readerXml = new ReaderXml();
        readerXml.scanSql( new File(filePath));

        end();
    }

    public static void init() throws IOException {
        System.out.println("start");
        fwInfo =  new FileWriter(saveSqlPath + resultSql);
        bwInfo = new BufferedWriter( fwInfo );
    }

    public static void end() throws IOException {
        bwInfo.flush();
        fwInfo.close();
        bwInfo.close();
        System.out.println("end");
    }

    /**
     * ɨ���ļ���
     * @param files Դ�ļ���
     */
    public void scanSql (File files ) {

        File [] fileLists = files.listFiles();
        if (fileLists == null || fileLists.length == 0) {
            return;
        }

        for (File file : fileLists) {
            if (file.isDirectory()) {
                    scanSql(file);
            } else {
                String readerType = file.getName();
                if (readerType.endsWith(fileType)) {
                    try {
                        getSqlFromXmlTran(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * �Ӻ��н������ļ�����ȡsql
     * @param file
     * @return
     * @throws Exception
     */
    public int getSqlFromXmlTran(File file) throws Exception {
        String sqlStartIndex = "<Sentence>";  //��<Sentence>�����ȡsql
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile()),"gb2312"));
        //  BufferedReader reader = new BufferedReader(new FileReader(file, "gb2312"));
        String tempStr;
        String transCode;

        StringBuffer ewXml = new StringBuffer();
        while ((tempStr = reader.readLine()) != null) {
            if ( !tempStr.trim().startsWith("--"))          //ȥ��ע��
                ewXml.append(tempStr);
        }
        reader.close();

        String data = delNote(ewXml);

        if (data.indexOf(sqlStartIndex) == -1)
            return -1;
        else {
            transCode = getCode( matchCode(data) );     //������

            String[] tmpDyn = getDyn(data);
            String[] tmpDynName = getDynName(tmpDyn);   //������
            String[] tmpSql = getSqlFromDyn(tmpDyn);   //sql���

            for (int i = 0; i < tmpDyn.length; i++) {
                if (!tmpSql[i].equals("")) {
                    writeInfo(file.getAbsolutePath(), transCode, tmpDynName[i], tmpSql[i]);
                }
            }
        }

        return 0;
    }

    /**
     * ����ȥ��ע�Ͳ���
     * @param data
     * @return
     */
    public String delNote(StringBuffer data) {
        String out = data.toString();
        Pattern pattern = Pattern.compile("<!--(.+?)-->");
        Matcher matcher = pattern.matcher(out);

        while (matcher.find()) {
            out = out.replace(matcher.group(0), "");
        }
        return out;
    }

    /**
     * ��ȡ��������ߺ���
     * @param data
     * @return
     */
    public String matchCode(String data) {
        Pattern p = Pattern.compile("<Transaction code=(.+?)>");
        Matcher m = p.matcher(data);
        if (m.find()) {
            return m.group(1);
        } else {
            p = Pattern.compile("<Function name=(.+?)>");
            m = p.matcher(data);
            if (m.find()) {
                return m.group(1);
            }
        }
        return "";
    }

    public String getCode (String data) {
        Pattern p = Pattern.compile("\"(.+?)\"");
        Matcher m = p.matcher(data);
        if (m.find())
            return m.group(1);
        return "";
    }

    /**
     * ��ȡDyn������
     * @param data
     * @return
     */
    public String[] getDyn(String data) {
        Pattern p = Pattern.compile("<DynSentence(.+?)</DynSentence>");
        Matcher matcher = p.matcher(data);
        int i = 0;
        String tmp = "";

        while (matcher.find()) {
            if (i == 0) {
                tmp = matcher.group(1);
            } else {
                tmp += "##" + matcher.group(1);  //��**��Ϊ����
            }
            i++;
        }
        return tmp.split("##");
    }

    /**
     * ��ȡ������
     * @param data
     * @return
     */
    public String[] getDynName(String[] data) {

        int length = data.length;
        String[] dynName = new String[length];
        Pattern pattern = Pattern.compile("\"(.+?)\"");

        for (int i = 0; i < length; i++) {
            Matcher matcher = pattern.matcher(data[i]);
            if ( matcher.find())
                dynName[i] = matcher.group(1);
            else {
                dynName[i] = "NOT FOUND";
            }
        }
        return dynName;
    }

    /**
     * ��ȡsql���
     * @param data
     * @return
     */
    public String[] getSqlFromDyn(String[] data) {
        int length = data.length;
        String[] sql = new String[length];

        Pattern p = Pattern.compile("<Sentence>(.+?)</Sentence>");  //��<Sentence>�л�ȡsql

        for (int i = 0; i < length; i++) {
            Matcher matcher = p.matcher(data[i]);
            if (matcher.find()) {
                sql[i] = matcher.group(1);
                if ( matcher.group(1).indexOf("&gt;") != -1 ||  matcher.group(1).indexOf("&lt;") != -1 ) {
                    sql[i] = matcher.group(1).replace("&gt;", ">").replace("&lt;", "<");
                }
            } else {
                sql[i] = "";
            }
        }
        return sql;
    }

    /**
     * �ѷ��ظ���sqlд�뱣��
     * @param filePath  �ļ�·��
     * @param transCode ������
     * @param dyn  ������
     * @param sql  sql���
     * @throws IOException
     */
    public void writeInfo(String filePath, String transCode, String dyn, String sql) throws IOException {
        String data = dealSql(sql).trim();

        for (String index : flagIndex  ) {
            if (data.toLowerCase().startsWith(index)) {
                bwInfo.write("[" + data + "] "  + "[" + filePath + "]\n");
                break;
            }
        }
    }

    /**
     * ����data��ȥ������ո��Լ�ע��
     * @param data
     * @return ������
     */
    public String dealSql(String data) {

        if (data.indexOf("/*") != -1) {
            String dataPre = data.substring(0, data.indexOf("/*"));
            String dataSuf = data.substring(data.indexOf("*/") + 2);
            data = dataPre + dataSuf;
        }

        if (data.indexOf("<!") != -1) {
            String dataPre = data.substring(0, data.indexOf("<!"));
            String dataSuf = data.substring(data.indexOf("->") + 2);
            data = dataPre + dataSuf;
        }

        String out = "";
        int sqlLength = data.length();
        for (int i = 0; i < sqlLength; i++) {
            char firstChar = data.charAt(i);
            if (firstChar == '\t') {
                firstChar = ' ';
            }
            out += firstChar;
            if (firstChar == ' ') {
                while (i + 1 < sqlLength && (data.charAt(i + 1) == '\t' || data.charAt(i + 1) == ' ')) {
                    i++;
                }
            }
        }
        return out;
    }
}
