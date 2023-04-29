package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entities.Note;
import com.helper.FactoryProvider;


public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Note note = new Note();
			note.setTitle(title);

			note.setContent(content);
			Session session = FactoryProvider.getFactory().openSession();
			session.beginTransaction();
			session.save(note);
			session.getTransaction().commit();
			session.close();
			response.getWriter().print("Notes added successfully");
			response.sendRedirect("all_notes.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
