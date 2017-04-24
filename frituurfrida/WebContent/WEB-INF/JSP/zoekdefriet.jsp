<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='head.jsp'>
	<c:param name='title' value='Zoek de friet' />
</c:import>
</head>
<body>
	<h1>Zoek de friet</h1>
	<form method='post'>
		<c:forEach items='${zoekDeFrietSpel.deuren}' var='deur'
			varStatus="status">
			<button type='submit' name='volgnummer' value='${status.index}'>
				<c:choose>
					<c:when test='${deur.open}'>
						<c:choose>
							<c:when test='${deur.metFriet}'>
								<img src='<c:url value="/images/gevonden.png"/>' alt='gevonden'>
							</c:when>
							<c:otherwise>
								<img src='<c:url value="/images/deuropen.png"/>' alt='deur open'>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe'>
					</c:otherwise>
				</c:choose>
			</button>
		</c:forEach>
	</form>
	<c:url value='' var='nieuwSpelURL'>
		<c:param name='nieuwSpel' value='true' />
	</c:url>
	<form method='post' action='${nieuwSpelURL}'>
		<input type='submit' value='Nieuw spel'>
	</form>
</body>
</html>