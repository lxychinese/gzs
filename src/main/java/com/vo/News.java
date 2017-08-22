package com.vo;

import java.util.Random;


public class News{

	private int id;
	private String title;
	private int height;
	public int getHeight() {
		int[] a={197,197,197,197,279,279};
		int len = a.length;
		Random random = new Random();//创建随机对象
		int arrIdx = random.nextInt(len);
		return a[arrIdx];
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private String content;
	private String createTime;
	private int type;
	private String imgSrc;
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	private String source;
	private String createBy;
	private String state;
	private News lastNews;
	private News nextNews;
	private String url;
	private String memo;
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	private Integer is_top;
	private Integer is_use;

	public Integer getIs_top() {
		return is_top;
	}

	public void setIs_top(Integer is_top) {
		this.is_top = is_top;
	}

	public Integer getIs_use() {
		return is_use;
	}

	public void setIs_use(Integer is_use) {
		this.is_use = is_use;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public News getLastNews() {
		return lastNews;
	}

	public void setLastNews(News lastNews) {
		this.lastNews = lastNews;
	}

	public News getNextNews() {
		return nextNews;
	}

	public void setNextNews(News nextNews) {
		this.nextNews = nextNews;
	}

	public News()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public News( String title, String content, String createTime) {
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
}
