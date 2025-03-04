package org.example.boot13_mybatis;

import java.util.List;

public interface MemberService {

    public int insertOK(MemberVO vo);
    public int updateOK(MemberVO vo);
    public int deleteOK(MemberVO vo);
    public MemberVO selectOne(MemberVO vo);
    public List<MemberVO> selectAll(int cpage, int limit);
    public List<MemberVO> searchList(int cpage,int limit,String searchKey,String searchWord);

}
