package org.soup.businessservice.mapper;

import org.soup.common.models.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.businessservice.dto.CustomerCreateRequest;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerCreateMapper extends CreateMapper<CustomerDto, CustomerCreateRequest> {
}
