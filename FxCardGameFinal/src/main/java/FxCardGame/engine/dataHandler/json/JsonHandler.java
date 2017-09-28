package FxCardGame.engine.dataHandler.json;

import FxCardGame.engine.dataHandler.recordStruct.GameRecord;

import java.io.IOException;

/**
 * Created by Been Touched on 11/12/2016.
 */
public class JsonHandler {
    private static GameRecord gameRecord;

    public static void saveGame(GameRecord gameRecord) throws IOException {
        JsonWrite.jsonSave(gameRecord);
    }

    public static GameRecord readGames() throws IOException {
        JsonRead js = new JsonRead();
        return js.jsonRead();
    }


}
