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
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import com.mysite.sbb.user.UserService;
import com.mysite.sbb.user.SiteUser;

//import org.springframework.transaction.annotation.Transactional;

//import com.mysite.sbb.answer.Answer;
//import com.mysite.sbb.question.Question;
//import com.mysite.sbb.question.QuestionRepository;
@Transactional
@SpringBootTest
class TaechoApplicationTests {
//  private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private UserService userService;
    
    @Test
    @Rollback(false)
    void testJpa() {
    	// 1. SiteUser 객체 선언 (메서드 전체에서 사용 가능하도록 범위 확장)
        SiteUser testUser; 

        // 2. 테스트용 사용자 ID 설정
        String testUserId = "test_user_id";

        // 3. 사용자 존재 여부를 확인하여 중복 생성 방지
        try {
            // 사용자가 이미 존재하는 경우, 기존 사용자 정보를 가져옵니다.
            testUser = this.userService.getUser(testUserId);
        } catch (DataNotFoundException e) {
            // 사용자가 없는 경우, 새로 생성합니다.
            testUser = this.userService.create(testUserId, "test@test.com", "1234");
        }
        
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            
            // 4. 이제 testUser 변수는 이 블록에서도 유효합니다.
            this.questionService.create(subject, content, testUser);        }
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
