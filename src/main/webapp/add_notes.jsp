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
			<div class="card p-5" style="background-color: #6a1b9a" >
				<form action="SaveNoteServlet" method="post">
					<div class="mb-3">
						<label for="notetitle" class="form-label" style="color: #ff9e80">Title</label>
						<input required name="title" type="text" class="form-control"
							id="title">
					</div>
					<div class="mb-3">
						<label for="content" class="form-label" style="color: #ff9e80">
							Content</label>
						<textarea required name="content" type="content"
							class="form-control" id="content" style="height: 200px"></textarea>
					</div>
					<button type="submit" class="btn btn-success">Add Note</button>
				</form>
			</div>

		</div>


	</div>

</body>
</html>