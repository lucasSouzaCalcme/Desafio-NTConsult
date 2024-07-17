package com.ntconsult.hotel.config;

import com.ntconsult.hotel.adapters.out.HotelAdapter;
import com.ntconsult.hotel.application.core.usecase.HotelUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelConfig {

    @Bean
    public HotelUseCase hotelUseCase(HotelAdapter hotelAdapter)
    {
        return new HotelUseCase(hotelAdapter);
    }
}
