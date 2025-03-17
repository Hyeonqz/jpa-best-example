# Fetch
다이렉트 페칭 또는 ID 로 가져오기는 식별자를 알고 있고 지연 연관관계가 현재 영속성 컨텍스트에서 필요하지 않을 때에 엔티티를 가져오는 바람직한 방법이다 <br>
다이렉트 페칭이라 함은 FetchType 에 따라 엔티티를 로딩하는 연관관계에 따른 방법이다 <br>

가장 좋은 방법은 모든 연관관계를  Lazy 로 유지하고, 해당 연관관계에서 페치가 필요할시 수동 페치를 적용하는게 적합하다 <br>

내부적으로 findById() 는 EntityManger.find() 메소드를 사용한다 <br>

- EntityManger 를 통한 다이렉트 패치
- Hibernate Session 을 통한 페치

- 다이렉트 페치 및 세션 수준 반복 읽기
- ID로 여러 엔티티 다이렉트 fetch
  - IN 연산자를 사용한 쿼리를 활용한다.

#### 미래 영속성 컨텍스트에서 데이터베이스 변경사항 전파를 위한 읽기 전용 엔티티 사용 이유
```java
    @Transactional(readOnly = true)
    public void getProduct() {
        Payment payment = paymentRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
```

읽기 전용 모드로 엔티티를 로드한다. <br>
readOnly 상태는 자동 플러시도 없고, 더티 체킹도 적용되지 않는다 <br>

#### Bytecode 관련 속성 지연 로딩
```java
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] avatar;
```

image 데이터를 byte 코드로 저장을 한다 <br>
속성 지연 로딩은 CLOB, BLOB, VARBINARY 등 많은 데이터를 저장하는 컬럼 타입 또는 별도 요청시 세부 정보가 로드돼야 하는 경우에 유용하다 <br>
- Bytecode Enhancement 의존성 추가
- enableLazyInitialization 설정을 통해 지연 초기화 활성화

하이버네이트 Bytecode Enhancement 는 빌드 타임에 처리되기 때문에 런타임 오버헤드는 추가되지 않는다 <br>

- 속성 지연 로딩과  N+1

#### 스프링 프로젝션을 통한 DTO 가져오기



















