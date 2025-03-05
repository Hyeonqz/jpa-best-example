# 엔티티의 플루언트 API 스타일
Entity 를 만드는 방법에 대해서 간단하게 알아보자 <br>
- Setter
- Method

#### 하이버네이트 프록시를 통해 자식 측에서 부모 연관관계 채우기
getOne() 메소드를 사용하여 하이버네이트 프록시 객체를 반환시킨다 <br>
하이버네이트는 초기화되지 않은 프록시의 외래키 값을 설정한다 <br>
영속성 컨텍스트에 올라가 있고 같은 트랜잭션 내부라면 findById() 말고 findOne() 이 좋다 <br>

#### 불변 엔티티 작성 방법
> @Immutable 어노테이션이 지정되야한다.

- 어떤 종류의 연관관계도 포함하지 않아야 한다
- hibernate.cache.use_reference_entries 설정이 true 로 지정되야 한다 <br>

불변 엔티티는 2차 캐시에 저장된다 <br>
```java
@Immutable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "엔티티이름")
```

#### 엔티티 복제
거의 할일은 없겠지만 필요하다면 Cloning 라이브러리를 이용하자 <br>   

#### 더티체킹
더티체킹은 현재 영속성 컨텍스트에 로드된 이후 수정된 관리 중, 엔티티를 플러시 시점에 감지하는 하이버네이트 메커니즘이다 <br>
그런 다음 애플리케이션 을 대신해 적절한 SQL Update 문을 실행한다 <br>
하이버네이트는 관리 엔티티의 속성이 하나만 변경된 경우에도 모든 관리 엔티티를 select 한다 <br>

#### Boolean 을 YES/NO 로 매핑
```java
private Boolean bestSelling; // BooleanType, YesNoType 으로 매핑
```

위 boolean 을 char 로 매핑하는 방법은 AttributeConverter 를 사용한다 <br>
```java
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    // Boolean -> String 으로 변환한다.
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute == null ? "NO" : "YES";
    }

    // String -> Boolean 으로 변환한다.
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return !"No".equals(dbData);
    }

}
```

하나 특징은 @Enumerated 어노테이션이 달린 타입에는 적용할 수 없다 <br>
@Converter(autoApply = true) 은 해당 변환기가 모든 Boolean 타입에 적용된다는 뜻이다 <br>
특정 속성에만 지정하려면 false 로 지정하고, 변환이 필요한 필드에 직접 매핑을 해야한다
```java
@Convert(converter= BooleanConverter.class)
private Boolean bestSelling;
```


#### 애그리거트 루트로부터 최적의 도메인 이벤트 발행


















