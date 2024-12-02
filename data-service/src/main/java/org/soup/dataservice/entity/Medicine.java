package org.soup.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicines")
public class Medicine extends AbstractEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 255)
    private String description;
}
