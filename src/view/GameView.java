package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel
{
    private Game game;
    private LetterGridView letterGridView;
    private long startTime;

    public GameView(Game game)
    {
        this.game = game;
        letterGridView = new LetterGridView(game.letterGrid);
        startTime = System.currentTimeMillis();

        setLayout(new BorderLayout());
        add(letterGridView, BorderLayout.CENTER);
    }

    public void update()
    {
        if(System.currentTimeMillis() - startTime >= game.duration)
        {

        }
    }
}
