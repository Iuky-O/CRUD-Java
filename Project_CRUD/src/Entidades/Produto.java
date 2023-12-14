
package Entidades;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Produto {
    
    private static DefaultTableModel modeloTabela;
    
    public static List<Produto> listaProdutos;  

    static {
        listaProdutos = new ArrayList<>();
    }

    private static int sequence = 1;
    
    private long codigo;
    private String nome;
    private String especificacoes;
    private float precoVenda;
    private float precoCusto;
    private boolean habilitadoVendas;

    public Produto(String nome, String especificacoes, float precoVenda, float precoCusto, boolean habilitadoVendas) {
        
        this.nome = nome;
        this.especificacoes = especificacoes;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
        this.habilitadoVendas = habilitadoVendas;
        
        
    }

    public Produto() {

    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public boolean isHabilitadoVendas() {
        return habilitadoVendas;
    }

    public void setHabilitadoVendas(boolean habilitadoVendas) {
        this.habilitadoVendas = habilitadoVendas;
    }
   
    public void setModeloTabela(DefaultTableModel modeloTabela) {
        
        Produto.modeloTabela = modeloTabela;
        
    }
    
    public void addL(){
        this.codigo = sequence++;
        listaProdutos.add(this);
    }
    
    public void adicionarProduto(Produto produto) {

        modeloTabela.addRow(new Object[]{
            produto.getCodigo(), 
            produto.getNome(), 
            produto.getEspecificacoes(), 
            produto.getPrecoCusto(), 
            produto.getPrecoVenda(),
            produto.isHabilitadoVendas() == true ? "Desabilitado":"Habilitado"
        });      
    }
}
