import java.io.*;
import java.net.*;
import java.nio.charset.*;
import org.json.*;

public class JsonReader {
    
    public JSONObject readJsonFromUrl(String link) throws IOException, JSONException {
        InputStream input = new URL(link).openStream();
        try {                                 
          BufferedReader re = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));  
        
          String Text = Read(re);         
          JSONObject json = new JSONObject(Text);    
          return json;    
        } catch (Exception e) {
          return null;
        } finally {
          input.close();
        }
    }

    private String Read(Reader re) throws IOException {     
        StringBuilder str = new StringBuilder();     
        int temp;
        do {
    
          temp = re.read();       
          str.append((char) temp);
    
        } while (temp != -1);        
        
        return str.toString();
    
    }
}
