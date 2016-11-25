<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/styles.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/bootstrap/bootstrap.css" />" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<%@ include file="menu.jsp"%>
<body id="body" data-data='${json}'>

	<div id="table" class="container-fluid marge">
		<div class="form-group">
			<input type="text" class="search form-control "
				placeholder="recherche">
		</div>
		<span class="counter pull-right"></span>
	
	<table class="sortable table table-bordered table-striped results"
		id="sortable">

		<thead>
			<tr class="">
				<td><a class="a-white" id="numero" href="#"> Numéro <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
				<td><a class="a-white" id="nom" href="#"> Nom <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
				<td><a class="a-white" id="secteur" href="#"> secteur <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
				<td><a class="a-white" id="maproj" href="#"> maproj <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
				<td><a class="a-white" id="devi" href="#"> Devis <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
				<td><a class="a-white" id="demand" href="#"> Demande <span
						class="fa fa-caret-down"></span> <span class="fa fa-caret-up"></span>
				</a></td>
			</tr>

		</thead>

		<tbody>

			<tr class="warning no-result">
				<td class="text-center" colspan="6"><i class="fa fa-warning"></i>
					Pas de résultat</td>
			</tr>


			<c:forEach items="${projets}" var="projet">

				<tr class="btn-tr" id="myBtn${projets.indexOf(projet)}" value="#"
					onclick="addmodal(${projets.indexOf(projet)})"
					data-data="${jsonprojets.get(projets.indexOf(projet)).getAsJsonObject()}">

					<td><c:out value="${projet.getnuproj()}" /></td>
					<td><c:out value="${projet.getlibeco()}" /></td>
					<td><c:out value="${projet.getsecteu()}" /></td>
					<td><c:out value="${projet.getmaproj()}" /></td>
					<td><c:out value="${projet.getaudevi()}" /></td>
					<td><c:out value="${projet.getdemand()}" /></td>

				</tr>

			</c:forEach>






		</tbody>
	</table>
	</div>
	<div id="main"></div>
	<script src="<c:url value="/resources/javascripts/hamburger.js" />"></script>
	<script src="<c:url value="/resources/javascripts/modal.js" />"></script>
	<script src="<c:url value="/resources/javascripts/sorttable.js" />"></script>
	<script src="<c:url value="/resources/javascripts/jquery-3.1.1.js" />"></script>
	<script
		src="<c:url value="/resources/javascripts/jquery-3.1.1.min.js" />"></script>
	<script src="<c:url value="/resources/javascripts/search.js" />"></script>
</body>
</html>