<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='head.jsp'>
	<c:param name='title' value='Gastenboek' />
</c:import>
</head>
<body>
	<h1>Gastenboek</h1>
	<c:if test='${not empty beheer}'>
		<form method='post'>
			<input type='submit' value='Uitloggen' name='uitloggen'>
		</form>
	</c:if>
	<c:choose>
		<c:when test='${empty param.toevoegen}'>
			<a href='<c:url value="/gastenboek.htm?toevoegen=true"/>'>Toevoegen</a>
		</c:when>
		<c:otherwise>
			<form method='post'>
				<label>Naam:<span>${fouten.naam}</span><input name='naam'
					autofocus required value='${param.naam}'></label> <label>Bericht:<span>${fouten.bericht}</span>
					<textarea name='bericht' required rows='5' cols='80'>${param.bericht}</textarea></label>
				<input type='submit' value='Toevoegen' name='toevoegen'>
			</form>
		</c:otherwise>
	</c:choose>
	<c:if test='${not empty gastenboek}'>
		<c:if test='${not empty beheer}'>
			<form method='post'>
		</c:if>
		<dl>
			<c:forEach var='entry' items='${gastenboek}'>
				<fmt:parseDate value="${entry.datum}" pattern="yyyy-MM-dd"
					var="datumAlsDate" type="date" />
				<dt>
					<fmt:formatDate value='${datumAlsDate}' type='both'
						dateStyle='short' timeStyle='short' />
					${entry.naam}
					<c:if test='${not empty beheer}'>
						<input type='checkbox' name='id' value='${entry.id}'>
					</c:if>
				</dt>
				<dd>${entry.bericht}</dd>
			</c:forEach>
			<c:if test='${not empty beheer}'>
				<input type='submit' value='Verwijderen' name='verwijderen'>
				</form>
			</c:if>
		</dl>
	</c:if>
</body>
</html>