package com.ntconsult.hotel.adapters.out.repository.mapper;

import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import com.ntconsult.hotel.application.core.domain.Reserva;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ReservaEntityMapper {

    ReservaEntity toReservaEntity(Reserva reserva);

    Reserva toReserva(ReservaEntity reservaEntity);

    Reserva toReservaOptional(Optional<ReservaEntity> reservaEntity);
}
