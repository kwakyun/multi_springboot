package org.example.boot15_jpa.board;

import java.util.List;

public interface BoardService {
    public List<BoardVO_JPA> selectAll(int startRow, int limit);

    public List<BoardVO_JPA> searchList(int cpage, int limit, String searchKey, String searchWord);

    public BoardVO_JPA selectOne(BoardVO_JPA vo);

    public int insertOK(BoardVO_JPA vo);

    public int updateOK(BoardVO_JPA vo);

    public int deleteOK(BoardVO_JPA vo);
}
