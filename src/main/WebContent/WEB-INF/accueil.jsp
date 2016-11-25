<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/stylesheets/styles.css" />">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/bootstrap/bootstrap.css" />" />
<title></title>
<p>Vous êtes connecté(e) avec l'adresse
	${sessionScope.sessionUtilisateur.email}</p>
</head>
<body>

	<div class="container-fluid">
		<a class="logout" href="/intranet/deconnexion"></a>
	</div>



	<div class="container index">

		<a class="menu a-black" href="/intranet/accueil">Accueil</a> <a
			class="menu a-black" href="/intranet/page">Page</a> <a
			class="menu a-black" href="/intranet/accueil">Accueil</a> <a
			class="menu a-black" href="/intranet/accueil">Accueil</a> <a
			class="menu a-black" href="/intranet/accueil">Accueil</a> <a
			class="menu a-black" href="/intranet/accueil">Accueil</a>

	</div>


</body>
</html>