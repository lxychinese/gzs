package com.data;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.liu.data.access.ProductAccess;

/**
 * Created by ybn on 2015/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/WEB-INF/applicationContext.xml",
})
public  class JunitAccessBase {

	@Autowired
	private ProductAccess productAccess;

    /**
     * 是否要用资源中心初始化
     *
     * @return
     */
    protected boolean getNeedInit() {
        return true;
    }

    
    @Test
    public final void test1() {
    	 ClassLoader classLoader = getClass().getClassLoader();
         /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
         URL url = classLoader.getResource("model.txt");
         File file = new File(url.getFile());
    	  try {
			List<String> list =FileUtils.readLines(file);
			
			Map<String,String> map=new LinkedHashMap<>();
			for(String str:list){
				System.out.println(str);
				String[] tr=str.split("\\=");
				try {
					map.put(tr[0], tr[1]);
				} catch (Exception e) {
					map.put(tr[0], "");
				}
			}
			productAccess.save(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    


}
