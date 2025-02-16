package org.hyeonqz.jpabestexample.nplus1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "n_order")
@Entity
public class NOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;

	private LocalDateTime createAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "n_member_id")
	private NMember member;

	public NOrder (String productName, LocalDateTime createAt, NMember member) {
		this.productName = productName;
		this.createAt = createAt;
		this.member = member;
	}

}
