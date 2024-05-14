import java.util.*;
public class Mapa{
    protected int largura;
    protected int altura;
    ArrayList<ArrayList<Cenario>> mapa = new ArrayList<>();
    public Mapa(int l, int a){
        largura = l;
        altura = a;
        gerarMapa();
        gerarCenario(Cenario.arvore, 3, 5,7, true);
        gerarCenario(Cenario.agua, 1, 7,9, true);
        gerarCenario(Cenario.montanha, 4, 3,5, true);
    }

    public void gerarMapa(){
        for(int linha = 0; linha < altura; linha++){
            ArrayList<Cenario> linhas = new ArrayList<>();
            for (int coluna = 0; coluna < largura; coluna++) {
                linhas.add(Cenario.planice);
            }
            mapa.add(linhas);
        }

    }

    public void gerarCenario(Cenario tile, int blocos, int tamanhoMinimo, int tamanhoMaximo, boolean irregular){
        for (int i = 0; i < blocos; i++) {
            Random gerador = new Random();
            int x_inicial = 0;
            int largura2 = gerador.nextInt(tamanhoMinimo, tamanhoMaximo + 1);
            int altura2 = gerador.nextInt(tamanhoMinimo, tamanhoMaximo + 1);
            int x = gerador.nextInt(1, largura - largura2);
            int y = gerador.nextInt(1, altura - altura2);

            if(irregular){
                x_inicial = gerador.nextInt(3, largura - tamanhoMaximo + 1);
            }

            for (int j = 0; j < altura2; j++) {
                if(irregular){
                    largura2 = gerador.nextInt((int) (0.7 * tamanhoMaximo), tamanhoMaximo + 1);
                    x = x_inicial - gerador.nextInt(1, 2);
                }
                for (int k = 0; k < largura2; k++) {
                    mapa.get(y + j).set(x + k, tile);
                }

            }
        }
    }

    public void mostrarMapa(){
        //Fazer a linha de cima
        System.out.print("X");
        for (int i = 0; i < largura; i++) {
            System.out.print("=");
        }
        System.out.println("X");
        for (ArrayList<Cenario> linha : mapa) {
            System.out.print("|");
            for (Cenario c : linha) {
                System.out.print(c);
            }
            System.out.println("|");
        }
        //Fazer a linha de baixo
        System.out.print("X");
        for (int i = 0; i < largura; i++) {
            System.out.print("=");
        }
        System.out.print("X");

    }

}
