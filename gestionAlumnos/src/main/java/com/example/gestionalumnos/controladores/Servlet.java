package com.example.gestionalumnos.controladores;

import com.example.gestionalumnos.modelo.Alumno;
import com.example.gestionalumnos.repositorio.DAOAlumnoImple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

@WebServlet(name = "servlet", value = "/servlet")
public class
Servlet extends HttpServlet {

    DAOAlumnoImple dao=new DAOAlumnoImple();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String action=request.getParameter("action");

        switch (action){
            case "login":
                login(request, response);
                break;
            case "add":
                addAlumno(request, response);
                mostrarAlum(request, response);
                break;
            case "delete":
                deleteAlum(request, response);
                mostrarAlum(request, response);
                break;
            case "filtrar":
                filtrarLocalidad(request, response);
                break;
            case "change":
                changeAlumno(request, response);
                break;
            case "irAChange":
                irAChange(request,response);
                break;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    //Método para inicar sesión y acceder al login si el email y el teléfono son correctos
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String email=request.getParameter("email");
        String telefono=request.getParameter("telefono");
        ArrayList<Alumno>alumnos=dao.mostrarAlumnos();
        //Comprobación que el email y el telefono correspone con alguno de la lista de los alumnos
        for(Alumno a: alumnos){
            if(email.equals(a.getEmail()) && telefono.equals(a.getTelefono())){
                mostrarAlum(request, response);
            }
        }
        //Condición para acceder siendo administrador
        if(email.equals("admin") && telefono.equals("admin")){
            mostrarAlum(request, response);
        }
        if(email=="" && telefono==""){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //Método para mostrar todos los alumnos que se encuentran registrados en la base de datos
    public void mostrarAlum(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        ArrayList<Alumno>listaAlumnos=dao.mostrarAlumnos();
        request.setAttribute("listaAlumnos", listaAlumnos);
        request.getRequestDispatcher("alumno.jsp").forward(request, response);
    }

    //Método para recoger los datos de un nuevo alumno de un formulario e insertarlo en la base de datos
    public void addAlumno(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String apellidosAlum=request.getParameter("apellidosAlum");
        String nombreAlum=request.getParameter("nombreAlum");
        String emailAlum=request.getParameter("emailAlum");
        String telefonoAlum=request.getParameter("telefonoAlum");
        String localidadAlum=request.getParameter("localidadAlum");
        String cicloAlum=request.getParameter("cicloAlum");
        int nivelAlum=Integer.parseInt(request.getParameter("nivelAlum"));
        String carnetAlum=request.getParameter("carnetAlum");
        String estudiosAlum=request.getParameter("estudiosAlum");
        String fechaAlum=request.getParameter("fechaAlum");
        String motivacionAlum=request.getParameter("motivacionAlum");
        String hobbiesAlum=request.getParameter("hobbiesAlum");

        Alumno newAlumno = new Alumno(apellidosAlum, nombreAlum, emailAlum, telefonoAlum, localidadAlum, cicloAlum, nivelAlum, carnetAlum, estudiosAlum, fechaAlum, motivacionAlum, hobbiesAlum);
        dao.añadirAlumno(newAlumno);
    }

    //Método para eliminar un alumno que se encuentra en la base de datos
    public void deleteAlum(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String telefonoAlum=request.getParameter("telefonoAlum");
        ArrayList<Alumno>misAlumnos=dao.mostrarAlumnos();
        //Recorro el array para comprobar que el telefono coincide con alguno de los alumnos de la base de datos
        for (Alumno a: misAlumnos){
            //Condición para comprobar que si el telefono coincide eliminarlo
            if(a.getTelefono().equals(telefonoAlum)){
                dao.eliminarAlumno(telefonoAlum);
            }
        }
        //Si esta condición se cumple redirigiremos a una página de error
        if(telefonoAlum==""){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //Método para modificar el alumno que tenemos registrado en la base de datos
    public void changeAlumno(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher rd;
        try {
            String apelMod = request.getParameter("apellidos");
            String nombreMod = request.getParameter("nombre");
            String emailMod = request.getParameter("email");
            String telefonoMod = request.getParameter("telefono");
            String locMod = request.getParameter("localidad_residencia");
            String cicloMod = request.getParameter("ciclo_matriculado");
            String prestaMod = request.getParameter("nivel_prestaciones");
            int nivelPrestacionesMod = 0;
            if (prestaMod != null && !prestaMod.isEmpty()) {
                nivelPrestacionesMod = Integer.parseInt(prestaMod);
            }
            String carnetMod = request.getParameter("carnet_conducir");
            String estuMod = request.getParameter("estudios_realizados");
            String fechaMod = request.getParameter("fecha_nacimiento");
            String motivacionMod = request.getParameter("motivacion_curso");
            String hobbiesMod = request.getParameter("hobbies");
            Alumno alumnoModificado = new Alumno(apelMod, nombreMod, emailMod, telefonoMod, locMod, cicloMod, nivelPrestacionesMod, carnetMod, estuMod, fechaMod, motivacionMod, hobbiesMod);
            dao.modificarAlumno(alumnoModificado);

            ArrayList<Alumno>listaAlumnos=dao.mostrarAlumnos();
            request.setAttribute("listaAlumnos", listaAlumnos);
            request.getRequestDispatcher("alumno.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo para ir a la página de eliminar alumnos
    public void irAChange (HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String email = request.getParameter("email");
        Alumno alu = dao.obtenerAlumnoPorEmail(email);
        request.setAttribute("alumno", alu);
        request.getRequestDispatcher("editAlum.jsp").forward(request, response);
    }

    //Método para filtrar a los alumnos por su localidad
    public void filtrarLocalidad(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String localidad=request.getParameter("localidad");
        ArrayList<Alumno>listaAlumnos=dao.filtrarLocalidad(localidad);
        request.setAttribute("listaAlumnos", listaAlumnos);
        request.getRequestDispatcher("alumno.jsp").forward(request, response);
    }
    public void destroy() {
    }

}