<%-- 
    Document   : Kupljeno
    Created on : Jun 13, 2016, 10:37:43 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <div class="row">
            <h3 class="text-center"/>Uspješno kupljeni proizvodi!</h3>
    </div>
    <hr/>
    <div class="col-md-12">
        <div class="panel panel-info text-center center-block">
            <div class="panel-heading">
                <h3>Povratak na web shop</h3>
            </div>
            <ul class="list-group">
                <li class="list-group-item"><a class="btn btn-info" href="/WebShop/Pocetna">Početna stranica</a></li>
                <li class="list-group-item"><a class="btn btn-info" href="/WebShop/Kategorije">Kategorije</a></li>
                <li class="list-group-item"><a class="btn btn-info" href="/WebShop/Profil">Košarica</a></li>
            </ul>
        </div>          
    </div>
</body>
</html>
