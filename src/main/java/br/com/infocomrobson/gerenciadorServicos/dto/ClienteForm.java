package br.com.infocomrobson.gerenciadorServicos.dto;

import lombok.Data;

@Data
public class ClienteForm {
    private String nome;
    private String telefone;
    private String cidade;
    private String observacao;
}
