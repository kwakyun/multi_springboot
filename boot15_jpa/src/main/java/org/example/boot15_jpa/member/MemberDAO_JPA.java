package org.example.boot15_jpa.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberDAO_JPA extends JpaRepository<MemberVO_JPA, Object> {

    //jpa 함수커스텀(정해진규칙)
    public List<MemberVO_JPA> findByOrderByNumDesc();//역정렬
    public List<MemberVO_JPA> findByOrderByNumAsc();//순정렬

    //JPQL(JPA+SQL) : @Query(JPA객체(Entity)를 테이블로 표현하는 쿼리문자열)
    @Query("select vo from MemberVO_JPA vo order by vo.num desc")
    public List<MemberVO_JPA> selectAllDesc_JPQL();//메소드명은 임의로 지정가능.

    @Query("select vo from MemberVO_JPA vo order by vo.num asc")
    public List<MemberVO_JPA> selectAllAsc_JPQL();//메소드명은 임의로 지정가능.

    //네이티브쿼리설정도 가능 : @Query(nativeQuery=true,value="sql")
    //DB에서 사용하는 SQL문을 그대로 사용가능(복잡한 쿼리에 유용하다)
    @Query(nativeQuery = true,value="select * from member_jpa order by num desc")
    public List<MemberVO_JPA> selectAllDesc_Native();//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,value="select * from member_jpa order by num asc")
    public List<MemberVO_JPA> selectAllAsc_Native();//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,value="select * from member_jpa order by num desc limit ?1,?2")
    public List<MemberVO_JPA> selectAllDescLimit_Native(int startRow,int limit);//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,
            value="select * from member_jpa where user_name like ?3 order by num desc limit ?1,?2")
    public List<MemberVO_JPA> searchListNameDescLimit_Native(int startRow, int limit, String searchWord);

    @Query(nativeQuery = true,
            value="select * from member_jpa where user_tel like ?3 order by num desc limit ?1,?2")
    public List<MemberVO_JPA> searchListTelDescLimit_Native(int startRow, int limit, String searchWord);

    //jpa 함수커스텀(정해진규칙)
    public MemberVO_JPA findByNum(int num);


}//end interface
