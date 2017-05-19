<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.1/css/bulma.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header>
 	<div class="section">
		<div class="container">
 			<div class="columns">
 				<div class="column is-one-quarter">
	  				<section id="sidemenu">
        				<tiles:insertAttribute name="menu" />
    				</section>
	 			</div>
	 			<div class="column">
	 				<div class="box">
	 					<section id="site-content">
		        			<tiles:insertAttribute name="body" />
		    			</section>
	 				</div>
	 			</div>
 			</div>
 		</div> 	
 	</div>
     
    <footer id="footer" class="footer">
        <div class="container">
        	<tiles:insertAttribute name="footer" />        
        </div>
    </footer>
</body>

</html>