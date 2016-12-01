package lzf;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڱ��������ļ�����
 * @author lzf
 * @date 2016��6��14�� ����10:25:18
 */
public class ErgodicFile {
	private FileWriter fw ;
	private BufferedWriter bw ;
	
    public static void main(String[] args) {
    	
    	Date date= new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");

		String searchPath = "D:/";
    //	String searchPath = "D:/tmp/";
    	String savePath = "D:/del/" + sdf.format(date) +".txt";
    //	String [] searchType = {"java","txt","sql","doc"};
    	String [] searchTypeW = {"pdf","word"};
    	String [] searchTypeR = {"pptx","ppt"};
    	String [] searchTypeM = {"rmvb","mp4","avi","flv"};
		String [] searchTypeS = {"sql"};
		String [] searchTypeZ = {"jar"};
		String [] searchTypeX = {"xml"};
		String [] searchTypeAll = {""};
    	String searchContent = "196df18b4473afc30f177b60cfd41395c4795915f3fb9";
    	String searchFileContent = "commons";
    	
    	ErgodicFile EF = new ErgodicFile();   	
    	//EF.searchFile(searchPath, savePath, searchTypeAll, searchContent);   //����ָ�������к����������ݵ��ļ�
    	//EF.searchFile(searchPath, savePath, searchFileContent);         //�����ļ��������������ݵ��ļ�
    	EF.searchFile(searchPath, savePath, searchTypeM);                //����ָ�����͵��ļ�
	}
    
    /**
     * ����ָ��·���£��ļ��������и����ֶε��ļ�
     * @param searchPath   ����·��
     * @param savePath  ����λ��
     * @param content   ��������
     */
    public void searchFile(String searchPath, String savePath, String content ) {    	
    	System.out.println("��ʼ");

    	//����·��������ʱ���򴴽�
		File saveFile = new File(savePath);
    	if ( !saveFile.exists() ) {
    		try {
    			saveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	//FileWriter��ʼ��
    	try {
			fw = new FileWriter(savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	bw = new BufferedWriter(fw);
    	
    	//��������
    	try {
    		showAllFiles(new File (searchPath) , content );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
	    try {
			bw.flush();
		    bw.close();
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   	
    	System.out.println("����");
    }
    
    /**
     * ����ָ������·���£��������͵��ļ�
     * @param searchPath  ����·��
     * @param savePath    ����λ��
     * @param searchType  ��������
     */
    public void searchFile(String searchPath, String savePath , String [] searchType) {    	
    	System.out.println("��ʼ");

    	//����·��������ʱ���򴴽�
		File saveFile = new File(savePath);
    	if ( !saveFile.exists() ) {
    		try {
    			saveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	try {
			fw = new FileWriter(savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	bw = new BufferedWriter(fw);
    	
    	//��������
    	try {
    		showFiles(new File (searchPath) , searchType);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
	    try {
			bw.flush();
		    bw.close();
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   	
    	System.out.println("����");
    }
    
    
    /**
     * ����ָ������·���£��������ͣ������������ݵ��ļ�
     * @param searchPath  ����·��
     * @param savePath    ����·��
     * @param searchType  ��������
     * @param searchContent ��������
     */
    public void searchFile(String searchPath, String savePath , String [] searchType, String searchContent) {    	
    	System.out.println("��ʼ");

    	//����·��������ʱ���򴴽�
		File saveFile = new File(savePath);
    	if ( !saveFile.exists() ) {
    		try {
    			saveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	try {
			fw = new FileWriter(savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	bw = new BufferedWriter(fw);
    	
    	//��������
    	try {
    		showFiles(new File (searchPath) , searchType , searchContent);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
	    try {
			bw.flush();
		    bw.close();
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   	
    	System.out.println("����");
    }
    
     // �ݹ����
     private void showFiles(File file, String [] types) {
         File flist[] = file.listFiles();
         if (flist == null || flist.length == 0) {
             return ;
         }
	     for (File f : flist) {
	         if (f.isDirectory()) {	
	             showFiles(f , types);
	         } else {
	             //���ｫ�г����е��ļ�
	             try {
				     //bw.write(f.getAbsolutePath());
	            	 getSelectType(f.getAbsolutePath(), types);
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
	         }
	     }
    }
    
     // �ݹ����
     private void showFiles(File file, String [] types, String content) {
         File flist[] = file.listFiles();
         if (flist == null || flist.length == 0) {
             return ;
         }
	     for (File f : flist) {
	         if (f.isDirectory()) {	
	             showFiles(f , types, content);
	         } else {
	             //���ｫ�г����е��ļ�
	             try {
				     //bw.write(f.getAbsolutePath());
	            	 getSelectType(f.getAbsolutePath(), types, content);
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
	         }
	     }
    }
     
     /**
      * ����ָ�����ͺ���ָ�����ݵ��ļ�
      * @param file   �������ļ���
      * @param type   �ļ�����
      * @param content ��������
      */
     private void showFiles(File file, String type,String content) {
         File flist[] = file.listFiles();
         if (flist == null || flist.length == 0) {
            return ;
         }
 	    for (File f : flist) {
 	         if (f.isDirectory()) {	
 	             showFiles(f , type , content);
 	         } else {
 	            //���ｫ�г����е��ļ�
 	             try {
 				     //bw.write(f.getAbsolutePath());
 	            	 getSelectType(f.getAbsolutePath(), type, content);
 				 } catch (IOException e) {
 					 e.printStackTrace();
 				}
 	         }
 	    }
    }
    
    /**
     * ����ָ�������ļ�
     * @param file
     * @param type
     */
    private void showFiles(File file, String type) {
        File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
           return ;
        }
	    for (File f : flist) {
	         if (f.isDirectory()) {	
	             showFiles(f , type);
	         } else {
	            //���ｫ�г����е��ļ�
	             try {
				     //bw.write(f.getAbsolutePath());
	            	 getSelectType(f.getAbsolutePath(), type);
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
	         }
	    }
    }
    
    /**
     * �����ļ�
     * @param file
     */
     private void showAllFiles(File file ) {
         File flist[] = file.listFiles();
         if (flist == null || flist.length == 0) {
            return ;
         }
	     for (File f : flist) {
	         if (f.isDirectory()) {	
	             showAllFiles( f );
	         } else {
	            //���ｫ�г����е��ļ�
	             try {
				     //bw.write(f.getAbsolutePath());
	            	 getSelectType(f.getAbsolutePath() );
				 } catch (IOException e) {
					 e.printStackTrace();
				}
	         }
	     }
    }
     
     /**
      * ��������ָ�����ݵ��ļ�
      * @param file
      */
     private void showAllFiles(File file ,String content) {
         File flist[] = file.listFiles();
         if (flist == null || flist.length == 0) {
            return ;
         }
 	    for (File f : flist) {
 	         if (f.isDirectory()) {	
 	             showAllFiles( f , content );
 	         } else {
 	            //���ｫ�г����е��ļ�
 	             try {
 	            	getFileName(f.getAbsolutePath(), content );
 				 } catch (IOException e) {
 					 e.printStackTrace();
 				}
 	         }
 	    }
    }
   
    public void getSelectType(String fileName) throws IOException {
        bw.write(fileName + "\n");
        System.out.println( fileName );
    }
    
    //��������
    public void getSelectType(String fileName, String type) throws IOException {
        if ( fileName.endsWith(type)) {
            bw.write(fileName + "\n");
        }
    }
    
    //ƥ�����������ļ������Ƿ����ַ���
    public void getSelectType(String fileName, String type , String content) throws IOException {
        if ( fileName.endsWith(type)) {
        	getContent(fileName, content);
        }
    }
    
    //����������
    public void getSelectType(String fileName, String [] types) throws IOException {
    	for (String type : types) {
    		 if ( fileName.endsWith(type) ) {
    			 bw.write(fileName + "\n");
    			 System.out.println( fileName );
    			 return;
    		 }
    	}
    }
    
    /**
     * ƥ�����������ļ��������Ƿ����ַ���
     * @param fileName
     * @param types
     * @param content
     * @throws IOException
     */
    public void getSelectType(String fileName, String [] types, String content) throws IOException {
    	for (String type : types) {
    		 if ( fileName.endsWith(type) ) {
    			 getContent(fileName, content);
    			 return;
    		 }
    	}
    }
    
    /**
     * ƥ���ַ���
     * @param fileName
     * @param content
     * @throws IOException
     */
    public void getContent(String fileName, String content) throws IOException {
       // bw.write(fileName + "\n");
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName) ) );
    	
    	int row = 0;
    	for ( String line = br.readLine(); line != null; line = br.readLine()) {
    		row++;
    		if ( line.indexOf(content) != -1 ) {
    			 bw.write(fileName + "  �� "  + row +" �� " + line + " \n"  );
    			 System.out.println( fileName +  "  " + row + "  " + line);
    		}
    	}
    	
    	br.close();
    }
    
    /**
     * �ļ�������ָ������
     * @param fileName
     * @param content
     * @throws IOException
     */
    public void getFileName(String fileName, String content) throws IOException {
        // bw.write(fileName + "\n");     	
 		if ( fileName.indexOf(content) != -1 ) {
 			 bw.write(fileName + "\n");
 			 System.out.println( fileName );
 		}
    }

    /**
	 * ���������޸��ļ�����
	 * @param filePath
	 */
    public void rename(String filePath) {
    	File file = new File(filePath);
    	for ( File tmpFile : file.listFiles() ){
    		String newName = tmpFile.getName().substring(2,tmpFile.getName().length());
		    File newFile = new File(filePath + newName);
		    tmpFile.renameTo(newFile);
    	}   	
    }

	/**
	 * ���������ļ�Ŀ¼��ɾ��ָ��ǰ׺���ļ�
	 * @param files �ļ�Ŀ¼
	 * @param preFlag ǰ׺
     * @return
     */
	public boolean delFilePre (File files,String preFlag ) {
        for ( File file : files.listFiles() ) {
			if (file.isDirectory()) {
				delFilePre(file ,preFlag);
			} else {
				int length = preFlag.length();
				if ( file.getName().substring(0,length).equals(preFlag) ) {
					System.out.println("delete: " + file.getName());
					file.delete();
				}
			}
		}
		return true;
	}

	/**
	 * ���������ļ�Ŀ¼��ɾ����ָ��ǰ׺���ļ�
	 * @param files   �ļ�Ŀ¼
	 * @param preFlag  ǰ׺
     */
	public void delFilePreNot (File files,String preFlag ) {
		for ( File file : files.listFiles() ) {
			if (file.isDirectory()) {
				delFilePreNot(file ,preFlag);
			} else {
				int length = preFlag.length();
				if ( !file.getName().substring(0,length).equals(preFlag) ) {
					System.out.println("delete: " + file.getName());
					file.delete();
				}
			}
		}
	}

	/**
	 * ���������ļ�Ŀ¼��ɾ��ָ����׺���ļ�
	 * @param files �ļ�Ŀ¼
	 * @param sufFlag ��׺
     */
	public void delFileSuf (File files,String sufFlag ) {
		for ( File file : files.listFiles() ) {
			if (file.isDirectory()) {
				delFileSuf(file ,sufFlag);
			} else {
				int length = sufFlag.length();
				if ( file.getName().substring(file.getName().length() - length,file.getName().length()).equals(sufFlag) ) {
					System.out.println("delete: " + file.getName());
					file.delete();
				}
			}
		}
	}

	/**
	 * �ƶ�ĳĿ¼�����ļ���ָ��Ŀ¼��
	 * @param oldDictionary
	 * @param newDictionary
     */
	public void removeFile (File oldDictionary , File newDictionary) {
		for ( File file : oldDictionary.listFiles() ) {
			if (file.isDirectory()) {
				removeFile(file ,newDictionary);
			} else {
                file.renameTo(new File(newDictionary.getAbsolutePath() + "/" + file.getName()));
			}
		}
	}

	/**
	 * �о��ļ�
	 * @param dictionary
     */
	public void listFile (File dictionary ) {
		for ( File file : dictionary.listFiles() ) {
			if (file.isDirectory()) {
				listFile(file );
			} else {
				System.out.println(file.getAbsolutePath());
			}
		}
	}
}
