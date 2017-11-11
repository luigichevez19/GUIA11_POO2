<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de Libros</title>
</head>
<body>
	<h1>Lista de Libros</h1>
	<h3>
	    <a href="nuevoLibro">Nuevo Libro</a>
	</h3>
	<table border="1">	
	    <th>Código</th>
	    <th>Nombre</th>
	    <th>Nombre Autor</th>
	    <th>Genero</th>
	    <th>Año</th>
	    <th>Estado</th>	
	   <c:forEach var="libroTemp" items="${listLibro}">
	        <tr>
	            <td><c:out value = "${libroTemp.codi_libr}"/></td>
	            <td>${libroTemp.nomb_libr}</td>
	            <td>${libroTemp.auto_libr}</td>
	            <td>${libroTemp.gene_libr}</td>
	            <td>${libroTemp.anio_libr}</td>
	            <td>${libroTemp.esta_libr}</td>
	            <td>
		            <a href="editarLibro?codi=${libroTemp.codi_libr}">Editar</a>
	                <a href="eliminarLibro?codi=${libroTemp.codi_libr}">Eliminar</a>
                </td>
	        </tr>
	    </c:forEach> 
	</table>
</body>
</html>