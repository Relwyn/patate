import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program Start !");

        String mapFile = "TEST";
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("./maps/" + mapFile));
            String line = reader.readLine();
            String[] lineSplit = line.split(" ");
            int maxx = Integer.valueOf(lineSplit[0]);
            int maxy = Integer.valueOf(lineSplit[1]);
            line = reader.readLine();

            while (line != null){
                System.out.println(line);
                lineSplit = line.split(" ");
                LawnMower lawnMower = new LawnMower(Integer.valueOf(lineSplit[0]), Integer.valueOf(lineSplit[1]), maxx, maxy, lineSplit[2]);
                System.out.println(lawnMower.action(reader.readLine()));
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
