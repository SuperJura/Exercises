<%-- 
    Document   : Proizvodi
    Created on : Apr 30, 2016, 8:43:48 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proizvodi</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <div class="alert alert-info text-center">
            Gledate proizvode iz kategorije:
            <span class="txtBlue">
                ${sessionScope.kategorijaNaziv}
            </span>
        </div>
        <div class="row">
            <div class="col-md-5">
                <jsp:include page="../PartialJSP/PopisProizvoda.jsp"/>
                <nav>
                    <ul class="pager">
                        <li><a href="/WebShop/Pagination?action=prev">Predhodni</a></li>
                        <li><a href="/WebShop/Pagination?action=next">Sljedeci</a></li>
                    </ul>
                </nav>
            </div>
            <jsp:include page="../PartialJSP/ProizvodDetails.jsp"/>
        </div>
    </body>
</html>
