package com.douyin.shortVideo.entity;

import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;

public class Comment implements DataBaseAware<Integer, Comment> {

	private Integer id;

	private static AtomicInteger autoIncrement = new AtomicInteger(0);

	private String content;
	private Integer articleId;
	private Integer userId;

	public Comment(Integer userId, Integer articleId, String content) {
		this.id = autoIncrement.getAndIncrement();
		this.userId = userId;
		this.articleId = articleId;
		this.content = content;
	}

	@Override
	public Integer getKey() {
		return id;
	}

	public String getContent() {
		return content;
	}
	public Integer getId() {
		return id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public Integer getUserId() {
		return userId;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("Comment{UID=%s-ArticleID=%s==>%s}", this.userId, this.articleId, this.content);
	}

}
