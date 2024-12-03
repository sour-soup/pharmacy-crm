package org.soup.dataservice.mapper;

import org.soup.common.models.MedicineDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.soup.dataservice.entity.Medicine;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicineMapper extends DtoMapper<Medicine, MedicineDto> {
}
