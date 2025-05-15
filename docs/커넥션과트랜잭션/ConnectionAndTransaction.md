# Connection & Transaction
Hibernate 5.2 부터는 데이터베이스 커넥션 획득을 실제 필요할 때 까지 지연시킬 수 있다 <br>
단일 데이터베이스일 경우 하이버네이트는 트랜잭션이 시작된 직 후 바로 JDBC 트랜잭션의 데이터베이스 커넥션을 획득한다 <br>
ex) @Transactional 지정된 메소드는 메소드 호출 직후 바로 커넥션을 얻는다 <br>

springboot 는 hikariCP 를 사용하여 db 커넥션을 진행한다 <br>
옵션을 통해 auto-commit 을 끌 수 있다 <br>
```yaml
spring:
  datasource:
    hikari:
      auto-commit: false
  jpa:
    properties:
      hibernate:
        connection:
          provider_disable_autocommit: true
```

### @Transactional(readOnly=true) 의 실제 작동방식

