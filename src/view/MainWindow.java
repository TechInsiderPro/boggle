package view;

import BreezyGUI.GBFrame;

public class MainWindow extends GBFrame
{
    private static final MainWindow instance = new MainWindow(600, 480);
    private View currentView;

    private MainWindow(int width, int height)
    {
        super();
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setCurrentView(View currentView)
    {
        if (this.currentView != null)
            this.remove(this.currentView);

        this.currentView = currentView;
        this.add(this.currentView);
    }

    public static MainWindow getInstance()
    {
        return instance;
    }
}
