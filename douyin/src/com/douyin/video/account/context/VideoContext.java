package com.douyin.video.account.context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.douyin.ApplicationContext;
import com.douyin.database.DataBaseAware;
import com.douyin.database.IndexedDB;
import com.douyin.friend.Friend;
import com.douyin.video.account.entity.Article;
import com.douyin.video.account.entity.Comment;
import com.douyin.video.account.entity.Like;
import com.douyin.video.account.util.CommandEnum;
import com.douyin.util.Logger;
import com.douyin.util.LoggerFactory;

/**
 * 用户操作上下文。理解为 MVC 应用中的 Service 层。
 */
public class VideoContext implements DataBaseAware<Integer, VideoContext> {

	private Friend friend;

	private static Logger LOG = LoggerFactory.getLogger(VideoContext.class);

	private List<Integer> articleIdList = new ArrayList<>();

	// Dao Objects
	private IndexedDB<Integer, Article> articleDB = ApplicationContext.getInstance().getArticleDB();
	private IndexedDB<Integer, Friend> friendDB = ApplicationContext.getInstance().getFriendDB();
	private IndexedDB<Integer, Like> likeDB = ApplicationContext.getInstance().getLikeDB();
	private IndexedDB<Integer, Comment> commentDB = ApplicationContext.getInstance().getCommentDB();

	public VideoContext(Friend friend) {
		this.friend = friend;
	}
	
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<Article> getArticles() {
		LOG.INFO(String.format("%s fetching articles...", friend.getUsername()));
		List<Article> res = new ArrayList<>();
		IndexedDB<Integer, Article> db = ApplicationContext.getInstance().getArticleDB();
		for(Integer id: articleIdList) {
			res.add(db.findById(id));
		}
		return res;
	}

	public void onUpdate(CommandEnum command, Integer id) {
		switch(command) {
			case ADD: {
				LOG.INFO(String.format("%s 刷到新的短视频 id = %d", friend.getUsername(), id));
				this.articleIdList.add(id); break;
			}
			case DELETE: {
				LOG.INFO(String.format("%s的id = %d 的短视频被删除", friend.getUsername(), id));
				this.articleIdList.remove(id); break;
			}
		}
	}

	/**
	 * 评论
	 */
	public void postComment(String content, Integer articleId) {

		Comment comment = new Comment(this.getFriend().getUserId(), articleId, content);	

		if (! articleDB.exist(comment.getArticleId())) {
			throw new RuntimeException("短视频没有找到");
		} else if (! friendDB.exist(comment.getUserId())) {
			throw new RuntimeException("用户没有找到");
		}

		commentDB.insert(comment);
		LOG.INFO(String.format("评论 %s 发送成功", comment.toString()));

	}

	/**
	 * 点赞
	 */
	public void postLike(Integer articleId) {

		Like like = new Like(this.getFriend().getUserId(), articleId);

		if (! articleDB.exist(like.getArticleId())) {
			throw new RuntimeException("短视频没有找到");
		} else if (! friendDB.exist(like.getFriendId())) {
			throw new RuntimeException("用户没有找到");
		}

		likeDB.insert(like);
		LOG.INFO(String.format("%s 插入成功", like.toString()));
	}

	/**
	 * 无索引，全表扫描找出该用户的所有 like
	 */
	public List<Like> findAllLikes() {
		return likeDB.findAll().stream().filter(x->{return x.getFriendId() == friend.getUserId();}).collect(Collectors.toList());
	}

	/**
	 * 无索引，全表扫描找出该用户的所有 comment
	 */
	public List<Comment> findAllComments() {
		return commentDB.findAll().stream().filter(x->{return x.getUserId() == friend.getUserId();}).collect(Collectors.toList());
	}

	/**
	 * 订阅
	 */
	public void subscribe(OfficialAccountContext context) {
		context.register(this.getFriend().getUserId());
	}

	/**
	 * 取消订阅
	 */
	public void unsubscribe(OfficialAccountContext context) {
		context.unregister(this.getFriend().getUserId());
	}

	@Override
	public Integer getKey() {
		return this.friend.getUserId();
	}

}
