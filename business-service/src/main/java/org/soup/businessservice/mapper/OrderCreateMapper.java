package org.soup.businessservice.mapper;

import org.soup.common.models.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.businessservice.requests.OrderCreateRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderCreateMapper extends CreateMapper<OrderDto, OrderCreateRequest> {
}
