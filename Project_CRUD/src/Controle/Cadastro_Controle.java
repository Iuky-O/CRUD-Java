
package Controle;

import Entidades.Produto;

public class Cadastro_Controle {
    
    public boolean cadastrarProduto(Produto p){
        boolean result = false;
        
        if(
                p != null && 
                p.getNome().length()>0 &&
                p.getPrecoCusto() != 0.0f && 
                p.getPrecoVenda() != 0.0f &&
                p.getEspecificacoes().length() > 0
                ){
            
            result = true;
        }
        
        return result;
    }
}
