package com.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liu.data.access.NewsAccess;
import com.liu.data.access.ProductAccess;
import com.liu.data.access.impl.NewsAccessImpl;
import com.liu.data.access.impl.ProductAccessImpl;
import com.liu.job.RefreshMemTask;

public class SysListener implements ServletContextListener {
	@Autowired
	private NewsAccess newsAccess;
	@Autowired
	private ProductAccess productAccessImpl;
	
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		setupContextVer2(context);
	}

	/**
	 * @param context
	 */
	public static void setupContextVer2(ServletContext context) {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		System.out.println("正在生成页面模板，请稍候 ...... ");

//		NewsAccessImpl newsAccessImpl = (NewsAccessImpl) ctx.getBean("newsAccessImpl");
		ProductAccessImpl productAccessImpl = (ProductAccessImpl) ctx.getBean("productAccessImpl");
		String path = context.getRealPath("/");
//		newsAccessImpl.list(null, path);
//		newsAccessImpl.getIndexList(path);
		//productAccessImpl.list(null, path);

		// 把案例页面也生成出来
		
		
		
		 RefreshMemTask refreshMemTask = new RefreshMemTask();
         Thread backupTaskThread = new Thread(refreshMemTask);
         backupTaskThread.setName("内存刷新线程");
         backupTaskThread.setDaemon(true);
         backupTaskThread.start();
         System.out.println("======================定时任务===========================");
         
         
         

		System.out.println("页面模板已生成完成!!!");
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		Runtime.getRuntime().exit(0);
	}

}
