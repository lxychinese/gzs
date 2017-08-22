package com.data;

import java.util.ArrayList;
import java.util.List;


public class DataParse{

	public static int parseInt(String numStr){
		int num = 0;
		try{
			num = Integer.parseInt(numStr);
		}catch (Exception exception) { }
		return num;
	}

	public static float parseFloat(String floatStr){
		float num = 0.0F;
		try{
			num = Float.parseFloat(floatStr);
		}
		catch (Exception exception) { }
		return num;
	}

	public static double parseDouble(String doubleStr){
		double num = 0.0D;
		try{
			num = Double.parseDouble(doubleStr);
		}
		catch (Exception exception) { }
		return num;
	}

	public static boolean parseBoolean(String bool){
		boolean sign = true;
		if (bool != null && bool.compareTo("1") != 0)
			sign = false;
		return sign;
	}

	public static String getStr(String str, String oldCode, String newCode)throws Exception{
		if (DataCheck.isEmpty(str))
			return "";
		else
			return new String(str.getBytes(oldCode), newCode);
	}

	public static String getBetweenTime(String key, String str){
		String word = "";
		String temp[] = str.split(";");
		if (temp.length < 1)
			return "";
		if (temp[0].trim().length() > 0)
			word = (new StringBuilder("Format(")).append(key).append(",'YYYY-MM-DD')").append(" >= '").append(temp[0]).append("'").toString();
		if (temp.length == 2 && temp[1].trim().length() > 0){
			if (word.length() > 0)
				word = (new StringBuilder(String.valueOf(word))).append(" and ").toString();
			word = (new StringBuilder(String.valueOf(word))).append("Format(").append(key).append(",'YYYY-MM-DD')").append(" <= '").append(temp[1]).append(" 00:00:00'").toString();
		}
		return word;
	}

	public static List getStrList(String str, String split){
		if (str == null || str.trim().length() == 0)
			return new ArrayList();
		String array[] = str.split(split);
		List list = new ArrayList();
		for (int i = 0; i < array.length; i++)
			list.add(array[i]);

		return list;
	}

	public static String getString(String str, int length){
		if (str == null)
			return "";
		if (str.length() > length)
			return (new StringBuilder(String.valueOf(str.substring(0, length - 2)))).append("...").toString();
		else
			return str;
	}

	public static String getString1(String str, int length){
		if (str == null)
			return "";
		if (str.length() > length)
			return str.substring(0, length);
		else
			return str;
	}
}
