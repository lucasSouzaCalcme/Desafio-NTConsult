package com.ntconsult.hotel.application.core.domain;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.ReservaEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class QuartoDisponivel {

    public static Specification<HotelEntity> hasId(Long idHotel) {
        return (root, query, cb) -> idHotel == null ? cb.conjunction() : cb.equal(root.get("id"), idHotel);
    }

    public static Specification<HotelEntity> hasQuartoId(Long idQuarto) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            return idQuarto == null ? cb.conjunction() : cb.equal(quartos.get("id"), idQuarto);
        };
    }

    public static Specification<HotelEntity> hasAvailableRoom() {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            Join<QuartoEntity, ReservaEntity> reservas = quartos.join("reservas", JoinType.LEFT);
            return reservas.get("id").isNull();
        };
    }

    public static Specification<HotelEntity> buildSpecification(Long idHotel, Long idQuarto) {
        return (root, query, cb) -> {
            Predicate hotelIdPredicate = hasId(idHotel).toPredicate(root, query, cb);
            Predicate quartoIdPredicate = hasQuartoId(idQuarto).toPredicate(root, query, cb);
            Predicate availableRoomPredicate = hasAvailableRoom().toPredicate(root, query, cb);

            return cb.and(hotelIdPredicate, quartoIdPredicate, availableRoomPredicate);
        };
    }
}
