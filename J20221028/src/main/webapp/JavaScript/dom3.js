/**
 * dom3.js
 */

document.addEventListener('DOMContentLoaded', function() {
	
	document.querySelector('button').addEventListener('click', function(){
		//아이디 조회해서 화면에서 삭제
		let trs = document.querySelectorAll('body>table>tbody>tr');
		let id = document.querySelector('input').value;
		for(let i = 0; i<trs.length; i++){
			if(trs[i].children[0].textContent == id ){
				trs[i].remove();
			}
		}
	});
	
	//객체
	let tableObject = {
		id: 'hong',
		titles: ["아이디", "이름", "이메일", "삭제"],
		data:[{id: 'user1', name: '홍길동', email: 'hong@email.com'},
			  {id: 'user2', name: '김민서', email: 'kim@email.com'},
	          {id: 'user3', name: '박항서', email: 'park@email.com'}],
		
		//데이터 추가
		addData: function(row) {
			this.data.push(row);
		},
		
		//테이블 생성
		makeTable: function() {
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead, tbody);
			return table;
		},
		
		//thead 부분
		makeHead: function() {
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			//titles가 가지고 있는 배열만큼 반복
			this.titles.forEach(function(title) {
				let th = document.createElement('th')
				let txt = document.createTextNode(title);
				
				th.append(txt);
				tr.append(th);
			})
			
			thead.append(tr);
			return thead;
		},
		
		//tbody 부분
		makeBody: function() {
			let tbody = document.createElement('tbody');
			//data가 가지고 있는 배열만큼 반복
			this.data.forEach(val => {
				let tr = document.createElement('tr');
				tbody.append(tr);
				//오브젝트의 갯수만큼 값가져오기
				for(let field in val){
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]);
					
					td.append(txt);
					tr.append(td);
					//console.log(val[field]);
				}
				
				//삭제버튼. 클릭하면 한건 삭제
				td = document.createElement('td');
				let button = document.createElement('button');
				button.addEventListener('click', function() {
					this.parentElement.parentElement.remove();
				});
				
				let txt = document.createTextNode('삭제');
				td.append(button);
				button.append(txt);
				tr.append(td);
			});
			
			return tbody;
		},

		
		init: function() {
			/*변수
			let id = 'kim';
			속성값을 읽어올려면 id앞에 this, 변수값을 읽어올려면 그냥 id 입력
			console.log('init call.' + id)*/
			
			//tag요소로 값을 가져올 경우 -> getElementsByTagName
			document.getElementsByTagName('body')[0].append(this.makeTable());
		}
	}
	
	// 데이터 추가.
	tableObject.addData({id: 'user4', name: '황선홍', email: 'hwang@email'});

	//화면에 그려주기
	tableObject.init();

}); //end of DOMContentLoaded



