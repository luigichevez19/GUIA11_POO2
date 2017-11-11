<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de Libros</title>
</head>
<body>
	<h1>Nuevo Libro</h1>
	<form:form action="guardarLibro" method="post" modelAttribute="objeLibro">
		<form:hidden path="codi_libr"/>
		<form:input path="nomb_libr" />
		<form:input path="auto_libr" />
		<form:input path="gene_libr" />
		<form:input path="anio_libr" />
		<form:input path="esta_libr" />
	
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>