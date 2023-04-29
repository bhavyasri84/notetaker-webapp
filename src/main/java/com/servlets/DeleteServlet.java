package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entities.Note;
import com.helper.FactoryProvider;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int noteId = Integer.parseInt(req.getParameter("note_id").trim());
			
			Session session = FactoryProvider.getFactory().openSession();
			Note note = session.get(Note.class, noteId);
			session.beginTransaction();
			session.remove(note);
			session.getTransaction().commit();
			session.close();
			resp.sendRedirect("all_notes.jsp");
			
		}
		catch(Exception e){
			
		}
	}

}
