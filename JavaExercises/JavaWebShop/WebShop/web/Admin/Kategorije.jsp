<%-- 
    Document   : Kategorije
    Created on : Jul 5, 2016, 9:05:32 PM
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
        <jl:headerMessage defaultMessage="Odaberite kategoriju proizvoda koje zelite mjenjati"/>
        <jsp:include page="../PartialJSP/PrikazKategorija.jsp"/>
    </body>
</html>
<script>
    function prikaziKategoriju(id)
    {
        window.location.href = "/WebShop/Proizvodi?kategorijaId=" + id + "&akcija=1";
    }
</script>