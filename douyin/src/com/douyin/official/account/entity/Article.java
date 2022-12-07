package com.douyin.official.account.entity;

import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;

public class Article implements DataBaseAware<Integer, Article> {
	
	private String title;
	private Integer id;
	private Long timestamp;
	private Integer authorId;
	private static AtomicInteger autoIncrement = new AtomicInteger(0);

	public Article(String title) {
		this.timestamp = System.currentTimeMillis();
		this.title = title;
		this.id = autoIncrement.getAndIncrement();
	}

	public Article(String title, Integer authorId) {
		this(title);
		this.authorId = authorId;
	}

	public Long getTimestamp() {
		return timestamp;
	}
	public String getTitle() {
		return title;
	}
	public Integer getId() {
		return id;
	}
	public Integer getAuthorId() {
		return authorId;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public Integer getKey() {
		return this.id;
	}

	@Override
	public String toString() {
		return this.title + "|" + this.timestamp;
	}
}
