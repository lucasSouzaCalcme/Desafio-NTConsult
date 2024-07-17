package com.ntconsult.hotel.config;

import com.ntconsult.hotel.adapters.out.*;
import com.ntconsult.hotel.application.core.usecase.ReservaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaConfig {

    @Bean
    public ReservaUseCase reservaUseCase(ReservaAdapter reservaAdapter,
                                         HotelAdapter hotelUseCase,
                                         ClienteAdapter clienteUseCase,
                                         QuartoAdapter quartoAdapter,
                                         SendMessageAdapter sendMessageAdapter
                                         )
    {
        return new ReservaUseCase(reservaAdapter, hotelUseCase,clienteUseCase,quartoAdapter, sendMessageAdapter);
    }
}
