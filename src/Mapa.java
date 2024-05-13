import java.util.*;
public class Mapa {
    protected int largura;
    protected int altura;
    ArrayList<ArrayList<String>> mapa = new ArrayList<ArrayList<String>>();
    public Mapa(int l, int a){
        largura = l;
        altura = a;
        gerarMapa();
    }

    public void gerarMapa(){
        for(int linha = 0; linha < altura; linha++){
            ArrayList<String> linhas = new ArrayList<String>();
            for (int coluna = 0; coluna < largura; coluna++) {
                linhas.add(".");
            }
            mapa.add(linhas);
        }

    }

    public void mostrarMapa(){
        //Fazer a linha de cima
        System.out.print("X");
        for (int i = 0; i < largura; i++) {
            System.out.print("=");
        }
        System.out.println("X");
        //Solução do meu mano
        for (ArrayList<String> linha : mapa) {
            System.out.print("|");
            for (String caractere : linha) {
                System.out.print(caractere);
            }
            System.out.println("|");
        }
        /*
        //Fazer a vertical
        Iterator it = mapa.iterator();
        while (it.hasNext()){
            System.out.println("|" + it.next() + "|");
        }
         */
        //Fazer a linha de baixo
        System.out.print("X");
        for (int i = 0; i < largura; i++) {
            System.out.print("=");
        }
        System.out.print("X");

    }
}
