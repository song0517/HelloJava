package co.edu.board;

public class PageVO {
	int totalCnt; //전체건수
	int pageNum; //현재페이지
	int startPage; //시작페이지
	int endPage; //마지막페이지
	int totalPage; //전체페이지
	boolean prev, next; //이전, 다음 페이지가 있는지
	
	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;
		
		totalPage = (int) Math.ceil(totalCnt / 10.0); // 51.6 -> 52page
		// startPage, endPage 계산.
		// 3페이지 기준
		this.endPage = (int) Math.ceil(this.pageNum/10.0)*10; //10페이지
		this.startPage = this.endPage - 9; //1페이지
		if(this.endPage > totalPage) {
			this.endPage = totalPage;
		}
		
		prev = this.startPage > 10; // 이전페이지
		next = this.endPage < totalPage; // 다음페이지
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVO [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
