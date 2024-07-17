package com.ntconsult.hotel.adapters.in.controller.mapper;

import com.ntconsult.hotel.adapters.in.controller.request.HotelRequest;
import com.ntconsult.hotel.adapters.in.controller.response.HotelResponse;
import com.ntconsult.hotel.application.core.domain.Hotel;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelRequest toHotelRquest(Hotel hotel);
    @Mapping(target = "avaliacao", ignore = true)
    HotelResponse toHotelResponde(Hotel hotel);

    Hotel toHotel(HotelRequest hotelRequest);
}
