<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
	<h1 class="title">Pattern List</h1>
	<c:if test="${not empty message}">
		<div class="notification is-success">${message}</div>
	</c:if>
	<table class="table">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Pattern Name</th>
				<th>Group</th>
				<th>Implementation</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="pattern" items="${patterns}" >
				<tr>
					<td><c:out value="${pattern.id }"/></td>
					<td><c:out value="${pattern.name }"/></td>
					<td><c:out value="${pattern.group }"/></td>
					<td><c:out value="${pattern.imp }"/></td>
					<td><a href="${pageContext.request.contextPath}/editPattern/${pattern.id}"><span class="icon"><i class="fa fa-pencil " aria-hidden="true"></i></span></a></td>
					<td>
						<form action="${pageContext.request.contextPath}/deletePattern/${pattern.id}" method="POST" id="deleteForm${pattern.id}">
							<a href="#" onclick="document.getElementById('deleteForm${pattern.id}').submit()">
								<span class="icon">
									<i class="fa fa-trash " aria-hidden="true">
									</i>
								</span>
							</a>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/addNewPattern" class="button is-success">Add Pattern</a>
</div>