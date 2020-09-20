package co.edu.unbosque.model.persistence;
import java.io.*;
public class Archivos {

    public String read() throws IOException{
        File f = new File("C:\\shared\\sysfiles\\Fragen.sabelotodo"); //Corregir
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        var line = "";
        var pastLine = br.readLine();
        while(pastLine != null) {
            line += pastLine+"\n";
            pastLine = br.readLine();
        }
        return line;
    }
}
