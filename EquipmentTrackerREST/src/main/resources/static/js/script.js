window.addEventListener('load', function(e) {
	console.log('document loaded');
	showEquipment();
	newEquipment();

});

function showEquipment() {
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
	dataDiv.textContent = "";

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

function newEquipment() {
	document.addEquipment.submit.addEventListener('click', function(e) {
		e.preventDefault();
		let form = e.target.parentElement;
		console.log(form);
		console.log(e.target);
		let equipment = {
				name: form.name.value,
				description: form.description.value,
				nsn: form.nsn.value,
				serial: form.serial.value,
				quantity: form.quantity.value,

		};
		console.log(equipment);
		addNewEquipment(equipment);
	});

}

function addNewEquipment(equipment) {
    let xhr = new XMLHttpRequest();
    let eqJson = JSON.stringify(equipment);
    xhr.open('POST', 'api/equipment');
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                let addedEquipment = JSON.parse(xhr.responseText);
                showEquipment();
            }
        }
    };
    xhr.send(eqJson);
}
