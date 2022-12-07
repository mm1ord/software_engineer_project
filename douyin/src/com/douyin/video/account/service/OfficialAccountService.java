package com.douyin.video.account.service;

import java.util.List;
import java.util.stream.Collectors;

import com.douyin.ApplicationContext;
import com.douyin.database.IndexedDB;
import com.douyin.friend.Friend;
import com.douyin.video.account.context.VideoContext;
import com.douyin.video.account.context.OfficialAccountContext;
import com.douyin.video.account.entity.Article;
import com.douyin.video.account.entity.Comment;
import com.douyin.video.account.entity.Like;
import com.douyin.video.account.entity.OfficialAccount;

/**
 * 一些调用公众号接口的方法，避免繁琐的数据库交互。单例。
 * 先获得 Context ，然后调用 Context 里面的方法进行操作
 */
public class OfficialAccountService {

	private static class SingletonHolder {
		private static OfficialAccountService instance = new OfficialAccountService();
	}

	ApplicationContext ctx = ApplicationContext.getInstance();

	// Dao Objects
	private IndexedDB<Integer, Like> likeDB = ApplicationContext.getInstance().getLikeDB();
	private IndexedDB<Integer, Comment> commentDB = ApplicationContext.getInstance().getCommentDB();
	private IndexedDB<Integer, Friend> friendDB = ctx.getFriendDB();
	private IndexedDB<Integer, VideoContext> friendContextDB = ctx.getFriendContextDB();
	private IndexedDB<Integer, OfficialAccountContext> officialContextDB = ctx.getOfficialAccountContextDB();
	private IndexedDB<Integer, Article> articleDB = ctx.getArticleDB();
	private IndexedDB<Integer, OfficialAccount> officialAccountDB = ctx.getOfficialAccountDB();

	public static OfficialAccountService getInstance() {
		return SingletonHolder.instance;
	}
	
	/**
	 * 插入朋友，同时插入对应的上下文
	 */
	public void insertFriend(Friend friend) {
		friendDB.insert(friend);
		friendContextDB.insert(new VideoContext(friend));
	}

	/**
	 * 插入短视频，同时插入对应的上下文
	 */
	public void insertOfficialAccount(OfficialAccount officialAccount) {
		officialAccountDB.insert(officialAccount);
		officialContextDB.insert(new OfficialAccountContext(officialAccount));
	}

	/**
	 * 根据 id 获得用户操作面板上下文
	 */
	public VideoContext getFriendContextById(int id) {
		return friendContextDB.findById(id);
	}

	/**
	 * 根据 id 获得短视频操作面板上下文
	 */
	public OfficialAccountContext getOfficialContextById(int id) {
		return officialContextDB.findById(id);
	}

	/**
	 * 获得指定短视频下的所有点赞
	 */
	public List<Like> findAllLikesByArticleId(Integer articleId) {
		return likeDB.findAll().stream().filter(x->{return x.getArticleId() == articleId;}).collect(Collectors.toList());
	}

	/**
	 * 获得指定短视频下的所有评论
	 */
	public List<Comment> findAllCommentsByArticleId(Integer articleId) {
		return commentDB.findAll().stream().filter(x->{return x.getArticleId() == articleId;}).collect(Collectors.toList());
	}

	/**
	 * 获得短视频的具体信息
	 */
	public String getArticleDetail(Integer articleId) {
		Article article = articleDB.findById(articleId);
		return String.format("\n短视频编号: %s\n内容: %s\n点赞: %s\n评论: %s\n",
			article.getId(),
			article.getTitle(),
			findAllLikesByArticleId(articleId),
			findAllCommentsByArticleId(articleId));
	}
}
