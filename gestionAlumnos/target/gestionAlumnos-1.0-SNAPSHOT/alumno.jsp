<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Alumnos</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">
    <link rel="icon" type="image/jpg" href="favicon/graduado.png"/>
</head>
<body>
    <div class="container_alumnos">
        <h1  class="title_alumnos">LISTA DE ALUMNOS</h1> <br>
        <form action="nuevoAlumno.jsp" method="POST">
            <button class="button_insert" type="submit">AÑADIR NUEVO ALUMNO</button>
        </form>
        <form action="servlet" method="POST">
            <input type="text" name="localidad" class="input_filtrado" placeholder="Localidad Del Alumno">
            <input type="hidden" name="action" value="filtrar">
            <button class="button_filtrar" type="submit">FILTRAR</button>
        </form>
        <table class="table_alumnos">
            <tr class="tr_alumnos">
                <th class="th_alumnos">Apellidos</th>
                <th class="th_alumnos">Nombre</th>
                <th class="th_alumnos">Email</th>
                <th class="th_alumnos">Teléfono</th>
                <th class="th_alumnos">Localidad De Residencia</th>
                <th class="th_alumnos">Ciclo Matriculado</th>
                <th class="th_alumnos">Nivel Prestaciones</th>
                <th class="th_alumnos">Carnet Conducir</th>
                <th class="th_alumnos">Estudios Realizados</th>
                <th class="th_alumnos">Fecha de Nacimiento</th>
                <th class="th_alumnos">Motivación Curso</th>
                <th class="th_alumnos">Hobbies</th>
                <th class="th_alumnos">Operaciones</th>
            </tr>

            <c:forEach items="${listaAlumnos}" var="a">
                <tr class="tr_alumnos">
                    <td class="td_alumnos">${a.apellidos}</td>
                    <td class="td_alumnos">${a.nombre}</td>
                    <td class="td_alumnos">${a.email}</td>
                    <td class="td_alumnos">${a.telefono}</td>
                    <td class="td_alumnos">${a.localidad_residencia}</td>
                    <td class="td_alumnos">${a.ciclo_matriculado}</td>
                    <td class="td_alumnos">${a.nivel_prestaciones}</td>
                    <td class="td_alumnos">${a.carnet_conducir}</td>
                    <td class="td_alumnos">${a.estudios_realizados}</td>
                    <td class="td_alumnos">${a.fecha_nacimiento}</td>
                    <td class="td_alumnos">${a.motivacion_curso}</td>
                    <td class="td_alumnos">${a.hobbies}</td>
                    <td class="td_alumnos">
                        <form action="servlet" method="POST">
                            <input name="telefonoAlum" value="${a.telefono}">
                            <input type="hidden" name="action" value="delete">
                            <button class="button_delete" type="submit">ELIMINAR</button>
                        </form>
                        <form action="servlet?action=irAChange&email=${a.email}" method="POST">
                            <button class="button_change" type="submit">MODIFICAR</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="index.jsp" method="POST">
            <input class="button_volver" type="submit" value="Volver">
        </form>
    </div>
</body>
</html>