<%-- 
    Document   : Proizvodi
    Created on : Jul 5, 2016, 9:25:00 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proizvodi</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Mjenjate proizvode iz kategorije:" highlited="${sessionScope.kategorijaNaziv}"/>
        
        <div class="row">
            <div class="btn-group col-md-1 col-md-offset-1">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Proizvodi<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach var="p" begin="0" items="${proizvodi}" step="1">
                        <li><a onclick="displayProizvod(${p.proizvodId})">${p.naziv}</a></li>
                    </c:forEach>
                </ul>
            </div>

            <jsp:include page="../PartialJSP/ProizvodMjenjanje.jsp"/>
    </body>
</html>
<script>
    function displayProizvod(id) {
        $.ajax({url: "/WebShop/DetaljiProizvoda?id=" + id,
            success: function (data) {
                document.getElementById("proizvodNaziv").value = data.naziv;
                document.getElementById("proizvodCijena").value = data.cijena;
                document.getElementById("proizvodSlika").value = data.slika;
                document.getElementById("proizvodOpis").value = data.opis;
                document.getElementById("proizvodId").value = data.proizvodId;
                document.getElementById("btnPromjena").classList.remove("hidden");
            }
        });
    }
</script>
