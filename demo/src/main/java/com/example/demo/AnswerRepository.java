
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> { }

/*
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // 지금은 커스텀 메서드 필요 없음, JpaRepository 기본 메서드(findById, save, delete 등) 사용 가능
}
*/