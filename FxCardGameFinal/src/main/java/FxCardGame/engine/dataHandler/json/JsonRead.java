package FxCardGame.engine.dataHandler.json;

import FxCardGame.engine.dataHandler.recordStruct.GameRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Been Touched on 11/12/2016.
 */

public class JsonRead {

    public JsonRead() {
    }

    public GameRecord jsonRead() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        GameRecord obj = mapper.readValue(new File("history.json"), GameRecord.class);
        return obj;
    }
}
