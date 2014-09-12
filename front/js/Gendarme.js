function Gendarme(){
	this.gendarmes = [
    {
        "name": "Cosme Fulanito"
    },
    {
        "name": "Jorge Alberto"
    },
    {
        "name": "Lionel Messi"
    }];
}

// class methods
Gendarme.prototype.getAll = function(id) {
	console.log("Getting Gendarme " + id);
	console.log("from list: "+ JSON.stringify(this.gendarmes));	
	return this.gendarmes;
};

// export the class
module.exports = new Gendarme();