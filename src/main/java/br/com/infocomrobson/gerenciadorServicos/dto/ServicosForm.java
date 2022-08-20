package br.com.infocomrobson.gerenciadorServicos.dto;

import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ServicosForm {
    private Long cliente;
    private Long tipoServico;
    private String descricaoServico;
    private LocalDate dataInicio = LocalDate.now();
    private LocalDate dataFim;
    private boolean pago;
    private String observacao;
    private double preco;
}












