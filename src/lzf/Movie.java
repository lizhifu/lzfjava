package lzf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by lzf on 2016/6/29.
 */
public class Movie {
    private HashMap<String,String> listMD5 = new HashMap<String,String>();
    private String DictPath = "D:/����/";
    private String savePath = "D:/person/video/";
    private int fileCount = 0;

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.init();

        movie.execute();
    }

    public void init() {
        File saveFile = new File(savePath);
        if ( !saveFile.exists() ) {
            saveFile.mkdirs();
        }

        File bigFilePath = new File (savePath + "big/");
        if ( !bigFilePath.exists()) {
            bigFilePath.mkdir();
        }

        File littleFilePath = new File (savePath + "little/");
        if ( !littleFilePath.exists()) {
            littleFilePath.mkdir();
        }


    }

    public void searchFile(File dictionary , String [] types ) {

        File listFiles[] = dictionary.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return ;
        }

        for (File file : listFiles) {
            if ( file.isDirectory() ) {
                searchFile( file , types);
            } else {
                for (String type : types ) {
                    if ( file.getName().endsWith(type) ) {
                        try {
                            addVideo(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }
    }

    public int addVideo (File file ) throws IOException {
        if ( containsMD5( file ) ) {
            file.delete();
            System.out.println("delete:" + file.getAbsolutePath());
        } else {
            fileCount ++ ;
            listMD5.put( fileMD5(file.getAbsolutePath()), "1" );

            long fileSize = file.length() / 1024 / 1024;   //�ļ���С����λΪM
            String [] tmp = file.getAbsolutePath().split("\\.");
            System.out.println(file.getAbsolutePath());
            String endFlag = "." + tmp[1];

            if ( fileSize >= 100 ) {
                file.renameTo(new File(savePath + "big/" + file.getName() ));
            } else {
                file.renameTo(new File(savePath + "little/" + file.getName() ));
            }


        }

        return 0;
    }

    public void execute() {
        File file = new File(DictPath);
        String [] types = {"mp4","rmvb","avi","flv"};
        searchFile( file , types );
    }

    public boolean equalsMD5(String fileOne, String fileTwo ) throws IOException {
        String first = fileMD5(fileOne);
        String second = fileMD5(fileOne);
        if ( first.equals(second) )
            return true;
        return false;
    }

    public boolean containsMD5( File file) throws IOException {
        if ( listMD5.get( fileMD5(file.getAbsolutePath() )) == null ) {
            return false;
        }
        return true;
    }

    public String byteArrayToHex(byte[] byteArray) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < byteArray.length; n++) {
            stmp = (Integer.toHexString(byteArray[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < byteArray.length - 1) {
                hs = hs + "";
            }
        }
        return hs;
    }

    public String fileMD5(String inputFile) throws IOException {
        // ��������С��������Գ��һ��������
        int bufferSize = 256 * 1024;
        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;
        try {
            // �õ�һ��MD5ת������ͬ����������Ի���SHA1��
            MessageDigest messageDigest =MessageDigest.getInstance("MD5");
            // ʹ��DigestInputStream
            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
            // read�Ĺ����н���MD5����ֱ�������ļ�
            byte[] buffer =new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0);
            // ��ȡ���յ�MessageDigest
            messageDigest= digestInputStream.getMessageDigest();
            // �õ������Ҳ���ֽ����飬����16��Ԫ��
            byte[] resultByteArray = messageDigest.digest();
            // ͬ�������ֽ�����ת�����ַ���
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } finally {
            try {
                digestInputStream.close();
            } catch (Exception e) {
            }
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
