<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>LOGIN</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">
    <link rel="icon" type="image/jpg" href="favicon/usuario.png"/>
  </head>
  <body class="body_index">
    <div class="container_login">
      <h1 class="title_login">Iniciar Sesión</h1>
      <form action="servlet" method="POST">
        <label class="label_login">Email</label> <br>
        <input class="input_login" name="email" type="text" placeholder="Escribe tu email"> <br>
        <label class="label_login">Número de Teléfono</label> <br>
        <input class="input_login" type="password" name="telefono" placeholder="Introduce tu teléfono"> <br>
        <input type="hidden" name="action" value="login">
        <button class="button_login" type="submit">ENVIAR</button>
      </form>
    </div>
  </body>
</html>