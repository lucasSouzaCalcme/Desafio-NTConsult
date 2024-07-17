package com.ntconsult.hotel.adapters.in.controller;

import com.ntconsult.hotel.adapters.in.controller.mapper.HotelMapper;
import com.ntconsult.hotel.adapters.in.controller.request.HotelRequest;
import com.ntconsult.hotel.adapters.in.controller.response.HotelResponse;
import com.ntconsult.hotel.application.core.domain.Hotel;
import com.ntconsult.hotel.application.core.domain.HotelFiltro;
import com.ntconsult.hotel.application.ports.in.HotelInputPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Optional;

@WebMvcTest(HotelController.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelInputPort hotelInputPort;

    @MockBean
    private HotelMapper hotelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInsertWhenValidHotelRequestThenReturnOk() throws Exception {
        // Arrange
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setNome("Hotel Test");
        hotelRequest.setEndereco("123 Test St");
        hotelRequest.setQuartos(Collections.emptyList());
        hotelRequest.setAvaliacao(Collections.emptyList());

        Hotel hotel = new Hotel();
        hotel.setNome("Hotel Test");
        hotel.setEndereco("123 Test St");
        hotel.setQuartos(Collections.emptyList());
        hotel.setAvaliacao(Collections.emptyList());

        Mockito.when(hotelMapper.toHotel(hotelRequest)).thenReturn(hotel);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hoteis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hotelRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(hotelInputPort, Mockito.times(1)).insert(hotel);
    }

    @Test
    public void testFindByIdWhenValidIdThenReturnHotelResponse() throws Exception {
        // Arrange
        Long id = 1L;
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setNome("Hotel Test");
        hotel.setEndereco("123 Test St");
        hotel.setQuartos(Collections.emptyList());
        hotel.setAvaliacao(Collections.emptyList());

        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setNome("Hotel Test");
        hotelResponse.setEndereco("123 Test St");
        hotelResponse.setQuartos(Collections.emptyList());

        Mockito.when(hotelInputPort.find(id)).thenReturn(Optional.of(hotel));
        Mockito.when(hotelMapper.toHotelResponde(hotel)).thenReturn(hotelResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hoteis/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Hotel Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endereco").value("123 Test St"));

        Mockito.verify(hotelInputPort, Mockito.times(1)).find(id);
    }

    @Test
    public void testFindFiltroWhenValidFiltroThenReturnHotelResponseList() throws Exception {
        // Arrange
        HotelFiltro hotelFiltro = new HotelFiltro();
        hotelFiltro.setDestino("Test Destination");

        Hotel hotel = new Hotel();
        hotel.setNome("Hotel Test");
        hotel.setEndereco("123 Test St");
        hotel.setQuartos(Collections.emptyList());
        hotel.setAvaliacao(Collections.emptyList());

        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setNome("Hotel Test");
        hotelResponse.setEndereco("123 Test St");
        hotelResponse.setQuartos(Collections.emptyList());

        Mockito.when(hotelInputPort.findHotelFiltro(hotelFiltro)).thenReturn(Collections.singletonList(hotel));
        Mockito.when(hotelMapper.toHotelResponde(hotel)).thenReturn(hotelResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hoteis/filtro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hotelFiltro)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Hotel Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endereco").value("123 Test St"));

        Mockito.verify(hotelInputPort, Mockito.times(1)).findHotelFiltro(hotelFiltro);
    }

    @Test
    public void testFindOpcoesWhenValidFiltroThenReturnHotelResponseList() throws Exception {
        // Arrange
        HotelFiltro hotelFiltro = new HotelFiltro();
        hotelFiltro.setDestino("Test Destination");

        Hotel hotel = new Hotel();
        hotel.setNome("Hotel Test");
        hotel.setEndereco("123 Test St");
        hotel.setQuartos(Collections.emptyList());
        hotel.setAvaliacao(Collections.emptyList());

        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setNome("Hotel Test");
        hotelResponse.setEndereco("123 Test St");
        hotelResponse.setQuartos(Collections.emptyList());

        Mockito.when(hotelInputPort.findHotelFiltroOpcoes(hotelFiltro)).thenReturn(Collections.singletonList(hotel));
        Mockito.when(hotelMapper.toHotelResponde(hotel)).thenReturn(hotelResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hoteis/opcoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hotelFiltro)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Hotel Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endereco").value("123 Test St"));

        Mockito.verify(hotelInputPort, Mockito.times(1)).findHotelFiltroOpcoes(hotelFiltro);
    }
}
