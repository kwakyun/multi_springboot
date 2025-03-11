package org.example.boot21_memberemail.member;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int insertOK(MemberVO vo) {
        log.info("insertOK()....");
        log.info(vo.toString());

        //예 : hi2222 >>> 암호화 $2a$10$5CJ/M.8tLuropv2XGseiVuKphv7l6AA29ohomccJZfYuI0KLaGc3y
        vo.setPw(passwordEncoder.encode(vo.getPw()));
        log.info(vo.getPw());

        return mapper.insertOK(vo);
    }

    @Override
    public int updateOK(MemberVO vo) {
        log.info("updateOK()....");
        log.info(vo.toString());

        //예 : hi2222 >>> 암호화 $2a$10$5CJ/M.8tLuropv2XGseiVuKphv7l6AA29ohomccJZfYuI0KLaGc3y
        vo.setPw(passwordEncoder.encode(vo.getPw()));
        log.info(vo.getPw());

        return mapper.updateOK(vo);
    }

    @Override
    public int deleteOK(MemberVO vo) {
        log.info("deleteOK()....");
        log.info(vo.toString());
        return mapper.deleteOK(vo);
    }

    @Override
    public MemberVO selectOne(MemberVO vo) {
        log.info("selectOne()....");
        log.info(vo.toString());
        return mapper.selectOne(vo);
    }

    @Override
    public List<MemberVO> selectAll(int cpage, int limit) {
        log.info("selectAll()....");
        log.info("cpage: " + cpage);//3
        log.info("limit: " + limit);//5
        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,
        return mapper.selectAll(startRow,limit);
    }

    @Override
    public List<MemberVO> searchList(int cpage, int limit, String searchKey, String searchWord) {
        log.info("searchList()....");
        log.info("cpage: " + cpage);
        log.info("limit: " + limit);
        log.info("searchKey: " + searchKey);
        log.info("searchWord: " + searchWord);

        //cpage,limit를 이용해서 시작행을 구합니다.
        int startRow = (cpage - 1) * limit;//0,5,10,,,,

        if(searchKey.equals("name")) {
            return mapper.searchListName(startRow,limit,"%"+searchWord+"%");
        }else{
            return mapper.searchListTel(startRow,limit,"%"+searchWord+"%");
        }
    }

    @Override
    public MemberVO  selectOneMyPage(String user_id) {
        return mapper.findById(user_id);
    }

    @Override
    public MemberVO emailSelectOne(String email) {
        return mapper.emailSelectOne(email);
    }

}