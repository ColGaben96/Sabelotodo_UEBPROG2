package co.edu.unbosque.model.persistence;
import java.io.*;

/**
 * @author Gabriel Blanco
 * @version 1.0
 */
public class Archivos {
    /**
     * <h1>Description:</h1><br>
     *     <p>Method to read the file</p>
     * @author Gabriel Blanco
     * @return
     * @throws IOException
     */
    public String read() throws IOException{
        File f = new File("./sysfiles/Fragen.sabelotodo");
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
