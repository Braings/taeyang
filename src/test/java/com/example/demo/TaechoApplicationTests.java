package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TaechoApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
    	Optional<Question> oq = this.questionRepository.findById(1);
    	assertTrue(oq.isPresent());
    	Question q = oq.get();
    	q.setSubject("수정된 제목");
    	this.questionRepository.save(q);
    	
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }
}
