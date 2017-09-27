package com.zhouf.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetCharDate
 */
@WebServlet("/GetCharData")
public class GetCharData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCharData() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();

		Random r = new Random();
		BarDataBean bean = new BarDataBean();
		bean.addData("西瓜", r.nextInt(100));
		bean.addData("冬瓜", r.nextInt(100));
		bean.addData("南瓜", r.nextInt(100));
		bean.addData("豆腐", r.nextInt(100));
		bean.addData("牛肉", r.nextInt(100));
		
		Gson gson = new Gson();
		String str = gson.toJson(bean);
		System.out.println("GetCharDate.doGet()->str:" + str);
		
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
