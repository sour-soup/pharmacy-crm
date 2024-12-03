package org.soup.common.models;

import java.time.LocalDateTime;

public record OrderDto(Long id, Long customerId, Long pharmacistId, LocalDateTime orderDate) {
}
