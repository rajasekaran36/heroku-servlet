package com.kgisl.raja;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgisl.raja.model.Student;

@WebServlet("/add")
public class SaveDataToDB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = (Connection) getServletContext().getAttribute("dbconnection");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into student values ('"+id+"','"+name+"')");
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}