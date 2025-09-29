package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;
	
	@Test
	void testJpa() {
	    Optional<Question> oq = this.questionRepository.findBySubjectAndContent(
	        "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다."
	    );
	    assertTrue(oq.isPresent());
	    Question q = oq.get();
	    assertEquals(1, q.getId());

	    List<Question> all = this.questionRepository.findAll();
	    assertEquals(2, all.size());
	    
	    Optional<Answer> oa = this.answerRepository.findById(1L);
	    assertTrue(oa.isPresent());
	    Answer a = oa.get();
	    assertEquals(2, a.getQuestion().getId());
	}
/*
	@Test
	void testJpa() {
		
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
		
		//Question q = all.get(0);
		//assertEquals("sbb가 무엇인가요?", q.getSubject());
		
		List<Question> all = this.questionRepository.findAll();
		
		assertEquals(2, all.size());
		
		Optional<Answer> oa = this.answerRepository.findById(1L);
		
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
		
	}
	*/
	
	/*
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	*/
}
