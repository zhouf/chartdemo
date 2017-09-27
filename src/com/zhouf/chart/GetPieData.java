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
@WebServlet("/GetPieData")
public class GetPieData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPieData() {
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
		
		PieDataBean bean = new PieDataBean();
		bean.addData("华为", r.nextInt(100));
		bean.addData("三星", r.nextInt(100));
		bean.addData("小米", r.nextInt(100));
		bean.addData("锤子", r.nextInt(100));
		bean.addData("苹果", r.nextInt(100));
		
		Gson gson = new Gson();
		String str = gson.toJson(bean);
		System.out.println("GetPieData.doGet()->str:" + str);
		
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
