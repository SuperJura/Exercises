<%-- 
    Document   : PregledKupnji
    Created on : Jun 16, 2016, 6:01:36 PM
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
        <title>Pregled kupnji</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Pregledajte sve kupnje korisnika"/>
        <jsp:include page="../PartialJSP/OdabirKorisnika.jsp"/>
        <div class="row">
            <c:if test="${trenutniKorisnik != null}">
                <div class="col-md-10 col-md-offset-1 topMargin">
                    <div class="panel panel-info text-center">
                        <div class="panel-heading">
                            <h3>Kupnje</h3>
                        </div>
                            <jsp:include page="../PartialJSP/PrikazTransakcija.jsp"/>
                        </table>
                    </div> 
                </div>
            </c:if>
        </div>        
    </body>
</html>
<script>
    function prikaziKorisnika(id) {
        window.location.href = "/WebShop/PregledKupnji?pregledKorisnikId=" + id;
    }
    function prikaziKorisnikaSDatumom()
    {
        var datumOd = $("#dpOd").val();
        var datumDo = $("#dpDo").val();
        if (datumOd && datumDo) {
            window.location.href = "/WebShop/PregledKupnji?pregledKorisnikId=" + ${trenutniKorisnikId} +
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
