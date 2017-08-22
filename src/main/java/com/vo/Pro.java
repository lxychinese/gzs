package com.vo;

import java.util.List;

public class Pro {

	private String id;
	private String name;
	private String proName;
	private String price;
	private String marketPrice;
	private List<ProImg> images;
	private String deImg;
	private String spec;

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}

	private List<Comment> comments;
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	private String descd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<ProImg> getImages() {
		return images;
	}

	public void setImages(List<ProImg> images) {
		this.images = images;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDescd() {
		return descd;
	}

	public void setDescd(String descd) {
		this.descd = descd;
	}

	public String getDeImg() {
		return deImg;
	}

	public void setDeImg(String deImg) {
		this.deImg = deImg;
	}

}
