import { list } from './complaints.js';

let insert = new list;

function insertEvent() {
	console.log(insert);
	return insert.insertGo('1234');
}

document.getElementById('insert').addEventListener('click', insertEvent);
