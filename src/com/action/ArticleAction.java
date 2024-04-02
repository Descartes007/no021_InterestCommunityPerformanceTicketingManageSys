package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Article;
import com.service.ArticleService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/article", produces = "text/plain;charset=utf-8")
public class ArticleAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ArticleService articleService;

	// 准备添加数据
	@RequestMapping("createArticle.action")
	public String createArticle() {
		return "admin/addarticle";
	}

	// 添加数据
	@RequestMapping("addArticle.action")
	public String addArticle(Article article) {
		article.setAddtime(VeDate.getStringDateShort());
		article.setHits("0");
		this.articleService.insertArticle(article);
		return "redirect:/article/createArticle.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteArticle.action")
	public String deleteArticle(String id) {
		this.articleService.deleteArticle(id);
		return "redirect:/article/getAllArticle.action";
	}

	// 批量删除数据
	@RequestMapping("deleteArticleByIds.action")
	public String deleteArticleByIds() {
		String[] ids = this.getRequest().getParameterValues("articleid");
		for (String articleid : ids) {
			this.articleService.deleteArticle(articleid);
		}
		return "redirect:/article/getAllArticle.action";
	}

	// 更新数据
	@RequestMapping("updateArticle.action")
	public String updateArticle(Article article) {
		this.articleService.updateArticle(article);
		return "redirect:/article/getAllArticle.action";
	}

	// 显示全部数据
	@RequestMapping("getAllArticle.action")
	public String getAllArticle(String number) {
		List<Article> articleList = this.articleService.getAllArticle();
		PageHelper.getPage(articleList, "article", null, null, 10, number, this.getRequest(), null);
		return "admin/listarticle";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryArticleByCond.action")
	public String queryArticleByCond(String cond, String name, String number) {
		Article article = new Article();
		if (cond != null) {
			if ("title".equals(cond)) {
				article.setTitle(name);
			}
			if ("image".equals(cond)) {
				article.setImage(name);
			}
			if ("contents".equals(cond)) {
				article.setContents(name);
			}
			if ("addtime".equals(cond)) {
				article.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				article.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.articleService.getArticleByLike(article), "article", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryarticle";
	}

	// 按主键查询数据
	@RequestMapping("getArticleById.action")
	public String getArticleById(String id) {
		Article article = this.articleService.getArticleById(id);
		this.getRequest().setAttribute("article", article);
		return "admin/editarticle";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
