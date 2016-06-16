<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="btn-group col-md-1 col-md-offset-1">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

            <c:if test="${trenutniKorisnik == null}">
                Korisnici<span class="caret"></span>
            </c:if>
            <c:if test="${trenutniKorisnik != null}">
                ${trenutniKorisnik}<span class="caret"></span>
            </c:if>
        </button>
        <ul class="dropdown-menu">
            <c:forEach var="k" begin="0" items="${Korisnici}" step="1">
                <li><a onclick="prikaziKorisnika(${k.korisnikId})">${k.korisnickoIme}</a></li>
            </c:forEach>
        </ul>
    </div>
    <c:if test="${trenutniKorisnik != null}">
        <div class='col-md-3'>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon3">Datum od - 
                    <span class="boldBlack">
                        Ukljucen
                    </span>
                </span>
                <input type="text" id="dpOd" class="form-control"/>
            </div>
        </div>
        <div class='col-md-3'>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon3">Datum do - 
                    <span class="boldBlack">
                        Iskljucen
                    </span> 
                </span>
                <input type="text" id="dpDo" class="form-control"/>
            </div>
        </div>
        <div class="col-md-3">
            <button class="btn btn-primary" id="btnDodaj" onclick="prikaziKorisnikaSDatumom()">Pregledaj s tim datumima</button>
        </div>
    </c:if>
</div>