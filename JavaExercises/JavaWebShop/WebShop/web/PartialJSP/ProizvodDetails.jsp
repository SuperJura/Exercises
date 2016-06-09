<div class="col-md-5 panel panel-default hidden background-light" id="divDetails">
    <div class="hidden" id="proizvodId"></div>
    <div class="panel background-dark">
        Naziv:
        <div id="proizvodNaziv" class="txtBlue"></div>
    </div>
    <div class="panel background-dark">
        Kategorija:
        <div id="proizvodKategorija" class="txtBlue"></div>
    </div>
    <div class="panel background-dark">
        Cijena:
        <div id="proizvodCijena" class="txtBlue"></div>
    </div>
    <div class="panel background-dark">
        <img id="proizvodSlika"  class="img-rounded center-block" width="305" height="305"/>
    </div>
    <div class="panel background-dark">
        Kratak opis:
        <div id="proizvodOpis" class="txtBlue"></div>
    </div>
    <div class="input-group input-group-md">
        <span class="input-group-addon" id="sizing-addon1">Kolicina: </span>
        <input type="number" class="form-control" id="numKolicina" min="0" max="50" value="1">
        <button class="btn btn-primary center-block" id="btnDodaj">Dodaj u kosaricu</button>
    </div>
</div>

<script>
    window.onload = function () {
        document.getElementById("btnDodaj").onclick = addProizvod;
    };

    function addProizvod() {
        var id = document.getElementById("proizvodId").textContent;
        var kolicina = document.getElementById("numKolicina").value;
        window.location.href = "/WebShop/Kosarica?id=" + id + "&akcija=" + 1 + "&kolicina=" + kolicina;
    }
</script>