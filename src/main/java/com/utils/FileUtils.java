package com.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;




/**
 * 提供附件或文件的公共方法或工具方法
 */
public class FileUtils extends org.apache.commons.io.FileUtils{
	
	private  static final int BUFFER_SIZE = 2048;
	
	/**
	 * 获取文件格式
	 * @param fileName 文件名
	 * @return
	 */
	public static String getFileFormat(String fileName){
		if(fileName != null && fileName.trim().length() > 0){
			int pos = fileName.lastIndexOf(".");
			if(pos > 0)
			return fileName.substring(pos + 1);
		}
		return "";
	}
	
	/**
	 * 获取文件名（不含后缀名）
	 * @param fileName 文件名
	 * @return
	 */
	public static String getFileNameWithNoFormat(String fileName){
		if(fileName != null && fileName.trim().length() > 0){
			int pos = fileName.lastIndexOf(".");
			return fileName.substring(0, pos);
		}
		return "";
	}



	
	/**
	 * 格式化文件路径
	 * @param path
	 * @return
	 */
	public static String formatPath(String path) {
		if(path != null && path.trim().length() > 0){
			// 将一个或多个“\”转化成“/”
			path = path.replaceAll("\\\\{1,}", "/");
			// 将多个“/”转化成一个“/”
			path = path.replaceAll("\\/{2,}", "/");
		}
	   return path;
	}
	
	/**
	 * 判断两个文件的整个路径（文件路径+文件名）是否相同
	 * @param filePath1 文件路径1
	 * @param fileName1 文件名1
	 * @param filePath2 文件路径2
	 * @param fileName2 文件名2
	 * @param isNeedToFormatPath 是否需要格式化文件路径
	 * @return
	 */
	public static boolean isTwoPathSame(String filePath1, String fileName1, String filePath2, String fileName2, boolean isNeedToFormatPath){
		if((filePath1 == null || filePath1.trim().length() <= 0) 
			|| (fileName1 == null || fileName1.trim().length() <= 0)
			|| (filePath2 == null || filePath2.trim().length() <= 0)
			|| (fileName2 == null || fileName2.trim().length() <= 0)){
			return false;
		}
		
		if(isNeedToFormatPath){
			filePath1 = formatPath(filePath1);
			filePath2 = formatPath(filePath2);
		}
		
		String fileWholePath1 = filePath1 + fileName1;
		String fileWholePath2 = filePath2 + fileName2;
		return fileWholePath1.equalsIgnoreCase(fileWholePath2);
	}
	
	/**
	 * 在磁盘上创建文件对象
	 * @param filePath
	 * @param fileName
	 * @param isAbsolutePath
	 * @param directoryPath
	 * @param autoBuildDir true表示当文件路径不存在时自动创建
	 * @param isNeedToFormatPath 是否需要格式化文件路径
	 * @return
	 */
	public static File openFile(String filePath, String fileName, boolean isAbsolutePath,String directoryPath, boolean autoBuildDir, boolean isNeedToFormatPath)throws Exception{
		File file = null;
		//如果是相对路径
		if(!isAbsolutePath){
			filePath = directoryPath + "\\" + filePath;
		}
		if(filePath != null && filePath.trim().length() > 0){
			//格式化文件路径
			if(isNeedToFormatPath){
				filePath = formatPath(filePath);
			}
			
			
			// 如果文件目录不存在则创建
			if(autoBuildDir){
				File dir = new File(filePath);
				if(!dir.exists())
					dir.mkdirs();
			}
			file = new File(filePath + "\\" + fileName);
		}
		return file; 
	}
	
	/**
	 * 判断文件名是否合法
	 * @param fileName
	 * @return
	 */
	public static boolean isFileNameValid(String fileName){
		if(fileName == null || fileName.trim().length() <= 0)
			return false;
		
		String[] errorStr =new String []{"/","\\",":",",","*","?","\"","<",">","|"};
		
		for(int i = 0; i < errorStr.length; i++){
			if(fileName.contains(errorStr[i]))
				return false;
		}
		return true;
		
	}
	/**
	 * 判断文件对象已存在于磁盘上
	 * @param filePath 文件路径
	 * @param fileName 文件名
	 * @param isAbsolutePath 是否为绝对路径
	 * @param directoryPath
	 * @param isNeedToFormatPath 是否需要格式化文件路径
	 * @return
	 */
	public static boolean isFileExist(String filePath, String fileName, boolean isAbsolutePath, String directoryPath, boolean isNeedToFormatPath){
		if(filePath == null && fileName == null)
			return false;
		try{
			File file = openFile(filePath, fileName, isAbsolutePath, directoryPath, true, isNeedToFormatPath);
			if(file == null)
				return false;
	        return file.exists();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断是否新建文件
	 * @param filePath 文件路径
	 * @param fileName 文件名
	 * @param isAbsolutePath 是否为绝对路径
	 * @param directoryPath
	 * @param isNeedToFormatPath 是否需要格式化文件路径
	 * @return 返回值为true,表示新建文件
	 */
	public static boolean isNewFile(String filePath, String fileName, boolean isAbsolutePath, String directoryPath, boolean isNeedToFormatPath){
		if(isFileExist(filePath, fileName,isAbsolutePath, directoryPath, isNeedToFormatPath))
			return false;
		return true;
	}
	
	/**
	 * 修改文件名
	 * @param oldFilePath
	 * @param oldFileName
	 * @param newFilePath
	 * @param newFileName
	 * @param isAbsoluteFilePath
	 * @param directoryPath
	 * @param isNeedToFormatPath 是否需要格式化文件路径
	 * @return
	 */
	public static boolean renameFile(String oldFilePath, String oldFileName, String newFilePath, String newFileName, 
									 boolean isAbsoluteFilePath, String directoryPath,boolean autoBuildDir, boolean isNeedToFormatPath){
		
		try{
			File oldFile = FileUtils.openFile(oldFilePath, oldFileName, isAbsoluteFilePath, directoryPath, autoBuildDir, isNeedToFormatPath);
			File newFile = FileUtils.openFile(newFilePath, newFileName, isAbsoluteFilePath, directoryPath, autoBuildDir, isNeedToFormatPath);
			if(oldFile == null || newFile == null || !oldFile.renameTo(newFile))
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return  true;
	}
	
	
	
	/**
	 * 根据文件的扩展名，获取模板文件
	 * @param extentFileName 文件的扩展名
	 * @param templateFilePath office模板文件的存放的绝对路径
	 * @return
	 */
	

	
	/**
	 * 构造一张宽为width，髙为height，内容为content的图片
	 * @param width
	 * @param height
	 * @param content
	 * @return
	 */
	public static BufferedImage buildBlankPicture(int width, int height, String content){
		// 在内存中创建图象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
		// 获取图形上下文   
		Graphics g = image.getGraphics();   
		// 设定背景色   
		g.fillRect(0, 0, width, height); 
		
		//设定字体   
		g.setFont(new Font("宋体",Font.PLAIN,20));
		g.setColor(Color.BLACK);
		g.drawString(content, width/2, height/2);
		
		g.dispose();
		
		return image;
	}
	
	/**
	 * 把输入流复制，输出到输出流
	 * @param in
	 * @param out
	 */
	public static void copy(InputStream in, OutputStream out){
		byte[] buffer = new byte[BUFFER_SIZE];
		int n = -1;
		try{
			while( (n = in.read(buffer)) > 0){
				out.write(buffer, 0, n);
			}
		}
		catch(SocketException se){
		}
		catch(IOException ex){
			//ex.printStackTrace();
		}
		finally{
			try{
				if(in != null)
					in.close();
				if(out != null){
					out.close();
				}
			}
			catch(IOException ex){
				//ex.printStackTrace();
			}
		}
	}
	

    /**
     * 根据指定路径复制文件
     * @param path1 带文件名的全路径
     * @param path2 不带文件名的目录
     * @return 新生成的文件全路径
     */
    public static String copy(String path1, String path2, boolean autoBuildDir){
    	File file1 = new File(path1);
    	path2 = path2.replace("/", "\\");
    	File file2 = new File(path2);
    	
    	if(file1.exists()){
    		if(null == path2 || path2.equals("")){
    			System.out.println("拷贝文件目的地址为空！");
    			return null;
    		}
    		
    		String dir = path2.substring(0, path2.lastIndexOf("\\"));
    		File dirFile = new File(dir);
	    	if(!dirFile.exists())
	    		if(autoBuildDir)
	    			dirFile.mkdirs();
	    		else
	    			System.out.println("拷贝文件目的地址目录不存在！");
    		
    		while(file2.exists()){
        		file2 = new File(getNewFileName(file2.getPath()));
        	}
        	
        	try {
    			InputStream in = new FileInputStream(file1);
    			OutputStream out = new FileOutputStream(file2);
    			FileUtils.copy(in, out);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}else{
    		System.out.println("文件"+path1+"不存在！");
    	}   
    	
    	return file2.getPath();
    }
    
    /**
     * 根据给定的文件名，生成新的文件名称
     * @param fileName
     * @return
     */
    private static String getNewFileName(String fileName){
    	String fileType = "";
    	String newFileName = "";
    	
    	//构造一个正则表达式
    	String patternStr = "（([0-9]+)）";
    	int lastIndex = fileName.lastIndexOf('.');    	
    	if(lastIndex != -1){
    		fileType = fileName.substring(lastIndex);
    		patternStr += fileType;
    	}
    	patternStr += "$";//匹配结尾
    	
    	//匹配并生成新文件名
    	Pattern p = Pattern.compile(patternStr);
		Matcher m = p.matcher(fileName);
		String temp = "（1）"+fileType;		
		if(m.find()) {
			int curNo = Integer.valueOf(m.group(1));			
			temp = "（"+(++curNo)+"）"+fileType;
			lastIndex = fileName.length() - m.group(0).length();
		}
		
		newFileName = fileName.subSequence(0, lastIndex)+temp;
		
		return newFileName;
    }
    
    /**
     * 从输入流中获取字符串
     * @param in 输入流
     * @param encoding 输入流的编码
     * @return 输出流的编码为UTF-8
     */
	public static String convertInputStreamToString(InputStream in,final String encoding){
		StringBuilder strBuilder = new StringBuilder(); 
		try{
			BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in,encoding)); 
			String sTempOneLine = new String(""); 
			while ((sTempOneLine = tBufferedReader.readLine()) != null){ 
				strBuilder.append(sTempOneLine); 
				strBuilder.append("\r\n");
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(in != null)
					in.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return strBuilder.toString();
	}
	
	public static String convertInputStreamToString(InputStream in){
//		return convertInputStreamToString(in,AdsWfContext.ENCODING_UTF8);
		StringBuilder strBuilder = new StringBuilder(); 
		try{
			BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in)); 
			String sTempOneLine = new String(""); 
			while ((sTempOneLine = tBufferedReader.readLine()) != null){ 
				strBuilder.append(sTempOneLine); 
				strBuilder.append("\r\n");
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(in != null)
					in.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return strBuilder.toString();
	}
}
