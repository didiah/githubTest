package org.zerock.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {

	@Select("select now()")
	public String getTime();
	
	@Insert("insert into tbl_board (title, content, writer) values (#{title}, #{content}, #{writer})")
	public void create(BoardVO vo)throws Exception;
	
	@Select("select *from tbl_board where bno=#{bno}")
	public BoardVO read(Integer bno)throws Exception;
	
	@Update("update tbl_board set title=#{title}, content=#{title}, writer=#{writer} where bno=#{bno}")
	public void update(BoardVO vo)throws Exception;
	
	@Delete("delete from tbl_board where bno=#{bno}")
	public void delete(Integer bno)throws Exception;
	
	@Select("select *from tbl_board order by bno desc")
	public List<BoardVO> list()throws Exception;
	
	@Select("select *from tbl_board where bno >0 order by bno desc limit #{pageStart},#{perPageNum}")
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	//@Select("select * from tbl_board where bno > 0 order by bno desc limit #{pageStart}, #{perPageNum}")
	public List<BoardVO> listPaging(PagingCriteria cri)throws Exception;
	
	//@Select("select count(bno) totalCount from tbl_board where bno > 0")
	public PageMaker countPaging(PagingCriteria cri)throws Exception;
	
	
}
