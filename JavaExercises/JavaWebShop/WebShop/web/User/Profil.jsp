<%-- 
    Document   : Profil
    Created on : Jun 9, 2016, 8:50:01 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kosarica ${Korisnik.korisnickoIme}</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Detalji Vase kosarice"/>
        <div class="row">
            <div class="col-md-6">
                <table class="table table-bordered">
                    <tr>
                        <td class="boldBlack">
                            Ime proizvoda u kosarici
                        </td>
                        <td class="boldBlack">
                            Kolicina tog proizvoda u kosarici
                        </td>
                    </tr>
                    <c:forEach var="entry" items="${Korisnik.kosarica.proizvodi}">
                        <tr>
                            <td>
                                ${entry.key}
                            </td>
                            <td>
                                ${entry.value}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
