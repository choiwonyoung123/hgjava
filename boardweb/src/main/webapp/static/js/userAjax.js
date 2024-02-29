/**
 * userAjax.js
 */
console.log('userAjax.js');

document.addEventListener('DOMContentLoaded', function(e){
	//id가 addBtn인 요소 찾기 >> 클릭 이벤트 등록 >> 함수 연결
	document.getElementById('addBtn').addEventListener('click', function(e){
		//서블릿호출, 화면제어
		let bookCode = document.getElementById('bcode').value;
		let bname = document.getElementById('bname').value;
		let author = document.getElementById('bauthor').value;
		let press = document.getElementById('bpress').value;
		let price = document.getElementById('bprice').value;
		let obj = {bookCode, bname, author, press, price};
		
		const addAjax = new XMLHttpRequest();
		//post방식 >> encoding처리
		addAjax.open('post', 'addBook.do');
		//호출 문자열
		addAjax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		addAjax.send('bcode='+bookCode+'&bname='+bname+'&bauthor='+author+'&bpress='+press+'&bprice='+price);
		//get방식
		//addAjax.send('get', 'addBook?bcode='+bcode+'&bname='+bname+'&bauthor='+author+'&bpress='+press+'&bprice='+price);
		addAjax.onload = function(e){
			let result = JSON.parse(addAjax.responseText);
			console.log(result);
			if(result.retCode == 'OK'){
				document.querySelector('#show tbody').appendChild(makeRow(obj));
			}
			else if(result.retCode == 'NG'){
				alert("오류")
			}
		}
	}); //end of add
	
	let json = "";
	const xhtp = new XMLHttpRequest();
	//open() >> 페이지 읽어들이기
	//요청방식 >> get, 요청url >> 경로
	xhtp.open('get', 'bookList.do');
	//
	xhtp.send();
	//onload이벤트 발생 >> 함수 실행
	xhtp.onload = function(e){
		//json문서를 자바스크립트 객체로 변환
		json = JSON.parse(xhtp.responseText);
		console.log('onload', json);
		
		//타이틀
		//데이터생성
		let title = ['도서코드', '도서명', '저자', '출판사', '가격'];
		//let title = json[0];
		let tr = document.createElement('tr');
		for(let prop in title){		
			//console.log(title);
			let th = document.createElement('th');
			th.innerText = prop;
			tr.appendChild(th);
		}
		//삭제버튼생성
		let th = document.createElement('th');
		th.innerText = '삭제';
		tr.appendChild(th);
		document.querySelector('#tableList thead').appendChild(tr);
		
		//데이터
		json.reduce((acc, item) => {
			acc.appendChild(makeRow(item));
			return acc;
		}, document.querySelector('#show tbody')); //초기값
		
		
		
	} //end of onload
}); //end of DOM
//한건 생성
function makeRow(obj = {}){
	//데이터생성
	let trTag = document.createElement('tr');
	trTag.setAttribute('id', 'book_'+obj.bookCode);
	trTag.setAttribute('data-code', obj.bookCode)
	for(let prop in obj){
		let tdTag = document.createElement('td');
		tdTag.innerText = obj[prop];
		trTag.appendChild(tdTag);
	}
	//삭제버튼생성
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow, true);
	btn.innerText = '삭제';
	//이벤트 연결
	let tdTag = document.createElement('td');
	tdTag.appendChild(btn);
	trTag.appendChild(tdTag);
	return trTag;
}
//한건 삭제
function deleteRow(e){
	let tr = this.parentElement.parentElement;
	let bcode = tr.dataset.code;
	//console.log(bcode);
	
	const addAjax = new XMLHttpRequest();
	//post방식 >> encoding처리
	addAjax.open('post', 'removeBook.do');
	//호출 문자열
	addAjax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	addAjax.send('bcode='+bcode);
	addAjax.onload = function(e){
		result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'OK'){
				tr.remove();		
		}
		else if(result.retCode == 'NG'){
			alert("오류")
		}
	}
}