package com.ntconsult.hotel.application.core.domain;
import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class HotelRegraAvancada {

    public static Specification<HotelEntity> hasEndereco(String endereco) {
        return (root, query, cb) -> endereco == null ? cb.conjunction() : cb.equal(root.get("endereco"), endereco);
    }

    public static Specification<HotelEntity> hasHospedes(Long hospede) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            return hospede == null ? cb.conjunction() : cb.equal(quartos.get("hospedes"), hospede);
        };
    }

    public static Specification<HotelEntity> hasMinQuartos(Long numQuartos) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            query.groupBy(root.get("id"), root.get("nome"), root.get("endereco"));
            return cb.ge(cb.count(quartos.get("id")), numQuartos != null ? numQuartos : 1L);
        };
    }

    public static Specification<HotelEntity> buildSpecification(String endereco, Long hospede, Long numQuartos) {
        return (root, query, cb) -> {
            Predicate enderecoPredicate = hasEndereco(endereco).toPredicate(root, query, cb);
            Predicate hospedePredicate = hasHospedes(hospede).toPredicate(root, query, cb);
            Predicate minQuartosPredicate = hasMinQuartos(numQuartos).toPredicate(root, query, cb);

            query.having(minQuartosPredicate);

            return cb.and(enderecoPredicate, hospedePredicate);
        };
    }

    public static Specification<HotelEntity> hasAvailability(LocalDate checkIn, LocalDate checkOut) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            Join<QuartoEntity, ReservaEntity> reservas = quartos.join("reservas", JoinType.LEFT);

            if (checkIn == null || checkOut == null) {
                return cb.conjunction();
            }

            return cb.or(
                    cb.isNull(reservas.get("id")),
                    cb.and(
                            cb.lessThanOrEqualTo(reservas.get("checkIn"), checkOut),
                            cb.greaterThanOrEqualTo(reservas.get("checkOut"), checkIn)
                    )
            );
        };
    }



}
