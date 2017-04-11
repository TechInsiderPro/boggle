package view;

import BreezyGUI.GBFrame;

/**
 * Created by Programming on 4/3/2017.
 */
public class GameWindow extends GBFrame
{
    private static final GameWindow instance = new GameWindow(600, 480);
    private JPanel currentView;

    private GameWindow(int width, int height)
    {
        super();
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel getCurrentView()
    {
        return currentView;
    }

    public void setCurrentView(JPanel currentView)
    {
        this.currentView = currentView;
    }

    public static GameWindow getInstance()
    {
        return instance;
    }
}
