package com.example.gestionalumnos.repositorio;

import com.example.gestionalumnos.modelo.Alumno;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

public interface DAOAlumno {
    public void insertarAlumnos(Connection conn);
    public ArrayList<Alumno>mostrarAlumnos();
    public Alumno obtenerAlumnoPorEmail(String email);
    public void añadirAlumno(Alumno alum);
    public boolean modificarAlumno(Alumno alum);
    public void eliminarAlumno(String telefono);
    public ArrayList<Alumno>filtrarLocalidad(String localidad);
}
