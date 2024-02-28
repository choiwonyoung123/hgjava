/**
 *  script.js
 */
console.log("script.js");
console.log(document);

//상위 >> 하위 = true
//하위 >> 상위 = false
//이벤트 전파 방지 >> e.stopPropagation()



//이벤트연결
//버튼 중에서 클래스 이름이 btn
//click 이벤트 발생 >> 함수 실행
document.querySelector('button.btn').addEventListener('click', clickFnc) 
//매개변수 e >> 필수
function clickFnc(ev){
	console.log(ev);
	//태그(요소) 만들기
	let liTag = document.createElement('li');
	//id가 name인 input태그 >> 해당 요소의 value값
	let userValue = document.querySelector('input#name').value;
	//입력값 텍스트로 넣기
	liTag.innerText = userValue;
	//버튼(요소) 만들기
	let btn = document.createElement('button');
	//삭제 텍스트,버튼 넣기
	btn.innerText = '삭제';
	liTag.appendChild(btn);
	//만든 태그 리스트 목록에 붙이기(
	document.querySelector('#list').appendChild(liTag);
	//입력값 초기화
	document.querySelector('#name').value = '';
}


//addBtn클릭 이벤트 등록, 콜백함수
document.querySelector('#addBtn').addEventListener('click', addRow) 
function addRow(){
	//입력값 id 가져오기
	let sno, sname, score
	sno = document.querySelector('#sno').value;
	sname = document.querySelector('#sname').value;
	score = document.querySelector('#score').value;
	if(!sno || !sname || !score){
		alert("값을 채우세요");
		//함수종료
		return;
	}
	//키와 값이 같으면 하나만 씀
	let obj = {sno, sname, score};
	document.querySelector('#studList').appendChild(makeRow(obj));
	
}
//매개변수로 student라는 객체 받음, sample데이터
function makeRow(student={sno:1, sname:'test', score:90}){
	let trTag = document.createElement('tr');
	trTag.addEventListener('click', displayRow, false);
	for(let prop in student){
		let tdTag = document.createElement('td');
		tdTag.innerText = student[prop];
		trTag.appendChild(tdTag);
	}
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	//이벤트 연결
	btn.addEventListener('click', deleteRow, false);
	let tdTag = document.createElement('td');
	tdTag.appendChild(btn);
	trTag.appendChild(btn);
	return trTag;
}
//한 행 삭제 함수, 매개변수 필수
function deleteRow(e){
	//★★★★★하위에서 상위로 이벤트가 전파되는 것을 막음
	
	//선택한 현재 대상 출력
	console.log(e.target);
	//상위 요소에 가서 삭제
	e.target.parentElement.remove();
}
function displayRow(e){
	//console.log(e.target, this);
	//console.log(this.children[0].innerText);
	//클릭한 tr에 있는 td데이터를 입력칸에 데이터 가져오기
	e.stopPropagation();
	document.querySelector('#sno').value = this.children[0].innerText; //첫번째 컬럼
	document.querySelector('#sname').value = this.children[1].innerText; //두번째 컬럼
	document.querySelector('#score').value = this.children[2].innerText; //세번째 컬럼
}
document.querySelector('#editBtn').addEventListener('click', editRow) 
function editRow(e){
	//html에서 선택자에 해당하는 모든 값을 list에 넣기
	let list = document.querySelectorAll('#studList tr');
	for(let i = 0; i < list.length; i++){
		//sno가 같은 것이 있다면 해당 sno 데이터를 수정하기
		if(list[i].children[0].innerText == document.querySelector('#sno').value){ //첫번째 컬럼
			list[i].children[1].innerText = document.querySelector('#sname').value; //두번째 컬럼
			list[i].children[2].innerText = document.querySelector('#score').value; //세번째 컬럼
		}
	}
}
//value >> input, select
//innerText >> 태그



// str에 값 활용해서 화면출력
function makeTr(){
	//tr생성
	
	for(let student of str){
		let trTag = document.createElement('tr');
		let tdTag1 = document.createElement('td');
		//document.querySelector('tr').appendChild(tdTag1);
		tdTag1.innerText = student.sno;
		let tdTag2 = document.createElement('td');
		//document.querySelector('tr').appendChild(tdTag2);
		tdTag2.innerText = student.name;
		let tdTag3 = document.createElement('td');
		//document.querySelector('tr').appendChild(tdTag3);
		tdTag3.innerText = student.score;
		//자식태그 추가
		trTag.appendChild(tdTag1);
		trTag.appendChild(tdTag2);
		trTag.appendChild(tdTag3);	
		document.querySelector('#studList').appendChild(trTag);
	}
	//td생성 >> appendChild
	//tr >> appendChild
}
function makeTr2(){
	//tr생성
	
	for(let student of str){
		let trTag = document.createElement('tr');
		for(let prop in student){
			let tdTag = document.createElement('td');
			tdTag.innerText = student[prop];
			trTag.appendChild(tdTag);
		}
		document.querySelector('#studList').appendChild(trTag);
	}
	//td생성 >> appendChild
	//tr >> appendChild
}
//makeRow함수 사용
function makeTr3(){
	//tr생성
	
	for(let student of str){
		document.querySelector('#studList').appendChild(makeRow(student));
	}
	//td생성 >> appendChild
	//tr >> appendChild
}
//makeTr();
//makeTr2();
makeTr3();