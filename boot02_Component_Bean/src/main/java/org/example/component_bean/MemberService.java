package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberDAO dao;

    public int insert(MemberVO vo) {
        log.info("insert()....");
        log.info("{}",vo);
        return dao.insert(vo);
    }
}
