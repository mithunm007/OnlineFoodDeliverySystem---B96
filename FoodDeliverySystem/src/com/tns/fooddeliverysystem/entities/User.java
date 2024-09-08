package com.tns.fooddeliverysystem.entities;

public class User {

	private int userid;
	private String username;
	private long contactno;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public User(int userid, String username, long contactno) {
		super();
		this.userid = userid;
		this.username = username;
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", contactno=" + contactno + "]";
	}

}
