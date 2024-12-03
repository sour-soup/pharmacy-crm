package org.soup.businessservice.requests;

public record OrderItemCreateRequest(Integer quantity, Double price, Long orderId, Long medicineId) {
}
