package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.service.AlumnoService;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos los datos del Formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);

        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);

        Alumno alumnoNuevo = new Alumno();
        alumnoNuevo.setNombre(nombre);
        alumnoNuevo.setApellido(apellido);
        alumnoNuevo.setDomicilio(domicilio);
        alumnoNuevo.setContacto(contacto);

        AlumnoService servicioAlumno = new AlumnoService();
        servicioAlumno.guardarAlumno(alumnoNuevo);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
