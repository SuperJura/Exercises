<div class="col-md-8 panel panel-default hidden background-light" id="divDetails">
    <form action="../PromjenaProizvoda" method="post">
        <input type="text" class="hidden" id="proizvodId" name="proizvodId" readonly="true"/>
        <div class="panel background-dark">
            Naziv:
            <input type="text" maxlength="50" class="form-control" id="proizvodNaziv" name="proizvodNaziv"/>
        </div>
        <div class="panel background-dark">
            Cijena:
            <input type="number" step="0.05" class="form-control" id="proizvodCijena" name="proizvodCijena"/>
        </div>
        <div class="panel background-dark">
            Slika:
            <input type="text" maxlength="200" class="form-control" id="proizvodSlika" name="proizvodSlika"/>
        </div>
        <div class="panel background-dark">
            Kratak opis:
            <input type="text" maxlength="50" class="form-control" id="proizvodOpis" name="proizvodOpis"/>
        </div>
        <button type="submit" class="btn btn-default" name="promjena">Promjeni</button>
        <button type="submit" class="btn btn-success" name="dodavanje">Dodaj novi proizvod u kategoriju</button>
    </form>
</div>
