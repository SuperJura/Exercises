<%-- 
    Document   : Error
    Created on : Jun 23, 2016, 4:44:08 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pogreska</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
    <jl:headerMessage defaultMessage="Informacije o Java Web Shop"/>
    <div class="container text-center">
        <div class="jumbotron">
            <h3 class="display-3">Dogodila se pogreska</h3>
            <p><a class="btn btn-lg btn-danger" href="/WebShop/Pocetna" role="button">Povratak na pocetnu stranicu</a></p>
        </div>
    </div>
</body>
</html>
