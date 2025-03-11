package org.example.boot21_memberemail.member;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberVO {
    private int num;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String email;

    private String regdate;
    private String user_role;

}
