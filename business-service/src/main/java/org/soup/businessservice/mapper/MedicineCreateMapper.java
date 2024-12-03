package org.soup.businessservice.mapper;

import org.soup.common.models.MedicineDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.businessservice.requests.MedicineCreateRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicineCreateMapper extends CreateMapper<MedicineDto, MedicineCreateRequest> {
}
