package com.douyin.video.account.entity;

import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;

public class Like implements DataBaseAware<Integer, Like>{
	
	private Integer id;
	private Integer friendId;
	private Integer articleId;

	private static AtomicInteger autoIncrement = new AtomicInteger(0);

	public Like(Integer friendId, Integer articleId) {
		this.id = autoIncrement.getAndIncrement();
		this.friendId = friendId;
		this.articleId = articleId;
	}

	@Override
	public Integer getKey() {
		return this.id;
	}

	public Integer getFriendId() {
		return friendId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("{用户:%s 给 用户:%s 点赞}", articleId, friendId);
	}

}
