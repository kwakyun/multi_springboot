package org.example.boot19_aop.board;

import lombok.Data;

@Data
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String writer;
    private String wdate;
}
