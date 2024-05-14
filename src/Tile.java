public class Tile extends Cores{
    protected String simbolo;
    protected String cor;
    protected boolean colorido;

    public Tile(String s, String c, boolean co){
        cor = c;
        colorido = co;
        if(colorido){
            simbolo = cor + s + RESET;
        }else{
            simbolo = s;
        }
    }
    protected static Tile planice = new Tile(".", Cores.AMARELO, true);
    protected static Tile arvore = new Tile("Y", Cores.VERDE_INTENSO, true);
    protected static Tile agua = new Tile("~", Cores.AZUL_NEGRITO_INTENSO, true);
    protected static Tile montanha = new Tile("A", Cores.BRANCO_NEGRITO_INTENSO, true);

    @Override
    public String toString() {
        return simbolo;
    }
}
