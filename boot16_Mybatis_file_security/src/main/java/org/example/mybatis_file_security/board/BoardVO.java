package org.example.mybatis_file_security.board;

import lombok.Data;

@Data
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String writer;
    private String wdate;
}
