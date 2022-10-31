/**
 * dom1.js
 */

//동적으로 만들고 싶을 경우 dom을 활용해서 생성할 수 있다.
document.addEventListener('DOMContentLoaded', function() {
	let show = document.getElementById('show');
	let formTag = document.createElement('form');
	
	//ID
	let txt = document.createTextNode("ID: ");
	let inputTag = document.createElement('input');
	inputTag.setAttribute("type", "text");
	inputTag.setAttribute("id", "id");
	
	let brTag = document.createElement('br');
	
	formTag.appendChild(txt);
	formTag.appendChild(inputTag);
	formTag.appendChild(brTag);

	show.appendChild(formTag);
	
	
	//NAME
	txt = document.createTextNode("Name: ");
	inputTag = document.createElement('input');
	inputTag.setAttribute("type", "text");
	inputTag.setAttribute("id", "name");
	brTag = document.createElement('br');
	
	formTag.appendChild(txt);
	formTag.appendChild(inputTag);
	formTag.appendChild(brTag);

	show.appendChild(formTag);
	
	//Phone
	txt = document.createTextNode("Phone: ");
	inputTag = document.createElement('input');
	inputTag.setAttribute("type", "text");
	inputTag.setAttribute("id", "phone");
	brTag = document.createElement('br');
	
	formTag.appendChild(txt);
	formTag.appendChild(inputTag);
	formTag.appendChild(brTag);

	show.appendChild(formTag);
	
	//전송
	inputTag = document.createElement('input');
	inputTag.setAttribute("type", "submit");
	inputTag.setAttribute("value", "전송");
	
	formTag.appendChild(inputTag);
	show.appendChild(formTag);
});

	
	





