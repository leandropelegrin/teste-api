package com.teste.kafka;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {

    private String nome;
    private String telefone;
    private String email;
    private String cargo;

}
