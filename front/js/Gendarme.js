function Gendarme(){
	this.gendarmes = [
      {
        "id": "5417075d01b7100e11c47cd7",
        "latLong": {
          "x": -3.0,
          "y": 3.0
        },
        "name": "gendarmeCritical",
        "vehicle": null
      },
      {
        "id": "5417075d01b7100e11c47cd8",
        "latLong": {
          "x": -73.99756,
          "y": 40.73083
        },
        "name": "gendarmeCritical",
        "vehicle": null
      },
      {
        "id": "5417075d01b7100e11c47cd9",
        "latLong": {
          "x": -73.99756,
          "y": 40.73083
        },
        "name": "gendarmeNormal",
        "vehicle": null
      },
      {
        "id": "5417075d01b7100e11c47cdb",
        "latLong": null,
        "patente": "CFG-222",
        "area": {
          "poligono": {
            "points": [
              {
                "x": -73.99756,
                "y": 40.73083
              },
              {
                "x": -73.99756,
                "y": 40.741404
              },
              {
                "x": -73.988135,
                "y": 40.741404
              },
              {
                "x": -73.988135,
                "y": 40.73083
              }
            ]
          }
        }
      },
      {
        "id": "5417075d01b7100e11c47cdc",
        "latLong": null,
        "patente": "CFG-223",
        "area": {
          "poligono": {
            "points": [
              {
                "x": -73.99756,
                "y": 40.73083
              },
              {
                "x": -73.99756,
                "y": 40.741404
              },
              {
                "x": -73.988135,
                "y": 40.741404
              },
              {
                "x": -73.988135,
                "y": 40.73083
              }
            ]
          }
        }
      },
      {
        "id": "5417075d01b7100e11c47cda",
        "latLong": {
          "x": -2.0,
          "y": 2.0
        },
        "name": "gendarNormal",
        "vehicle": {
          "id": "5417075d01b7100e11c47cdb",
          "latLong": null,
          "patente": "CFG-222",
          "area": {
            "poligono": {
              "points": [
                {
                  "x": -73.99756,
                  "y": 40.73083
                },
                {
                  "x": -73.99756,
                  "y": 40.741404
                },
                {
                  "x": -73.988135,
                  "y": 40.741404
                },
                {
                  "x": -73.988135,
                  "y": 40.73083
                }
              ]
            }
          }
        }
      }
];
}

// class methods
Gendarme.prototype.getAll = function(id) {
	console.log("Getting Gendarme " + id);
	console.log("from list: "+ JSON.stringify(this.gendarmes));	
	return this.gendarmes;
};

// export the class
module.exports = new Gendarme();