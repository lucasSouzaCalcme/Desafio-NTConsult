package com.ntconsult.hotel.adapters.out.repository.mapper;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.application.core.domain.Hotel;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface HotelEntityMapper {

    HotelEntity toHotelEntity(Hotel hotel);

    Hotel toHotel(HotelEntity hotelEntity);
}
