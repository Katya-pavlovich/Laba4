import java.io.*;

public class Icecream {
    private String name;
    private float percent;
    private boolean isChocolate;


    public Icecream(){}

    public Icecream(String name){
        this.name = name;
    }

    public Icecream(String name, float percent, boolean isChocolate){
        this.name = name;
        this.percent = percent;
        this.isChocolate = isChocolate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }
    public void initFromConsole() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "Utf8"));
        System.out.println("Название");
        setName(reader.readLine());

        System.out.println("Жирность");
        setPercent(Float.parseFloat(reader.readLine()));

        System.out.println("Содержит шоколад?");
        String isChocolate = reader.readLine();

        if("Да".equals(isChocolate)){
           setChocolate(true);
        }
        else if("Нет".equals(isChocolate)){
            setChocolate(false);
        }
        else System.out.println("Error");

    }
    public String printData() {
        return "Название - " + getName() + '\n'
                + "Жирность - " + getPercent() + "%\n" + "Содержит шоколад - " + isChocolate() + '\n';
    }

    public static float averagePercent(Icecream[] icecreams){
        float averagePercent = 0;
        for(int i = 0;i<icecreams.length; i++) {
            averagePercent = averagePercent + icecreams[i].percent;
        }
        averagePercent= averagePercent/icecreams.length;
        return averagePercent;
    }

    public static int count(Icecream[] icecreams){
        int count = 0;
        for(int i=0; i<icecreams.length; i++){
            if(icecreams[i].isChocolate){
                count++;
            }
        }
        return count;
    }

    public void writeToFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file, true);
        writer.append(printData());
        writer.flush();
        writer.close();
    }

    public static void readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        int flag;
        char[] buffer = new char[1];
        FileReader reader = new FileReader(file);
        do {
            flag = reader.read(buffer);
            System.out.print(buffer[0]);
        }while (flag == 1);
        reader.close();
    }
}
