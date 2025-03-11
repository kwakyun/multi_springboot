package org.example.boot20_sendemail;

import lombok.Data;

@Data
public class EmailVO{
    private String subject;
    private String content;
    private String regdate;
    private String reciver;
}