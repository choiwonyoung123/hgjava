/**
 *  static/js/userList.js 파일 데이터
 */
//mockaroo >> json포맷파일 >> 복사붙여넣기
let str = `[{"id":1,"first_name":"Gloriane","last_name":"Thorp","email":"gthorp0@joomla.org","gender":"Female","salary":4424},
{"id":2,"first_name":"Broddie","last_name":"Speck","email":"bspeck1@technorati.com","gender":"Male","salary":2745},
{"id":3,"first_name":"Lilas","last_name":"Pelfer","email":"lpelfer2@spotify.com","gender":"Female","salary":2903},
{"id":4,"first_name":"Jo","last_name":"Hulett","email":"jhulett3@thetimes.co.uk","gender":"Male","salary":3249},
{"id":5,"first_name":"Dulcine","last_name":"Balser","email":"dbalser4@purevolume.com","gender":"Female","salary":3967},
{"id":6,"first_name":"Allistir","last_name":"Denidge","email":"adenidge5@php.net","gender":"Male","salary":3770},
{"id":7,"first_name":"Dorolice","last_name":"Goforth","email":"dgoforth6@weibo.com","gender":"Female","salary":3280},
{"id":8,"first_name":"Rosette","last_name":"Ilewicz","email":"rilewicz7@nih.gov","gender":"Female","salary":3394},
{"id":9,"first_name":"Horton","last_name":"Gentil","email":"hgentil8@samsung.com","gender":"Male","salary":3641},
{"id":10,"first_name":"Elladine","last_name":"Osanne","email":"eosanne9@moonfruit.com","gender":"Female","salary":2096},
{"id":11,"first_name":"Aleksandr","last_name":"Bagwell","email":"abagwella@webmd.com","gender":"Male","salary":3528},
{"id":12,"first_name":"Robert","last_name":"Franses","email":"rfransesb@123-reg.co.uk","gender":"Male","salary":2262},
{"id":13,"first_name":"Gray","last_name":"Babonau","email":"gbabonauc@about.me","gender":"Male","salary":2030},
{"id":14,"first_name":"Jerrie","last_name":"Yakolev","email":"jyakolevd@discuz.net","gender":"Female","salary":3018},
{"id":15,"first_name":"Julee","last_name":"Whodcoat","email":"jwhodcoate@aol.com","gender":"Female","salary":2302}]`;
//문자열을 자바스크립트 오브젝트 파일로 변환
let json = JSON.parse(str);
console.log(json);


console.log("userlist.js");
//document.querySelector('#name').value = '홍길동';

document.addEventListener('DOMContentLoaded', function(e){
	document.querySelector('#name').value = '홍길동';
	
	//thead영역
	let title = json[0];
	let tr = document.createElement('tr');
	for(let prop in title){		
		//console.log(title);
		let th = document.createElement('th');
		th.innerText = prop;
		tr.appendChild(th);
	}
	document.querySelector('#tableList thead').appendChild(tr);
	
	//tbody영역
	json.forEach(function(item, idx){
		//console.log(item, idx); //item > 데이터한건
		let tr = document.createElement('tr');
		for(let prop in item){		
			let td = document.createElement('td');
			td.innerText = item[prop];
			tr.appendChild(td);
		}
		document.querySelector('#tableList tbody').appendChild(tr);
	});
});
//성별선택 이벤트 연결 
document.querySelector('#genderList').addEventListener('change', genderChange);
function genderChange(e){
	//성별선택 > tbody지우기 > 새로운목록출력
	let gender;
	gender = document.querySelector('#genderList').value;
	document.querySelector('tbody').innerText = '';
	let tr = document.createElement('tr');
		for(let prop in item){		
			let td = document.createElement('td');
			td.innerText = item[prop];
			tr.appendChild(td);
		}
		document.querySelector('#tableList tbody').appendChild(tr);
}