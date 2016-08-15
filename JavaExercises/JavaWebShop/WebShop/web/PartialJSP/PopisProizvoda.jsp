<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="i" begin="0" items="${proizvodi}" step="1">
    <div class="panel panel-default background-dark">
        <div class="panel-body">
            <div class="text-left col-md-7">
                ${i.naziv}
            </div>
            <button id="btn_${i.proizvodId}" class="btn btn-primary text-right" onClick="displayProizvodKorisnik(this.id)">
                Pregledaj proizvod
            </button>
            <div class="text-left col-md-7">
                Tip proizvoda: 
                <a class="txtBlue" href="/WebShop/Proizvodi?kategorijaId=${i.idKategorija}">
                    ${i.kategorija}
                </a> 
            </div>
            <div class="text-left col-md-7">
                ${i.cijena}
            </div>
        </div>   
    </div>
</c:forEach>