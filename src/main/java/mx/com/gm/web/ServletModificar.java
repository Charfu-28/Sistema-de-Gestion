package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.service.AlumnoService;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAlumnoS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        AlumnoService servicioAlumno = new AlumnoService();
        alumno = servicioAlumno.buscarAlumno(alumno);

        //request.setAttribute("alumno", alumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);
        request.getRequestDispatcher("/WEB-INF/editarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actualizar = request.getParameter("Actualizar");        
        AlumnoService servicioAlumno = new AlumnoService();

        if (actualizar != null) {
            // Recuperamos los datos del Formulario
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            
            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            // Quitamos el objeto alumno de sesion para no propagar esta información
            sesion.removeAttribute("alumno");
        } 
        else {
            // Caso eliminar
            String idAlumnoString = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoString);
            Alumno alumnoEliminar = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumnoEliminar);            
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
