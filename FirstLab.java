import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class FirstLab {
    public static void main(String[] args)
            throws Exception {

        File file = new File("Text Files\\test.txt");

        // BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // String st;

        // while ((st = reader.readLine()) != null) {

        // System.out.println(st);
        // }
        // writer.write("hi");//delete the previous data and write.
        writer.append("wow");// write without delete previous data.
        writer.close();
    }
}
