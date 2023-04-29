<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<%@include file="all_css_js.jsp"%>

</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container d-flex justify-content-center">
		<div class="row ">
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>
				<div class="card mt-3" style="width: 30rem;">
					<div class="card-body">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text"><%=note.getContent()%></p>
						<a href="updatenote.jsp?note_id=<%=note.getId()%>"><button class="btn btn-primary mr-2">Edit</button></a> 
						<a href="DeleteServlet?note_id=<%=note.getId()%>"><button class="btn btn-danger">Delete</button></a>
					</div>
				</div>
				<%
				}
				s.close();
				%>

			</div>
		</div>

	</div>

</body>
</html>