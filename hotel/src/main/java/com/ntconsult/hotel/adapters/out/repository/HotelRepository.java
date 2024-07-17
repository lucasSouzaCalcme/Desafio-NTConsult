package com.ntconsult.hotel.adapters.out.repository;

import com.ntconsult.hotel.adapters.in.controller.response.HotelFiltroResponse;
import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface HotelRepository extends JpaRepository<HotelEntity, Long>, JpaSpecificationExecutor<HotelEntity> {



}
