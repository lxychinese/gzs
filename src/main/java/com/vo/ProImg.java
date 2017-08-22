/**  
* @Title:  ProImg.java
* @Package com.vo
* @Description: TODO(用一句话描述该文件做什么)
* @author Liu XiaoYang
* @date  2014-7-16 下午04:39:01
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.vo;

/**
 * @ClassName: ProImg
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Liu XiaoYang
 * @date 2014-7-16 下午04:39:01
 *
 */
public class ProImg {
	
	private String bigProductImagePath;// 商品图片（大）路径
	private String smallProductImagePath;// 商品图片（小）路径
	public String getBigProductImagePath() {
		return bigProductImagePath;
	}
	public void setBigProductImagePath(String bigProductImagePath) {
		this.bigProductImagePath = bigProductImagePath;
	}
	public String getSmallProductImagePath() {
		return smallProductImagePath;
	}
	public void setSmallProductImagePath(String smallProductImagePath) {
		this.smallProductImagePath = smallProductImagePath;
	}

}
