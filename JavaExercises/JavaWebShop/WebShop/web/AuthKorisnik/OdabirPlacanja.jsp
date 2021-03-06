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
            <h3 class="text-center"/>Tipovi plaćanja</h3>
        <hr>
        <div class="col-sm-3 col-md-offset-1">
            <div class="panel panel-info text-center">
                <div class="panel-heading">
                    <h3>Gotovina</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Plaćanje gotovinom ne zahtjeva karticu ili PayPal račun</li>
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
                    <form action='/WebShop/ExpressCheckout' METHOD='POST'>
                        <input type='image' name='submit' src='https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif' border='0' align='top' alt='Check out with PayPal'/>
                    </form>
                </ul>
            </div>          
        </div>
        <div class="col-sm-3">
            <div class="panel panel-success text-center">
                <div class="panel-heading">
                    <h3>Povratak na kosaricu</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Povratak na košaricu za mjenjanje sastava</li>
                    <li class="list-group-item"><a class="btn btn-success" href="/WebShop/Profil">Povratak</a></li>
                </ul>
            </div>          
        </div>
    </div>
</body>
</html>