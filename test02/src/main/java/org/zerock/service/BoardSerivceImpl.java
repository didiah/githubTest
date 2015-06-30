package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.model.BoardMapper;
import org.zerock.model.BoardVO;
import org.zerock.model.Criteria;
import org.zerock.model.PageMaker;
import org.zerock.model.PagingCriteria;

@Service
public class BoardSerivceImpl implements BoardService {

	@Inject
	private BoardMapper mapper;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		
		mapper.create(vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		return mapper.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		mapper.update(vo);

	}

	@Override
	public void remove(Integer bno) throws Exception {
		mapper.delete(bno);

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return mapper.list();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return mapper.listCriteria(cri);
	}

	@Override
	public List<BoardVO> listPaging(PagingCriteria cri) throws Exception {
		
		return mapper.listPaging(cri);
	}

	@Override
	public PageMaker countPaging(PagingCriteria cri) throws Exception {
		
		return mapper.countPaging(cri);
	}

}
