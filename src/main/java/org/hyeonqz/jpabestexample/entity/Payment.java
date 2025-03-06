package org.hyeonqz.jpabestexample.entity;

import java.io.Serializable;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionNo;

    @DomainEvents
    public void publishCreate() {
        // 이벤트 선언
    }

    @AfterDomainEventPublication
    public void callbackMethod() {
        // 잠재적으로 도메인 이벤트 리스트 정리
    }

}
