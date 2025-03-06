package org.example.boot15_jpa.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardDAO_JPA extends JpaRepository<BoardVO_JPA, Object> {


    @Query(nativeQuery = true,value="select * from board_jpa order by num desc limit ?1,?2")
    public List<BoardVO_JPA> selectAllDescLimit_Native(int startRow,int limit);//메소드명은 임의로 지정가능.

    @Query(nativeQuery = true,
            value="select * from board_jpa where title like %?3% order by num desc limit ?1,?2")
    public List<BoardVO_JPA> searchListTitleDescLimit_Native(int startRow, int limit, String searchWord);

    @Query(nativeQuery = true,
            value="select * from board_jpa where content like %?3% order by num desc limit ?1,?2")
    public List<BoardVO_JPA> searchListContentDescLimit_Native(int startRow, int limit, String searchWord);

    //jpa 함수커스텀(정해진규칙)
    public BoardVO_JPA findByNum(int num);


}//end interface
