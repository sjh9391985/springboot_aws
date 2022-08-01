package com.book.springbootaws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 흔히 Mybatis에서 DAO 라 불리는 DB Layer 접근자의 역할을 하는곳.
 * JPA에선 Repository라고 불리며 인터페이스로 생성함.
 * 단순히 인터페이스 생성 후, JpaRepository<Entity, PK 타입> 를 상속하면 기본적인 CRUD 메소드가 생성됨.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {



}
