package org.zerock.service;

import java.util.List;

import org.zerock.model.BoardVO;
import org.zerock.model.Criteria;
import org.zerock.model.PageMaker;
import org.zerock.model.PagingCriteria;

public interface BoardService {

	public void regist(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void modify(BoardVO vo)throws Exception;
	
	public void remove(Integer bno)throws Exception;
	//not used
	public List<BoardVO> listAll() throws Exception;
	//not used
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	public List<BoardVO> listPaging(PagingCriteria cri)throws Exception;
	
	public PageMaker countPaging(PagingCriteria cri)throws Exception;
}
