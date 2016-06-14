<script src="../Resources/js/jquery-2.2.3.js" type="text/javascript"></script>
<script src="../Resources/js/bootstrap.js" type="text/javascript"></script>
<script src="../Resources/js/javascript.js" type="text/javascript"></script>
<link href="../Resources/Css/styles.css" rel="stylesheet" type="text/css"/>
<link href="../Resources/Css/bootstrap.css" rel="stylesheet" type="text/css"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/WebShop/Pocetna" class="navbar-text navbar-left">Java web shop</a>
        </div>
        <c:if test="${Korisnik == null || Korisnik.administrator == false}">
            <div id="navbar" class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/WebShop/Kategorije">Kategorije</a></li>
                    <li><a href="/WebShop/Profil">
                            Kosarica
                            <span class="bold"> ${Korisnik.korisnickoIme}
                            </span>
                        </a></li>
                    <li><a href="#contact">O nama</a></li>
                </ul>
            </div>
        </c:if>
        <c:if test="${Korisnik.administrator == true}">
            <div id="navbar" class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/WebShop/Kategorije">Pregled kupnja</a></li>
                    <li><a href="/WebShop/Kategorije">Pregled ulogiravanja</a></li>
                    <li><a href="/WebShop/PristupStranicama">Pregled pristupa stranicama</a></li>
                    <li><a href="/WebShop/Profil">
                            Odjava 
                            <span class="bold"> ${Korisnik.korisnickoIme}
                            </span>
                        </a></li>
                </ul>
            </div>
        </c:if>
    </div>
</nav>