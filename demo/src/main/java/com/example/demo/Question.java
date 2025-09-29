package com.example.demo;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // PK 자동 증가
    private Long id;  
    // private Integer id;

    @Column(length = 200)
    private String subject;   // 제목

    @Column(columnDefinition = "TEXT")
    private String content;   // 내용

    private LocalDateTime createDate;  // 생성일시
    
    @OneToMany(mappedBy = "question", cascade =CascadeType.REMOVE)
    private List<Answer> answerList;
}

