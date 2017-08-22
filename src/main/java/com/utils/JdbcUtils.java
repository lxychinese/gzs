package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


public  class JdbcUtils {
	private static DataSource myDataSource = null;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();

			InputStream is =JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(is);
			myDataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public JdbcUtils() {
		
	}

	

	public  DataSource getDataSource() {
		return myDataSource;
	}

	public  Connection getConnection() throws SQLException {
		
		return myDataSource.getConnection();
	}

	/*
	 * 释放数据库连接
	 */
	public  void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    try {
				if (conn != null && !conn.isClosed() )
					
						conn.close();
						// myDataSource.free(conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}
}
