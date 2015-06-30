package org.zerock.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.model.BoardVO;
import org.zerock.model.PagingCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testRegist()throws Exception{
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/regist")).andReturn();
		
		logger.info(result.toString());
		
	}
	@Test
	public void testRegistPost()throws Exception{
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/regist")
				.param("title", "제목")
				.param("content", "내용")
				.param("writer", "사람")).andReturn();
		logger.info(result.toString());
	}
	
	@Test
	public void testList()throws Exception{
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn();
		List<BoardVO> list = (List<BoardVO>)result.getModelAndView().getModel().get("list");
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
		
	}
	@Test
	public void testRead()throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("bno", "11")).andReturn();
		BoardVO vo = (BoardVO)result.getModelAndView().getModel().get("BoardVO");
		logger.info(vo.toString());
	}
	@Test
	public void testRemove()throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "11")).andReturn();
		
		logger.info(result.toString());
	}
	@Test
	public void testListCri()throws Exception{
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/listCri")
				.param("page", "1")
				.param("perPageNum", "10")).andReturn();
		List<BoardVO> list = (List<BoardVO>)result.getModelAndView().getModel().get("list");
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	@Test
	public void testListPaging()throws Exception{
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/listPage")
				.param("page", "1")
				.param("perPageNum", "10")
				.param("displayPageNum", "5")).andReturn();
		
		List<BoardVO> list = (List<BoardVO>)result.getModelAndView().getModel().get("list");
		
		logger.info(list.toString());
		
		PagingCriteria cri = (PagingCriteria)result.getModelAndView().getModel().get("cri");
		logger.info(cri.toString());
		}
				
		
	
}
