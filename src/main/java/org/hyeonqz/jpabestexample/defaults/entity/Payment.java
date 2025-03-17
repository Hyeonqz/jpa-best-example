package org.hyeonqz.jpabestexample.defaults.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionNo;

    @OneToMany
    private List<Product> product = new ArrayList<>();

    @DomainEvents
    public void publishCreate() {
        // 이벤트 선언
    }

    @AfterDomainEventPublication
    public void callbackMethod() {
        // 잠재적으로 도메인 이벤트 리스트 정리
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", transactionNo='" + transactionNo + '\'' +
                '}';
    }
}
