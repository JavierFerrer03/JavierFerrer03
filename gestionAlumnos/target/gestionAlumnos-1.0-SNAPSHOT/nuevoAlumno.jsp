<%--
  Created by IntelliJ IDEA.
  User: alumno
  Date: 29/10/23
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Nuevo Alumno</title>
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
        <link rel="icon" type="image/jpg" href="favicon/graduado.png"/>
    </head>
    <body class="bodynewAlumno">
        <div class="container_newAlum">
            <h1 class="title_newAlum">DATOS PARA EL NUEVO ALUMNO</h1>
            <form action="servlet" method="POST">
                <label class="label_newAlum">Apellidos</label>
                <input type="text" class="input_newAlum" name="apellidosAlum" placeholder="Escribe tus apellidos"> <br>
                <label class="label_newAlum">Nombre</label>
                <input type="text" class="input_newAlum" name="nombreAlum" placeholder="Escribe tu nombre"> <br>
                <label class="label_newAlum">Email</label>
                <input type="email" class="input_newAlum" name="emailAlum" placeholder="Escribe tu email"> <br>
                <label class="label_newAlum">Teléfono</label>
                <input type="text" class="input_newAlum" name="telefonoAlum" placeholder="Escribe tu teléfono"> <br>
                <label class="label_newAlum">Localidad Residencial</label>
                <input type="text" class="input_newAlum" name="localidadAlum" placeholder="Escribe tu localidad de residencia"> <br>
                <label class="label_newAlum">Ciclo Matriculado</label>
                <select name="cicloAlum">
                    <option value="DAW">DAW</option>
                    <option value="DAM">DAM</option>
                    <option value="ASIR">ASIR</option>
                </select> <br>
                <label class="label_newAlum">Nivel Prestaciones</label>
                <input type="number" class="input_newAlum" name="nivelAlum"> <br>
                <label class="label_newAlum">Carnet Conducir</label>
                Si<input type="radio" class="input_newAlum" name="carnetAlum" value="Si">
                No<input type="radio" class="input_newAlum" name="carnetAlum" value="No"> <br>
                <label class="label_newAlum">Estudios Realizados</label>
                <input type="text" class="input_newAlum" name="estudiosAlum" placeholder="Indique sus estudios"> <br>
                <label class="label_newAlum">Fecha Nacimiento</label>
                <input type="date" class="input_newAlum" name="fechaAlum"> <br>
                <label class="label_newAlum">Motivación Curso</label>
                <select name="motivacionAlum">
                    <option value="" selected disabled>Motivación</option>
                    <option value="Muy motivado">Muy motivado</option>
                    <option value="Moderadamente motivado">Moderadamente motivado</option>
                    <option value="Poco motivado">Poco motivado</option>
                </select><br>
                <label class="label_newAlum">Hobbies</label> <br>
                <textarea name="hobbiesAlum" class="textarea_newAlum" placeholder="Introduce tus hobbies"></textarea> <br>
                <input type="hidden" name="action" value="add">
                <button class="button_add" type="submit">INTRODUCIR DATOS</button>
            </form>
        </div>
    </body>
</html>
