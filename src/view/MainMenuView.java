package view;

import model.Game;

import java.awt.*;

public class MainMenuView extends View
{
    private Button playButton;
    private IntegerField gameDurationField, gameWidthField, gameHeightField;

    public MainMenuView()
    {
        this.addLabel("Boggle", 0, 0, 4, 1);
        this.gameWidthField = addIntegerField(4, 1, 1, 1, 1);
        this.gameHeightField = addIntegerField(4, 2, 1, 1, 1);
        this.gameDurationField = addIntegerField(100000, 3, 1, 1, 1);
        this.playButton = addButton("Text", 1, 2, 1, 1);
    }

    @Override
    public void buttonClicked(Button button)
    {
        if (button.equals(playButton))
            MainWindow.getInstance().setCurrentView(new GameView(new Game(gameDurationField.getNumber(), gameWidthField.getNumber(), gameHeightField.getNumber())));
    }
}
