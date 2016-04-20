<%-- 
    Document   : test
    Created on : Apr 19, 2016, 3:56:12 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <c:forEach var="i" begin="0" items="${sessionScope.items}" step="1">
            <div>
                <p>Naziv:
                    <span>
                        ${i.naziv}
                    </span>
                </p>
                <p>Cijena:
                    <span>
                        ${i.cijena}
                    </span>
                </p>
                <p>Opis:
                    <span>
                        ${i.opis}
                    </span>
                </p>
            </div>

        </c:forEach>
    </body>
</html>
