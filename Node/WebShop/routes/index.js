var express = require('express');
var repository = require('../services/DAL/Repository');
var router = express.Router();

/* GET home page. */
// router.get('/', function(req, res, next) {
//   res.render('index', { title: 'Express' });
// });

router.get('/', function(req, res){
	res.render('index', {
		title: 'WebShop',
		proizvodi: new repository.getPopularneProizvode()
	});
});

router.get('/Proizvodi/:id', function(req, res){
	var id = req.params['id'];
	res.render('index', {
		title: 'WebShop',
		proizvodi: new repository.getProizvodeForIdKategorija(id)
	});
});

router.get('/Kategorije', function(req, res){
	res.render('kategorije',{
		title: 'Kategorije',
		kategorije: new repository.getKategorije()
	});
});

router.get('/Profil', function(req, res){
	res.render('profil',{
		title: 'Kosarica'
	});
});


//Kada je post onda je sigurno insert
router.post('/Kosarica', function(req, res){

	var id = req.body.proizvodId;
	var kolicina = parseInt(req.body.numKolicina);
	dodajProizvodeUSession(req, id, kolicina);

	res.render('profil',{
		title: 'Kosarica'
	});
});

//Kada je get onda moze biti ili insert ili delete (TODO: napraviti bolje)
router.get('/Kosarica', function(req, res){

	var id = req.query['id'];
	var kolicina = parseInt(req.query['kolicina']);
	var akcija = req.query['akcija'];

	console.log(id + " " + kolicina + " " + akcija);
	if(akcija == 1){
		dodajProizvodeUSession(req, id, kolicina);
	}
	else if(akcija == 2){
		makniProizvodeIzSessiona(req, id, kolicina);
	}

	res.render('profil',{
		title: 'Kosarica'
	});
});

router.get('/Login', function(req, res){

	res.render('login',{
		title: 'Login korisnika',
		loginError: 'Da biste mogli kupovati, morate se ulogirati.'
	});
});

router.post('/Login', function(req, res){

	var pageToRender = 'login';
	var title = "Login korisnika";
	var loginError = "";

	var akcija = parseInt(req.body.akcija);
	var txtIme = req.body.txtIme;
	var txtLozinka = req.body.txtLozinka;

	console.log(akcija)
	switch(akcija){
		case 1:
			var korisnik = repository.getKorisnik(txtIme, txtLozinka);
			if(korisnik != null){
				req.session.korisnik = korisnik,
				pageToRender = "profil",
				title = "Kosarica"
			}
			else loginError = "Krivo korisnicko ime ili lozinka.";
		break;
		case 2:
			loginError = "Registracija nije podrzana u ovoj verziji aplikacije.";
		break;
	}

	res.render(pageToRender,{
		title: title,
		loginError: loginError
	});

});

function dodajProizvodeUSession(req, id, kolicina){
	var proizvodi = req.session.proizvodi;
	var ukupnaCijena = parseInt(req.session.ukupnaCijena);
	if(!proizvodi) proizvodi = [];
	if(!ukupnaCijena) ukupnaCijena = 0;

	var vecPostojiUListi = false;
	for (var i = 0; i <proizvodi.length; i++) {
		if(proizvodi[i].proizvodId === id){
			vecPostojiUListi = true;
			var trenutnaKolicina = parseInt(proizvodi[i].kolicina);
			proizvodi[i].kolicina = kolicina + trenutnaKolicina;
		}
	}
	if(!vecPostojiUListi){
		var indexSljedeceg = proizvodi.length;
		proizvodi[indexSljedeceg] = new repository.proizvodZaKosaricu(id, kolicina);
	}

	ukupnaCijena += kolicina * repository.getProizvod(id).cijena;
	req.session.ukupnaCijena = ukupnaCijena;
	req.session.proizvodi = proizvodi;

	console.log(ukupnaCijena);
}

function makniProizvodeIzSessiona(req, id, kolicina){
	var proizvodi = req.session.proizvodi;
	var ukupnaCijena = parseInt(req.session.ukupnaCijena);
	if(proizvodi){
		for (var i = 0; i < proizvodi.length; i++) {
			if(proizvodi[i].proizvodId == id){
				var trenutnaKolicina = parseInt(proizvodi[i].kolicina);
				trenutnaKolicina -= kolicina;
				if(trenutnaKolicina < 0) {trenutnaKolicina = 0;}
				proizvodi[i].kolicina = trenutnaKolicina;
			}
		}
	}
	if(ukupnaCijena){
		ukupnaCijena -= kolicina * repository.getProizvod(id).cijena;
	}
	req.session.ukupnaCijena = ukupnaCijena;
	req.session.proizvodi = proizvodi;
}

router.get('/api/getProizvod/:id', function(req, res){
	var id = req.params['id'];
	res.send(new repository.getProizvod(id));
})

module.exports = router;