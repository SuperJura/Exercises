<%-- 
    Document   : Kategorije
    Created on : Apr 30, 2016, 3:49:18 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kategorije</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <div class="alert alert-info text-center">
            Kategorije proizvoda koje Vam nudimo
        </div>
        <div class="container">
            <c:forEach var="i" begin="0" items="${sessionScope.kategorije}">
                <button class="btn btn-default btn-block" onclick="kategorijaOnClick(${i.kategorijaId})">
                    <div class="text-center">
                        <div class="text-primary txtLarge">
                            ${i.naziv}
                        </div>
                    </div>
                </button>
            </c:forEach>
        </div>
    </body>
    <script>
        function kategorijaOnClick(id)
        {
            window.location.href = "/WebShop/Proizvodi/" + id;
        }
    </script>
</html>
