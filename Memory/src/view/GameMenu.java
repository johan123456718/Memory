package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class GameMenu {

    public static MenuBar addMenu(MemoryController controller) {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");

        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.onNewGameSelected();
            }

        });

        MenuItem loadGame = new MenuItem("Load Game");
        loadGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Load current game
            }

        });

        MenuItem saveAndExit = new MenuItem("Save & Exit");
        saveAndExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
                // Save game
            }

        });

        fileMenu.getItems().addAll(newGame, loadGame, saveAndExit);

        Menu helpMenu = new Menu("Help");

        MenuItem gameRules = new MenuItem("Game Rules");
        gameRules.setOnAction(e -> {
            controller.showRules();
        });

        helpMenu.getItems().add(gameRules);
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

}
