package com.douyin;

import com.douyin.database.IndexedDB;
import com.douyin.friend.Friend;
import com.douyin.friend.Group;
import com.douyin.official.account.context.VideoContext;
import com.douyin.official.account.context.OfficialAccountContext;
import com.douyin.official.account.entity.Article;
import com.douyin.official.account.entity.Comment;
import com.douyin.official.account.entity.Like;
import com.douyin.official.account.entity.OfficialAccount;

/**
 * 单例，整个应用程序的管理类。其他模块获取到这一单例对象后，可以获取适用于整个应用程序的数据。
 */
public class ApplicationContext {


	private static volatile ApplicationContext manager;
	private static Object lockObject = new Object();

	/**
	 * 双重校验锁单例，对象获取
	 */
	public static ApplicationContext getInstance() {
		if(manager == null) {
			synchronized(lockObject) {
				if(manager == null) {
					manager = new ApplicationContext();
				}
			}
		}
		return manager;
	}

	/**
	 * 保存所有用户，key 是 用户 id。
	 */
	// IndexDB 的构造方法传入的是需要建立的索引。可以传多个。
	private IndexedDB<Integer, Friend> friendDB = new IndexedDB<>("username");

	private IndexedDB<Integer, OfficialAccount> officialAccountDB = new IndexedDB<>();

	private IndexedDB<Integer, Group> groupMap = new IndexedDB<>();

	private IndexedDB<Integer, Article> articleDB = new IndexedDB<>();

	private IndexedDB<Integer, VideoContext> friendContextDB = new IndexedDB<>();

	private IndexedDB<Integer, OfficialAccountContext> officialAccountContextDB = new IndexedDB<>();

	private IndexedDB<Integer, Like> likeDB = new IndexedDB<>();

	private IndexedDB<Integer, Comment> commentDB = new IndexedDB<>();

	public IndexedDB<Integer, Friend> getFriendDB() {
		return friendDB;
	}
	public IndexedDB<Integer, Group> getGroupDB() {
		return groupMap;
	}
	public IndexedDB<Integer, Article> getArticleDB() {
		return articleDB;
	}
	public IndexedDB<Integer, VideoContext> getFriendContextDB() {
		return friendContextDB;
	}
	public IndexedDB<Integer, OfficialAccountContext> getOfficialAccountContextDB() {
		return officialAccountContextDB;
	}
	public IndexedDB<Integer, Like> getLikeDB() {
		return likeDB;
	}
	public IndexedDB<Integer, Comment> getCommentDB() {
		return commentDB;
	}
	public IndexedDB<Integer, OfficialAccount> getOfficialAccountDB() {
		return officialAccountDB;
	}
}
