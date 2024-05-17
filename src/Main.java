import java.io.*;
import java.util.*;
public class Main extends Cores{
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
        while(true){
            System.out.println("\nCrie seu personagem: \n" +
                    "Classe: \n" +
                    "1. Guerreiro \n" +
                    "2. Mago \n" +
                    "3. Ladino \n");
            int classe = s.nextInt();
            break;
        }

        carregarMapa();
    }
}