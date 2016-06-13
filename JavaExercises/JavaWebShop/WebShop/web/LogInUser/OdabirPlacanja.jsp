<%-- 
    Document   : OdabirPlacanja
    Created on : Jun 12, 2016, 1:44:57 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="jl" uri="http://jurica.adamek.java3" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Odabir nacina placanja</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <jl:headerMessage defaultMessage="Odaberite nacin placanja"/>
        <div class="row">
            <h3 class="text-center"/>Tipovi placanja</h3>
        <hr>
        <div class="col-sm-3 col-md-offset-1">
            <div class="panel panel-info text-center">
                <div class="panel-heading">
                    <h3>Gotovina</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Placanje gotovinom ne zahtjeva karticu ili PayPal racun</li>
                    <li class="list-group-item"><a class="btn btn-info" href="/WebShop/Kupnja?akcija=1">Plati gotovinom</a></li>
                </ul>
            </div>          
        </div>
        <div class="col-sm-3">
            <div class="panel panel-info text-center">
                <div class="panel-heading">
                    <h3>PayPal</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Potreban je PayPal racun</li>
                    <li class="list-group-item"><a class="btn btn-info">Plati PayPal-om</a></li>
                </ul>
            </div>          
        </div>
        <div class="col-sm-3">
            <div class="panel panel-success text-center">
                <div class="panel-heading">
                    <h3>Povratak na kosaricu</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Povratak na kosaricu za mjenjanje sastava</li>
                    <li class="list-group-item"><a class="btn btn-success" href="/WebShop/Profil">Povratak</a></li>
                </ul>
            </div>          
        </div>
    </div>
</body>
</html>