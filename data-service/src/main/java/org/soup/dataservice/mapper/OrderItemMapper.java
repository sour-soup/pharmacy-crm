package org.soup.dataservice.mapper;

import org.mapstruct.*;
import org.soup.common.models.OrderItemDto;
import org.soup.dataservice.entity.Medicine;
import org.soup.dataservice.entity.Order;
import org.soup.dataservice.entity.OrderItem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper extends DtoMapper<OrderItem, OrderItemDto> {
    @Override
    @Mapping(source = "medicineId", target = "medicine.id")
    @Mapping(source = "orderId", target = "orderDto.id")
    OrderItemDto toDto(OrderItem OrderItem);

    @Override
    @InheritInverseConfiguration(name = "toDto")
    OrderItem toEntity(OrderItemDto OrderItemDto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "medicineId", target = "medicine")
    @Mapping(source = "orderId", target = "order")
    OrderItem partialUpdate(@MappingTarget OrderItemDto OrderItemDto, OrderItem orderItemDto1);

    default Order createOrder(Long orderId) {
        if (orderId == null) {
            return null;
        }
        Order orderDto = new Order();
        orderDto.setId(orderId);
        return orderDto;
    }

    default Medicine createMedicine(Long medicineId) {
        if (medicineId == null) {
            return null;
        }
        Medicine medicine = new Medicine();
        medicine.setId(medicineId);
        return medicine;
    }
}
