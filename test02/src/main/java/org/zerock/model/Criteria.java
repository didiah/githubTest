package org.zerock.model;

import javax.swing.text.rtf.RTFEditorKit;

public class Criteria {

	private int page = 1;
	private int perPageNum = 10;
	
	public Criteria setPage(int page){
		this.page = page;
		return this;
	}
	public Criteria setPerPageNum(int perPageNume){
		this.perPageNum = perPageNume;
		return this;
	}
	public int getPageStart(){
		return (this.page-1)*perPageNum;
	}
	public int getPerPageNum(){
		return this.perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
}
