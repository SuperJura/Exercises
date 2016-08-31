//this is debug purpose only
//TODO: Make a sql database

function kategorija(naziv) {
	var id = kategorija.id;
	if (!id) {id=1}

	this.naziv = naziv;
	this.idKategorija = id;

	kategorija.id = id+1;
}

function getKategorije(){
	if (!getKategorije.kategorije) {
		var listaKategorija = 
		[
			new kategorija('voce'),
			new kategorija('povrce'),
			new kategorija('meso'),
			new kategorija('slastice'),
			new kategorija('magija')
		]

		getKategorije.kategorije = listaKategorija;
	}

	return getKategorije.kategorije;
}


function getKategorija(kategorijaId){
	var kategorije = new getKategorije();
	for (var i = 0; i < kategorije.length; i++) {
		if (kategorije[i].idKategorija === kategorijaId) {
			return kategorije[i].naziv;
		}
	}
}

function proizvod(IdProizvod, naziv, kategorijaId, cijena, slika, opis){
	this.IdProizvod = IdProizvod;
	this.naziv = naziv,
	this.kategorijaId = kategorijaId,
	this.cijena = cijena;
	this.slika = slika;
	this.opis = opis;

	this.kategorija = getKategorija(this.kategorijaId);
}

function getProizvode(){
	if (!getProizvode.proizvodi) {	
		var listaProizvoda = 
		[
			new proizvod(1, 'Jabuka', 1, 10, 'http://pngimg.com/upload/small/apple_PNG12509.png', 'plava jabolka'),
			new proizvod(2, 'Kruska', 1, 15, 'https://upload.wikimedia.org/wikipedia/commons/5/5d/Pear_DS.jpg', 'cista kruska'),

			new proizvod(3, 'Mrkva', 2, 5, 'http://media.mercola.com/assets/images/food-facts/carrot-fb.jpg', 'ona mrkva'),
			new proizvod(4, 'Kupus', 2, 20, 'https://upload.wikimedia.org/wikipedia/commons/6/6f/Cabbage_and_cross_section_on_white.jpg', 'slatki kupus'),
			
			new proizvod(5, 'Svinjetina', 3, 100, 'http://kingofwallpapers.com/pork/pork-007.jpg', 'pravo meso'),
			new proizvod(6, 'Ne-svinjetina', 3, 50, 'http://pngimg.com/upload/chicken_PNG2145.png', 'meso'),
			
			new proizvod(7, 'Sladoled', 4, 10, 'http://www-tc.pbs.org/food/files/2012/07/History-of-Ice-Cream-1.jpg', 'razliciti okusi'),
			new proizvod(8, 'Cips', 4, 15, 'http://images.mentalfloss.com/sites/default/files/styles/insert_main_wide_image/public/istock_000012710166_small.jpg', 'fini'),
			
			new proizvod(9, 'Mjolnir', 5, 99.0, 'https://upload.wikimedia.org/wikipedia/commons/b/b7/Mjollnir.png', 'The cekic'),
			new proizvod(10, 'Harrys wooden stick', 5, 0.99, 'http://pad3.whstatic.com/images/thumb/9/9c/Make-a-Harry-Potter-Wand-Step-7.jpg/aid191044-728px-Make-a-Harry-Potter-Wand-Step-7.jpg', 'random drvo')
		]
		
		getProizvode.proizvodi = listaProizvoda;
	}
	return getProizvode.proizvodi;	
}

function getPopularneProizvode(){
	var proizvodi = getProizvode();
	return [proizvodi[1], proizvodi[4], proizvodi[5], proizvodi[9]];
}

function getProizvod(id){
	var listaProizvoda = getProizvode();

	for (var i = 0; i < listaProizvoda.length; i++) {
		if (listaProizvoda[i].IdProizvod == id) {
			return listaProizvoda[i];
		}

	}
}

function getProizvodeForIdKategorija(idKategorija){
	var outputProizvodi = [];
	var sviProizvodi = getProizvode();
	for (var i = 0; i < sviProizvodi.length; i++) {
			console.log(idKategorija + " " + sviProizvodi[i].kategorijaId);
		if (sviProizvodi[i].kategorijaId == idKategorija) {
			outputProizvodi.push(sviProizvodi[i]);
		}
	}

	return outputProizvodi;
}

module.exports.kategorija = kategorija;
module.exports.getKategorije = getKategorije;
module.exports.proizvod = proizvod;
module.exports.getProizvode = getProizvode;
module.exports.getPopularneProizvode = getPopularneProizvode;
module.exports.getProizvod = getProizvod;
module.exports.getProizvodeForIdKategorija = getProizvodeForIdKategorija;