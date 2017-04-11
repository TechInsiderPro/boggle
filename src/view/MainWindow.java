package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{
    private static final MainWindow instance = new MainWindow(600, 480);
    private JPanel currentView;

    private MainWindow(int width, int height)
    {
        super();
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setCurrentView(JPanel currentView)
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
