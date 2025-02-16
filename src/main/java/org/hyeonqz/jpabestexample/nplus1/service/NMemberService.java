package org.hyeonqz.jpabestexample.nplus1.service;

import java.util.List;

import org.hyeonqz.jpabestexample.nplus1.entity.NMember;
import org.hyeonqz.jpabestexample.nplus1.entity.NOrder;
import org.hyeonqz.jpabestexample.nplus1.repository.NMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NMemberService {
	private final NMemberRepository nMemberRepository;

	@Transactional(readOnly = true)
	public void getMemberWithOrders() {
		List<NMember> nMemberList = nMemberRepository.findAll();
		log.info("Member : {}", nMemberList.size());

		for (NMember nMember : nMemberList) {
			List<NOrder> orders = nMember.getOrders(); // N+1 발생
			log.info("Member : {} _ OrderCount : {}", nMember.getName(), orders.size());
		}
	}
}
