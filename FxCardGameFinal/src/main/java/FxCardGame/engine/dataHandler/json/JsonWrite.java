package FxCardGame.engine.dataHandler.json;


import FxCardGame.engine.dataHandler.recordStruct.GameRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Been Touched on 11/12/2016.
 */
public class JsonWrite {

    private GameRecord gameRecord;

    public JsonWrite(GameRecord game) {
    }


    public static void jsonSave(GameRecord gameRecord) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonRead rd = new JsonRead();
        GameRecord gr = rd.jsonRead();

        String tor;

        if(gr == null){
            System.out.println("Null");
            mapper.writeValue(new File("history.json"), gameRecord);
        }else{
            gr.add(gameRecord);
            mapper.writeValue(new File("history.json"),gr);
        }
    }
}


