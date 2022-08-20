package br.com.infocomrobson.gerenciadorServicos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String cidade;
    private String observacao;
    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Servicos> servicos = new ArrayList<>();

}
