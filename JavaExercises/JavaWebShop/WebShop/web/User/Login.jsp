<%-- 
    Document   : Login
    Created on : Jun 2, 2016, 8:18:40 PM
    Author     : Jurica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prijavite se</title>
    </head>
    <body>
        <jsp:include page="../PartialJSP/Header.jsp"/>
        <div class="alert alert-danger text-center">
            ${loginError}
        </div>
        <div class="row">
            <div class="col-md-5 col-md-offset-1">
                <div class="panel panel-default">
                    <form class="form-signin" action="/WebShop/Login" method="POST">
                        <h2 class="form-signin-heading">Prijavite se</h2>
                        <input hidden="true" name="action" value="prijava"/>
                        <label class="sr-only">Korisničko ime:</label>
                        <input type="text" id="txtIme" name="txtIme" class="form-control" placeholder="Korisničko ime" required autofocus>
                        <label class="sr-only">Lozinka:</label>
                        <input type="password" id="txtLozinka" name="txtLozinka" class="form-control" placeholder="Lozinka" required>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Prijavi se!</button>
                    </form>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Nemate račun?</div>
                    <form class="form-signin" action="/WebShop/Login" method="POST">
                        <h2 class="form-signin-heading">Registrirajte se</h2>
                        <input hidden="true" name="action" value="registracija"/>
                        <label class="sr-only">Korisničko ime:</label>
                        <input type="text" id="txtImeReg" name="txtImeReg" class="form-control" placeholder="Korisničko ime" required >
                        <label class="sr-only">Lozinka:</label>
                        <input type="password" id="txtLozinkaReg" name="txtLozinkaReg" class="form-control" placeholder="Lozinka" required>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Registrirajte se!</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
