package br.com.infocomrobson.gerenciadorServicos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_servico")
@Data
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
