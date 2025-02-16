package org.hyeonqz.jpabestexample.nplus1.repository;

import java.util.List;

import org.hyeonqz.jpabestexample.nplus1.entity.NMember;

public interface CustomNMemberRepository {
	List<NMember> findAllWithNOrders();
}
