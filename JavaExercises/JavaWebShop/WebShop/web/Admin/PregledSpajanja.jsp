<%-- 
    Document   : PregledSpajanja
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
        <title>Pregled spajanja</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Pregledajte sve događaje vezane uz korisnike"/>

        <jsp:include page="../PartialJSP/OdabirKorisnika.jsp"/>
        <div class="row">
            <c:if test="${trenutniKorisnik != null}">
                <div class="col-md-5 col-md-offset-1 topMargin">
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
                <div class="col-md-5 topMargin">
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
    function prikaziKorisnika(id) {
        window.location.href = "/WebShop/PregledSpajanja?pregledKorisnikId=" + id;
    }
    function prikaziKorisnikaSDatumom()
    {
        var datumOd = $("#dpOd").val();
        var datumDo = $("#dpDo").val();
        if (datumOd && datumDo) {
            window.location.href = "/WebShop/PregledSpajanja?pregledKorisnikId=" + ${trenutniKorisnikId} +
                    "&datumOd=" + datumOd + "&datumDo=" + datumDo;
        }
    }
    $(function () {
        $("#dpOd").datepicker({
            dateFormat: "dd.mm.yy"
        });
        $("#dpDo").datepicker({
            dateFormat: "dd.mm.yy"
        });
    });
</script>
