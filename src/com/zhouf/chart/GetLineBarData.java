package com.zhouf.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import com.google.gson.Gson;
import com.zhouf.db.DBManage;

/**
 * 获取柱和线的图表数据响应，接收sql语句，返回json对象
 */
@WebServlet("/GetLineBarData")
public class GetLineBarData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLineBarData() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		
		String sql = request.getParameter("sql");
		
		
		PrintWriter out = response.getWriter();

		Random r = new Random();
		BarDataBean bean = new BarDataBean();
//		bean.addData("西瓜", r.nextInt(100));
//		bean.addData("冬瓜", r.nextInt(100));
//		bean.addData("南瓜", r.nextInt(100));
//		bean.addData("豆腐", r.nextInt(100));
//		bean.addData("牛肉", r.nextInt(100));
		
		WebRowSet rs = DBManage.getWRS(sql);
		try {
			while(rs.next()){
				String col1 = rs.getString(1);
				double col2 = rs.getDouble(2);
				System.out.println("GetLineBarData.doGet()->col1:" + col1 + " col2:" + col2);
				bean.addData(col1, col2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(bean);
		System.out.println("GetLineBarData.doGet()->str:" + str);
		
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
