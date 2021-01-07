package mx.com.gm.web;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.service.AlumnoService;

@WebServlet("/ServletCotrolador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        AlumnoService servicioAlumno = new AlumnoService();
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();
        request.setAttribute("alumnos", alumnos);
        try {
            request.getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

}
