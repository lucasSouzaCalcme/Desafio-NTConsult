package com.ntconsult.hotel.adapters.out.repository.mapper;

import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import com.ntconsult.hotel.application.core.domain.Quarto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuartoMapper {

    QuartoEntity toEntity(Quarto quarto);

    Quarto toQuarto(QuartoEntity quartoEntity);
}
