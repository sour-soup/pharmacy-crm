package org.soup.dataservice.mapper;

import org.mapstruct.*;
import org.soup.dataservice.entity.Customer;
import org.soup.dataservice.entity.Order;
import org.soup.common.models.OrderDto;
import org.soup.dataservice.entity.Pharmacist;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper extends DtoMapper<Order, OrderDto> {
    @Override
    @Mapping(source = "pharmacistId", target = "pharmacist.id")
    @Mapping(source = "customerId", target = "customer.id")
    OrderDto toDto(Order Order);

    @Override
    @InheritInverseConfiguration(name = "toDto")
    Order toEntity(OrderDto Order);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "pharmacistId", target = "pharmacist")
    @Mapping(source = "customerId", target = "customer")
    Order partialUpdate(@MappingTarget OrderDto Order, Order OrderDto);

    default Customer createCustomer(Long customerId) {
        if (customerId == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;
    }

    default Pharmacist createPharmacist(Long pharmacistId) {
        if (pharmacistId == null) {
            return null;
        }
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setId(pharmacistId);
        return pharmacist;
    }
}
