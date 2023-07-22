package com.example.basespring.entities;

import com.example.basespring.entities.basic.BaseEntity;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "products")
public class Products extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    @NotNull(message = "Products cannot be left blank")
    private String productName;
    @Lob
    private String description;
    private Date datetime;
    private float price;
}
