package com.ntconsult.hotel.adapters.in.controller;

import com.ntconsult.hotel.adapters.in.controller.mapper.ClienteMapper;
import com.ntconsult.hotel.adapters.in.controller.request.ClienteRequest;
import com.ntconsult.hotel.adapters.in.controller.response.ClienteResponse;
import com.ntconsult.hotel.application.core.domain.Cliente;
import com.ntconsult.hotel.application.ports.in.ClienteInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClienteInputPort clienteInputPort;
    @MockBean
    private ClienteMapper clienteMapper;
    private ClienteRequest validClienteRequest;
    private Cliente validCliente;
    private ClienteResponse validClienteResponse;

    @BeforeEach
    public void setUp() {
        validClienteRequest = new ClienteRequest("John Doe", "123 Main St", "12345678900");
        validCliente = new Cliente();
        validCliente.setName("John Doe");
        validCliente.setEndereco("123 Main St");
        validCliente.setCpf("12345678900");

        validClienteResponse = new ClienteResponse("John Doe", "123 Main St", "12345678900");
    }

    @Test
    public void testInsertWhenValidClienteRequestThenReturnOk() throws Exception {

        Mockito.when(clienteMapper.toCliente(any(ClienteRequest.class))).thenReturn(validCliente);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\",\"endereco\":\"123 Main St\",\"cpf\":\"12345678900\"}"))
                .andExpect(status().isOk());

        Mockito.verify(clienteInputPort, Mockito.times(1)).insert(any(Cliente.class));
    }

    @Test
    public void testFindByidWhenValidIdThenReturnClienteResponse() throws Exception {

        Long validId = 1L;
        Mockito.when(clienteInputPort.find(eq(validId))).thenReturn(Optional.of(validCliente));
        Mockito.when(clienteMapper.toClienteResponse(any(Cliente.class))).thenReturn(validClienteResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clientes/{id}", validId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endereco").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("12345678900"));

        Mockito.verify(clienteInputPort, Mockito.times(1)).find(eq(validId));
        Mockito.verify(clienteMapper, Mockito.times(1)).toClienteResponse(any(Cliente.class));
    }
}
