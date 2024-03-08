/**
 * boardAjax.js
 */


const service = {
	//댓글목록 5개씩
	replyList(param = {bno: 1, page: 1}, successCall, errorCall) {
		$.ajax({
			//호출
			url: 'replyList.do',
			method: 'get',
			data: param,
			dataType: 'json'
		})
		//기능을 매개값으로 받기
		.done(successCall)
		.fail(errorCall)
	},
	pageList(bno = 1, successCall, errorCall){
		$.ajax({
			//
			url: 'getTotal.do?bno=' + bno,
			method: 'get',
			//data: param, 생략
			dataType: 'json'
		})
		//기능을 매개값으로 받기
		.done(successCall)
		.fail(errorCall)
	},
	removeReply(rno = 1, successCall, errorCall){
		$.ajax({
			url: 'removeReply.do',
			method: 'post',
			data: {rno}
			//dataType: 'json'
		})
		.done(successCall)
		.fail(errorCall)
	},
	addReply(param = {bno, reply, replyer}, successCall, errorCall){
		$.ajax({
			url: 'addReply.do',
			method: 'post',
			data: param
		})
		.done(successCall)
		.fail(errorCall)
	}
}

export default service;
