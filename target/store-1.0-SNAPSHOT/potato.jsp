<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ziemniaki</title>
</head>
<body>

<h1>Oto dział w ziemniakami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="ziemniak">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Kup ziemniaka">
</form>

<form action="${pageContext.request.contextPath}/sell-from-basket" method="post">
    <input type="hidden" name="item" value="ziemniak">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Sprzedaj ziemniaka">
</form>

<form action="${pageContext.request.contextPath}/index-servlet" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>
</body>
</html>
