package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Article;

@Repository("articleDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ArticleDAO {

	/**
	 * ArticleDAO 接口 可以按名称直接调用article.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包article.xml里的insertArticle配置 返回值0(失败),1(成功)
	public int insertArticle(Article article);

	// 更新数据 调用entity包article.xml里的updateArticle配置 返回值0(失败),1(成功)
	public int updateArticle(Article article);

	// 删除数据 调用entity包article.xml里的deleteArticle配置 返回值0(失败),1(成功)
	public int deleteArticle(String articleid);

	// 查询全部数据 调用entity包article.xml里的getAllArticle配置 返回List类型的数据
	public List<Article> getAllArticle();

	// 按照Article类里面的值精确查询 调用entity包article.xml里的getArticleByCond配置 返回List类型的数据
	public List<Article> getArticleByCond(Article article);

	// 按照Article类里面的值模糊查询 调用entity包article.xml里的getArticleByLike配置 返回List类型的数据
	public List<Article> getArticleByLike(Article article);

	// 按主键查询表返回单一的Article实例 调用entity包article.xml里的getArticleById配置
	public Article getArticleById(String articleid);

}
