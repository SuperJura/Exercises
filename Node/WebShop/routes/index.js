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

router.post('/Kosarica', function(req, res){
	var proizvodi = req.session.proizvodi
	if(!proizvodi) {proizvodi = []}

	var id = req.body.proizvodId;
	var kolicina = parseInt(req.body.numKolicina);

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
	console.log(proizvodi);
	
	req.session.proizvodi = proizvodi;
	res.render('profil',{
		title: 'Kosarica'
	});
});

router.get('/api/getProizvod/:id', function(req, res){
	var id = req.params['id'];
	res.send(new repository.getProizvod(id));
})

module.exports = router;