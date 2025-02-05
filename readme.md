# JPA Best Examples

- JPA 모범 사례를 직접 구현해 보기 위한 프로젝트 입니다.
- 모든 예제는 상황별로 패키지 분리를 해두었습니다.


## 실행 환경
- Java21
- Hibernate 6.1
- H2
- Spring Data JPA
- Gradle


### 1. 연관관계 & FK
- 개념적으로 FK 를 사용하지만, 물리적으로 FK 는 사용하지 않을 상황을 예시로 다룸
  - <a href="">1. JPA 옵션을 통한 개념적 FK 사용 </a>
  - <a href="">2. id 를 통한 연관관계 참조 </a>