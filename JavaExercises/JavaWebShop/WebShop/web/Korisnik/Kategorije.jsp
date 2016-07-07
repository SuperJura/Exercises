<%-- 
    Document   : Kategorije
    Created on : Apr 30, 2016, 3:49:18 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kategorije</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Kategorije proizvoda koje Vam nudimo"/>
        <jsp:include page="../PartialJSP/PrikazKategorija.jsp"/>
    </body>
</html>
<script>
    function prikaziKategoriju(id)
    {
        window.location.href = "/WebShop/Proizvodi?kategorijaId=" + id;
    }
</script>
