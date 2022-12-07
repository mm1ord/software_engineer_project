package com.douyin.video.account.context;

import java.util.ArrayList;
import java.util.List;

import com.douyin.ApplicationContext;
import com.douyin.database.DataBaseAware;
import com.douyin.database.IndexedDB;
import com.douyin.video.account.entity.Article;
import com.douyin.video.account.entity.Comment;
import com.douyin.video.account.entity.Like;
import com.douyin.video.account.entity.OfficialAccount;
import com.douyin.video.account.service.OfficialAccountService;
import com.douyin.video.account.util.CommandEnum;

public class OfficialAccountContext implements DataBaseAware<Integer, OfficialAccountContext> {

	private OfficialAccount account;

	private IndexedDB<Integer, Article> articleDB = ApplicationContext.getInstance().getArticleDB();
	private IndexedDB<Integer, Comment> commentDB = ApplicationContext.getInstance().getCommentDB();
	private IndexedDB<Integer, Like> likeDB = ApplicationContext.getInstance().getLikeDB();


	public OfficialAccountContext(OfficialAccount oa) {
		this.account = oa;
	}

	private List<Integer> subscribers = new ArrayList<>();

	// == getter ==

	public OfficialAccount getAccount() {
		return account;
	}

	public List<Integer> getSubscribers() {
		return subscribers;
	}

	// == common ==

	public void postArticle(Article article) {
		article.setAuthorId(account.getAccountId());
		articleDB.insert(article);
		IndexedDB<Integer, VideoContext> friendContextDb = ApplicationContext.getInstance().getFriendContextDB();
		for (Integer id : subscribers) {
			friendContextDb.findById(id).onUpdate(CommandEnum.ADD, article.getId());
		}
	}
	
	public void deleteArticle(Article article) {
		Integer articleId = article.getId();
		articleDB.delete(articleId);
		// delete likes and comments as well
		for (Comment comment : OfficialAccountService.getInstance().findAllCommentsByArticleId(articleId)) {
			commentDB.delete(comment.getId());
		}
		for (Like like : OfficialAccountService.getInstance().findAllLikesByArticleId(articleId)) {
			likeDB.delete(like.getId());
		}

		IndexedDB<Integer, VideoContext> friendDb = ApplicationContext.getInstance().getFriendContextDB();
		for (Integer id : subscribers) {
			friendDb.findById(id).onUpdate(CommandEnum.DELETE, id);
		}
	}

	public void register(Integer friendId) {
		subscribers.add(friendId);
	}

	public void unregister(Integer friendId) {
		subscribers.remove(friendId);
	}

	@Override
	public Integer getKey() {
		return account.getAccountId();
	}
}