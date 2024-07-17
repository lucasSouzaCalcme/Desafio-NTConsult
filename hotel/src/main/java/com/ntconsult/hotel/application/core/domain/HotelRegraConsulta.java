package com.ntconsult.hotel.application.core.domain;

import com.ntconsult.hotel.adapters.out.repository.entity.HotelEntity;
import com.ntconsult.hotel.adapters.out.repository.entity.QuartoEntity;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class HotelRegraConsulta {

    public static Specification<HotelEntity> hasEndereco(String endereco) {

        return (root, query, cb) -> endereco == null ? cb.conjunction() : cb.equal(root.get("endereco"), endereco);
    }

    public static Specification<HotelEntity> hasComodidade(String comodidade) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            return comodidade == null ? cb.conjunction() : cb.equal(quartos.get("comodidade"), comodidade);
        };
    }

    public static Specification<HotelEntity> hasPreco(Double preco) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            return (preco == null || preco <= 0) ? cb.conjunction() : cb.lessThanOrEqualTo(quartos.get("preco"), preco);
        };
    }


    public static Specification<HotelEntity> hasAvaliacao(Double avaliacao) {
        return (root, query, cb) -> {
            Join<HotelEntity, QuartoEntity> quartos = root.join("quartos", JoinType.INNER);
            if (avaliacao == null) {
                return cb.conjunction();
            } else {
                // Adicionando a cláusula HAVING para a média das avaliações
                query.groupBy(root.get("id"), root.get("nome"), root.get("endereco"));
                return cb.ge(cb.avg(quartos.get("avaliacao")), avaliacao);
            }
        };
    }

}
