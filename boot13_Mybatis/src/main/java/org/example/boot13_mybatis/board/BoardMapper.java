package org.example.boot13_mybatis.board;

import org.apache.ibatis.annotations.Mapper;
import org.example.boot13_mybatis.member.MemberVO;

import java.util.List;

@Mapper
public interface BoardMapper {
    //추상메소드명(예: selectAll)은 sqlMapper_member.xml 문서의 id와 같아야한다.
    public List<BoardVO> selectAll(int startRow, int limit);

    public List<BoardVO> searchListWriter(int startRow, int limit, String searchWord);

    public List<BoardVO> searchListWdate(int startRow, int limit, String searchWord);

    public BoardVO selectOne(BoardVO vo);

    public int insertOK(BoardVO vo);

    public int updateOK(BoardVO vo);

    public int deleteOK(BoardVO vo);

}
