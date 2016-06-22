<%-- 
    Document   : ONama
    Created on : Jun 22, 2016, 11:13:46 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>O Nama</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
    <jl:headerMessage defaultMessage="Informacije o Java Web Shop"/>
    <div class="container text-center">
        <div class="jumbotron">
            <h1 class="display-3">Java Web Shop </h1>
            <p class="lead">Web aplikacija napravljena pomocu Java EE za kolegij "Java Web Programiranje"</p>
        </div>

        <div class="row text-center">
            <h3>Koristene komponente</h3>
        </div>
        <div class="row marketing">
            <div class="col-lg-3 col-lg-offset-3">
                <h4>Servlets</h4>
                <h4>Java Server Pages</h4>
                <h4>Java Server Faces</h4>
            </div>
            <div class="col-lg-3">
                <h4>REST</h4>
                <h4>Filters, Tags, jsp:include</h4>
                <h4>MS Sql Server</h4>
            </div>
        </div>

        <footer class="footer">
            <p>Jurica Adamek</p>
        </footer>

    </div>
</body>
</html>
