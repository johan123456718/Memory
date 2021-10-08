package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MemoryLogic;

public class MemoryView extends Application {

    private MemoryLogic model;
    private MemoryController controller;
    private GridPane root;
    private Button[] cardButton;
    private Label playerTurn, playerPoints;
    private Alert alertInformation;
    private Image btnImage;

    @Override
    public void start(Stage primaryStage) {
        model = new MemoryLogic();
        model.initNewGame();
        controller = new MemoryController(model, this);
        alertInformation = new Alert(AlertType.INFORMATION);
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(20, 20, 20, 20));
        createElements();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Memory Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        handleButtons();

    }

    protected void resetView() {
    }

    private void createElements() {
        HBox menuBar = new HBox();
        menuBar.setPadding(new Insets(-20, -20, -20, -20));
        menuBar.getChildren().add(GameMenu.addMenu(controller));
        root.add(menuBar, 0, 0);

        HBox[] buttonBox = new HBox[model.getSize() / 8];
        cardButton = new Button[model.getSize()];
        btnImage = new Image("images/background.png");
        for (int i = 0; i < cardButton.length; i++) {
            cardButton[i] = new Button();
            cardButton[i].setFocusTraversable(false);
            cardButton[i].setPrefSize(40, 60);
            cardButton[i].setGraphic(new ImageView(btnImage));
            cardButton[i].setId("button" + i);
        }

        int button = 0;

        for (int j = 0; j < model.getSize() / 8; j++) {
            buttonBox[j] = new HBox();
            buttonBox[j].setSpacing(10);
            for (int i = 0; i < 8; i++) {
                buttonBox[j].getChildren().add(cardButton[button++]);
            }
            root.add(buttonBox[j], 0, j + 1);
        }

        HBox playerBox = new HBox();
        HBox pointsBox = new HBox();
        playerBox.setSpacing(10);
        playerTurn = new Label();
        playerPoints = new Label();
        updatePlayers();
        updatePoints();
        playerBox.getChildren().add(playerTurn);
        pointsBox.getChildren().add(playerPoints);
        int currentRow = model.getSize() / 8 + 1;
        root.add(new Label("---------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------------"), 0, currentRow++);
        root.add(playerBox, 0, currentRow++);
        root.add(pointsBox, 0, currentRow);
    }

    protected void handleButtons() {
        for (Button b : cardButton) {
            b.setOnAction(e -> {
                controller.onButtonPressed(b);
            });
        }
    }

    protected void updatePlayers() {
        // updates the label texts for player turn to show the right player turn
        playerTurn.setText("Player turn: ");
    }

    protected void updatePoints() {
        // updates the label text for player points to show the right player points
        playerPoints.setText("Player points: ");
    }

    protected Button[] getButtons() {
        return cardButton;
    }

    protected void showAlertInformation(String title, String message) {
        alertInformation.setTitle(title);
        alertInformation.setContentText(message);
        alertInformation.setHeaderText(title);
        alertInformation.setResizable(false);
        alertInformation.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
