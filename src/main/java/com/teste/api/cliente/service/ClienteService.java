package com.teste.api.cliente.service;

import com.teste.kafka.Cliente;
import com.teste.api.cliente.kafka.KafkaEventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClienteService {

    private final KafkaEventProducer kafkaEventProducer;

    public Cliente publicarEventoCliente(Cliente cliente) {
        log.info("ClienteService - Cliente: {}", cliente.toString());

        cliente.setCargo("Arroz");
        log.info("ClienteService - Cliente: {}", cliente.toString());

        kafkaEventProducer.sendCliente(cliente);
        return cliente;
    }

}
