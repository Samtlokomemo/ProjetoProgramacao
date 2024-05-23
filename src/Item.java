public class Item {
    protected String nome;
    protected String tipo;
    protected int dano;
    protected int preco;
    
    public Item(String nome, String tipo, int dano, int preco){
        this.nome = nome;
        this.tipo = tipo;
        this.dano = dano;
        this.preco = preco;
    }

    public static Item espada = new Item("Espada", "Físico", 5, 7);
    public static Item punhos = new Item("Punhos", "Físico", 1, 0);
    public static Item adaga = new Item("Adaga", "Físico", 3, 6);

    @Override
    public String toString() {
        return this.nome;
    }
}
