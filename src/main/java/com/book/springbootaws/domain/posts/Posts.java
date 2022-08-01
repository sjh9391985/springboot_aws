package com.book.springbootaws.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 6
@NoArgsConstructor // 5
@Entity // 1
public class Posts {

    @Id // 2
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3
    private Long id;

    @Column(length = 500, nullable = false) // 4
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/**
 * 규칙)
 * - 주요 어노테이션 순서로 Class에 가깝게 둔다.
 * - 클래스 명칭은 실제 DB table과 매칭될 클래스이며 보통 Entity 클래스라고 부름
 *
 * 1. @Entity
 * JPA 어노테이션
 * 테이블과 링크될 클래스임을 나타냄
 * 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블이름을 매칭
 *
 * 2. @Id
 * 해당 테이블의 PK 필드를 나타냄
 *
 * 3. @GeneratedValue
 * PK의 생성규칙을 나타냄
 * 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨
 *
 * 4. @Column
 * 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨.
 * 기본값외에 추가 옵션을 사용하고자 한다면 옵션 사용 가능.
 *
 * *참고
 * 웬만하면 Entity의 PK는 Long 타입의 Auto_increment 사용을 추천함.
 *
 * 5. @NoArgsConstructor
 * lombok 라이브러리 어노테이션
 * 기본 생성자 자동추가
 * public Posts{} 와 같은 효과
 *
 * 7. @Builder
 * 해당 클래스의 빌더 패턴 클래스를 생성
 * 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
 *
 * * Entity 클래스 주의점
 * 자바빈 규약을 고려하며 무분별한 Gette/Setter 생성은 해당 클래스의 인스턴스 값들이 언제 어디서 변경하는지 코드상 명확한 구분이 어려움
 * 차후 기능 변경 시 복잡해질 수 있음.
 */
