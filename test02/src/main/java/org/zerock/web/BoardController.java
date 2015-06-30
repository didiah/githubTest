package org.zerock.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.model.BoardVO;
import org.zerock.model.Criteria;
import org.zerock.model.PagingCriteria;
import org.zerock.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	
	@RequestMapping(value = "/regist" , method = RequestMethod.GET)
	public void registGET()throws Exception{
		logger.info("regist get.......");
	}
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model)throws Exception{
	
		logger.info("regist post......");
		logger.info(vo.toString());
		
		service.regist(vo);
		
		return "/board/success";
	}
	@RequestMapping(value = "/registPage" , method = RequestMethod.GET)
	public void registPagingGET()throws Exception{
		logger.info("regist get.......");
	}
	@RequestMapping(value = "/registPage", method = RequestMethod.POST)
	public String registPagingPOST(@ModelAttribute("cri") PagingCriteria cri, BoardVO vo, Model model)throws Exception{
	
		logger.info("regist post......");
		logger.info(vo.toString());
		
		service.regist(vo);
		
		return "/board/success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		model.addAttribute("list", service.listAll());
		
	}
	
	@RequestMapping(value ="/read", method = RequestMethod.GET)
	public void read(int bno, Model model)throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPaging(@ModelAttribute("cri")PagingCriteria cri, Model model)throws Exception{
		model.addAttribute(service.read(cri.getBno()));
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int bno)throws Exception{
		service.remove(bno);
		
		return "/board/success";
	}
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@ModelAttribute("cri") PagingCriteria cri)throws Exception{
		service.remove(cri.getBno());
		
		return "/board/success";
	}
	@RequestMapping(value ="/mod",method= RequestMethod.GET)
	public void modifyGET(int bno, Model model)throws Exception{
		model.addAttribute(service.read(bno));
		
	}
	@RequestMapping(value ="/modPage",method = RequestMethod.GET)
	public void modifyPagingGET(@ModelAttribute("cri") PagingCriteria cri, Model model)throws Exception{
		model.addAttribute(service.read(cri.getBno()));
	}
	@RequestMapping(value ="/mod",method= RequestMethod.POST)
	public String modifyPOST(BoardVO vo,Model model)throws Exception{
		logger.info("mod post.........");
		service.modify(vo);
		return "/board/success";
	}
	@RequestMapping(value ="/modPage",method= RequestMethod.POST)
	public String modifyPagingPOST(@ModelAttribute("cri") PagingCriteria cri, BoardVO vo, Model model)throws Exception{
		logger.info("mod post.........");
		service.modify(vo);
		return "/board/success";
	}
	@RequestMapping(value = "/listcri", method = RequestMethod.GET)
	public void listCriteria(Criteria cri, Model model)throws Exception{
		model.addAttribute("list",service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPaging(@ModelAttribute("cri")PagingCriteria cri, Model model)throws Exception{
		
		model.addAttribute("list",service.listPaging(cri));
		model.addAttribute("pageMaker",service.countPaging(cri).calcPage(cri));
	}
	
	
}
