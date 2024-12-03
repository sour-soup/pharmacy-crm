package org.soup.dataservice.mapper;

import org.soup.common.models.PharmacistDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.dataservice.entity.Pharmacist;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PharmacistMapper extends DtoMapper<Pharmacist, PharmacistDto> {
}
