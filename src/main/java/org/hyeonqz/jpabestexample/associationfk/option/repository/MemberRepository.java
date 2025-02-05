package org.hyeonqz.jpabestexample.associationfk.option.repository;

import org.hyeonqz.jpabestexample.associationfk.option.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, Long> {
}
