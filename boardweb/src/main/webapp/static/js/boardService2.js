/**
 * 	boardService.js
 */

// .pagination >> a >> click이벤트
let page = 1;
function pagingFunc(){	
	document.querySelectorAll('.pagination>a').forEach(item => {
	item.addEventListener('click', function(e){
		e.preventDefault(); //a태그의 링크기능 차단
		let page = item.innerText; //1,2,3값 >> 페이지로 사용
		
		//const rlistHtp = new XMLHttpRequest();
		//rlistHtp.open('get', 'replyList.do?bno='+bno+'&page='+page);
		//rlistHtp.send();
		//rlistHtp.onload = function(e){
		//	let result = JSON.parse(rlistHtp.responseText);
		//	console.log(result);
		//}
		replyList(page);
		pageList();
	});
}); //nodelist
}



//이벤트등록 >> 클릭 - addReplyFnc 함수
document.querySelector('.addReply').addEventListener('click', addReplyFnc);
//addReplyFnc 함수
function addReplyFnc(e){
	//input 속성의 name이 'reply'인 값 가져오기
	let reply = document.querySelector('input[name="reply"]').value;
	if(!reply){
		alert('댓글을 입력하세요');
		return;
	}
	//let replyer = "${logid}";
	//XMLHttpRequest 객체 생성
	const addHtp = new XMLHttpRequest();
	fetch('addReply.do', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + replyer
	})
	let result = awiat.result.json();
	if(result.retCode == 'OK'){
		alert("등록성공");
		document.querySelector('.reply ul').value = '';
		resolve 
	}
	
	//비동기 연결 시작 >> post방식 - addReply.do 화면
	//addHtp.open('post', 'addReply.do');
	//
	//addHtp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	//전송 시작 >> 응답 요청 전달 >> 서버의 응답 회신
	//addHtp.send('bno='+bno+'&reply='+reply+'&replyer='+replyer);
	//요청에 대한 응답을 처리하는 콜백함수
	//addHtp.onload = function(e){
		//json >> javascript 포맷
	//	let result = JSON.parse(addHtp.responseText);
	//	if(result.retCode == 'OK'){
	//		alert("등록성공")
	//		//reply 클래스의 ul에 행 추가
	//		document.querySelector('.reply ul').appendChild(makeRow(result.retVal));
	//		document.querySelector('#reply').value='';
			
			//건수 계산 위한 ajax 호출
	//		const cntHtp = new XMLHttpRequest();
	//		page = 1;
	//		replyList();
	//		pageList;
	//	}
	//	else{
	//		alert("처리 중 에러");
	//	}
	//}
	//console.log(bno, reply, replyer);
}



//한건등록 
function makeRow(obj = {}){
	let fields = ['replyNo', 'reply', 'replyer'];
	let liTag = document.createElement('li');
	liTag.setAttribute('data-rno', obj.replyNo);
	fields.forEach(prop => {
			let span = document.createElement('span');
			span.innerText = obj[prop];
			if(prop == 'reply'){
				span.className = 'col-sm-6';
			}
			else{
				span.className = 'col-sm-2';
			}
			liTag.appendChild(span);
		});
		//삭제버튼
		let span = document.createElement('span');
		span.className = 'col-sm-2';
		let btn = document.createElement('button');
		btn.addEventListener('click', deleteRow);
		btn.innerText = '삭제';
		span.appendChild(btn);
		liTag.appendChild(span);
		return liTag;
}

function makeRow2(obj = {}){
	//클론 가져오기
	let clon = document.querySelector('.content>ul>li:nth-of-type(1)').cloneNode(true);
	clon.setAttribute('data-rno', obj.replyNo);
	//클론에서 값 바꾸기
	clon.querySelector('span:nth-of-type(1)').innerText = obj.replyNo;
	clon.querySelector('span:nth-of-type(2)').innerText = obj.reply;
	clon.querySelector('span:nth-of-type(3)').innerText = obj.replyer;
	
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow);
	btn.innerText = '삭제';
	clon.querySelector('span:nth-of-type(4)').innerText = '';
	clon.querySelector('span:nth-of-type(4)').appendChild(btn);
	return clon;
}

//한건삭제
function deleteRow(e){
	let rno = this.parentElement.parentElement.dataset.rno;
	let li = this.parentElement.parentElement;
	console.log(this.parentElement);
	let writer = this.parentElement.previousElementSibling.innerText;
	if(replyer != writer){
		alert('삭제권한이 없습니다.')
		return;
	}
	
	const delHtp = new XMLHttpRequest();
	fetch('../removeReply.do', {
		method: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'rno=' + rno
	})
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
				alert(result.retMsg);
				replyList(page);
				pageList();
			}
			else{
				alert(result.retMsg);
			}
	})
	.catch(err => console.log(err));
	
//	delHtp.open('post', 'removeReply.do');
//	delHtp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
//	delHtp.send('rno='+rno);
//	delHtp.onload = function(e){
//		console.log(delHtp);
//		const result = JSON.parse(delHtp.responseText);
//		if(result.retCode == 'OK'){
//			alert(result.retMsg);
//			li.remove();
//		}
//		else{
//			alert(result.retMsg);
//		}
//	}
}

//댓글목록
function replyList(rpage = 1){
	const xhtp = new XMLHttpRequest();
	fetch('../replyList.do?bno=' + bno + '&page=' + rpage)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
			alert('성공');
		}
		else{
			alert('실패');
		}
	})
	
	
//	xhtp.open('get', 'replyList.do?bno=' + bno + '&page=' +rpage);
//	xhtp.send();
//	xhtp.onload = function(e){
//		//console.log(xhtp.responseText);
//		const data = JSON.parse(xhtp.responseText);
//		//기존목록 삭제
//		document.querySelectorAll('li[data-rno]').forEach(item => item.remove());
//		//목록
//		data.forEach(item => {
//			document.querySelector('.reply ul').appendChild(makeRow2(item));
//		});
//	}
}
replyList();

//페이징 replyList.do
function pageList(){
	const plistHtp = new XMLHttpRequest();
//	fetch('../getTotal.do?bno=' + bno)
//	.then(resolve => resolve.json())
//	.then(result => {
//		if(result.retCode == 'OK'){
//			alert('성공');
//		}
//		else{
//			alert('실패');
//		}
//	})
	
	
	plistHtp.open('get', 'getTotal.do?bno=' + bno);
	plistHtp.send();
	plistHtp.onload = function(e){
	//기존내용 초기화
	document.querySelector('div.pagination').innerHTML = '';
	let result = JSON.parse(plistHtp.responseText);
	let totalCnt = result.totalCount;
	let realEnd = Math.ceil(totalCnt / 5);
	let next, prev;
	//1~5, 6~10 페이지
	let startPage, endPage;
	endPage = Math.ceil(page/5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;
	next = endPage < realEnd ? true : false;
	prev = startPage > 1;
	
	if(prev){
		let aTag = document.createElement('a');
		//aTag.innerText = startPage - 1;
		aTag.innerHTML = '&laquo';
		aTag.href = '#';
		aTag.setAttribute('data-page', startPage - 1);
		document.querySelector('div.pagination').appendChild(aTag);
	}
	for(let p = startPage; p <= endPage; p++){
		let aTag = document.createElement('a');
		aTag.innerText = p;
		aTag.href = '#';
		if(p == page){
			aTag.className = 'active';
		}
		document.querySelector('div.pagination').appendChild(aTag);
	}
	if(next){
	let aTag = document.createElement('a');
		//aTag.innerText = endPage + 1;
		aTag.innerHTML = '&raquo';
		aTag.href = '#';
		aTag.setAttribute('data-page', endPage + 1);
		document.querySelector('div.pagination').appendChild(aTag);
	}
	pagingFunc();
	}
}
pageList();