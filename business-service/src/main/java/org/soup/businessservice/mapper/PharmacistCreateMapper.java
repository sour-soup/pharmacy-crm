package org.soup.businessservice.mapper;

import org.soup.common.models.PharmacistDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.businessservice.requests.PharmacistCreateRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PharmacistCreateMapper extends CreateMapper<PharmacistDto, PharmacistCreateRequest> {
}
