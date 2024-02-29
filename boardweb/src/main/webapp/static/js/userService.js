/**
 * userService.js
 */
document.addEventListener('DOMContentLoaded', function(e){	
	console.clear();
	console.log("userService.js");
	
	//forEach메소드 >> 반환값x
	//filter메소드 >> 새로운 배열생성
	let fAry = json.filter(function(item, idx, ary){
		//return item.salary > 3000;
		return true;
		//return idx < 5;
	});
	
	//화살표함수
	let mAry = fAry.map((item, idx, ary) => { //콜백함수
		let obj = {id: item.id, 
		           name: item.first_name + '-' + item.last_name, 
		           salary: item.salary};
		return obj;
	});
	//let mAry = fAry.map(item => {
	//	return {id: item.id, 
	//	           name: item.first_name + '-' + item.last_name, 
	//	           salary: item.salary};
	//});
	console.log(mAry);
	
	//reduce메소드 >> 새로운 값/배열 생성
	//json.reduce();
	let result = [1,3,2,4,5].reduce((acc, item, idx, ary) => { //콜백함수
		console.log(acc, item, idx);
		acc.push(item*2);
		return acc;
	}, []); //초기값 >> 배열, 0
	//push >> 배열에 값 넣기
	result = json.reduce((acc, item, idx) => { //콜백함수
		if(item.gender == 'Male'){
			acc.push(item);
		}
		return acc;
	}, []); //초기값 >> 배열
	
	console.log(result);
	
}); //end of DOMContentLoaded
 
function filterList(gender = 'Male'){
	document.querySelector('tbody').innerHTML = '';
	json.filter(function(item){
		return item.gender == gender || gender == 'All';
	}).forEach(function(item){
		document.querySelector('tbody').appendChild(makeRow(item));
		
	})
}
