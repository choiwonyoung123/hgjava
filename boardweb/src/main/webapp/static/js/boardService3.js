/**
 * boardService3.js
 * 기능
 */

//댓글 등록
//service.addReply({bno:bno,reply:reply,replyer:replyer},
//	addReplyListCall,
//	err => console.log('error=>', err)
//);

//function addReplyListCall(result){
//	console.log(result);
//}

import service from './boardAjax.js';


//메서드 호출
let page = 1;
service.replyList({bno:bno,page:page},
	//done시
	replyListCall,
	//fail시
	err => console.log('error=>', err)
); //인자값1
//댓글목록 5건 출력
function replyListCall(result){
	let ul = $('.content>ul');
	//기존목록 삭제
	$('.content>ul>li:gt(1)').remove();
	
	console.log(result);
	$(result).each(function(idx, item){
		//li 요소의 첫번째 대상 선택
		//clone() >> 복사
		let clon = $('.content>ul>li').eq(0).clone();
		let delBtn = $('<button>삭제</button>');
		//삭제버튼 클릭 이벤트 >> 콜백함수
		delBtn.click(function(e){
			service.removeReply(item.replyNo,
			function(result){
				if(result.retCode == 'OK'){						
					alert('삭제 완료');
					service.replyList({bno:bno, page:page},
						replyListCall,
						err => console.log('error=>', err))
					//delBtn.parent().parent().remove();
				}
				else{
					alert('삭제 실패');
				}
			},
			function(err){
				console.log(err);
			})
		})
		clon.find('span:eq(0)').text(item.replyNo);
		clon.find('span:eq(1)').text(item.reply);
		clon.find('span:eq(2)').text(item.replyer);
		clon.find('span:eq(3)').html(delBtn);
		ul.append(clon);
	});
	//새로운 페이지 생성
	service.pageList(bno,
	createPageElement,
	err => console.log('error=>', err))
}



//페이지 목록출력
//메서드 호출
service.pageList(bno,
	//function(result){
	//	console.log(result)
	//},
	createPageElement,
	err => console.log('error=>', err)
)
function createPageElement(result){
	let pagination = $('div.pagination');
	pagination.html('');
	//document.querySelector('div.pagination').innerHTML = '';
	//let result = JSON.parse(plistHtp.responseText);
	let totalCnt = result.totalCount;
	let startPage, endPage;
	let next, prev;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = Math.ceil(page/5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;
	next = endPage < realEnd ? true : false;
	prev = startPage > 1;
	
	if(prev){
		//jquery 방식
		$('<a />')
		.attr('href', '#')
		.attr('data-page', startPage - 1)
		.html('&laquo;')
		.appendTo(pagination);
		
		//자바스크립트 방식
		//let aTag = document.createElement('a');
		// aTag.innerText = startPage - 1;
		//aTag.innerHTML = '&laquo';
		//aTag.href = '#';
		//aTag.setAttribute('data-page', startPage - 1);
		//document.querySelector('div.pagination').appendChild(aTag);
	}
	for(let p = startPage; p <= endPage; p++){
		//jquery 방식
		let aTag = $('<a />')
		.attr('href', '#')
		.attr('data-page', p)
		.html(p)
		.appendTo(pagination);
		if(p == page){
			aTag.addClass('active');
		}
		
		//자바스크립트 방식
		//let aTag = document.createElement('a');
		//aTag.innerText = p;
		//aTag.href = '#';
		//if(p == page){
		//	aTag.className = 'active';
		//}
		//document.querySelector('div.pagination').appendChild(aTag);
	}
	if(next){
		//jquery 방식
		$('<a />')
		.attr('href', '#')
		.attr('data-page', endPage + 1)
		.html('&raquo;')
		.appendTo(pagination);
		
		//자바스크립트 방식
		//let aTag = document.createElement('a');
		// aTag.innerText = endPage + 1;
		//aTag.innerHTML = '&raquo';
		//aTag.href = '#';
		//aTag.setAttribute('data-page', endPage + 1);
		//document.querySelector('div.pagination').appendChild(aTag);
	}
}

//페이지 이동
//a태그로 이벤트 위임
$('.pagination').on('click', 'a', function(e){
	page = $(this).data('page');
	service.replyList({bno:bno,page:page},
		//done시
		replyListCall,
		//fail시
		err => console.log('error=>', err)
	);
})

$('.addReply').on('click', function(e){
	service.addReply({bno,reply,replyer},
	function(result){
		if(result.retCode == 'OK'){
			alert('등록성공');
			service.pageList(bno, result => {
				page = Math.ceil(result.totalCount / 5)
				service.replyList({bno: bno, page: page},
					replyListCall,
					err => console.log('error=>', err)
				);
			},
			err => console.log(err))
		}
		else{
			alert('등록실패');
		}
	},
	err => console.log('error=>',err));
})
