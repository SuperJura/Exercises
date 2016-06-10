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
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-bordered">
                    <tr>
                        <td class="boldBlack">
                            Ime proizvoda u kosarici
                        </td>
                        <td class="boldBlack">
                            Kolicina tog proizvoda u kosarici
                        </td>
                        <td>
                            Sveukupna cijena: 
                            <span class="boldBlack">
                                ${cijena}
                            </span>
                        </td>
                    </tr>
                    <c:forEach var="proizvod" items="${Korisnik.kosarica.proizvodi}">
                        <tr>
                            <td>
                                <jl:ProizvodNaziv proizvodId="${proizvod.key}"/>
                            </td>
                            <td>
                                ${proizvod.value}
                            </td>
                            <td>
                                <jl:ProizvodCijena kolicina="${proizvod.value}" proizvodId="${proizvod.key}"/>
                            </td>
                            <td>
                                <div class="row">
                                    <div class="col-lg-offset-1 col-lg-9">
                                        <div class="input-group">
                                            <span class="input-group-addon">Kolicina:</span>
                                            <input type="number" class="form-control" id="numKolicina" min="0" max="50" value="1" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary" id="btnMakni" onclick="makniProizvod(this)">Makni
                                                    <div class="hidden" id="proizvodId">${proizvod.key}</div>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
<script>
    function makniProizvod(btn)
    {
        var proizvodId = btn.childNodes[1].firstChild.nodeValue;
        alert(proizvodId);
    }
</script>