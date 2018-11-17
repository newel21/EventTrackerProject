window.addEventListener('load', function(e) {
	console.log('document loaded');
	showEquipment(getEquipment);

});

function showEquipment(getEquipment) {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/equipment');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if(xhr.status === 200) {
				let response = xhr.responseText;
				let equipment = JSON.parse(response);
				console.log(equipment);
				getEquipment(equipment);
			}
			else {
				console.log('NOT FOUND');
			}
		}
	}
	xhr.send();
}

function getEquipment(equipment) {
	var dataDiv = document.getElementById('showTable');

	var table = document.createElement('table');
	dataDiv.appendChild(table);

	var thead = document.createElement('thead');
	table.appendChild(thead);

	var tr = document.createElement('tr');
	thead.appendChild(tr);

	var nameTH = document.createElement('th');
	nameTH.textContent = "NAME";
 	tr.appendChild(nameTH);

	var descriptionTH = document.createElement('th');
	descriptionTH.textContent = "DESCRIPTION";
	tr.appendChild(descriptionTH);

	var nsnTH = document.createElement('th');
	nsnTH.textContent = "NSN";
	tr.appendChild(nsnTH);

	var serialTH = document.createElement('th');
	serialTH.textContent = "SERIAL #";
	tr.appendChild(serialTH);

	var quantityTH = document.createElement('th');
	quantityTH.textContent = "QTY";
		tr.appendChild(quantityTH);



	var tbody = document.createElement('tbody');
	table.appendChild(tbody);

	for (var i = 0; i < equipment.length; i++) {
		var tr = document.createElement('tr');
		tr.id = equipment[i].id;
		tbody.appendChild(tr);

		var name = document.createElement('td');
		name.textContent = equipment[i].name;
		tr.appendChild(name);

		var description = document.createElement('td');
		description.textContent = equipment[i].description;
		tr.appendChild(description);

		var nsn = document.createElement('td');
		nsn.textContent = equipment[i].nsn;
		tr.appendChild(nsn);

		var serial = document.createElement('td');
		serial.textContent = equipment[i].serial;
		tr.appendChild(serial);

		var quantity = document.createElement('td');
		quantity.textContent = equipment[i].quantity;
		tr.appendChild(quantity);


	}
}

// function getEquipment(equipment) {
// 	var tableDiv = document.getElementById('table');
//
// 	if(typeof equipment === 'object') {
// 		var name = document.createElement('blockquote');
// 		name.textContent = equipment[0].name;
// 		tableDiv.appendChild(name);
//
// 		var uList = document.createElement('ul');
// 		tableDiv.appendChild(uList);
//
// 		var description = document.createElement('li');
// 		description.textContent = equipment[0].description;
// 		uList.appendChild(description);
//
// 		var nsn = document.createElement('li');
// 		nsn.textContent = equipment[0].nsn;
// 		uList.appendChild(nsn);
//
// 		var serial = document.createElement('li');
// 		serial.textContent = equipment[0].serial;
// 		uList.appendChild(serial);
//
// 		var quantity = document.createElement('li');
// 		quantity.textContent = equipment[0].quantity;
// 		uList.appendChild(quantity);
//
//
// 	}
