<%-- 
    Document   : PregledKorisnika
    Created on : Jun 15, 2016, 5:57:29 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Pregledajte sve dogadaje vezane uz korisnike"/>

        <div class="row">
            <div class="btn-group col-md-1">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Korisnici<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach var="k" begin="0" items="${Korisnici}" step="1">
                        <li><a onclick="prikaziKorisnika(${k.korisnikId})">${k.korisnickoIme}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <c:if test="${trenutniKorisnik != null}">
                <div class="col-md-5">
                    <div class="panel panel-info text-center">
                        <div class="panel-heading">
                            <h3>Sva spajanja</h3>
                        </div>
                        <table class="table table-bordered">
                            <tr>
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
                <div class="col-md-5">
                    <div class="panel panel-info text-center">
                        <div class="panel-heading">
                            <h3>Sve prijave</h3>
                        </div>
                        <table class="table table-bordered">
                            <tr>
                                <td class="boldBlack">
                                    IP adresa
                                </td>
                                <td class="boldBlack">
                                    Datum spajanja
                                </td>
                            </tr>
                            <c:forEach var="prijava" items="${prijave}">
                                <tr>
                                    <td>
                                        ${prijava.ipAdresa}
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${prijava.datum}" pattern="dd.MM.yyyy hh:mm" type="both"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>          
                </div>
            </c:if>
        </div>
    </body>
</html>
<script>
    function prikaziKorisnika(id){
        window.location.href = "/WebShop/Korisnik?pregledKorisnikId=" + id;
    }
</script>
