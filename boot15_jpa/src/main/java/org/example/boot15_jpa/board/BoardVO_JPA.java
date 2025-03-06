package org.example.boot15_jpa.board;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="board_jpa",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}) //테이블명, 유니크 컬럼 제약조건 설정...
public class BoardVO_JPA {
    @Id
    @Column(name="num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//mysql auto_increment
    private int num;

    @Column(name="title",nullable=false)
    private String title;

    @Column(name="content",nullable=false)
    private String content;

    @Column(name="writer",nullable=false)
    private String writer;

    @Column(name="wdate",insertable = false,/*updatable = false,*/
            columnDefinition = "DATETIME(0) DEFAULT CURRENT_TIMESTAMP")
    private String wdate;
}
