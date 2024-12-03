package org.soup.common.models;

public record OrderItemDto(Long id, Integer quantity, Double price, Long orderId, Long medicineId) {
}
