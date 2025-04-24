package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/user")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("action");
		
		if(type.equals("register")) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String eamil = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String postal = request.getParameter("postal");
			
			//PrintWriter out = response.getWriter();
			
			try {
				Connection conn = Helper.getConnection();
				PreparedStatement ps = conn.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, gender);
				ps.setString(4, eamil);
				ps.setString(5, phone);
				ps.setString(6, address);
				ps.setInt(7, Integer.parseInt(postal));
				
				int res = ps.executeUpdate();
				if(res>0) {
					request.setAttribute("msg","Please login to continue");
					request.getRequestDispatcher("login.jsp").forward(request, response); 
				}
				else {
					request.setAttribute("msg","Registration failed try again");
					request.getRequestDispatcher("register.jsp").forward(request, response); 
				}
				Helper.close(conn,ps);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			try {
				Connection conn = Helper.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from register where name=? and password=?");
				ps.setString(1, name);
				ps.setString(2, password);
				
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					request.setAttribute("name",name);
					request.getRequestDispatcher("index.jsp").forward(request, response); 
				}
				else {
					request.setAttribute("msg","Invalid credentail login again!");
					request.getRequestDispatcher("login.jsp").forward(request, response); 
				}
				Helper.close(conn, ps);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
