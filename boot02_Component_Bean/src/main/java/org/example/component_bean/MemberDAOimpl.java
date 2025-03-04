package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {
    @Override
    public int insert(MemberVO vo) {
        log.info("insert()....");
        log.info("{}",vo);
        return 0;
    }
}
