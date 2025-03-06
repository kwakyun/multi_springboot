package org.example.boot15_jpa.board;

import org.example.boot15_jpa.board.BoardVO_JPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardDAO_JPA extends JpaRepository<BoardVO_JPA, Object> {

    //jpa 함수커스텀(정해진규칙)
    public List<BoardVO_JPA> findByOrderByNumDesc(); //역정렬
    public List<BoardVO_JPA> findByOrderByNumAsc(); //순정렬


    //JPQL(JPA+SQL) : @Query(JPA객체(Entity)를 테이블로 표현하는 쿼리문자열)
    @Query("select vo from BoardVO_JPA vo order by vo.num desc")
    public List<BoardVO_JPA> selectAllDesc_JPQL();//메소드명은 임의로 지정가능.

    @Query("select vo from BoardVO_JPA vo order by vo.num asc")
    public List<BoardVO_JPA> selectAllAsc_JPQL();//메소드명은 임의로 지정가능.

    //네이티브쿼리설정도 가능 : @Query(nativeQuery=true,value="sql")
    //DB에서 사용하는 SQL문을 그대로 사용가능(복잡한 쿼리에 유용하다)
    @Query(nativeQuery = true,value="select * from board_jpa order by num desc")
    public List<BoardVO_JPA> selectAllDesc_Native();//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,value="select * from board_jpa order by num asc")
    public List<BoardVO_JPA> selectAllAsc_Native();//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,value="select * from board_jpa order by num desc limit ?1,?2")
    public List<BoardVO_JPA> selectAllDescLimit_Native(int startRow,int limit);//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,
            value="select * from board_jpa where title like ?3 order by num desc limit ?1,?2")
    public List<BoardVO_JPA> searchListTitleDescLimit_Native(int startRow, int limit, String searchWord);

    @Query(nativeQuery = true,
            value="select * from board_jpa where writer like ?3 order by num desc limit ?1,?2")
    public List<BoardVO_JPA> searchListWriterDescLimit_Native(int startRow, int limit, String searchWord);

    //jpa 함수커스텀(정해진규칙)
    public BoardVO_JPA findByNum(int num);
}
