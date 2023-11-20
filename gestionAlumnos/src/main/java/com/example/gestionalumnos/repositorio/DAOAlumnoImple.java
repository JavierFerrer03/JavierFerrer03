package com.example.gestionalumnos.repositorio;

import com.example.gestionalumnos.modelo.Alumno;
import com.example.gestionalumnos.util.Conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

public class DAOAlumnoImple implements DAOAlumno{

    //Método para insertar los alumnos en la base de datos
    @Override
    public void insertarAlumnos(Connection conn) {
        String ficheroCSV="/home/alumno/Actividades/gestionAlumnos/alumnos.csv";
        String insertQuery="INSERT INTO Alumnos (Apellidos, Nombre, Email, Telefono, Localidad_residencia, Ciclo_matriculado, Nivel_prestaciones, Carnet_conducir, Estudios_realizados, Fecha_nacimiento, Motivacion_curso, Hobbies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr = conn.prepareStatement(insertQuery);
            BufferedReader br=new BufferedReader(new FileReader(ficheroCSV));
            String linea;
            br.readLine();
            while ((linea=br.readLine()) !=null){
                String[] datos=linea.split(";");
                pr.setString(1, datos[0]);
                pr.setString(2, datos[1]);
                pr.setString(3, datos[2]);
                pr.setString(4, datos[3]);
                pr.setString(5, datos[4]);
                pr.setString(6, datos[5]);
                pr.setInt(7,Integer.parseInt(datos[6]));
                pr.setString(8, datos[7]);
                pr.setString(9, datos[8]);
                pr.setString(10, datos[9]);
                pr.setString(11, datos[10]);
                pr.setString(12, datos[11]);

                pr.executeUpdate();
            }
            System.out.println("Los datos han sido introducidos correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Método para mostrar todos los alumnos de la base de datos
    @Override
    public ArrayList<Alumno> mostrarAlumnos() {
        Connection conexion= Conexion.conectar();
        ArrayList<Alumno>todosAlumnos=new ArrayList<>();
        String consultaSQL="SELECT  * FROM alumnos";
        try {
            PreparedStatement pr = conexion.prepareStatement(consultaSQL);
            ResultSet rset =  pr.executeQuery();
            while(rset.next()){
                todosAlumnos.add(new Alumno(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getString(9), rset.getString(10),  rset.getString(11), rset.getString(12)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todosAlumnos;
    }

    @Override
    public Alumno obtenerAlumnoPorEmail(String email) {
        Connection connection = Conexion.conectar();
        Alumno alumno = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM alumnos WHERE email = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno(
                        rs.getString("apellidos"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("localidad_residencia"),
                        rs.getString("ciclo_matriculado"),
                        rs.getInt("nivel_prestaciones"),
                        rs.getString("carnet_conducir"),
                        rs.getString("estudios_realizados"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("motivacion_curso"),
                        rs.getString("hobbies")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return alumno;
    }

    //Método para añadir un nuevo alumno a la base de datos
    @Override
    public void añadirAlumno(Alumno alum) {
        Connection conex=Conexion.conectar();
        String insertQuery= "INSERT INTO Alumnos (Apellidos, Nombre, Email, Telefono, Localidad_residencia, Ciclo_matriculado, Nivel_prestaciones, Carnet_conducir, Estudios_realizados, Fecha_nacimiento, Motivacion_curso, Hobbies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr= conex.prepareStatement(insertQuery);
            pr.setString(1, alum.getApellidos());
            pr.setString(2, alum.getNombre());
            pr.setString(3, alum.getEmail());
            pr.setString(4, alum.getTelefono());
            pr.setString(5, alum.getLocalidad_residencia());
            pr.setString(6, alum.getCiclo_matriculado());
            pr.setInt(7, alum.getNivel_prestaciones());
            pr.setString(8, alum.getCarnet_conducir());
            pr.setString(9, alum.getEstudios_realizados());
            pr.setString(10, alum.getFecha_nacimiento());
            pr.setString(11, alum.getMotivacion_curso());
            pr.setString(12, alum.getHobbies());

            pr.executeUpdate();
            System.out.println("El alumno ha sido registrado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Método para modificar un alumnos que ya tenemos en la base de datos
    @Override
    public boolean modificarAlumno(Alumno alum) {
        Connection conex=Conexion.conectar();
        String updateQuery="UPDATE alumnos SET apellidos = ?, nombre = ?,  email= ?, localidad_residencia= ?, ciclo_matriculado= ?, nivel_prestaciones= ?, carnet_conducir= ?, estudios_realizados= ?, fecha_nacimiento= ?, motivacion_curso= ?, hobbies= ? WHERE telefono= ?";
        try {
            PreparedStatement pr= conex.prepareStatement(updateQuery);
            pr.setString(1, alum.getApellidos());
            pr.setString(2, alum.getNombre());
            pr.setString(3, alum.getEmail());
            pr.setString(4, alum.getLocalidad_residencia());
            pr.setString(5, alum.getCiclo_matriculado());
            pr.setInt(6, alum.getNivel_prestaciones());
            pr.setString(7, alum.getCarnet_conducir());
            pr.setString(8, alum.getEstudios_realizados());
            pr.setString(9, alum.getFecha_nacimiento());
            pr.setString(10, alum.getMotivacion_curso());
            pr.setString(11, alum.getHobbies());
            pr.setString(12, alum.getTelefono());
            
            int rowsAffected = pr.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    //Método para eliminar un alumno que se encuentra en la base de datos
    @Override
    public void eliminarAlumno(String telefono) {
        Connection conex=Conexion.conectar();
        String deleteQuery="DELETE FROM alumnos WHERE telefono=?";
        try {
            PreparedStatement pr=conex.prepareStatement(deleteQuery);
            pr.setString(1, telefono);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Método para mostrar los alumnos según la localidad
    @Override
    public ArrayList<Alumno>filtrarLocalidad(String localidad) {
        Connection conex=Conexion.conectar();
        ArrayList<Alumno>todosAlumnos=new ArrayList<>();
        String selectSQL="SELECT * FROM alumnos WHERE LOWER(localidad_residencia) LIKE ?";
        try(PreparedStatement pr=conex.prepareStatement(selectSQL)) {
            pr.setString(1, "%" + localidad.toLowerCase() + "%");
            ResultSet rset= pr.executeQuery();
            while(rset.next()){
                todosAlumnos.add(new Alumno(rset.getString("apellidos"), rset.getString("nombre"), rset.getString("email"), rset.getString("telefono"), rset.getString("localidad_residencia"), rset.getString("ciclo_matriculado"), rset.getInt("nivel_prestaciones"), rset.getString("carnet_conducir"), rset.getString("estudios_realizados"), rset.getString("fecha_nacimiento"),  rset.getString("motivacion_curso"), rset.getString("hobbies")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todosAlumnos;
    }
}
