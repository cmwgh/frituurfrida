<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
<c:param name='title' value="Frituur Frida"/>
</c:import>
</head>
<body>
<h1>Frituur Frida</h1>
<h2>Vandaag zijn we ${openGesloten}</h2>
<img src="images/${openGesloten}.png" alt="${openGesloten}">
<h2>Onze Adres</h2>
<dl>
	<dt>Adres</dt>
	<dd>${frituurFrida.straat} ${frituurFrida.huisNr}<br>
	${frituurFrida.gemeente.postCode} ${frituurFrida.gemeente.naam}</dd>
</dl>

</body>
</html>