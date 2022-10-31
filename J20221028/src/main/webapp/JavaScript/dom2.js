//dom2.js

//index.html의 document
document.addEventListener('DOMContentLoaded', domLoadedFunc);

function domLoadedFunc() {
	//키:값의 형식
	let data = `[{"id":1,"first_name":"Antoine","last_name":"Mitford","email":"amitford0@utexas.edu","gender":"Male","salary":1894},
				 {"id":2,"first_name":"Lorine","last_name":"Velde","email":"lvelde1@zimbio.com","gender":"Female","salary":3830},
				 {"id":3,"first_name":"Alisha","last_name":"Reeks","email":"areeks2@admin.ch","gender":"Female","salary":4268},
				 {"id":4,"first_name":"Cullen","last_name":"Yearsley","email":"cyearsley3@rediff.com","gender":"Male","salary":6504}]`;

	//json형태로 만들어진것을 자바스크립트 object형식으로 바꾸겠다.
	let obj = {}
	let result = JSON.parse(data); // json => object

	/*console.log(result);

	console.log(result[1].email);
	
	for (let i = 0; i < result.length; i++) {
		console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);
	}

	//확장 for
	for (let obj of result) {
		console.log(`id: ${obj.id}, email: ${obj['email']}`);
	}

	console.clear();*/

	//배열일 경우에는 배열이름.forEach(); -> 매게값으로 함수를 받는다.
	//값, 인덱스, 배열 순서
	result.forEach(function(value, index, array) {
		//if(value.salary > 5000)
		if (index < 2)
			console.log(value, index, array);
	});

	//데이터 테이블로 뿌려주기.
	let tableTag = document.createElement('table');
	let show = document.getElementById('show');
	show.appendChild(tableTag);

	//thead
	let theadTag = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];

	for (let title of titles) {
		let thTag = document.createElement('th');
		let titleTxt = document.createTextNode(title); //<th>아이디</th>
		thTag.appendChild(titleTxt);
		tr.appendChild(thTag);
	}

	//thead에 체크박스 생성
	let th = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute("type", "checkbox");
	checkbox.addEventListener('change', function() {
		//tbody의 체크박스 -> cks
		//let cks = document.querySelectorAll('#show input[type="checkbox"]');

		//forEach -> 반복
		document.querySelectorAll('#show input[type="checkbox"]').forEach(function(check) {
			//tdoby의 체크박스와 thead의 체크박스의 checked를 같게 만들겠다.
			check.checked = checkbox.checked;
		});
	});

	th.appendChild(checkbox);
	tr.appendChild(th);

	theadTag.appendChild(tr);
	tableTag.appendChild(theadTag);

	//tbody
	let tbodyTag = document.createElement('tbody');
	tableTag.appendChild(tbodyTag);

	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
	for (let obj of result) {
		//데이터건수만큼 반복
		let trTag = makeTr(obj);

		tbodyTag.appendChild(trTag);
	} // end of for(let obj of result)

	// 추가버튼에 이벤트 등록.
	document.querySelector('button[type="button"]').addEventListener('click', function() {
		console.log('추가버튼 발생!');
		let id = document.getElementById('id').value;
		let fName = document.getElementById('fname').value;
		let email = document.getElementById('email').value;
		let salary = document.getElementById('salary').value;
		let gender = document.getElementById('gender').value;

		let newRow = {
			id: id,
			first_name: fName,
			email: email,
			gender: gender,
			salary: salary
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
	});

	// 수정버튼에 이벤트 등록
	document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);

	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		//console.log(trs);
		let id = document.getElementById('id').value;

		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[0].textContent == id) {
				trs[i].children[1].textContent = document.getElementById('fname').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[4].textContent = document.getElementById('salary').value;
			}
		}
	} // end of updateFunc();

	//선택삭제버튼에 이벤트 등록
	document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deleteFunc);

	function deleteFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');

		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[6].children[0].checked) {
				trs[i].remove();
			}
		}
	}// end of deleteFunc()

	//tr, td 생성 함수
	function makeTr(row) {
		let trTag = document.createElement('tr');

		trTag.addEventListener('mouseover', showDetailFun); //마우스가 올라가면 실행될 이벤트

		trTag.addEventListener('click', clickFun); // 클릭하면 실행될 이벤트

		trTag.addEventListener('mouseout', function() {
			this.style.backgroundColor = null;
		}); //마우스를 빼면 실행될 이벤트

		for (let field of fields) {
			//항목만큼 반복
			let tdTag = document.createElement('td');
			let fieldTxt = document.createTextNode(row[field]);
			tdTag.appendChild(fieldTxt);
			trTag.appendChild(tdTag);
		}
		//삭제버튼<td><button>삭제</button></td>
		let tdTag = document.createElement('td');
		let buttonTag = document.createElement('button');
		buttonTag.addEventListener('click', function() {
			//console.log(this);
			this.parentElement.parentElement.remove();
		});

		let txt = document.createTextNode('삭제');
		tdTag.appendChild(buttonTag);
		buttonTag.appendChild(txt);
		trTag.appendChild(tdTag);

		tdTag = document.createElement('td');
		tdTag.style.textAlign = 'center';
		let checkBox = document.createElement('input');
		checkBox.addEventListener('change', function() {
			//console.log(this.checked);
		});
		checkBox.setAttribute("type", "checkbox");
		tdTag.appendChild(checkBox);
		trTag.appendChild(tdTag);

		return trTag;
	} // end of makeTr();

	function showDetailFun() {
		this.style.backgroundColor = 'yellow';
		//console.log(this.children[6].textContent);
	} // end of showDetailFun()

	function clickFun() {
		document.getElementById('id').value = this.children[0].textContent;
		document.getElementById('fname').value = this.children[1].textContent;
		document.getElementById('email').value = this.children[2].textContent;
		document.getElementById('gender').value = this.children[3].textContent;
		document.getElementById('salary').value = this.children[4].textContent;

	} //end of clickFun()
} // end of domLoadedFunc()


