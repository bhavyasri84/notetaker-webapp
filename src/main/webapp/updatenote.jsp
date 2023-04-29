<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="all_css_js.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container form-container">
		<div class="row col-sm-9 mt-5 shadow-2 ">
			<div class="card p-5" style="background-color: #8bc34a" >
			<%int noteId = Integer.parseInt(request.getParameter("note_id").trim());

			Session s = FactoryProvider.getFactory().openSession();
			Note note = s.get(Note.class,noteId);
				
			%>
				<form action="UpdateNoteServlet" method="post">
					<input value="<%=note.getId()%>" name="note_id" type="hidden"/>
					<div class="mb-3">
						<label for="notetitle" class="form-label" style="color: #ff9e80">Title</label>
						<input required name="title" type="text" class="form-control"
							id="title" value=<%= note.getTitle() %>>
					</div>
					<div class="mb-3">
						<label for="content" class="form-label" style="color: #ff9e80">
							Content</label>
						<textarea required name="content" type="content"
							class="form-control" id="content" style="height: 200px" value=<%=note.getContent() %>></textarea>
					</div>
					<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>

		</div>


	</div>

</body>
</html>