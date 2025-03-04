package org.example.board_model;

import lombok.Data;

@Data
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String writer;
    private String wdate;
}
