package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Concert;
import com.service.ConcertService;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/concert", produces = "text/plain;charset=utf-8")
public class ConcertAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ConcertService concertService;
	@Autowired
	@Resource
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createConcert.action")
	public String createConcert() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addconcert";
	}

	// 添加数据
	@RequestMapping("addConcert.action")
	public String addConcert(Concert concert) {
		concert.setHits("0");
		concert.setSellnum("0");
		this.concertService.insertConcert(concert);
		return "redirect:/concert/createConcert.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteConcert.action")
	public String deleteConcert(String id) {
		this.concertService.deleteConcert(id);
		return "redirect:/concert/getAllConcert.action";
	}

	// 批量删除数据
	@RequestMapping("deleteConcertByIds.action")
	public String deleteConcertByIds() {
		String[] ids = this.getRequest().getParameterValues("concertid");
		for (String concertid : ids) {
			this.concertService.deleteConcert(concertid);
		}
		return "redirect:/concert/getAllConcert.action";
	}

	// 更新数据
	@RequestMapping("updateConcert.action")
	public String updateConcert(Concert concert) {
		this.concertService.updateConcert(concert);
		return "redirect:/concert/getAllConcert.action";
	}

	// 显示全部数据
	@RequestMapping("getAllConcert.action")
	public String getAllConcert(String number) {
		List<Concert> concertList = this.concertService.getAllConcert();
		PageHelper.getPage(concertList, "concert", null, null, 10, number, this.getRequest(), null);
		return "admin/listconcert";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryConcertByCond.action")
	public String queryConcertByCond(String cond, String name, String number) {
		Concert concert = new Concert();
		if (cond != null) {
			if ("title".equals(cond)) {
				concert.setTitle(name);
			}
			if ("image".equals(cond)) {
				concert.setImage(name);
			}
			if ("cateid".equals(cond)) {
				concert.setCateid(name);
			}
			if ("actor".equals(cond)) {
				concert.setActor(name);
			}
			if ("recommend".equals(cond)) {
				concert.setRecommend(name);
			}
			if ("address".equals(cond)) {
				concert.setAddress(name);
			}
			if ("addtime".equals(cond)) {
				concert.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				concert.setHits(name);
			}
			if ("sellnum".equals(cond)) {
				concert.setSellnum(name);
			}
			if ("contents".equals(cond)) {
				concert.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.concertService.getConcertByLike(concert), "concert", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryconcert";
	}

	// 按主键查询数据
	@RequestMapping("getConcertById.action")
	public String getConcertById(String id) {
		Concert concert = this.concertService.getConcertById(id);
		this.getRequest().setAttribute("concert", concert);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editconcert";
	}

	public ConcertService getConcertService() {
		return concertService;
	}

	public void setConcertService(ConcertService concertService) {
		this.concertService = concertService;
	}

}
