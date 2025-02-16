package org.hyeonqz.jpabestexample.nplus1.repository;

import java.util.List;

import org.hyeonqz.jpabestexample.nplus1.entity.NMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NMemberRepository extends JpaRepository<NMember, Long>, CustomNMemberRepository {

	@EntityGraph(attributePaths = "orders")
	@Query("SELECT m FROM NMember m")
	List<NMember> findAllWithOrders();

	@Query("SELECT m FROM NMember m JOIN FETCH m.orders")
	List<NMember> findAllFetchWithOrders();
}
