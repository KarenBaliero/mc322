
let fs = require('fs');

let csv = require('fast-csv');

fs.createReadStream('matriz.csv')
	.pipe(csv())
	.on('data', function(data) {
		console.log(data);
	})
	.on('end', function(data) {
		console.log('Read finished');
	});