package lzf;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

	public static int listFileContent(String path) {
		String content = "";
		return listFileContent(path,content);
	}

	public static int listFileContent(String path, String content) {
		String sufType = "";
		return listFileContent(path,content,sufType);
	}

	public static int listFileContent(String path, String content,
									  String sufType) {
		Boolean type =true;
		return listFileContent(path,content,sufType,type);
	}

	public static int listFileContent(String path, String content,
									  String sufType, Boolean type) {
		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return listFileContent(path,content,sufTypes,type);
	}

	public static int listFileContent(String path, String content,
									  String[] sufTypes, Boolean type) {
		String [] contents = new String [1] ;
		contents[0] = content;
		return listFileContent(path,contents,sufTypes,type);
	}


	/**
	 * �г�����Ŀ¼�¸�����׺������ָ�����ݵ��ļ�
	 *
	 * @param path
	 *            Ŀ¼��ַ
	 * @param contents
	 *            ������������
	 * @param sufTypes
	 *            ��׺��
	 * @param type
	 *            ������׺��true�����ȥ������׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileContent(String path, String[] contents,
									  String[] sufTypes, Boolean type) {
		File files = new File(path);
		if (checkDict(files) != 0) {
			return -1;
		}

		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				listFileContent(file.getAbsolutePath(), contents, sufTypes,
						type);
			} else {
				for (String sufType : sufTypes) {
					if (type) {
						if (file.getAbsolutePath().endsWith(sufType)) {
							try {
								matchContent(file.getAbsolutePath(), contents);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else {
						if (!file.getAbsolutePath().endsWith(sufType)) {
							try {
								matchContent(file.getAbsolutePath(), contents);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * ��ȡ�ļ���ƥ���ַ���������
	 *
	 * @param fileName
	 *            �ļ���
	 * @param contents
	 *            ƥ���ַ�������
	 * @return ƥ�䵽��������û���򷵻�""
	 * @throws Exception
	 */
	private static String matchContent(String fileName, String[] contents)
			throws Exception {
		String codeMethod = getCharset(fileName);

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), codeMethod));
		String line = br.readLine();
		int lineCount = 1;
		while (line != null) {
			for (String content : contents) {
				if (line.indexOf(content) != -1) {
					String tmp = fileName + "  " + line + "  " + lineCount
							+ " " + codeMethod;
					System.out.println(tmp);
					br.close();
					return tmp;
				}
			}
			lineCount++;
			line = br.readLine();
		}
		br.close();
		return "";
	}

	/**
	 * �о�Ŀ¼���ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFile(String path) {
		return listFileSuf(path,"",true);
	}

	/**
	 * �������ļ������о�Ŀ¼���ļ�
	 * @param path ԴĿ¼·��
	 * @param sufType �ļ�����
	 * @param type  ������׺��true�����ȥ������׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileSuf(String path, String sufType, boolean type) {

		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return listFileSuf(path,sufTypes,type);
	}

	/**
	 * �������ļ������о�Ŀ¼���ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @param sufTypes
	 *            �ļ�����
	 * @param type
	 *            ������׺��true�����ȥ������׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileSuf(String path, String[] sufTypes, boolean type) {
		File files = new File(path);
		if (checkDict(files) != 0) {
			return -1;
		}

		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				listFileSuf(file.getAbsolutePath(), sufTypes, type);
			} else {
				if (type) {
					for (String sufType : sufTypes) {
						if (file.getAbsolutePath().endsWith(sufType)) {
							System.out.println(file.getAbsolutePath());
							break;
						}
					}
				} else {
					for (String sufType : sufTypes) {
						if (!file.getAbsolutePath().endsWith(sufType)) {
							System.out.println(file.getAbsolutePath());
							break;
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * �г�����Ŀ¼���ļ���������ָ�����ݵ��ļ�
	 *
	 * @param path
	 *            Ŀ¼·��
	 * @param content
	 *            �ļ�������
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileName(String path, String content) {
		String [] contents = new String [1] ;
		contents[0] = content;
		return listFileName(path,contents);
	}


	/**
	 * �г�����Ŀ¼���ļ���������ָ�����ݵ��ļ�
	 *
	 * @param path
	 *            Ŀ¼·��
	 * @param contents
	 *            �ļ�������
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileName(String path, String[] contents) {

		String[] sufTypes = {""};
		return listFileName(path,contents,sufTypes,true);
	}

	/**
	 * �г�����Ŀ¼��ָ����׺���ͣ��ļ���������ָ�����ݵ��ļ�
	 *
	 * @param path
	 *            Ŀ¼·��
	 * @param contents
	 *            �ļ�������
	 * @param sufTypes
	 *            ��׺����
	 * @param type
	 *            ������׺��true�����ȥ������׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int listFileName(String path, String[] contents,
								   String[] sufTypes, Boolean type) {
		File files = new File(path);
		if (checkDict(files) != 0) {
			return -1;
		}

		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				listFileName(file.getAbsolutePath(), contents, sufTypes, type);
			} else {
				for (String sufType : sufTypes) {
					if (type) {
						if (file.getAbsolutePath().endsWith(sufType)) {
							for (String content : contents) {
								if (file.getAbsolutePath().indexOf(content) != -1) {
									System.out.println(file.getAbsolutePath());
									break;
								}
							}
						}
					} else {
						if (!file.getAbsolutePath().endsWith(sufType)) {
							for (String content : contents) {
								if (file.getAbsolutePath().indexOf(content) != -1) {
									System.out.println(file.getAbsolutePath());
									break;
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}

	public static int deleteFile() {
		return 0;
	}

	/**
	 * �г�����Ŀ¼��ָ����׺���͵��ļ�
	 *
	 * @param path
	 *            Ŀ¼·��
	 * @param sufType
	 *            ��׺����
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int deleteFileSuf(String path, String sufType) {
		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return deleteFileSuf(path,sufTypes);
	}

	/**
	 * ɾ��Ŀ¼�¸����ļ����͵��ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @param sufTypes
	 *            �ļ�����
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int deleteFileSuf(String path, String[] sufTypes) {
		return deleteFileSuf(path,sufTypes,true);
	}

	/**
	 * ɾ��Ŀ¼�¸����ļ����͵��ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @param sufTypes
	 *            �ļ�����
	 * @param type
	 *            ������׺��true�����ȥ������׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int deleteFileSuf(String path, String[] sufTypes, boolean type) {
		File files = new File(path);
		if (checkDict(files) != 0) {
			return -1;
		}

		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				deleteFileSuf(file.getAbsolutePath(), sufTypes, type);
			} else {
				if (type) {
					for (String sufType : sufTypes) {
						if (file.getAbsolutePath().endsWith(sufType)) {
							System.out.println("del:" + file.getAbsolutePath());
							file.delete();
							break;
						}
					}
				} else {
					for (String sufType : sufTypes) {
						if (!file.getAbsolutePath().endsWith(sufType)) {
							System.out.println("del:" + file.getAbsolutePath());
							file.delete();
							break;
						}
					}
				}
			}
		}
		return 0;
	}

	/**
	 * ɾ��Ŀ¼�¸���ǰ׺���ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @param preType
	 *            �ļ�����
	 * @param type
	 *            ����ǰ׺��true�����ȥ����ǰ׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int deleteFilePre(String path, String preType, boolean type) {
		String [] preTypes = new String [1] ;
		preTypes[0] = preType;
		return deleteFilePre(path,preTypes,type);
	}


	/**
	 * ɾ��Ŀ¼�¸���ǰ׺���ļ�
	 *
	 * @param path
	 *            ԴĿ¼·��
	 * @param preTypes
	 *            �ļ�����
	 * @param type
	 *            ����ǰ׺��true�����ȥ����ǰ׺(false)
	 * @return 0���ɹ���-1��ʧ��
	 */
	public static int deleteFilePre(String path, String[] preTypes, boolean type) {
		File files = new File(path);
		if (checkDict(files) != 0) {
			return -1;
		}

		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				deleteFileSuf(file.getAbsolutePath(), preTypes, type);
			} else {
				if (type) {
					for (String sufType : preTypes) {
						if (file.getAbsolutePath().startsWith(sufType)) {
							System.out.println("del:" + file.getAbsolutePath());
							file.delete();
							break;
						}
					}
				} else {
					for (String sufType : preTypes) {
						if (!file.getAbsolutePath().startsWith(sufType)) {
							System.out.println("del:" + file.getAbsolutePath());
							file.delete();
							break;
						}
					}
				}
			}
		}
		return 0;
	}

	/**
	 * �ƶ�ָ��Ŀ¼��ָ�����͵��ļ�������Ŀ¼��
	 *
	 * @param oldDictionary
	 *            ԴĿ¼·��
	 * @param newDictionary
	 *            Ŀ��Ŀ¼·��
	 * @param types
	 *            �ļ�����
	 */
	public static void removeFileSufOnly(String oldDictionary,
										 String newDictionary, String[] types) {
		File oldFile = new File(oldDictionary);

		File fileLists[] = oldFile.listFiles();
		if (fileLists == null || fileLists.length == 0) {
			return;
		}

		for (File file : fileLists) {
			if (file.isDirectory()) {
				removeFileSufOnly(file.getAbsolutePath(), newDictionary, types);
			} else {
				for (String type : types) {
					if (file.getName().endsWith(type)) {
						file.renameTo(new File(new File(newDictionary)
								.getAbsolutePath() + "/" + file.getName()));
						System.out.println(file.getName());
						break;
					}
				}
			}
		}
	}

	/**
	 * �ƶ�Ŀ¼
	 *
	 * @param oldPath
	 *            ԴĿ¼·��
	 * @param newPath
	 *            Ŀ��Ŀ¼·��
	 * @return 0���ɹ� 1��ʧ��
	 */
	public static int removeFile(String oldPath, String newPath) {
		return removeFileSuf(oldPath,newPath,"");
	}

	/**
	 * �ƶ�����Ŀ¼��ָ�������ļ�����Ŀ¼
	 * @param oldPath ԴĿ¼·��
	 * @param newPath Ŀ��Ŀ¼
	 * @param sufType �ļ�����
	 * @return
	 */
	public static int removeFileSuf(String oldPath, String newPath,
									String sufType) {
		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return removeFileSuf(oldPath,newPath,sufTypes);
	}

	/**
	 * �ƶ�����Ŀ¼��ָ�������ļ�����Ŀ¼
	 *
	 * @param oldPath
	 *            ԴĿ¼·��
	 * @param newPath
	 *            Ŀ��Ŀ¼
	 * @param types
	 *            �ļ�����
	 * @return 0
	 */
	public static int removeFileSuf(String oldPath, String newPath,
									String[] types) {
		File oldFile = new File(oldPath);
		File fileLists[] = oldFile.listFiles();
		if (fileLists == null || fileLists.length == 0) {
			return -1;
		}

		File newFile = new File(newPath);
		if (!newFile.exists()) {
			newFile.mkdirs();
		}

		for (File file : fileLists) {
			if (file.isDirectory()) {
				File newFileC = new File(newFile.getAbsolutePath() + "/"
						+ file.getName());
				newFileC.mkdir();
				removeFileSuf(file.getAbsolutePath(),
						newFileC.getAbsolutePath(), types);
				System.out.println(file.getName());
			} else {
				for (String type : types) {
					if (file.getName().endsWith(type)) {
						file.renameTo(new File(newFile.getAbsolutePath() + "/"
								+ file.getName()));
						System.out.println(file.getName());
						break;
					}
				}
			}
		}

		return 0;
	}

	/**
	 * ���Ŀ¼�Ƿ���ں�Ϊ��
	 *
	 * @param files
	 *            �ļ�
	 * @return
	 */
	private static int checkDict(File files) {
		if (!files.exists()) {
			return -1;
		}

		File[] fileList = files.listFiles();
		if (fileList == null || fileList.length == 0) {
			return -2;
		}
		return 0;
	}

	/**
	 * ��ȡ�ļ������ʽ
	 *
	 * @param fileName
	 *            �ļ�·��
	 * @return �����ʽ
	 * @throws IOException
	 */
	private static String getCharset(String fileName) throws IOException {
		File sourceFile = new File(fileName);
		String charset = "GBK";
		byte[] first3Bytes = new byte[3];
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				sourceFile));
		try {
			boolean checked = false;
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1) {
				bis.close();
				return charset; // �ļ�����Ϊ ANSI
			} else if (first3Bytes[0] == (byte) 0xFF
					&& first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE"; // �ļ�����Ϊ Unicode
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE"; // �ļ�����Ϊ Unicode big endian
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8"; // �ļ�����Ϊ UTF-8
				checked = true;
			}
			bis.reset();
			if (!checked) {
				// int loc = 0;
				while ((read = bis.read()) != -1) {
					// loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF) // ��������BF���µģ�Ҳ����GBK
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) // ˫�ֽ� (0xC0 - 0xDF)
							// (0x80
							// - 0xBF),Ҳ������GB������
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) {// Ҳ�п��ܳ������Ǽ��ʽ�С
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else
								break;
						} else
							break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bis.close();
		return charset;
	}

	public static void main(String[] args) {
		System.out.println("start");
		listFileContent("G:/del");
		System.out.println("end");
	}
}
