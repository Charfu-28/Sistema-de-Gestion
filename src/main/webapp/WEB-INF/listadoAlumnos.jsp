<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<html>
    <head>        
        <title>Listado de Alumnos</title>
    </head>
    <body>
        <table border="1">
            <caption>
                Listar Alumnos
            </caption>            
            <tr>
                <th>Alumno ID</th>
                <th>Nombbre</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Acción</th>
            </tr>
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                    <td>${alumno.idAlumno}</td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>${alumno.domicilio.calle} ${alumno.domicilio.noCalle} ${alumno.domicilio.pais}</td>
                    <td>${alumno.contacto.email}</td>
                    <td>${alumno.contacto.telefono}</td>
                    <td><a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}"><i class="fas fa-edit"></i></a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar Alumno</a>
    </body>
</html>
