/**
 *  object2.js
 */

//index.html을 모두 읽은 후 실행
document.addEventListener('DOMContentLoaded', function() {
	//document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	let data = `[{"id":1,"first_name":"Antoine","last_name":"Mitford","email":"amitford0@utexas.edu","gender":"Male","salary":1894},
				 {"id":2,"first_name":"Lorine","last_name":"Velde","email":"lvelde1@zimbio.com","gender":"Female","salary":3830},
				 {"id":3,"first_name":"Alisha","last_name":"Reeks","email":"areeks2@admin.ch","gender":"Female","salary":4268},
				 {"id":4,"first_name":"Cullen","last_name":"Yearsley","email":"cyearsley3@rediff.com","gender":"Male","salary":6504},
				 {"id":5,"first_name":"Sutherland","last_name":"Dittson","email":"sdittson4@blinklist.com","gender":"Male","salary":3177},
				 {"id":6,"first_name":"Ari","last_name":"Thurstance","email":"athurstance5@nationalgeographic.com","gender":"Male","salary":7238},
				 {"id":7,"first_name":"Odilia","last_name":"Rome","email":"orome6@blogspot.com","gender":"Female","salary":2309},
				 {"id":8,"first_name":"Ebony","last_name":"Cowterd","email":"ecowterd7@oracle.com","gender":"Female","salary":4802},
				 {"id":9,"first_name":"Tod","last_name":"Snailham","email":"tsnailham8@aol.com","gender":"Male","salary":3633},
				 {"id":10,"first_name":"Kora","last_name":"Maltby","email":"kmaltby9@phoca.cz","gender":"Female","salary":9145}]`;

	// json 타입 => javascript 오브젝트 타입으로 변환
	let result = JSON.parse(data);
	console.log(result);

	//for(String str : personList)
	//<ul><li>obj</li></ul>
	//<div id="show"><div>

	const fields = ['id', 'first_name', 'email', 'salary'];
	//let ulTag = document.createElement('ul');
	let tableTag = document.createElement('table');
	let trTag = document.createElement('tr');

	for (row of result) {
		//ulTag.appendChild(makeList(row));
		trTag.appendChild(makeTr(row));
	}

	//document.getElementById('show').appendChild(ulTag);
	document.getElementById('show').appendChild(tableTag);

	function makeTr(obj) {
		let str = '';
		
		for (field of fields) {
			let tdTag = document.createElement('td');
			str += `${field}: ${obj[field]} `;
			let txt = document.createTextNode(str);
		}
			tdTag.appendChild(txt);
			trTag.appendChild(tdTag);
	}

	function makeList(obj) {
		let liTag = document.createElement('li');
		//let txt = document.createTextNode(`id: ${obj.id}, name: ${obj.first_name}, salary: ${obj.salary}, email: ${obj.email}`);
		let str = '';
		for (field of fields) {
			str += `${field}: ${obj[field]} `;
		}
		let txt = document.createTextNode(str);
		liTag.appendChild(txt);

		return liTag;
	}
});
