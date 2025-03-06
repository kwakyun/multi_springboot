package org.example.boot15_jpa.member;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity   //자바객체와 DB테이블을 매칭시켜주는 기능
@Table(name="member_jpa",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})}) //테이블명,유니크컬럼제약조건 설정...
public class MemberVO_JPA {

    @Id  //pk 컬럼지정
    @Column(name="num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//mysql auto_increment
    private int num;

    @Column(name="user_id",nullable=false)
    private String id;

    @Column(name="user_pw",nullable=false)
    private String pw;

    @Column(name="user_name",nullable=false)
    private String name;

    @Column(name="user_tel",nullable=false)
    private String tel;

    //입력시 날짜입력값이 없으면 now()처리,수정시는 입력시 들어간 날자 그대로반영
    @Column(name="regdate",
            insertable = false,/*updatable = false,*/
    columnDefinition = "DATETIME(0) DEFAULT CURRENT_TIMESTAMP")  
    private Date regdate;


}
