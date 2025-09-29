package com.example.demo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findBySubjectAndContent(String subject, String content);
}

/*
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);

}
*/

/*
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// Question 엔티티와 해당 엔티티의 ID 타입(Long)을 지정하여 상속합니다.
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 이제 save(), findById(), findAll() 등의 메서드를 자동으로 사용할 수 있습니다.
}
*/