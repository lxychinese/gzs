package com.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtils {
	   private final Log logger = LogFactory.getLog(getClass());   
	   private Configuration freemarker_cfg = null;
	 /**
     * 获取freemarker的配置. freemarker本身支持classpath,目录和从ServletContext获取.
     */
    protected Configuration getFreeMarkerCFG(){
        if (null == freemarker_cfg){
            // Initialize the FreeMarker configuration;
            // - Create a configuration instance
            freemarker_cfg = new Configuration();

            // - FreeMarker支持多种模板装载方式,可以查看API文档,都很简单:路径,根据Servlet上下文,classpath等等
           
            //htmlskin是放在classpath下的一个目录
            freemarker_cfg.setClassForTemplateLoading(this.getClass(), "/htmlskin");
            freemarker_cfg.setDefaultEncoding("UTF-8");   

            
        }
       
        return freemarker_cfg;
    }

    /**
     * 生成静态文件.
     *
     */
    public boolean geneHtmlFile(String url,String templateFileName,Map propMap,String htmlFileName ){
        try{
            Template t = getFreeMarkerCFG().getTemplate(templateFileName);
            t.setEncoding("UTF-8");
            File afile = new File(url +"/"  + htmlFileName);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile),"UTF-8"));
            t.process(propMap, out);
        } catch (TemplateException e){
            logger.error("Error while processing FreeMarker template " + templateFileName,e);
            return false;
        }catch (IOException e){
            logger.error("Error while generate Static Html File " + htmlFileName,e);
            return false;
        }
        return true;
    }
   
   

    /**
     * 创建多级目录
     * @param aParentDir String
     * @param aSubDir  以 / 开头
     * @return boolean 是否成功
     */
    public static boolean creatDirs(String aParentDir, String aSubDir){
        File aFile = new File(aParentDir);
        if (aFile.exists()){
            File aSubFile = new File(aParentDir + aSubDir);
            if (!aSubFile.exists()){
                return aSubFile.mkdirs();
            }else{
                return true;
            }
        }else{
            return false;
        }
    }   

}
