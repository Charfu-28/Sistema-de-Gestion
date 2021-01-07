package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.domain.Alumno;

public class AlumnoService {

    private AlumnoDAO alumnoDao = new AlumnoDAO();

    public List<Alumno> listarAlumnos() {
        return alumnoDao.listar();
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return alumnoDao.buscarAlumno(alumno);
    }

    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDao.insertar(alumno);
        } else {
            alumnoDao.modificar(alumno);
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnoDao.eliminar(alumno);
    }

}
