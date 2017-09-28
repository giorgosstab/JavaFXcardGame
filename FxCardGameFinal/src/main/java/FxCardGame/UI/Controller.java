package FxCardGame.UI;

import FxCardGame.engine.dataHandler.DataHandler;
import FxCardGame.engine.gameEngine.Card;
import FxCardGame.engine.gameEngine.Deck;
import FxCardGame.engine.gameEngine.Hearts.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private static Game game;
    @FXML
    Labeled heartsOnDeck, heartsOnDeck1, birthDate, birthDate1, points, points1, playerName, playerName1, playerSurname, playerSurname1, playerNickname, playerNickname1;
    @FXML
    DatePicker getBirthDate, getBirthDate1;
    @FXML
    TextField getPlayerName, getPlayerName1, getPlayerSurname, getPlayerSurname1, getPlayerNickname, getPlayerNickname1;
    @FXML
    TextArea getIntroductoryStatement, getIntroductoryStatement1, echoTab;
    @FXML
    AnchorPane scrollTab;
    @FXML
    ScrollPane scPane;
    @FXML
    HBox p1deck, p1deck1;
    @FXML
    Button dealCards, decideWinner;
    @FXML
    Pane paneDeck, paneDeck1;
    private boolean fiveCardsAreaDealt = false;
    @FXML
    RadioButton saveAsXML, saveAsJSON;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindValues();
    }

    private void bindValues() {
        playerName.textProperty().bind(getPlayerName.textProperty());
        playerName1.textProperty().bind(getPlayerName1.textProperty());
        playerNickname.textProperty().bind(getPlayerNickname.textProperty());
        playerNickname1.textProperty().bind(getPlayerNickname1.textProperty());
        playerSurname.textProperty().bind(getPlayerSurname.textProperty());
        playerSurname1.textProperty().bind(getPlayerSurname1.textProperty());
    }

    public void setDateLabel() {
        birthDate.setText(getBirthDate.getValue().toString());
    }

    public void setDateLabel1() {
        birthDate1.setText(getBirthDate1.getValue().toString());
    }


    private void echoToTab(String echo, boolean eraseHistory) {
        if(eraseHistory){
            echoTab.setText("");
        }
        echoTab.setText(echoTab.getText() + "\n" + echo);
    }

    private boolean checkIfUserIsSet(int user) {
        if (user == 1) {
            if ((!playerNickname.textProperty().get().isEmpty() || !playerName.textProperty().get().isEmpty() || !playerSurname.textProperty().get().isEmpty() || !(getBirthDate.getValue() == null) || !getIntroductoryStatement.textProperty().get().isEmpty())) {
                return true;
            }

            return false;
        } else {
            if ((!playerNickname1.textProperty().get().isEmpty() || !playerName1.textProperty().get().isEmpty() || !playerSurname1.textProperty().get().isEmpty() || !(getBirthDate1.getValue() == null) || !getIntroductoryStatement1.textProperty().get().isEmpty())) {
                return true;
            }
            return false;
        }
    }


    public void introduce(ActionEvent event) {
        String[] ii = event.getSource().toString().split("'");
        if (ii[1].contains("1")) {
            if (checkIfUserIsSet(1)) {
                echoToTab("Introductory Statement: \n" + getIntroductoryStatement.textProperty().get() + "\nMy full name is: " + playerName.textProperty().get() + " " + playerSurname.textProperty().get() + " and I'm born at " + getBirthDate.getValue().toString(), true);
            } else {
                echoToTab("User one (1), please fill in your info.", true);
            }
        } else {
            if (checkIfUserIsSet(2)) {
                echoToTab("Introductory Statement: \n" + getIntroductoryStatement1.textProperty().get() + "\nMy full name is: " + playerName1.textProperty().get() + " " + playerSurname1.textProperty().get() + " and I'm born at " + getBirthDate1.getValue().toString(), true);
            } else {
                echoToTab("User two (2), please fill in your info.", true);
            }
        }
    }

    public void introduceDealer() {
        echoToTab("Hello, I'm your dealer, I'm doing this for living.", true);
    }

    public void initializeGame() {
        if (!(checkIfUserIsSet(1) || checkIfUserIsSet(2))) {
            echoToTab("User info are not set correctly, please fill them in.", true);
        } else {
            game = new Game(1, playerName.getText(), playerName1.getText(), playerSurname.getText(), playerSurname1.getText(), playerNickname.getText(), playerNickname.getText());
            echoToTab("Game is initialized.", true);
            dealCards.setText("Deal Cards");
        }
    }

    public void showDealerDeck() {
        if (game == null) {
            echoToTab("Please initialize game first", true);
        } else {
            HBox tor = new HBox();
            tor.getChildren().addAll(getImageObjectsFromDeck(game.getGameDealer().getDeck(), 1));
            scPane.setContent(tor);
        }
    }


    public ArrayList<ImageView> getImageObjectsFromDeck(Deck deck, int size) {
        ArrayList<ImageView> c = new ArrayList<>();
        for (Card card : deck.getDeck()) {
            System.out.println(card.toString());
            ImageView image = new ImageView(new Image("img/" + card.toString() + ".png"));
            image.setFitHeight((size == 0) ? 90.0 : 110.0);
            image.setFitWidth((size == 0) ? 61.0 : image.getFitWidth());
            c.add(image);
        }
        return c;
    }

    public ArrayList<ImageView> getFiveHiddenCards() {

        ArrayList<ImageView> c = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageView im = new ImageView(new Image("img/backview.png"));
            im.setFitHeight(90.0);
            im.setFitWidth(61.0);
            c.add(im);
        }
        return c;
    }


    public void dealCards() {
        if (game == null && checkIfUserIsSet(1) && checkIfUserIsSet(2)) {
            initializeGame();
            echoToTab("Game has initialized", true);
            System.out.println("Game has initialized");
        } else if (game.getGameRunning() && fiveCardsAreaDealt == false) {
            dealHiddenCards(getFiveHiddenCards());
        }
    }

    public void showPlayerDeck(ActionEvent e) {
        String[] ii = e.getSource().toString().split("=");
        if (!ii[1].contains("1")) {
            p1deck.getChildren().clear();
            p1deck.getChildren().addAll(getImageObjectsFromDeck(game.getPlayers().get(0).getDeck(), 0));
            heartsOnDeck.setText(game.getPlayers().get(0).getHeartsOnDeck() + "");
        } else {
            p1deck1.getChildren().clear();
            p1deck1.getChildren().addAll(getImageObjectsFromDeck(game.getPlayers().get(1).getDeck(), 0));
            heartsOnDeck1.setText(game.getPlayers().get(1).getHeartsOnDeck() + "");
        }
    }

    public void decideWinner() throws JAXBException, IOException {
        game.decideWinner();
        updatePoints();
        if (game.getPlayers().get(0).getPoints() == game.getPlayers().get(1).getPoints()) {
            echoToTab("Game is tie, winners cannot be decided yet, play another round.", true);
            decideWinner.setText("Replay");
            game.endRound();
            clearGui();
        } else {
            echoToTab("Winning player is " + game.getWinner().getName() + " with " + game.getWinner().getPoints() + " points.", true);
            decideWinner.setText("New Round");
            game.endRound();
            clearGui();
        }
    }

    private void clearGui() {
        p1deck.getChildren().clear();
        p1deck1.getChildren().clear();
        fiveCardsAreaDealt = false;
        decideWinner.setText("Decide winner");
    }

    private void updatePoints() {
        points.setText(game.getPlayers().get(0).getPoints() + "");
        points1.setText(game.getPlayers().get(1).getPoints() + "");
    }

    private void dealHiddenCards(ArrayList<ImageView> fiveHiddenCards) {
        p1deck.getChildren().addAll(getFiveHiddenCards());
        p1deck1.getChildren().addAll(getFiveHiddenCards());
        game.dealToPlayers();
        if (!fiveCardsAreaDealt) {
            fiveCardsAreaDealt = true;
        }
    }

    public void saveAsXML(){
        if(saveAsJSON.isSelected()){
            DataHandler.setSaveType(DataHandler.SaveType.BOTH);
        }else{
            DataHandler.setSaveType(DataHandler.SaveType.XML);
        }
    }

    public void saveAsJSON(){
       if(saveAsXML.isSelected()){
           DataHandler.setSaveType(DataHandler.SaveType.BOTH);
       }else{
           DataHandler.setSaveType(DataHandler.SaveType.JSON);
       }
    }

    public void readHistory() throws IOException {
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                DataHandler dt = new DataHandler();
                if (dt.getSaveType() == null) {
                    echoToTab("Please select data type.", true);
                } else if (dt.getSaveType() == DataHandler.SaveType.BOTH) {
                    echoToTab("--Xml History--", false);
                    echoToTab(dt.readGame().get(0).toString(), false);
                    echoToTab("--Json History--", false);
                    echoToTab(dt.readGame().get(1).toString(), false);
                } else if (dt.getSaveType() == DataHandler.SaveType.JSON) {
                    echoToTab(dt.readGame().get(0).toString(), true);
                } else {
                    echoToTab(dt.readGame().get(0).toString(), true);
                }
            }
        });
        tr.run();
    }
}
