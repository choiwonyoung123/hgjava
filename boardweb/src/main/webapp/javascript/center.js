/**
 * center.js
 */
console.log('center.js');

//공공데이터 url
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=0fI6Uua0Cehga%2FBTA%2FMi6gCcBVZCOJTghp9BlaGcQ7cPLNbz8UcAA5dExNrZTu81fn94v7JwQChaVE2fqHE9Tg%3D%3D';
//값 가져오기 위한 배열 생성
let showFields = ['id', 'centerName', 'phoneNumber', 'sido'];
//테이블 접근
let tbody = document.querySelector('#list');
//fetch then catch
fetch(url)
//json 값
.then(resolve => resolve.json())
//값 출력
.then(result => {
	console.log(result);
	//반환된 값 >> data >> 반복문
	result.data.forEach(center => {
		let tr = document.createElement('tr');
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

//조회이벤트 >> 클릭
document.querySelector('#searchBtn').addEventListener('click', searchCenter);
function searchCenter(sido = ''){
	fetch('center.jsp?sido=' + sido)
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		result.data.forEach(center => {
			
			let tr = document.createElement('tr');
		})
		
	})
}
