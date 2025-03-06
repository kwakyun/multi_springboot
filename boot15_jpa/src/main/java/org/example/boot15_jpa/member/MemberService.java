package org.example.boot15_jpa.member;

import java.util.List;

public interface MemberService {

    public int insertOK(MemberVO_JPA vo);
    public int updateOK(MemberVO_JPA vo);
    public int deleteOK(MemberVO_JPA vo);
    public MemberVO_JPA selectOne(MemberVO_JPA vo);
    public List<MemberVO_JPA> selectAll(int cpage, int limit);
    public List<MemberVO_JPA> searchList(int cpage, int limit, String searchKey, String searchWord);

}
