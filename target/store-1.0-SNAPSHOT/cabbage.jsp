<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kapusta</title>
</head>
<body>

<h1>Oto dział z kapustą:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="kapusta">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Kup kapuste">
</form>

<form action="${pageContext.request.contextPath}/sell-from-basket" method="post">
    <input type="hidden" name="item" value="kapusta">
    <label for="quantity">Ilość:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <input type="submit" value="Sprzedaj kapuste">
</form>

<form action="${pageContext.request.contextPath}/index-servlet" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>
