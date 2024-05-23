import java.io.*;
import java.util.*;
public class Main extends Cores{

    public static Random dado = new Random();
    public static Scanner s = new Scanner(System.in);
    private static void carregarMapa() throws IOException {
        File mapaFile = new File("mapa.txt");
        if(!mapaFile.exists()){
            Mapa mapa1 = new Mapa(45, 15);
            FileWriter writer = new FileWriter("mapa.txt");
            writer.write("\nMAPA LEGAL\n");
            writer.write(mapa1.toString());
            writer.close();
        }else{
            FileReader reader = new FileReader("mapa.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Personagem.goblin.arma = Item.adaga;
        System.out.println("\nNome do personagem:");
        String nome = s.next();

        System.out.println("""
                Crie seu personagem:\s
                Classe:\s
                1. Guerreiro\s
                2. Mago\s
                3. Ladino\s
                """);
        int classe = s.nextInt();
        String classeString = switch (classe) {
            case 1 -> "Guerreiro";
            case 2 -> "Mago";
            case 3 -> "Ladino";
            default -> null; //Mexer nisso depois
        };
        Personagem jogador = new Personagem(nome, classeString);
        while(true) {
            carregarMapa();
            //Só pra testar se ta indo certo
            System.out.println("Olá " + jogador.nome + ",\nVida: " + jogador.vida + "\nClasse: " + jogador.classe + "\nArma: " + jogador.arma);
            System.out.println("Um golbin apareceu, ataque-o");
            boolean emCombate = true;
            while (emCombate){
                System.out.println("Sua vida: " + jogador.vida + "\nVida do goblin: " + Personagem.goblin.vida);
                System.out.println("\n\n0. Atacar \n1.Equipar Arma \n2.Fugir ");
                int acao = s.nextInt();
                switch (acao){
                    case 0 -> {
                        jogador.atacar(Personagem.goblin);
                        System.out.println("Você atacou o goblin!");
                    }
                    case 1 -> {
                        System.out.println("Você equipou uma espada");
                        jogador.trocarArma(Item.espada);
                    }
                    case 2 -> {
                        int d20 = dado.nextInt(1, 20);
                        System.out.println(d20);
                        if(d20 <= 10){
                            System.out.println("Você falhou em fugir!");
                        }else{
                            System.out.println("Você conseguiu fugir!");
                            emCombate = false;
                        }
                    }
                }
                //Ação do golbin
                if(dado.nextInt(1, 20) >= 12){
                    //Te acertou mano kkkkkkkkkkkkkkk
                    System.out.println("O goblin te acertou uma facada");
                    Personagem.goblin.atacar(jogador);
                }
                if(Personagem.goblin.vida <= 0){
                    System.out.println("O goblin morreu!");
                    emCombate = false;
                }
            }
            break;
        }


    }
}