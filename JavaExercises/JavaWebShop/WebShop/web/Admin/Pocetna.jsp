<%-- 
    Document   : test
    Created on : Apr 19, 2016, 3:56:12 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://jurica.adamek.java3" prefix="jl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN Pocetna stranica</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Dobrodosli admine!"/>
        <div class="row">
            <div class="col-sm-5 col-md-offset-1">
                <div class="panel panel-info text-center">
                    <div class="panel-heading">
                        <h3>Admin stranice</h3>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item"><a class="btn btn-info"  href="/WebShop/PristupStranicama">Pregled pristupa stranicama</a></li>
                        <li class="list-group-item"><a class="btn btn-info"  href="/WebShop/Kategorije?akcija=1">Mjenjanje proizvoda</a></li>
                        <li class="list-group-item"><a class="btn btn-info" href="/WebShop/PregledSpajanja">Pregled spajanja</a></li>
                        <li class="list-group-item"><a class="btn btn-info" href="/WebShop/PregledKupnji">Pregled kupnja</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="panel panel-success text-center">
                    <div class="panel-heading">
                        <h3>Korisnikove stranice</h3>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item"><a class="btn btn-success"  href="/WebShop/Pocetna">Java web shop - pocetna</a></li>
                        <li class="list-group-item"><a class="btn btn-success" href="/WebShop/Kategorije">Kategorije</a></li>
                        <li class="list-group-item"><a class="btn btn-success" href="/WebShop/Profil">Kosarica</a></li>
                        <li class="list-group-item"><a class="btn btn-success" href="/WebShop/Korisnik/ONama.jsp">O nama</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
