package com.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.util.CheckUtil;

/**
 * Servlet implementation class WeiXinServlet
 */
public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WeiXinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr	");
		
		PrintWriter out = response.getWriter();
		if(CheckUtil.checkSingture(signature, timestamp, nonce)){
			out.print(echostr);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
