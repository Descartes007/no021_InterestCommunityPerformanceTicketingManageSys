package com.entity;

import com.util.VeDate;

public class Reply {
	private String replyid = "R" + VeDate.getStringId();
	private String articleid;
	private String usersid;
	private String username;
	private String reply;
	private String addtime;
	private String title;
	
	public String getReplyid() {
		return replyid;
	}

	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}

	public String getArticleid() {
		return this.articleid;
	}
	
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
