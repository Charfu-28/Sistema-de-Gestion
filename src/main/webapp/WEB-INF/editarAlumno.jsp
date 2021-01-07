<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Editar Alumno</title>
    </head>
    <body>
        <h1>Editar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletModificar" method="POST">
            <input type="hidden" name="idAlumno" value="${alumno.idAlumno}" />
            Nombre: <input type="text" name="nombre" value="${alumno.nombre}" /><br/>
            Apellido: <input type="text" name="apellido" value="${alumno.apellido}" /><br/><br/>
            Datos Domicilio:<br/>
            Calle: <input name="calle" type="text" value="${alumno.domicilio.calle}" /><br/>
            No.Calle: <input name="noCalle" type="text" value="${alumno.domicilio.noCalle}" /><br/>
            País: <input name="pais" type="text" value="${alumno.domicilio.pais}" /><br/><br/>
            Datos Contacto:<br/>
            Email: <input name="email" type="email" value="${alumno.contacto.email}" /><br/>
            Teléfono: <input name="telefono" type="tel" value="${alumno.contacto.telefono}" /><br/><br/>
            <input type="submit" value="Actualizar" name="Actualizar" />
            <input type="submit" value="Eliminar" name="Eliminar"  />
        </form>
    </body>
</html>
