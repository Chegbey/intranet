<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="<c:url value="/resources/stylesheets/styles.css" />">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/stylesheets/bootstrap/bootstrap.css" />" />
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">

<title></title>
</head>
<body>
	<form method="post" action="inscription" class="form-horizontal">

		<h2 class="text-center">Inscription</h2>

		<div class="container index">

			<fieldset>


				<div class="container-fluid ">
					<c:choose>
						<c:when test="${ form.getemail_valid() == true }">

							<div class="form-group has-success ">
								<label class="control-label col-md-4" for="email">Adresse
									email</label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="email"
										aria-describedby="helpBlock2"
										value="<c:out value="${utilisateur.email}"/>"
										placeholder="Champ Obligatoire"> <span id="email"
										class="help-block"></span>
								</div>
							</div>

						</c:when>
						<c:when test="${ form.getemail_valid() == false }">

							<div class="form-group has-error has-feedback ">
								<label class="control-label col-md-4" for="email">Adresse
									email</label>
								<div class="col-md-4">
									<input type="text" class="form-control " id="email"
										aria-describedby="inputError2Status"
										value="<c:out value="${utilisateur.email}"/>"
										placeholder="Champ Obligatoire"> <span
										class="glyphicon glyphicon-remove form-control-feedback"
										aria-hidden="true"></span> <span id="email" class="sr-only"></span>
									<span>${form.erreurs['email']}</span> <span>${ form.getemail_valid() }</span>
								</div>
							</div>

						</c:when>
						<c:otherwise>

							<div class="form-group">
								<label for="email" class="col-md-4 control-label">Adresse
									email</label>
								<div class="col-md-4">
									<input type="text" id="email" class="form-control" name="email"
										value="<c:out value="${utilisateur.email}"/>"
										placeholder="Champ Obligatoire" />
								</div>
							</div>

						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${ form.getpass_valid() == true }">

							<div class="form-group has-success ">
								<label class="control-label col-md-4" for="motdepasse">Mot
									de passe </label>
								<div class="col-md-4">
									<input type="password" class="form-control" id="motdepasse"
										aria-describedby="helpBlock2" value=""
										placeholder="Champ Obligatoire"> <span id="motdepasse"
										class="help-block"></span>
								</div>
							</div>

						</c:when>
						<c:when test="${ form.getpass_valid() == false }">

							<div class="form-group has-error has-feedback ">
								<label class="control-label col-md-4" for="motdepasse">Mot
									de passe </label>
								<div class="col-md-4">
									<input type="password" class="form-control " id="motdepasse"
										aria-describedby="inputError2Status" value=""
										placeholder="Champ Obligatoire"> <span
										class="glyphicon glyphicon-remove form-control-feedback"
										aria-hidden="true"></span> <span id="motdepasse"
										class="sr-only"></span> <span>${form.erreurs['motdepasse']}</span>
									<span>${ form.getpass_valid() }</span>
								</div>
							</div>

						</c:when>
						<c:otherwise>

							<div class="form-group">
								<label for="motdepasse" class="col-md-4 control-label">Mot
									de passe </label>
								<div class="col-md-4">
									<input type="password" id="motdepasse" class="form-control"
										name="motdepasse" value="" placeholder="Champ Obligatoire" />
								</div>
							</div>

						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${ form.getconf_valid() == true }">

							<div class="form-group has-success ">
								<label class="control-label col-md-4" for="confirmation">Confirmation
									Mot de passe </label>
								<div class="col-md-4">
									<input type="password" class="form-control" id="confirmation"
										aria-describedby="helpBlock2" value=""
										placeholder="Champ Obligatoire"> <span
										id="confirmation" class="help-block">Bravo !</span>
								</div>
							</div>

						</c:when>
						<c:when test="${ form.getconf_valid() == false }">

							<div class="form-group has-error has-feedback ">
								<label class="control-label col-md-4" for="confirmation">Confirmation
									Mot de passe </label>
								<div class="col-md-4">
									<input type="password" class="form-control " id="confirmation"
										aria-describedby="inputError2Status" value=""
										placeholder="Champ Obligatoire"> <span
										class="glyphicon glyphicon-remove form-control-feedback"
										aria-hidden="true"></span> <span id="confirmation"
										class="sr-only"></span> <span>${form.erreurs['confirmation']}</span>
								</div>
							</div>

						</c:when>
						<c:otherwise>

							<div class="form-group">
								<label for="confirmation" class="col-md-4 control-label">Confirmation
									Mot de passe </label>
								<div class="col-md-4">
									<input type="password" id="confirmation" class="form-control"
										name="confirmation" value="" placeholder="Champ Obligatoire" />
								</div>
							</div>

						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${ form.getnom_valid() == true }">

							<div class="form-group has-success ">
								<label class="control-label  col-md-4" for="nom">Nom
									d'utilisateur </label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="nom"
										aria-describedby="helpBlock2"
										value="<c:out value="${utilisateur.nom}"/>" /> <span id="nom"
										class="help-block">Bravo !</span>
								</div>
							</div>

						</c:when>
						<c:when test="${ form.getnom_valid() == false }">

							<div class="form-group has-error has-feedback ">
								<label class="control-label col-md-4" for="nom">Nom
									d'utilisateur </label>
								<div class="col-md-4">
									<input type="text" class="form-control " id="nom"
										aria-describedby="inputError2Status"
										value="<c:out value="${utilisateur.nom}"/>" /> <span
										class="glyphicon glyphicon-remove form-control-feedback"
										aria-hidden="true"></span> <span id="nom" class="sr-only"></span>
									<span>${form.erreurs['nom']}</span>
								</div>
							</div>

						</c:when>
						<c:otherwise>


							<div class="form-group ">
								<label for="nom" class="col-md-4 control-label">Nom
									d'utilisateur </label>
								<div class="col-md-4">
									<input type="text" id="nom" class="form-control" name="nom"
										value="<c:out value="${utilisateur.nom}"/>" />

								</div>
							</div>

						</c:otherwise>
					</c:choose>

					<div class="form-group">
						<div class="text-center">
							<input type="submit" value="Inscription"
								class="btn btn-default btn-lg" />
						</div>
					</div>

					<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
				</div>
			</fieldset>

			</br> <a class="text-center a-black" href="/intranet/connexion">Vous
				possèdez déjà un compte ?</a>


		</div>
	</form>
</body>
</html>