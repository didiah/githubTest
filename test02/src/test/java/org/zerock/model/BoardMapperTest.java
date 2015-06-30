package org.zerock.model;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardMapperTest {
	
	private static final Logger logger =LoggerFactory.getLogger(BoardMapperTest.class);

	@Inject
	private BoardMapper mapper;
	
	@Test
	public void testTime(){
		
		logger.info(mapper.toString());
		logger.info(mapper.getTime());
	}
	
	@Test
	public void create()throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("추가");
		vo.setContent("완료");
		vo.setWriter("사람");
		
		mapper.create(vo);
	}
	
	@Test
	public void testRead()throws Exception{
		logger.info(mapper.read(1).toString());
	}
	
	@Test
	public void testUpdate()throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("수정");
		vo.setContent("수정완료");
		vo.setWriter("수정사람");
		vo.setBno(2155);
		
		mapper.update(vo);
		
	}
	
	@Test
	public void testDelete()throws Exception{
		mapper.delete(2155);
	}
	
	@Test
	public void testList()throws Exception{
		List<BoardVO> list = mapper.list();
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	@Test
	public void testListCriteria()throws Exception{
		Criteria cri = new Criteria().setPage(1).setPerPageNum(10);
		
		List<BoardVO> list = mapper.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	@Test
	public void testCounting()throws Exception{
		PagingCriteria cri = new PagingCriteria();
		PageMaker pageMaker = mapper.countPaging(cri);
		logger.info("TOTALCOUNT:" + pageMaker.getTotalCount());
	}
	@Test
	public void testListPagingSearch()throws Exception{
		PagingCriteria cri = new PagingCriteria().
				setSearchType("t").setKeyword("Test");
							
		
		List<BoardVO> list = mapper.listPaging(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
}
