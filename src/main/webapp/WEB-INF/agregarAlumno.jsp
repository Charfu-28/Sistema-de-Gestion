<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletAgregar" method="POST">
            Nombre: <input type="text" name="nombre" /><br/>
            Apellido: <input type="text" name="apellido" /><br/><br/>
            Datos Domicilio:<br/>
            Calle: <input name="calle" type="text" /><br/>
            No.Calle: <input name="noCalle" type="text" /><br/>
            País: <input name="pais" type="text" /><br/><br/>
            Datos Contacto:<br/>
            Email: <input name="email" type="email" /><br/>
            Teléfono: <input name="telefono" type="tel" /><br/><br/>
            <input type="submit" value="Guardar" name="Guardar" />
        </form>
    </body>
</html>
