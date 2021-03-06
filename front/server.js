var express = require("express");
var bodyParser = require("body-parser");

var Gendarme = require("./js/Gendarme");

var app = express();

server = require('http').createServer(app);

app.use(express.static(__dirname + '/dist'));

console.log(__dirname);

app.get('/', function(req, res) {
  res.json(__dirname + ' It work\'s!');
});

var port = Number(process.env.PORT || 5000);

server.listen(port);
console.log("Listening on " + port);

app.use(bodyParser.json());

///////////////////////////API UTILS//////////////////////////////////////////
var bodyHasRequiredProperties = function(body, properties){
	for (var i in properties) {
		var prop = properties[i];
		if(!body.hasOwnProperty(prop)) {
		    return false;
		} else {
			if (!body[prop]) {
				return false;
			}
		}
	}
	return true;
}
///////////////////////////API UTILS END//////////////////////////////////////////
var router = express.Router(); 				// get an instance of the express Router

app.all('*', function(req, res, next) {
  console.log("Habilitando CORS...");
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  next();
});

///////////////////////// API //////////////////////////////////////

router.get('/services/getAgent/:swlat/:swlng/:nelat/:nelng', function(req, res) {
	
	console.log("Entro en la llamada de la api, obteniendo el servicio de los gendarmes.");

	var gendarmes = Gendarme.getAll( req.params.id);
	return (res.json(gendarmes));
});

router.get('/services/getNotInArea', function(req, res) {
	
	console.log("Entro en la llamada de la api, obteniendo el servicio de los gendarmes no asignados.");

	var gendarmes = Gendarme.getNotInArea( req.params.id);
	return (res.json(gendarmes));
});

// REGISTER OUR ROUTES -------------------------------
// all of our routes will be prefixed with /api
app.use('/api', router);