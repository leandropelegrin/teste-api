package com.teste.api.cliente.controller;

import com.teste.kafka.Cliente;
import com.teste.api.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cliente")
    public ResponseEntity<String> salvarCliente(@RequestBody Cliente cliente){

        log.info("Cliente - {}", cliente.toString());

        try {
            Cliente clientePublicado = clienteService.publicarEventoCliente(cliente);

            return ResponseEntity.ok("deu bom cliente: " + clientePublicado.toString());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
