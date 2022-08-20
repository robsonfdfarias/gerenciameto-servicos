package br.com.infocomrobson.gerenciadorServicos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_servicos")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "tipo_servico_id")
    private TipoServico tipoServico;
    private String descricaoServico;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean pago;
    private String observacao;
    private double preco;
}
