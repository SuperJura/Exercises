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
        <title>Kosarica ${korisnik.korisnickoIme}</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Detalji Vase kosarice"/>
        <c:if test="${korisnik.korisnickoIme != null}">
            <a class="btn btn-success col-md-offset-1" href="/WebShop/PregledKorisnikovihKupnji">Pregled svih kupnji</a>
            <a class="btn btn-success col-md-offset-1" href="/WebShop/Login?akcija=3">Izlogirajte se iz ovog racuna</a>
        </c:if>
        <c:if test="${korisnik.korisnickoIme == null}">
            <a class="btn btn-danger col-md-offset-1" href="/WebShop/User/Login.jsp">Ulogirajte se</a>
        </c:if>
        <div class="row topMargin">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-bordered">
                    <tr>
                        <td class="boldBlack">
                            Ime proizvoda u kosarici
                        </td>
                        <td class="boldBlack">
                            Kolicina tog proizvoda u kosarici
                        </td>
                        <td colspan="2">
                            Sveukupna cijena: 
                            <span class="boldBlack" id="spanCijena" cijena="${cijena}">
                            </span>
                        </td>    
                        <td>
                            <c:if test="${korisnik != null}">
                                <c:if test="${cijena != 0.0}">
                                    <button class="btn btn-info btn-block" id="btnDovrsi" onclick="dovrsi(this)">Dovrsi narudzbu</button>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                    <c:forEach var="proizvod" items="${korisnik.kosarica.proizvodi}">
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
                                            <input type="number" class="form-control" id="numKolicina${proizvod.key}" min="0" max="50" value="1" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-danger" id="btnMakni${proizvod.key}" onclick="makniProizvod(this)">Makni
                                                </button>
                                                <button class="btn btn-success" id="btnDodaj${proizvod.key}" onclick="dodajProizvod(this)">Dodaj
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
        var id = btn.id.substr(8);
        var kolicina = document.getElementById("numKolicina" + id).value;
        window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 2 + "&kolicina=" + kolicina;
    }

    function dodajProizvod(btn)
    {
        var id = btn.id.substr(8);
        var kolicina = document.getElementById("numKolicina" + id).value;
        window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 1 + "&kolicina=" + kolicina;
    }

    function dovrsi(btn)
    {
        window.location.href = "/WebShop/LogInUser/OdabirPlacanja.jsp";
    }
    $(function () {
        var cijena = $("#spanCijena").attr("cijena");
        
        floatCijena = parseFloat(cijena);
        $("#spanCijena").text(floatCijena.toFixed(2) + " KN");
    });
</script>