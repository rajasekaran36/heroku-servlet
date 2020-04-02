package com.kgisl.raja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewDataWeb extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        Connection con = (Connection) getServletContext().getAttribute("dbconnection");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                writer.println("<tr>");
                writer.println("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>");
                writer.println("<tr>");       
            }
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
    }
}