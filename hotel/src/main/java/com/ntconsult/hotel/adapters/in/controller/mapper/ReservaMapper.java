package com.ntconsult.hotel.adapters.in.controller.mapper;

import com.ntconsult.hotel.adapters.in.controller.request.ReservaRequest;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.core.domain.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaRequest toReservaRequest(Reserva reserva);

    Reserva toReserva(ReservaRequest reservaRequest);
    Reserva toReservaEntity(ReservaEntity reserva);
}
