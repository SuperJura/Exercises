function displayProizvodKorisnik(id) {
    $.ajax({url: "/api/getProizvod/" + id,
        success: function (data) {
            document.getElementById("proizvodNaziv").textContent = data.naziv;
            document.getElementById("proizvodKategorija").textContent = data.kategorija;
            document.getElementById("proizvodCijena").textContent = getCijenaKune(data.cijena);
            document.getElementById("proizvodSlika").src = data.slika;
            document.getElementById("proizvodOpis").textContent = data.opis;
            document.getElementById("proizvodId").textContent = data.proizvodId;
            document.getElementById("divDetails").classList.remove("hidden");
        }
    });
}

function getCijenaKune(cijena) {
    return cijena.toFixed(2) + " KN";
}

function prikaziKategoriju(idKategorija){
    window.location.href = "/Proizvodi/" + idKategorija;
}