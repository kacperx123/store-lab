<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Marchewki</title>
</head>
<body>

<h1>Oto dział w marchewkami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="marchewka">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Kup marchewke">
</form>

<form action="${pageContext.request.contextPath}/sell-from-basket" method="post">
    <input type="hidden" name="item" value="marchewka">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Sprzedaj marchewke">
</form>
<form action="${pageContext.request.contextPath}/index-servlet" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>
</body>
</html>
