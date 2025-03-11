package org.example.boot21_memberemail.member;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface MemberService {

    public int insertOK(MemberVO vo);
    public int updateOK(MemberVO vo);
    public int deleteOK(MemberVO vo);
    public MemberVO selectOne(MemberVO vo);
    public List<MemberVO> selectAll(int cpage, int limit);
    public List<MemberVO> searchList(int cpage,int limit,String searchKey,String searchWord);
    public MemberVO selectOneMyPage(String user_id);
    public MemberVO emailSelectOne(@RequestParam String email);

}
