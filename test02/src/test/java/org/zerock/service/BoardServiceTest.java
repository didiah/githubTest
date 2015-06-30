package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.zerock.model.BoardVO;
import org.zerock.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Inject
	private BoardService service;
	
	@Test
	public void testRegist() throws Exception{
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("서비스");
		vo.setContent("서비스완료");
		vo.setWriter("사람");
		service.regist(vo);
	}
	
	@Test
	public void testRead()throws Exception{
		logger.info(service.read(2156).toString());
	}
	
	@Test
	public void testModify()throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setTitle("수정수정");
		vo.setContent("수정수정");
		vo.setWriter("수정수정");
		vo.setBno(2156);
		
		service.modify(vo);
	}
	
	@Test
	public void testRemove()throws Exception{
		service.remove(2156);
	}
	
	@Test
	public void testListAll()throws Exception{
		List<BoardVO> list = service.listAll();
		
		for (BoardVO boardVO : list) {
			logger.info(service.listAll().toString());
		}
	}
	@Test
	public void testListCriteria()throws Exception{
		Criteria cri = new Criteria().setPage(1).setPerPageNum(10);
		
		List<BoardVO> list = service.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	
}
