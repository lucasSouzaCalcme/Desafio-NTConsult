package com.ntconsult.hotel.adapters.out.repository;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuartoRepository extends JpaRepository<QuartoEntity, Long> {

    Optional<QuartoEntity> findByIdAndHotel(Long id, HotelEntity hotel);

}
