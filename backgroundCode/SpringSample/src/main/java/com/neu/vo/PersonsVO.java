package com.neu.vo;

public class PersonsVO {
	private String id;
	
	private String create_datetime;
	
	private String email;
	
	private String phone;
	
	private String sex;
	
	private String username;
	
	private String zone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String create_datetime) {
		this.create_datetime = create_datetime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "PersonsVO [id=" + id + ", create_datetime=" + create_datetime + ", email=" + email + ", phone=" + phone
				+ ", sex=" + sex + ", username=" + username + ", zone=" + zone + "]";
	}
	

}
