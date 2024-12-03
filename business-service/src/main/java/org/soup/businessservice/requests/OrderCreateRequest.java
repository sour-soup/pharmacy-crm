package org.soup.businessservice.requests;

import java.time.LocalDateTime;

public record OrderCreateRequest(Long customerId, Long pharmacistId, LocalDateTime orderDate) {
}
