<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Авторизация</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript" src="js/users.js"></script>

</head>

<body>

    <div id="header">
    </div>

    <div class="middle">
        <H1>Авторизация</H1>

         <form method="post">

            <label>Логин:</label>
            <input required type="text" name="login" placeholder="Логин">
            <br />

            <label>Пароль:</label>
            <input required type="text" name="password" placeholder="Пароль"><br />

            <input type="submit" value="Вход">
        </form>

        <a href="/registration.jsp">Зарегистрироваться</a>

        <b style="color: red">${errorMessage}</b>

    </div>

    <div id="footer">
    </div>

    <script type="text/javascript" src="js/cart.js"></script>

    <script type="text/javascript" src="js/search.js"></script>

</body>

</html>