package com.tramate.dto;

public class GuideDto {
	private int num;
	private String name;
	private String nat;
	private String spot;
	private String mobile;
	private String email1;
	private String email2;
	private String addr;
	private String content;
	private String img;
	private String fare;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "GuideDto [num=" + num + ", name=" + name + ", nat=" + nat + ", spot=" + spot + ", mobile=" + mobile
				+ ", email1=" + email1 + ", email2=" + email2 + ", addr=" + addr + ", content=" + content + ", img="
				+ img + ", fare=" + fare + "]";
	}
	
	
}
