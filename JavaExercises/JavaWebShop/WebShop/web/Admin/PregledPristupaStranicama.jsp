<%-- 
    Document   : PregledPristupaStranicama
    Created on : Jun 14, 2016, 11:31:52 AM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="jl" uri="http://jurica.adamek.java3" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregled pristupa stranicama</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Zadnjih ${kolicinaZapisa} pristupa stranicama web shopa"/>

        <div class="btn-group col-md-1 col-md-offset-1">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${kolicinaZapisa}<span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a onclick="prikaziPristupeKorisnika(25)">25</a></li>
                <li><a onclick="prikaziPristupeKorisnika(50)">50</a></li>
                <li><a onclick="prikaziPristupeKorisnika(100)">100</a></li>
                <li><a onclick="prikaziPristupeKorisnika(150)">150</a></li>
            </ul>
        </div>
        <div class="row topMargin">
            <div class="col-md-10 col-md-offset-1 topMargin">
                <table class="table table-bordered">
                    <tr>
                        <td class="boldBlack">
                            Korisnik
                        </td>
                        <td class="boldBlack">
                            IP adresa
                        </td>
                        <td class="boldBlack">
                            Stranica spajanja
                        </td>
                        <td class="boldBlack">
                            Datum spajanja
                        </td>
                    </tr>
                    <c:forEach var="pristup" items="${pristupi}">
                        <tr>
                            <td>
                                ${pristup.korisnik}
                            </td>
                            <td>
                                ${pristup.ipAdresa}
                            </td>
                            <td>
                                ${pristup.stranica}
                            </td>
                            <td>
                                <fmt:formatDate value="${pristup.datum}" pattern="dd.MM.yyyy hh:mm" type="both"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
<script>
</script>