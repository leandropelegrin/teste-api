package com.teste.api.cliente.kafka;

import com.teste.kafka.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaEventProducer {

    @Autowired
    private KafkaTemplate<String, Cliente> kafkaTemplate;

    public void sendCliente(Cliente cliente) {
        cliente.setCargo("Porto");
        log.info("SendCliente: {}", cliente);


        Message<Cliente> message = MessageBuilder
                .withPayload(cliente)
                .setHeader(KafkaHeaders.TOPIC, "testecliente")
                .build();

        kafkaTemplate.send(message);

    }
}
