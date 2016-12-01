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
	 * 列出给定目录下给定后缀包含有指定内容的文件
	 *
	 * @param path
	 *            目录地址
	 * @param contents
	 *            待检索内容组
	 * @param sufTypes
	 *            后缀组
	 * @param type
	 *            给定后缀（true）或除去给定后缀(false)
	 * @return 0：成功，-1：失败
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
	 * 获取文件所匹配字符串的行数
	 *
	 * @param fileName
	 *            文件名
	 * @param contents
	 *            匹配字符串数组
	 * @return 匹配到的行数，没有则返回""
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
	 * 列举目录下文件
	 *
	 * @param path
	 *            源目录路径
	 * @return 0：成功，-1：失败
	 */
	public static int listFile(String path) {
		return listFileSuf(path,"",true);
	}

	/**
	 * 按给定文件类型列举目录下文件
	 * @param path 源目录路径
	 * @param sufType 文件类型
	 * @param type  给定后缀（true）或除去给定后缀(false)
	 * @return 0：成功，-1：失败
	 */
	public static int listFileSuf(String path, String sufType, boolean type) {

		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return listFileSuf(path,sufTypes,type);
	}

	/**
	 * 按给定文件类型列举目录下文件
	 *
	 * @param path
	 *            源目录路径
	 * @param sufTypes
	 *            文件类型
	 * @param type
	 *            给定后缀（true）或除去给定后缀(false)
	 * @return 0：成功，-1：失败
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
	 * 列出给定目录下文件名包含有指定内容的文件
	 *
	 * @param path
	 *            目录路径
	 * @param content
	 *            文件名内容
	 * @return 0：成功，-1：失败
	 */
	public static int listFileName(String path, String content) {
		String [] contents = new String [1] ;
		contents[0] = content;
		return listFileName(path,contents);
	}


	/**
	 * 列出给定目录下文件名包含有指定内容的文件
	 *
	 * @param path
	 *            目录路径
	 * @param contents
	 *            文件名内容
	 * @return 0：成功，-1：失败
	 */
	public static int listFileName(String path, String[] contents) {

		String[] sufTypes = {""};
		return listFileName(path,contents,sufTypes,true);
	}

	/**
	 * 列出给定目录下指定后缀类型，文件名包含有指定内容的文件
	 *
	 * @param path
	 *            目录路径
	 * @param contents
	 *            文件名内容
	 * @param sufTypes
	 *            后缀类型
	 * @param type
	 *            给定后缀（true）或除去给定后缀(false)
	 * @return 0：成功，-1：失败
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
	 * 列出给定目录下指定后缀类型的文件
	 *
	 * @param path
	 *            目录路径
	 * @param sufType
	 *            后缀类型
	 * @return 0：成功，-1：失败
	 */
	public static int deleteFileSuf(String path, String sufType) {
		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return deleteFileSuf(path,sufTypes);
	}

	/**
	 * 删除目录下给定文件类型的文件
	 *
	 * @param path
	 *            源目录路径
	 * @param sufTypes
	 *            文件类型
	 * @return 0：成功，-1：失败
	 */
	public static int deleteFileSuf(String path, String[] sufTypes) {
		return deleteFileSuf(path,sufTypes,true);
	}

	/**
	 * 删除目录下给定文件类型的文件
	 *
	 * @param path
	 *            源目录路径
	 * @param sufTypes
	 *            文件类型
	 * @param type
	 *            给定后缀（true）或除去给定后缀(false)
	 * @return 0：成功，-1：失败
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
	 * 删除目录下给定前缀的文件
	 *
	 * @param path
	 *            源目录路径
	 * @param preType
	 *            文件类型
	 * @param type
	 *            给定前缀（true）或除去给定前缀(false)
	 * @return 0：成功，-1：失败
	 */
	public static int deleteFilePre(String path, String preType, boolean type) {
		String [] preTypes = new String [1] ;
		preTypes[0] = preType;
		return deleteFilePre(path,preTypes,type);
	}


	/**
	 * 删除目录下给定前缀的文件
	 *
	 * @param path
	 *            源目录路径
	 * @param preTypes
	 *            文件类型
	 * @param type
	 *            给定前缀（true）或除去给定前缀(false)
	 * @return 0：成功，-1：失败
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
	 * 移动指定目录下指定类型的文件到给定目录下
	 *
	 * @param oldDictionary
	 *            源目录路径
	 * @param newDictionary
	 *            目的目录路径
	 * @param types
	 *            文件类型
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
	 * 移动目录
	 *
	 * @param oldPath
	 *            源目录路径
	 * @param newPath
	 *            目的目录路径
	 * @return 0：成功 1：失败
	 */
	public static int removeFile(String oldPath, String newPath) {
		return removeFileSuf(oldPath,newPath,"");
	}

	/**
	 * 移动给定目录下指定类型文件到新目录
	 * @param oldPath 源目录路径
	 * @param newPath 目的目录
	 * @param sufType 文件类型
	 * @return
	 */
	public static int removeFileSuf(String oldPath, String newPath,
									String sufType) {
		String [] sufTypes = new String [1] ;
		sufTypes[0] = sufType;
		return removeFileSuf(oldPath,newPath,sufTypes);
	}

	/**
	 * 移动给定目录下指定类型文件到新目录
	 *
	 * @param oldPath
	 *            源目录路径
	 * @param newPath
	 *            目的目录
	 * @param types
	 *            文件类型
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
	 * 检查目录是否存在和为空
	 *
	 * @param files
	 *            文件
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
	 * 获取文件编码格式
	 *
	 * @param fileName
	 *            文件路径
	 * @return 编码格式
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
				return charset; // 文件编码为 ANSI
			} else if (first3Bytes[0] == (byte) 0xFF
					&& first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE"; // 文件编码为 Unicode
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE"; // 文件编码为 Unicode big endian
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8"; // 文件编码为 UTF-8
				checked = true;
			}
			bis.reset();
			if (!checked) {
				// int loc = 0;
				while ((read = bis.read()) != -1) {
					// loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
							// (0x80
							// - 0xBF),也可能在GB编码内
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
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
