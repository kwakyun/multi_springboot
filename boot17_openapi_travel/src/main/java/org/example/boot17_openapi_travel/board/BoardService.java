package org.example.boot17_openapi_travel.board;

import java.util.List;

public interface BoardService {
    public List<BoardVO> selectAll(int startRow, int limit);

    public List<BoardVO> searchList(int cpage, int limit,  String searchKey,String searchWord);

    public BoardVO selectOne(BoardVO vo);

    public int insertOK(BoardVO vo);

    public int updateOK(BoardVO vo);

    public int deleteOK(BoardVO vo);
}
