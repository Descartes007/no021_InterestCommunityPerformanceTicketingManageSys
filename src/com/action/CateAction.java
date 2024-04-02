package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/cate", produces = "text/plain;charset=utf-8")
public class CateAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createCate.action")
	public String createCate() {
		return "admin/addcate";
	}

	// 添加数据
	@RequestMapping("addCate.action")
	public String addCate(Cate cate) {
		this.cateService.insertCate(cate);
		return "redirect:/cate/createCate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCate.action")
	public String deleteCate(String id) {
		this.cateService.deleteCate(id);
		return "redirect:/cate/getAllCate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCateByIds.action")
	public String deleteCateByIds() {
		String[] ids = this.getRequest().getParameterValues("cateid");
		for (String cateid : ids) {
			this.cateService.deleteCate(cateid);
		}
		return "redirect:/cate/getAllCate.action";
	}

	// 更新数据
	@RequestMapping("updateCate.action")
	public String updateCate(Cate cate) {
		this.cateService.updateCate(cate);
		return "redirect:/cate/getAllCate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCate.action")
	public String getAllCate(String number) {
		List<Cate> cateList = this.cateService.getAllCate();
		PageHelper.getPage(cateList, "cate", null, null, 10, number, this.getRequest(), null);
		return "admin/listcate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCateByCond.action")
	public String queryCateByCond(String cond, String name, String number) {
		Cate cate = new Cate();
		if (cond != null) {
			if ("catename".equals(cond)) {
				cate.setCatename(name);
			}
			if ("memo".equals(cond)) {
				cate.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.cateService.getCateByLike(cate), "cate", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycate";
	}

	// 按主键查询数据
	@RequestMapping("getCateById.action")
	public String getCateById(String id) {
		Cate cate = this.cateService.getCateById(id);
		this.getRequest().setAttribute("cate", cate);
		return "admin/editcate";
	}

	public CateService getCateService() {
		return cateService;
	}

	public void setCateService(CateService cateService) {
		this.cateService = cateService;
	}

}
