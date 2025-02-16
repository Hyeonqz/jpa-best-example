package org.hyeonqz.jpabestexample.nplus1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.hyeonqz.jpabestexample.nplus1.entity.NMember;
import org.hyeonqz.jpabestexample.nplus1.entity.NOrder;
import org.hyeonqz.jpabestexample.nplus1.repository.NMemberRepository;
import org.hyeonqz.jpabestexample.nplus1.repository.NOrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NMemberServiceTest {

	@Autowired
	private NMemberService nMemberService;

	@Autowired
	private NMemberRepository nMemberRepository;

	@Autowired
	private NOrderRepository nOrderRepository;

	@Test
	@DisplayName("멤버별로 주문을 주문 개수를 조회한다.")
	void getMemberWithOrdersTest() {
	    // given & when & then
		nMemberService.getMemberWithOrders();
	}

	@Test
	void insertTest() {
	    // given
		NMember member = null;
		NOrder order =  null;
		for (int i = 0; i < 5000; i++) {
			member = new NMember("현규"+i);
			order = new NOrder("치킨"+i, LocalDateTime.now(), member);
			nMemberRepository.save(member);
			nOrderRepository.save(order);
		}
	}

}