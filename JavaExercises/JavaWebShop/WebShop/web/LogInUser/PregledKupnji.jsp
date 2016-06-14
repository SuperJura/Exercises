<%-- 
    Document   : PregledKupnji
    Created on : Jun 13, 2016, 8:48:17 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="jl" uri="http://jurica.adamek.java3"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Povijest kupnje</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Ovdje su ispisane sve Vase prosle kupnje"/>

        <div class="row topMargin">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-bordered">
                    <tr>
                        <td class="boldBlack">
                            Ime proizvoda
                        </td>
                        <td class="boldBlack">
                            Kolicina tog proizvoda
                        </td>
                        <td class="boldBlack">
                            Datum kupnje
                        </td>
                        <td class="boldBlack">
                            Tip placanja
                        </td>
                        <td class="boldBlack">
                            Sveukupna cijena
                        </td>
                    </tr>
                    <c:forEach var="transakcija" items="${transakcije}">
                        <tr>
                            <td>
                                <jl:ProizvodNaziv proizvodId="${transakcija.proizvodId}"/>
                            </td>
                            <td>
                                ${transakcija.kolicina}
                            </td>
                            <td>
                                ${transakcija.datumKupnje}
                            </td>
                            <td>
                                ${transakcija.tipPlacanja}
                            </td>
                            <td>
                                ${transakcija.cijenaPojedinacna * transakcija.kolicina}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
