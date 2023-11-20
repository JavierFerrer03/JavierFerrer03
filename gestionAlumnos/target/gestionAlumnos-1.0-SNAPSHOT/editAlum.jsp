<%--
  Created by IntelliJ IDEA.
  User: alumno
  Date: 2/11/23
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editar Alumno</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">
    <link rel="icon" type="image/jpg" href="favicon/graduado.png"/>
</head>
<body class="body_alumnos">
<div class="container_editAlum">
    <h1 class="title_editAlum">DATOS DE LOS ALUMNOS</h1>
            <form action="servlet?action=change" method="POST">
                <input type="hidden" name="emailAlumno" value="">
                <label class="label_newAlum">Apellidos</label>
                <input type="text" class="input_newAlum" name="apellidos" value="${alumno.apellidos}"> <br>
                <label class="label_newAlum">Nombre</label>
                <input type="text" class="input_newAlum" name="nombre" value="${alumno.nombre}"> <br>
                <label class="label_newAlum">Email</label>
                <input type="email" class="input_newAlum" name="email" value="${alumno.email}"> <br>
                <label class="label_newAlum">Teléfono</label>
                <input type="text" class="input_newAlum" name="telefono" value="${alumno.telefono}" readonly> <br>
                <label class="label_newAlum">Localidad Residencial</label>
                <input type="text" class="input_newAlum" name="localidad_residencia" value="${alumno.localidad_residencia}"> <br>
                <label class="label_newAlum">Ciclo Matriculado</label>
                <select name="ciclo_matriculado">
                    <option value="DAW" ${alumno.ciclo_matriculado == 'DAW' ? 'selected' : ''}>DAW</option>
                    <option value="DAM" ${alumno.ciclo_matriculado == 'DAM' ? 'selected' : ''}>DAM</option>
                    <option value="ASIR" ${alumno.ciclo_matriculado == 'ASIR' ? 'selected' : ''}>ASIR</option>
                </select> <br>
                <label class="label_newAlum">Nivel Prestaciones</label>
                <input type="number" class="input_newAlum" name="nivel_prestaciones" value="${alumno.nivel_prestaciones}"> <br>
                <label class="label_newAlum">Carnet Conducir</label>
                <input type="radio" class="input_newAlum" name="carnet_conducir" value="Si" ${alumno.carnet_conducir == 'Si' ? 'checked' : ''}>Si
                <input type="radio" class="input_newAlum" name="carnet_conducir" value="No" ${alumno.carnet_conducir == 'No' ? 'checked' : ''}>No <br>
                <label class="label_newAlum">Estudios Realizados</label>
                <input type="text" class="input_newAlum" name="estudios_realizados" value="${alumno.estudios_realizados}"> <br>
                <label class="label_newAlum">Fecha Nacimiento</label>
                <input type="text" class="input_newAlum" name="fecha_nacimiento" value="${alumno.fecha_nacimiento}"> <br>
                <label class="label_newAlum">Motivación Curso</label>
                <select name="motivacion_curso">
                    <option value="Muy motivado" ${alumno.motivacion_curso == 'Muy motivado' ? 'selected' : ''}>Muy motivado</option>
                    <option value="Moderadamente motivado" ${alumno.motivacion_curso == 'Moderadamente motivado' ? 'selected' : ''}>Moderadamente motivado</option>
                    <option value="Poco motivado" ${alumno.motivacion_curso == 'Poco motivado' ? 'selected' : ''}>Poco motivado</option>
                </select><br>
                <label class="label_newAlum">Hobbies</label> <br>
                <textarea id="hobbies" name="hobbies" rows="4" cols="50">${alumno.hobbies}</textarea><br><br>
                <input type="hidden" name="action" value="change">
                <button class="button_add" type="submit">INTRODUCCIR DATOS</button>
            </form>
    </div>
</body>
</html>
