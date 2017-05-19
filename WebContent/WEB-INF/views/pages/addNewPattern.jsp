<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1 class="title">Pattern Add Form</h1>
${message}
<form:form method="POST" action="${pageContext.request.contextPath}/addNewPattern" modelAttribute="pattern">
	<div class="field">
		<form:label path="name" class="label">Pattern Name</form:label>
		<p class="control">
			<form:input path="name" class="input" placeholder="What is this pattern called ?"/>			
		</p>
	</div>
	<div class="field">
		<form:label path="group" class="label">Pattern Group</form:label>
		<p class="control">
			<form:input path="group" class="input" placeholder="Which group is this pattern in ?"/>
		</p>
	</div>
	<div class="field">
		<form:label path="imp" class="label">Implementation</form:label>
		<p class="control">
			<form:input path="imp" class="input" placeholder="Where can this pattern be implemented ?"/>
		</p>
	</div>
	<div class="field">
		<p class="control">
			<button type="submit" class="button is-success">Save</button>
		</p>
	</div>
</form:form>