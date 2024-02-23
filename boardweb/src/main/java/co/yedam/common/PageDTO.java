package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//필드
	private int page;
	private int startPage, endPage;
	private boolean prev, next;
	
	
	//생성자
	public PageDTO(int page, int totalCnt) {
		//현재페이지
		this.page = page;
		//실제마지막페이지
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		
		this.endPage = (int) Math.ceil(page / 10.0) * 10;
		this.startPage = this.endPage - 9;
		
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
}
