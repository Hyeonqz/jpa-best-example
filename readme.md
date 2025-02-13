# JPA Best Examples

- JPA 모범 사례를 직접 구현해 보기 위한 프로젝트 입니다.
- 모든 예제는 상황별로 패키지 분리를 해두었습니다.
- 모든 예제 및 개념은 '**스프링 부트 JPA 모범 사례**' 책을 참고하였습니다.

## 실행 환경
- Java21
- Hibernate 6.1
- H2
- Spring Data JPA
- Gradle


### 0. 기본 개념
영속성 유닛은 EntityMangerFactory 인스턴스를 생성하는데 필요한 모든 정보가 담긴 상자이다 <br>
위 영속성 유닛 설정은 application.yml 에서 hibernate 및 spring.jpa 설정을 통해 진행한다 <br>

#### 영속성 컨텍스트 란?
엔티티를 영구적으로 보관하는 환경을 뜻한다 <br>
어플리케이션과 데이터베이스 사이에 객체를 저장하는 가상의 데이터베이스 역할을 한다 <br>
EntityManger 를 통해 객체를 처리할 때 사용되며 내부에 캐시를 갖는데, 이를 1차 캐시 라고 한다 <br>
이외의 별도로 JPA 구현체들은 어플리케이션 수준에서의 캐시를 지원하는데, 이를 공유 캐시 또는 2차 캐시 라고 한다 <br>

#### EntityMangerFactory 란?
이름에서 보다시피 EntityManger 를 생성하는 팩토리 이다 <br>
기본적으로 영속성 유닛으로 제공된 정보를 통해 호출될 때마다 애플리케이션에서 관리되는 새로운 EntityManger 인스턴스를 반환하는 createEntityManger() 라는 메소드를 제공한다 <br>

#### EntityManger 란?
- DB 에서 데이터를 가져오면 메모리에 해당 데이터의 복사본이 생성된다.
- 가져온 데이터를 보관하는 메모리 영역을 Persistence Context(영속성 컨텍스트) 또는 1차 캐시 라고 한다 

1차 캐시에 업로드 된 엔티티 객체를 수정하는 작업은 영속성 컨텍스트가 엔티티에 대한 캐시 역할 뿐 아니라, 엔티티 상태 전환에 대한 버퍼와 트랜잭션 쓰기 지연 캐시 역할도 한다는 사실을 활용해야 한다 <br>
- flush() 시점에 Hibernate 는 버퍼링된 엔티티 상태 전환을, 메모리 내 영속된 상태를 데이터베이스와 최적으로 동기화하기 위한 DML 구문으로 변환되는 작업을 담당한다.

즉 CRUD 는 EntityManger 를 통해 이뤄진다 <br>
추가적인 팁은 데이터베이스 물리적 트랜잭션당 하나 이상의 영속성 컨텍스트를 사용하지 말아야 한다 <br>

그리고 CUD 를 통한 변경 작업은 flush() 될 때 데이터베이스에 동기화 된다 <br>
* flush 전략은 Auto, Commit 으로 각자 상황에 맞게 사용하면 된다

그리고 트랜잭션이 완료되면, 영속성 컨텍스트에 있는 모든 객체가 분리 된다 <br>
모든 엔티티의 분리는 EntityManger.clear() 메소드를 통해 되거나 close() 메소드에 의해 발생한다 <br>
아니면 특정 엔티티는 detach()(=evict()) 라는 메소드를 호출해 분리될 수 있다 <br>

분리가 되면 객체는 영속성 컨텍스트를 떠나 외부에 유지된다 <br>
-> JPA 가 더 이상 이를 관리하지 않는다 뜻임 <br>











### 1. 연관관계 & FK
- 개념적으로 FK 를 사용하지만, 물리적으로 FK 는 사용하지 않을 상황을 예시로 다룸
  - <a href="https://github.com/Hyeonqz/jpa-best-example/tree/master/src/main/java/org/hyeonqz/jpabestexample/associationfk/option">1. JPA 옵션을 통한 개념적 FK 사용 </a>
  - <a href="https://github.com/Hyeonqz/jpa-best-example/tree/master/src/main/java/org/hyeonqz/jpabestexample/associationfk/id">2. id 를 통한 연관관계 참조 </a>