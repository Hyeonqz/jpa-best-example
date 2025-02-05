package org.hyeonqz.jpabestexample.associationfk.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hyeonqz.jpabestexample.JpaBestExampleApplication;
import org.hyeonqz.jpabestexample.associationfk.option.entity.Members;
import org.hyeonqz.jpabestexample.associationfk.option.entity.Order;
import org.hyeonqz.jpabestexample.associationfk.option.repository.MemberRepository;
import org.hyeonqz.jpabestexample.associationfk.option.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@ActiveProfiles("dev")
@SpringBootTest(classes = JpaBestExampleApplication.class)
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private EntityManager entityManager;

	@BeforeEach
	@Transactional
	void setUp() {
		Members member = new Members("jin", "010-1234-5678");
		memberRepository.save(member);
		Order order = new Order(LocalDateTime.now(), member);
		orderRepository.save(order);
	}

	@AfterEach
	void tearDown () {
		entityManager.clear();
	}

	@Test
	@DisplayName("Order 조회시 FetchType 에 따른 비교를 해본다.")
	void selectOrderTest() {
	    // given & when
		Optional<Order> byId = orderRepository.findById(1L);

		// then
		Assertions.assertThat(byId).isPresent();
	}

}