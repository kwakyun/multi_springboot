package org.example.boot21_memberemail.email;

import lombok.Data;

import java.util.Map;

@Data
public class EmailVO{
    private String subject;
    private String content;
    private String regdate;
    private String reciver;
    private String password;
}