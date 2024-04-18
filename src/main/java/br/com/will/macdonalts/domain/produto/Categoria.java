package br.com.will.macdonalts.domain.produto;

public enum Categoria {
    HAMBURGUER("hamburguer", "hamburguer's"),
    SANDUICHE("sanduiche", "sanduiches"),
    REFRIGERANTE("refrigerante", "refrigerantes"),
    SUCO("SUCO", "sucos");

    private String categoria;
    private String plural;

    Categoria(String categoria, String plural){
        this.categoria = categoria;
        this.plural = plural;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getPlural() {
        return plural;
    }

    public static Categoria pegarCategoria(String text){
        for(Categoria cat : Categoria.values()){
            if (cat.getCategoria().equalsIgnoreCase(text)){
                return cat;
            }
        }
        throw new RuntimeException("Categoria não encontrada");
    }

    public static Categoria pegarPlural(String text){
        for(Categoria cat : Categoria.values()){
            if (cat.getPlural().equalsIgnoreCase(text)){
                return cat;
            }
        }
        throw new RuntimeException("Categoria não encontrada");
    }
}
