package com.douyin.official.account;

import com.douyin.friend.Friend;
import com.douyin.ApplicationContext;
import com.douyin.database.IndexedDB;
import com.douyin.official.account.context.VideoContext;
import com.douyin.official.account.context.OfficialAccountContext;
import com.douyin.official.account.entity.Article;
import com.douyin.official.account.entity.OfficialAccount;
import com.douyin.official.account.service.OfficialAccountService;
import com.douyin.util.Logger;
import com.douyin.util.LoggerFactory;

/**
 * 方法调用 tutorial
 */
public class OfficialAccountShowCase {
	public static void main(String[] args) {

		ApplicationContext ctx = ApplicationContext.getInstance();

		IndexedDB<Integer, Friend> friendDB = ctx.getFriendDB();
		IndexedDB<Integer, VideoContext> friendContextDB = ctx.getFriendContextDB();
		IndexedDB<Integer, OfficialAccountContext> officialContextDB = ctx.getOfficialAccountContextDB();
		IndexedDB<Integer, Article> articleDB = ctx.getArticleDB();
		IndexedDB<Integer, OfficialAccount> officialAccountDB = ctx.getOfficialAccountDB();

		Logger logger = LoggerFactory.getLogger(OfficialAccount.class);

		// === 系统操作 ===
		// 系统设计的方案：
		
		// 使用 FriendContext，OfficialContext 进行操作
		// 具体内容都存入了数据库中，需要数据时，从 ApplicationContext 取得数据库，并直接进行增删改查操作。
		
		// 系统：添加用户
		friendDB.insert(new Friend("mm1ord"));
		friendDB.insert(new Friend("悲伤荷包蛋"));
		friendDB.insert(new Friend("睦弟"));

//		// 系统：添加公众号
		officialAccountDB.insert(new OfficialAccount(" "));
		officialAccountDB.insert(new OfficialAccount(" "));
		officialAccountDB.insert(new OfficialAccount(" "));

		// 系统：添加用户操作上下文
		friendContextDB.insert(new VideoContext(friendDB.findById(0)));
		friendContextDB.insert(new VideoContext(friendDB.findById(1)));
		friendContextDB.insert(new VideoContext(friendDB.findById(2)));

		// 系统：添加公众号上下文
		officialContextDB.insert(new OfficialAccountContext(officialAccountDB.findById(0)));
		officialContextDB.insert(new OfficialAccountContext(officialAccountDB.findById(1)));
		officialContextDB.insert(new OfficialAccountContext(officialAccountDB.findById(2)));

		// === 用户和公众号操作 ===

		// 用户：订阅
		friendContextDB.findById(0).subscribe(officialContextDB.findById(0));
		friendContextDB.findById(0).subscribe(officialContextDB.findById(1));
		friendContextDB.findById(0).subscribe(officialContextDB.findById(2));

		// 短视频发表
		officialContextDB.findById(0).postArticle(new Article("视频1"));
		officialContextDB.findById(0).postArticle(new Article("视频2"));
		officialContextDB.findById(0).postArticle(new Article("视频3"));

		logger.INFO(friendContextDB.findById(0).getArticles());

		// 用户：点赞操作
		friendContextDB.findById(0).postLike(0);
		friendContextDB.findById(0).postLike(1);
		friendContextDB.findById(0).postLike(2);
		friendContextDB.findById(1).postLike(1);
		friendContextDB.findById(2).postLike(2);

		// 用户：进行评论
		friendContextDB.findById(0).postComment(" 我超 666", 0);
		friendContextDB.findById(0).postComment(" 这亚索打的真菜 ", 0);
		friendContextDB.findById(0).postComment(" 下次一定", 1);
		friendContextDB.findById(0).postComment(" 我有一个朋友想认识你", 1);

		// 用户：获得该用户的所有点赞
		logger.INFO(friendContextDB.findById(0).findAllLikes());
		
		// 用户：获得该用户的所有评论
		logger.INFO(friendContextDB.findById(0).findAllComments());

		// 公众号：文章删除
		officialContextDB.findById(0).deleteArticle(articleDB.findById(0));

		// 用户：获得用户订阅的所有文章
		logger.INFO(friendContextDB.findById(0).getArticles());

		// === 公共操作 ===

		// 所有人：查看短视频的具体信息
		logger.INFO(OfficialAccountService.getInstance().getArticleDetail(1));

		// 所有人：查看某文章的所有评论
		logger.INFO(OfficialAccountService.getInstance().findAllCommentsByArticleId(1));

		// 所有人：查看文章的所有点赞
		logger.INFO(OfficialAccountService.getInstance().findAllLikesByArticleId(1));

	}
}
