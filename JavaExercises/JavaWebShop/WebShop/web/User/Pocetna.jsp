<%-- 
    Document   : test
    Created on : Apr 19, 2016, 3:56:12 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pocetna stranica</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Pregledajte naše popularne proizvode ovdje!"/>
        <div class="row">
            <div class="col-md-5">
                <jsp:include page="../PartialJSP/PopisProizvoda.jsp"/>
            </div>
            <jsp:include page="../PartialJSP/ProizvodDetails.jsp"/>
        </div>
    </body>
</html>