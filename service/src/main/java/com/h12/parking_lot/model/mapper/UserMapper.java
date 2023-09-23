package com.h12.parking_lot.model.mapper;

import com.h12.parking_lot.model.User;
import com.h12.parking_lot.model.dto.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserDto userDTO, @MappingTarget User user);
}
