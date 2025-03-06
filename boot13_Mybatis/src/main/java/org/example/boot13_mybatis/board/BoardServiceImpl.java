package org.example.boot13_mybatis.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public List<BoardVO> selectAll(int cpage, int limit) {
        log.info("selectAll().. ");
        log.info("cpage:{},limit:{}",cpage,limit);
        int startRow = (cpage-1) * limit;
        return mapper.selectAll(startRow, limit);
    }

    @Override
    public List<BoardVO> searchList(int cpage, int limit,  String searchKey,String searchWord) {
        log.info("searchList().. ");
        log.info("cpage:{},limit:{}",cpage,limit);
        log.info("searchKey:{},searchWord:{}",searchKey,searchWord);
        int startRow = (cpage-1) * limit;
        if(searchKey.equals("title")){
            return mapper.searchListTitle(startRow, limit, "%"+searchWord+"%");
        }else{
            return mapper.searchListContent(startRow, limit, "%"+searchWord+"%");
        }
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        log.info("selectOne().. ");
        log.info("vo:{}",vo);
        return mapper.selectOne(vo);
    }

    @Override
    public int insertOK(BoardVO vo) {
        log.info("insertOK().. ");
        log.info("vo:{}",vo);
        return mapper.insertOK(vo);
    }

    @Override
    public int updateOK(BoardVO vo) {
        log.info("updateOK().. ");
        log.info("vo:{}",vo);
        return mapper.updateOK(vo);
    }

    @Override
    public int deleteOK(BoardVO vo) {
        log.info("deleteOK().. ");
        log.info("vo:{}",vo);
        return mapper.deleteOK(vo);
    }
}
