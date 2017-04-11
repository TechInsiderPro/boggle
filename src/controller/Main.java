package controller;

import view.MainMenuView;
import view.MainWindow;

public class Main
{

    public static void main(String[] args)
    {
        MainWindow.getInstance().setCurrentView(new MainMenuView());
        MainWindow.getInstance().setVisible(true);

        Thread updateThread = new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(16);
                    MainWindow.getInstance().repaint();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        updateThread.start();
    }
}
