package com.example.basespring.entities;

import com.example.basespring.entities.basic.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
@ToString
public class Sales extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String saleName;
    @Lob
    private String dos;
    @ManyToOne
    @JoinColumn(name = "product_id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Products product;
}
