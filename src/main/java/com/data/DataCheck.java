package com.data;


public class DataCheck{

	public static boolean isEmpty(String str)
	{
		return str == null || str.trim().length() == 0;
	}

	public static boolean isNull(Object str)
	{
		return str == null;
	}
}
