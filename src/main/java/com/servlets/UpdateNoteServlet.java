package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entities.Note;
import com.helper.FactoryProvider;


public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteid = Integer.parseInt(request.getParameter("note_id"));
			
			Session session = FactoryProvider.getFactory().openSession();
			Note note = session.get(Note.class,noteid);
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			session.beginTransaction();
			note.setTitle(title);
			note.setContent(content);
			session.update(note);
			session.getTransaction().commit();
			session.close();
			
			response.sendRedirect("all_notes.jsp");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		
	}

}
