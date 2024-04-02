package com.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageHelper {

	public static void getPage(List<?> list, String name, List<String> nameList, List<String> valueList, int pageSize, String number,
			HttpServletRequest request, String method) {
		StringBuffer buffer = new StringBuffer();
		String name2 = name.substring(0, 1).toUpperCase() + name.substring(1);
		String path = "";
		String action = "getAll" + name2 + ".action";
		if (method != null) {
			action = "query" + name2 + "ByCond.action";
		}

		List<Object> objList = new ArrayList<Object>();
		if (nameList != null && valueList != null) {
			for (int i = 0; i < nameList.size(); i++) {
				path += "&" + nameList.get(i) + "=" + valueList.get(i);
			}
		}
		int pageNumber = list.size();
		int maxPage = pageNumber;
		if (maxPage % pageSize == 0) {
			maxPage = maxPage / pageSize;
		} else {
			maxPage = maxPage / pageSize + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * pageSize;
		int over = (Integer.parseInt(number) + 1) * pageSize;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Object obj = list.get(i);
			objList.add(obj);
		}
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=0" + path + "\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) - 1) + "" + path + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) + 1) + "" + path + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (maxPage - 1) + "" + path + "\">尾页</a>");
		}
		String html = buffer.toString();
		request.setAttribute("html", html);
		request.setAttribute(name + "List", objList);
	}

	public static void getUserPage(List<?> list, String name, String actionName, int pageSize, String number, HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer();
		String path = "";
		String action = actionName + ".action";
		List<Object> objList = new ArrayList<Object>();
		int pageNumber = list.size();
		int maxPage = pageNumber;
		if (maxPage % pageSize == 0) {
			maxPage = maxPage / pageSize;
		} else {
			maxPage = maxPage / pageSize + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * pageSize;
		int over = (Integer.parseInt(number) + 1) * pageSize;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Object obj = list.get(i);
			objList.add(obj);
		}
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=0" + path + "\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) - 1) + "" + path + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (Integer.parseInt(number) + 1) + "" + path + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"" + name + "/" + action + "?number=" + (maxPage - 1) + "" + path + "\">尾页</a>");
		}
		String html = buffer.toString();
		request.setAttribute("html", html);
		request.setAttribute(name + "List", objList);
	}

	public static void getIndexPage(List<?> list, String name, String actionName, String id, int pageSize, String number,
			HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer();
		String path = "";
		String action = actionName + ".action";
		if (!"".equals(id) && id != null) {
			path = "&id=" + id + "";
		}
		List<Object> objList = new ArrayList<Object>();
		int pageNumber = list.size();
		int maxPage = pageNumber;
		if (maxPage % pageSize == 0) {
			maxPage = maxPage / pageSize;
		} else {
			maxPage = maxPage / pageSize + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * pageSize;
		int over = (Integer.parseInt(number) + 1) * pageSize;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Object obj = list.get(i);
			objList.add(obj);
		}
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"index/" + action + "?number=0" + path + "\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"index/" + action + "?number=" + (Integer.parseInt(number) - 1) + "" + path + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"index/" + action + "?number=" + (Integer.parseInt(number) + 1) + "" + path + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/" + action + "?number=" + (maxPage - 1) + "" + path + "\">尾页</a>");
		}
		String html = buffer.toString();
		request.setAttribute("html", html);
		request.setAttribute(name + "List", objList);
	}

}
