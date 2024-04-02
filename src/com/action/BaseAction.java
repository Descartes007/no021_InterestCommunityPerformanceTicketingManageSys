package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Action 基类
 */
@Controller
public class BaseAction {

	/* 日志 */
	protected final Log log = LogFactory.getLog(getClass());

	/* 获取基本环境 */
	public Map<String, String[]> getParameters() {// 封装为Map的requestParameters
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest().getParameterMap();
	}

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	public HttpSession getSession() {
		HttpSession session = null;
		try {
			session = this.getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	/* 向客户端输出操作成功或失败信息 */
	public void writeJsonResponse(String success) throws IOException, JSONException {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = attrs.getResponse();
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 将要被返回到客户端的对象
		JSONObject json = new JSONObject();
		json.accumulate("result", success);
		System.out.println(json.toString());
		out.println(json.toString());
		out.flush();
		out.close();
	}
}
