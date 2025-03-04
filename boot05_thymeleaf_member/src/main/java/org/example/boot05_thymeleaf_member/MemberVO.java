package org.example.boot05_thymeleaf_member;

import lombok.Data;

@Data
public class MemberVO {
    private int num;
    private String id;
    private String pw;
    private String name;
    private String tel;
}
