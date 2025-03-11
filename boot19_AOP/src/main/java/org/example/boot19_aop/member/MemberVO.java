package org.example.boot19_aop.member;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberVO {
    private int num;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String imgname;
    private MultipartFile file;
}
