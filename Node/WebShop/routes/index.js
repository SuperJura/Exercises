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

router.get('/Kategorije', function(req, res){
	res.render('kategorije',{
		title: 'Kategorije',
		kategorije: new repository.getKategorije()
	});
});

module.exports = router;