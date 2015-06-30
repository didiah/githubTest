package org.zerock.model;

public class PagingCriteria {

	private int page = 1;
	private int perPageNum = 10;
	private int displayPageNum = 10;
	
	private int bno;
	
	private String searchType;
	private String keyword;
	
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public PagingCriteria setKeyword(String keyword) {
		this.keyword = keyword;
		return this;
	}
	public String getSearchType() {
		return searchType;
	}
	public PagingCriteria setSearchType(String searchType) {
		this.searchType = searchType;
		return this;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getPage() {
		return page;
	}
	public PagingCriteria setPage(int page){
		this.page = page;
		return this;
	}
	public int getPerPageNum(){
		return perPageNum;
	}
	public PagingCriteria setPerPageNum(int perPageNum){
		this.perPageNum = perPageNum;
		return this;
	}
	public int getDisplayPageNum(){
		return displayPageNum;
	}
	public PagingCriteria setDisplayPageNum(int displayPageNum){
		this.displayPageNum = displayPageNum;
		return this;
	}
	
	public int getPageStart(){
		return (this.page -1)* perPageNum;
	}
	
	
}
