<%@ page pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8" />
<title>Connexion</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/styles.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/bootstrap/bootstrap.css" />" />
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
</head>

<body>
	<form method="post" class="form-horizontal"
		action="<c:url value="/connexion" />">
		<h2 class="text-center">Connexion</h2>
		<div class="container index">
			<fieldset>


				<div class="container-fluid ">

					<div class="form-group">
						<label for="nom" class="control-label col-md-4">Adresse
							email </label>
						<div class=" col-md-4">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Champ obligatoire"
								value="<c:out value="${utilisateur.email}"/>" /> <span
								class="erreur">${form.erreurs['email']}</span>
						</div>
					</div>

					<div class="form-group">
						<label for="motdepasse" class="control-label col-md-4">Mot
							de passe </label>
						<div class=" col-md-4">
							<input type="password" class="form-control" id="motdepasse"
								name="motdepasse" placeholder="Champ obligatoire" value="" /> <span
								class="erreur">${form.erreurs['motdepasse']}</span>
						</div>
					</div>

					<input name="Connexion" type="submit" value="Connexion"
						class="btn btn-default btn-lg" />


					<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

				</div>

				<%-- Vérification de la présence d'un objet utilisateur en session --%>

				<c:if test="${!empty sessionScope.sessionUtilisateur}">

					<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>

					<p class="succes">Vous êtes connecté(e) avec l'adresse :
						${sessionScope.sessionUtilisateur.email}</p>

				</c:if>

			</fieldset>
			<br> <a class="text-center a-black" href="/intranet/">Vous
				ne possèdez pas déjà un compte ?</a>
		</div>
	</form>
</body>

</html>