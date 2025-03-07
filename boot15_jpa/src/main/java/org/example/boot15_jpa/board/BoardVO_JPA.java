package org.example.boot15_jpa.board;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="board_jpa")
public class BoardVO_JPA {

    @Id
    @Column(name="num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//mysql auto_increment
    private int num;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="user_id",nullable = false)
    private String writer;

    @Column(name="wdate",insertable = false,
            columnDefinition = "DATETIME(0) DEFAULT CURRENT_TIMESTAMP")
    private Date wdate;
}
