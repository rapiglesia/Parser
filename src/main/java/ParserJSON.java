import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserJSON {
    private String datestamp;
    private String level;
    private String type;
    private String detail;

    public ParserJSON() {
    }

    public static void main (String[] args) {
        File logJSON = new File("src/main/resources/log.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            HashMap<String,HashMap<String,String>> map = mapper.readValue(new File(logJSON.getAbsolutePath()), new TypeReference<HashMap<String,HashMap<String,String>>>() {});

            for(HashMap.Entry<String, HashMap<String,String>> test : map.entrySet()) {
                if (test.getValue().get("level").contentEquals("3")) {
                    System.out.println("Numero de LOG : " + test.getKey());
                    System.out.println("Date : " + test.getValue().get("datestamp"));
                    System.out.println("Level : " + test.getValue().get("level"));
                    System.out.println("Detail : " + test.getValue().get("detail"));
                    System.out.println("Type : " + test.getValue().get("type") + "\n");
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
