package org.soup.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 15)
    private String phone;
}
