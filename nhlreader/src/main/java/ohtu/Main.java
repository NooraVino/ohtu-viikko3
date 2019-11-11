
package ohtu;
import java.time.LocalDate;
import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalTime;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );
        
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
      
        
        System.out.println("Players from FIN : " + " pvm: " +  LocalDate.now() + " aika: "  +LocalTime.now() + "\n" );
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
            
        }   
    }
  
}
