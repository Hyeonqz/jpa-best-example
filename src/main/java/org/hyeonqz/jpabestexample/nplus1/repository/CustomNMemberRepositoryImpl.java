package org.hyeonqz.jpabestexample.nplus1.repository;

import java.util.List;

import org.hyeonqz.jpabestexample.nplus1.entity.NMember;
import org.hyeonqz.jpabestexample.nplus1.entity.QNMember;
import org.hyeonqz.jpabestexample.nplus1.entity.QNOrder;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CustomNMemberRepositoryImpl implements CustomNMemberRepository{

	private final JPAQueryFactory jpaQueryFactory;
	private static final QNMember qnMember = QNMember.nMember;
	private static final QNOrder qnOrder = QNOrder.nOrder;

	@Override
	public List<NMember> findAllWithNOrders () {
		return jpaQueryFactory.selectFrom(qnMember)
			.leftJoin(qnMember.orders, qnOrder)
			.fetchJoin()
			.fetch()
			;
	}

}
