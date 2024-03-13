package br.com.will.macdonalts.domain.produto;

public enum Categoria {
    HAMBURGUER("gamburguer"),
    SANDUICHE("sanduiche"),
    REFRIGERANTE("refrigerante"),
    SUCO("SUCO");

    private String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
