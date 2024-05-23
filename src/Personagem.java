public class Personagem {
    String nome;
    String classe;

    Item arma;
    int vidaMaxima = 100;
    int vida = vidaMaxima;

    public Personagem(String nome, String classe){
        this.nome = nome;
        this.classe = classe;
        this.arma = Item.punhos;

    }

    public void atacar(Personagem alvo){
        alvo.vida -= arma.dano;
    }
    public void trocarArma(Item armaNova){ this.arma = armaNova; }

    protected static Personagem goblin = new Personagem("Calvin", "Guerreiro");
}
