package com.example.demo;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//import java.util.Optional;

import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;

//import com.mysite.sbb.answer.Answer;
//import com.mysite.sbb.question.Question;
//import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
//@Transactional
class TaechoApplicationTests {
//  private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;
    
    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }
}

//package com.example.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//@Transactional
//class TaechoApplicationTests {
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//    @Test
//    void testJpa() {
//    	assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//        
//    	Optional<Question> oq = this.questionRepository.findById(1);
//    	assertTrue(oq.isPresent());
//    	Question q = oq.get();
//    	q.setSubject("수정된 제목");
//    	this.questionRepository.save(q);
//    	
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//    }
//}
