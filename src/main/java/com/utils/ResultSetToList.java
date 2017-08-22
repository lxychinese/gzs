package com.utils;

import java.sql.*;
import java.util.*;

public class ResultSetToList {

	public static List convertList(ResultSet rs) throws SQLException {
		List list = new ArrayList();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		Map rowData;
		for (; rs.next(); list.add(rowData)) {
			rowData = new HashMap();
			for (int i = 1; i <= columnCount; i++)
				rowData.put(md.getColumnName(i), rs.getObject(i));
		}
		return list;
	}

	public static Map convertMap(ResultSet rs) throws SQLException {
		Map map = new HashMap();
		ResultSetMetaData md = rs.getMetaData();
		int columncounts = md.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columncounts; i++)
				if (rs.getObject(i) != null)
					map.put(md.getColumnName(i), rs.getObject(i).toString());
				else
					map.put(md.getColumnName(i), null);

		}
		return map;
	}
}
