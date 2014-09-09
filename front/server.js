var express = require("express");
var bodyParser = require("body-parser");

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