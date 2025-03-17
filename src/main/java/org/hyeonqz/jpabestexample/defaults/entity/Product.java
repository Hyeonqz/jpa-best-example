package org.hyeonqz.jpabestexample.defaults.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String count;

    private BigDecimal price;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] avatar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Payment payment;

    @Builder
    public Product(String name, String count, BigDecimal price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", price=" + price +
                '}';
    }
}
