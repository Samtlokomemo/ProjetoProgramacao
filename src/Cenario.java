public class Cenario extends Cores{
    protected String simbolo;
    protected String cor;
    protected boolean colorido;

    public Cenario(String s, String c, boolean co){
        cor = c;
        colorido = co;
        if(colorido){
            simbolo = cor + s + RESET;
        }else{
            simbolo = s;
        }
    }
    protected static Cenario planice = new Cenario(".", Cores.AMARELO, true);
    protected static Cenario arvore = new Cenario("Y", Cores.VERDE_INTENSO, true);
    protected static Cenario agua = new Cenario("~", Cores.AZUL_NEGRITO_INTENSO, true);
    protected static Cenario montanha = new Cenario("A", Cores.CIANO_NEGRITO_INTENSO, true);
    protected static Cenario jogador = new Cenario("O", Cores.BRANCO_NEGRITO_INTENSO, true);

    @Override
    public String toString() {
        return simbolo;
    }
}
