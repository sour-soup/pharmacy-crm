package models;

import lombok.Value;

@Value
public class CustomerDto {
    Long id;
    String name;
    String phone;
}
