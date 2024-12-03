package org.soup.businessservice.mapper;

import org.soup.common.models.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.businessservice.requests.OrderItemCreateRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemCreateMapper extends CreateMapper<OrderItemDto, OrderItemCreateRequest> {
}
