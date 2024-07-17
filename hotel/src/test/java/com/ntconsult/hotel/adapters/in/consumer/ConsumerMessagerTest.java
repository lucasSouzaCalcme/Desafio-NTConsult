package com.ntconsult.hotel.adapters.in.consumer;

import com.ntconsult.hotel.adapters.in.consumer.response.CustomerMessage;
import com.ntconsult.hotel.application.ports.in.ReservaInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsumerMessagerTest {

    @Mock
    private ReservaInputPort reservaInputPort;

    @InjectMocks
    private ConsumerMessager consumerMessager;

    @Test
    public void testReceiveWhenValidCustomerMessageThenUpdateReservaInputPort() {

        CustomerMessage customerMessage = new CustomerMessage("123");
        consumerMessager.receive(customerMessage);
        verify(reservaInputPort, times(1)).update(123L);
    }

    @Test
    public void testReceiveWhenInvalidCdReservaThenNoUpdateReservaInputPort() {

        CustomerMessage customerMessage = new CustomerMessage("invalid");
        consumerMessager.receive(customerMessage);
        verify(reservaInputPort, never()).update(anyLong());
    }
}
