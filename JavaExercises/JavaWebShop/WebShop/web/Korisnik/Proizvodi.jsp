<%-- 
    Document   : Proizvodi
    Created on : Apr 30, 2016, 8:43:48 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proizvodi</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Gledate proizvode iz kategorije:" highlited="${sessionScope.kategorijaNaziv}"/>
        <div class="row">
            <div class="col-md-5 col-md-offset-1">
                <jsp:include page="../PartialJSP/PopisProizvoda.jsp"/>
                <nav>
                    <ul class="pager">
                        <li><a href="/WebShop/Stranicenje?akcija=2">Predhodni</a></li>
                        <li><a href="/WebShop/Stranicenje?akcija=1">Sljedeci</a></li>
                    </ul>
                </nav>
            </div>
            <jsp:include page="../PartialJSP/ProizvodDetails.jsp"/>
        </div>
    </body>
</html>
