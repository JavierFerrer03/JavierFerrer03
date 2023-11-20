package com.example.gestionalumnos.modelo;

import com.example.gestionalumnos.repositorio.DAOAlumnoImple;

import java.util.ArrayList;

public class Alumno {
    private String apellidos;
    private String nombre;
    private String email;
    private String telefono;
    private String localidad_residencia;
    private String ciclo_matriculado;
    private int nivel_prestaciones;
    private String carnet_conducir;
    private String estudios_realizados;
    private String fecha_nacimiento;
    private String motivacion_curso;
    private String hobbies;

    public Alumno(){
        this.apellidos="";
        this.nombre="";
        this.email="";
        this.telefono="";
        this.localidad_residencia="";
        this.ciclo_matriculado="";
        this.nivel_prestaciones=0;
        this.carnet_conducir="";
        this.estudios_realizados="";
        this.motivacion_curso="";
        this.hobbies="";
    }
    public Alumno(String apellidos, String nombre, String email, String telefono, String localidad_residencia, String ciclo_matriculado, int nivel_prestaciones, String carnet_conducir, String estudios_realizados, String fecha_nacimiento, String motivacion_curso, String hobbies) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.localidad_residencia = localidad_residencia;
        this.ciclo_matriculado = ciclo_matriculado;
        this.nivel_prestaciones = nivel_prestaciones;
        this.carnet_conducir = carnet_conducir;
        this.estudios_realizados = estudios_realizados;
        this.fecha_nacimiento = fecha_nacimiento;
        this.motivacion_curso = motivacion_curso;
        this.hobbies = hobbies;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad_residencia() {
        return localidad_residencia;
    }

    public void setLocalidad_residencia(String localidad_residencia) {
        this.localidad_residencia = localidad_residencia;
    }

    public String getCiclo_matriculado() {
        return ciclo_matriculado;
    }

    public void setCiclo_matriculado(String ciclo_matriculado) {
        this.ciclo_matriculado = ciclo_matriculado;
    }

    public int getNivel_prestaciones() {
        return nivel_prestaciones;
    }

    public void setNivel_prestaciones(int nivel_prestaciones) {
        this.nivel_prestaciones = nivel_prestaciones;
    }

    public String getCarnet_conducir() {
        return carnet_conducir;
    }

    public void setCarnet_conducir(String carnet_conducir) {
        this.carnet_conducir = carnet_conducir;
    }

    public String getEstudios_realizados() {
        return estudios_realizados;
    }

    public void setEstudios_realizados(String estudios_realizados) {
        this.estudios_realizados = estudios_realizados;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getMotivacion_curso() {
        return motivacion_curso;
    }

    public void setMotivacion_curso(String motivacion_curso) {
        this.motivacion_curso = motivacion_curso;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", localidad_residencia='" + localidad_residencia + '\'' +
                ", ciclo_matriculado='" + ciclo_matriculado + '\'' +
                ", nivel_prestaciones=" + nivel_prestaciones +
                ", carnet_conducir='" + carnet_conducir + '\'' +
                ", estudios_realizados='" + estudios_realizados + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", motivacion_curso='" + motivacion_curso + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DAOAlumnoImple daoAlum=new DAOAlumnoImple();
        ArrayList<Alumno>listaDeAlumnos=daoAlum.mostrarAlumnos();
        for (Alumno a: listaDeAlumnos){
            System.out.println(a.apellidos + " "+ a.nombre);
        }
    }

}
