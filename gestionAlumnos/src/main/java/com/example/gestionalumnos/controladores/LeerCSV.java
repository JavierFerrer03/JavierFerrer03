package com.example.gestionalumnos.controladores;

import com.example.gestionalumnos.util.Conexion;
import com.example.gestionalumnos.repositorio.DAOAlumnoImple;

import java.sql.Connection;

public class LeerCSV {
    public static void main(String[] args) {
        DAOAlumnoImple dao=new DAOAlumnoImple();
        Connection conex=Conexion.conectar();
        dao.insertarAlumnos(conex);
    }
}
