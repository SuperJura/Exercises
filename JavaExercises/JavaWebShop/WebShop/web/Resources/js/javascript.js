function displayProizvod(id)
{
    proizvodId = id.toString().split("_")[1];
    $.ajax({url: "/WebShop/rest/proizvodi/" + proizvodId,
        success: function (data) {
            document.getElementById("proizvodNaziv").textContent =data.naziv;
            document.getElementById("proizvodKategorija").textContent = data.kategorija;
            document.getElementById("proizvodCijena").textContent = data.cijena;
            document.getElementById("proizvodSlika").src  = data.slika;
            document.getElementById("proizvodOpis").textContent = data.opis;
            document.getElementById("proizvodId").textContent = data.proizvodId;
            document.getElementById("divDetails").classList.remove("hidden");   
        }
    });
}