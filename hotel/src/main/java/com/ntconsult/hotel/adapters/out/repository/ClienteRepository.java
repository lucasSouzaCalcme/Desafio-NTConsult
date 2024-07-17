package com.ntconsult.hotel.adapters.out.repository;

import com.ntconsult.hotel.adapters.out.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
