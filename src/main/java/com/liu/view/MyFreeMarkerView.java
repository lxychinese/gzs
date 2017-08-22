package com.liu.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.liu.data.access.impl.NewsAccessImpl;
import com.utils.SpringUtil;

public class MyFreeMarkerView extends FreeMarkerView {
	 private static final String CONTEXT_PATH = "base"; 
	    @Override
	    protected void exposeHelpers(Map<String, Object> model,
	            HttpServletRequest request) throws Exception {
	    	
	    	NewsAccessImpl newsAccessImpl = (NewsAccessImpl) SpringUtil.getBean("newsAccessImpl");
	    	 model.put(CONTEXT_PATH, request.getContextPath());
	         super.exposeHelpers(model, request);
	    }
}
