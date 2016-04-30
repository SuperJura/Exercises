<%-- 
    Document   : test
    Created on : Apr 19, 2016, 3:56:12 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pocetna stranica</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <div class="alert alert-info text-center">
            Pregledajte naše popularne proizvode ovdje!
        </div>
        <div class="row">
            <div class="col-md-5">
                <c:forEach var="i" begin="0" items="${sessionScope.popularProizvodi}" step="1">
                    <div class="panel panel-default background-dark">
                        <div class="panel-body">
                            <div class="text-left col-md-7">
                                ${i.naziv}
                            </div>
                                <button id="btn_${i.proizvodId}" class="btn btn-primary text-right" onClick="displayProizvod(this.id)">
                                Pregledaj proizvod
                            </button>
                            <div class="text-left col-md-7">
                                Tip proizvoda: 
                                <span class="txtBlue">
                                    ${i.kategorija}
                                </span> 
                            </div>
                            <div class="text-left col-md-7">
                                ${i.cijena}
                            </div>
                        </div>   
                    </div>
                </c:forEach>
            </div>
            <jsp:include page="../PartialJSP/ProizvodDetails.jsp"/>
        </div>
    </body>
    
    <script type="text/javascript">
        function displayProizvod(id)
        {
            proizvodId = id.toString().split("_")[1];
            $.ajax({url: "/WebShop/rest/proizvodi/" + proizvodId,
                success: function (data) {
                    document.getElementById("proizvodNaziv").textContent =data.naziv;
                    document.getElementById("proizvodKategorija").textContent = data.kategorija;
                    document.getElementById("proizvodCijena").textContent = data.cijena;
                    document.getElementById("proizvodSlika").src  = data.slika;
                    document.getElementById("proizvodOpis").textContent = data.opis;
                    
                    document.getElementById("divDetails").classList.remove("hidden");   
                }
            });
        }
    </script>
</html>