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

router.get('/api/getProizvod/:id', function(req, res){
	var id = req.params['id'];
	res.send(new repository.getProizvod(id));
})

module.exports = router;