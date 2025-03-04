package org.example.boot13_mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    //추상메소드명(예:selectAll)은 sqlMapper_member.xml 문서의 id와 같아야한다.
    public List<MemberVO> selectAll(int startRow, int limit);

    public List<MemberVO> searchListName(int startRow, int limit, String searchWord);

    public List<MemberVO> searchListTel(int startRow, int limit, String searchWord);

    public MemberVO selectOne(MemberVO vo);

    public int insertOK(MemberVO vo);

    public int updateOK(MemberVO vo);

    public int deleteOK(MemberVO vo);
}
