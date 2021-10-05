<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% //gerenciador_war_exploded/novaEmpresa É O MESMO QUE O c:... %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${linkServletNovaEmpresa}" method="post">
    Nome: <input type="text" name="nome" />
    Data: <input type="text" name="data" />
    <input type="submit" name="enviar">
</form>
</body>
</html>