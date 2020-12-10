import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Icecream[] icecreams = new Icecream[2];
        for(int i=0;i<2;i++){
            icecreams[i] = new Icecream();
            icecreams[i].initFromConsole();
            icecreams[i].writeToFile("data.txt");
        }
        System.out.println("\nReaded from file\n");
        Icecream.readFromFile("data.txt");
    }
}
