package org.example.boot13_mybatis.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int insertOK(BoardVO vo) {
        log.info("insertOK()...");
        log.info(vo.toString());
        return boardMapper.insertOK(vo);
    }

    @Override
    public int updateOK(BoardVO vo) {
        log.info("updateOK()....");
        log.info(vo.toString());
        return boardMapper.updateOK(vo);
    }

    @Override
    public int deleteOK(BoardVO vo) {
        log.info("deleteOK()....");
        log.info(vo.toString());
        return boardMapper.deleteOK(vo);
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        log.info("selectOne()....");
        log.info(vo.toString());
        return boardMapper.selectOne(vo);
    }

    @Override
    public List<BoardVO> selectAll(int cpage, int limit) {
        log.info("selectAll()....");
        log.info("cpage: " + cpage);//3
        log.info("limit: " + limit);//5
        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,
        return boardMapper.selectAll(startRow,limit);
    }

    @Override
    public List<BoardVO> searchList(int cpage, int limit, String searchKey, String searchWord) {
        log.info("searchList()....");
        log.info("cpage: " + cpage);
        log.info("limit: " + limit);
        log.info("searchKey: " + searchKey);
        log.info("searchWord: " + searchWord);

        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,

        if(searchKey.equals("writer")) {
            return boardMapper.searchListWriter(startRow,limit,"%"+searchWord+"%");
        }else{
            return boardMapper.searchListWdate(startRow,limit,"%"+searchWord+"%");
        }
    }
}
