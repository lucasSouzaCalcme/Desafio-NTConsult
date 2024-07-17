package com.ntconsult.hotel.config;

import com.ntconsult.hotel.adapters.out.ClienteAdapter;
import com.ntconsult.hotel.application.core.usecase.ClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    public ClienteUseCase clienteUseCase(ClienteAdapter clienteAdapter){
        return new ClienteUseCase(clienteAdapter);
    }
}
