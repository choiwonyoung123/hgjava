/**
 * center.js
1 data = fetch api에서 요청에 대한 응답에서 반환되는 실체 데이터

2 resolve = fetch api에서 promise가 성공적으로 완료된 것(fulfilled) 
>> then() 메서드에 전달된 콜백함수 실행

3 reject = fetch api에서 promise가 실패한 것(rejected)
>> catch() 메서드에 전달된 콜백함수 실행

4 json() = 요청에 대한 응답의 본문을 JSON 형식으로 파싱하여 javascript 객체로 변환

5 innerText = 특정 요소의 텍스트 콘텐츠만 나타냄, html태그 해석하지 않고 텍스트 그대로 반환

6 innerHTML = 특정 요소의 html 콘텐츠 나타냄, 요소 내부의 모든 콘텐츠 삽입 및 변경 가능

7 forEach() = 

8 JSON.stringify() = javascript >> json(문자열) 형태 변환

 */
console.log('center.js');









//공공데이터 url
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=0fI6Uua0Cehga%2FBTA%2FMi6gCcBVZCOJTghp9BlaGcQ7cPLNbz8UcAA5dExNrZTu81fn94v7JwQChaVE2fqHE9Tg%3D%3D';
//값 가져오기 위한 배열 생성
let showFields = ['id', 'centerName', 'phoneNumber', 'sido'];
//테이블 접근
let tbody = document.querySelector('#list');
let searchSido = document.querySelector('#searchSido');
let centerList = [];



//fetch then catch
fetch(url)
//json 값
.then(resolve => resolve.json())
//값 출력
.then(result => {
	console.log(result);
	//반환된 값 >> data >> 반복문
	centerList = result.data;
	centerList.forEach(center => {
		let tr = document.createElement('tr');
		//
		showFields.forEach(field => {
			let td = document.createElement('td');
			if(field == 'centerName'){				
				td.innerText = center[field].substring('코로나19 '.length);
			}
			else{
				td.innerText = center[field]
			}
			tr.append(td);
		})
		tbody.append(tr);
	})
})
.catch(err => console.log(err));



//행추가
function makeRow(center = {}){
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e){
		//location.href = 'map.jsp?lat=' + center.lat + '&lng=' + center.lng;
		window.open('map.jsp?lat=' + center.lat + '&lng=' + center.lng + '&centerName=' + center.centerName);
	})
	showFields.forEach(field => {
		let td = document.createElement('td');
		if(field == 'centerName'){				
			td.innerText = center[field].substring('코로나19 '.length);
		}
		else{
			td.innerText = center[field]
		}
		tr.append(td);
	})
	return tr;
}



//조회이벤트 >> 클릭
//document.querySelector('#searchBtn').addEventListener('click', searchCenter);
//function searchCenter(keyword = ''){
//	fetch(url)
//	.then(resolve => resolve.json())
//	.then(result => {
//		tbody.innerHTML = '';
//		result.data.forEach(center => {
//			let tr = document.createElement('tr');
//			showFields.forEach(field => {
//			let td = document.createElement('td');
//			if(field.sido == keyword){			
//				td.innerText = center[field].substring('코로나19 '.length);
//			}
//			else{
//				td.innerText = center[field]
//			}
//			tr.append(td);
//		})
//		tbody.append(tr);
//		})
//	})
//}


fetch(url)
.then(resolve => resolve.json())
.then(result => {
	let filterAry = [];
	result.data.forEach(center => {
		//행추가 >> 테이블 생성
		tbody.append(makeRow(center));
		//시도정보만 담고있는 배열 >> option생성
		if(filterAry.indexOf(center.sido) == -1){
			filterAry.push(center.sido);
		}
	})
	filterAry.forEach(sido => {
		let opt = document.createElement('option');
		opt.innerText = sido;
		searchSido.append(opt);
	})
})
.catch(err => console.log(err));



//조회버튼 클릭 (전체 문자)
//document.querySelector('#searchBtn').addEventListener('click', function(e){
//	tbody.innerHTML = ''; //리스트 초기화
//	let kw = document.querySelector('#keyword').value; //입력받은 키워드 값 가져오기
//	centerList.filter(center => center.sido == kw) //배열에서 sido가 키워드가 같은 것만 필터링
//	.forEach(center => { //필터링된 값만 가져와서 행추가
//		tbody.append(makeRow(center));
//	})
//})
//조회버튼 클릭 (포함된 문자)
document.querySelector('#searchBtn').addEventListener('click', function(e){
	tbody.innerHTML = ''; //리스트 초기화
	let kw = document.querySelector('#keyword').value; //입력받은 키워드 값 가져오기
	centerList.filter(center => center.sido.indexOf(kw) >= 0)
			.forEach(center => tbody.append(makeRow(center)));	
})
//조회버튼 변화
document.querySelector('#searchSido').addEventListener('change', function(e){
	tbody.innerHTML = ''; //리스트 초기화
	let kw = document.querySelector('#searchSido').value; //바뀌는 키워드 값 가져오기
	//let kw = this.value; //value 값을 받아오는 대신 this 사용 가능
	centerList.filter(center => center.sido == kw) //배열에서 sido가 키워드가 같은 것만 필터링
	.forEach(center => { //필터링된 값만 가져와서 행추가
		tbody.append(makeRow(center));
	})
})

//JSON 전송 >> db 입력
document.getElementById('registerData').addEventListener('click', function(e){
	//서버 사용 >> fetch 사용
	fetch('../registerCenter.do',{
		method: 'post',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(centerList)
	})
	.then(resolve => resolve.text())
	.then(result => console.log(result))
	.catch(err => console.log(err));
})

