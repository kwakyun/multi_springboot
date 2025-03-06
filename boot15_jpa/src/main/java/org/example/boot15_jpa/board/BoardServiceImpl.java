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
    public int insertOK(BoardVO_JPA vo) {
        log.info("insertOK()....");
        log.info(vo.toString());
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
        log.info("updateOK()....");
        log.info(vo.toString());

        //insertable=false만 설정되었을때는 수정시 날짜값에 null이반영되기때문에
        //수정한 날짜로 날짜변경하고자 한다면 아래와같은 처리필요
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
        log.info("deleteOK()....");
        log.info(vo.toString());
        int flag = 0;
        try{
            jpa.delete(vo);//jpa내장함수 : vo안에pk값이 있으면 update,없으면 insert
            flag = 1;
        }catch (Exception e){
            log.error("입력된 데이터를 확인하세요");
        }
        return flag;
    }

    @Override
    public BoardVO_JPA selectOne(BoardVO_JPA vo) {
        log.info("selectOne()....");
        log.info(vo.toString());
        return jpa.findByNum(vo.getNum());//jpa 커스텀함수
    }

    @Override
    public List<BoardVO_JPA> selectAll(int cpage, int limit) {
        log.info("selectAll()....");
        log.info("cpage: " + cpage);//3
        log.info("limit: " + limit);//5
        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,
        //return jpa.findAll(); //jpa내장함수 별도구현필요없음.
        //return jpa.findByOrderByNumDesc(); //jpa 함수커스텀(정해진규칙)
        //return jpa.selectAllDesc_JPQL(); //JPQL-함수명 임의지정가능
        //return jpa.selectAllAsc_JPQL(); //JPQL-함수명 임의지정가능
        //return jpa.selectAllDesc_Native();//NativeQuery-함수명 임의지정가능
        //return jpa.selectAllAsc_Native();//NativeQuery-함수명 임의지정가능
        return jpa.selectAllDescLimit_Native(startRow,limit);//파라메터 전달가능
    }

    @Override
    public List<BoardVO_JPA> searchList(int cpage, int limit, String searchKey, String searchWord) {
        log.info("searchList()....");
        log.info("cpage: " + cpage);
        log.info("limit: " + limit);
        log.info("searchKey: " + searchKey);
        log.info("searchWord: " + searchWord);

        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,

        if(searchKey.equals("title")) {
            return jpa.searchListTitleDescLimit_Native(startRow,limit,"%"+searchWord+"%");//파라메터 전달가능
        }else{
            return jpa.searchListWriterDescLimit_Native(startRow,limit,"%"+searchWord+"%");//파라메터 전달가능
        }
    }
}//end class
