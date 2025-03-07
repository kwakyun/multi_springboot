package org.example.boot15_jpa.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO_JPA jpa;

    @Override
    public List<BoardVO_JPA> selectAll(int cpage, int limit) {
        log.info("selectAll().. ");
        log.info("cpage:{},limit:{}",cpage,limit);
        int startRow = (cpage-1) * limit;
        return jpa.selectAllDescLimit_Native(startRow, limit);
    }

    @Override
    public List<BoardVO_JPA> searchList(int cpage, int limit, String searchKey, String searchWord) {
        log.info("searchList().. ");
        log.info("cpage:{},limit:{}",cpage,limit);
        log.info("searchKey:{},searchWord:{}",searchKey,searchWord);
        int startRow = (cpage-1) * limit;
        if(searchKey.equals("title")){
            return jpa.searchListTitleDescLimit_Native(startRow, limit, searchWord);
        }else{
            return jpa.searchListContentDescLimit_Native(startRow, limit, searchWord);
        }
    }

    @Override
    public BoardVO_JPA selectOne(BoardVO_JPA vo) {
        log.info("selectOne().. ");
        log.info("vo:{}",vo);
        return jpa.findByNum(vo.getNum());
    }

    @Override
    public int insertOK(BoardVO_JPA vo) {
        log.info("insertOK().. ");
        log.info("vo:{}",vo);
        int flag = 0;
        try{
            jpa.save(vo);//jpa내장함수 : vo안에pk값이 있으면 update,없으면 insert
            flag = 1;
        }catch (Exception e){
            log.error("입력된 데이터를 확인하세요");
        }
        return flag;
    }

    @Override
    public int updateOK(BoardVO_JPA vo) {
        log.info("updateOK().. ");
        log.info("vo:{}",vo);
        //insertable=false만 설정되었을때는 수정시 날짜값에 null이반영되기때문에
        //수정한 날짜로 날짜변경하고자 한다면 아래와같은 처리필요
        vo.setWdate(new Timestamp(System.currentTimeMillis()));
        int flag = 0;
        try{
            jpa.save(vo);//jpa내장함수 : vo안에pk값이 있으면 update,없으면 insert
            flag = 1;
        }catch (Exception e){
            log.error("입력된 데이터를 확인하세요");
        }
        return flag;
    }

    @Override
    public int deleteOK(BoardVO_JPA vo) {
        log.info("deleteOK().. ");
        log.info("vo:{}",vo);
        int flag = 0;
        try{
            jpa.delete(vo);//jpa내장함수 : vo안에pk값이 있으면 update,없으면 insert
            flag = 1;
        }catch (Exception e){
            log.error("입력된 데이터를 확인하세요");
        }
        return flag;
    }
}
