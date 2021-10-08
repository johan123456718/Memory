package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MemoryLogic;
import model.Player;

/**
 *
 * @author user
 */
public class MemoryController {

    private MemoryLogic model;
    private MemoryView view;
    private int randomImage;

    protected MemoryController() {
        this.model = new MemoryLogic();
        this.view = new MemoryView();
        randomImage = 0;
    }

    protected MemoryController(MemoryLogic model, MemoryView view) {
        this.model = model;
        this.view = view;
    }

    protected void showRules() {
        view.showAlertInformation("Rules", "Turn over any two cards.\r\n"
                + "If the two cards match, keep them.\r\n"
                + "If they don't match, they will turn back over.\r\n"
                + "Remember what was on each card and where it was.\r\n"
                + "Watch and remember during the other player's turn.\r\n"
                + "The game is over when all the cards have been matched.\r\n"
                + "The player with the most matches wins.");
    }

    // Needs to change
    protected void onNewGameSelected() {
        model.initNewGame();
        view.resetView();
    }

    protected void onButtonPressed(Button b) {
        String fileExtension = ".png";
        String imageNr = "";
        imageNr = String.valueOf(model.getCards().get(randomImage++).getCardId());
        ImageView img = new ImageView("images/" + imageNr + fileExtension);
        img.setFitHeight(141);
        img.setFitWidth(90);
        b.setGraphic(img);
    }

    protected Player getCurrentPlayer() {
        return null;
    }

    protected void updateScores() {

    }
}
