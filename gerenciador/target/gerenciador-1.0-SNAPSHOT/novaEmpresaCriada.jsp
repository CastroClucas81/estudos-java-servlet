<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sucesso</title>
</head>
<body>
<%
    //jsp java server page - pagina java dinâmica
    //todo o cod jsp é executado no lado do servidor
    //String nomeEmpresa = (String) request.getAttribute("empresa");
%>
    <c:if test="${not empty empresa}">
        "nome da empresa: " ${empresa}
    </c:if>

    <c:if test="${empty empresa}">
        "Nenhuma empresa cadastrada!"
    </c:if>

</body>
</html>

