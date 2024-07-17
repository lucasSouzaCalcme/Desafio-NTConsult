package com.ntconsult.hotel.adapters.out.repository;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ReservaEntity r SET r.status = 'PAGO' WHERE r.id = :reservaId")
    void updateStatusToPago(@Param("reservaId") Long reservaId);
    Optional<ReservaEntity> findByHotelAndQuarto(HotelEntity hotel, QuartoEntity quarto);
}
