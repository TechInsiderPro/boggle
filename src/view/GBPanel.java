package view;

import BreezyGUI.DoubleField;
import BreezyGUI.IntegerField;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class GBPanel extends Panel
{
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    public GBPanel()
    {
        this.setLayout(this.gbl);
        this.gbc.fill = GridBagConstraints.CENTER;
        this.gbc.weightx = 100.0D;
        this.gbc.weighty = 100.0D;
        this.gbc.insets.bottom = 1;
        this.gbc.insets.left = 2;
        this.gbc.insets.right = 2;
        this.gbc.insets.top = 1;
        this.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                GBPanel.this.mouseClicked(e.getX(), e.getY());
            }

            public void mousePressed(MouseEvent e)
            {
                GBPanel.this.mousePressed(e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e)
            {
                GBPanel.this.mouseReleased(e.getX(), e.getY());
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                GBPanel.this.mouseDragged(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                GBPanel.this.mouseMoved(e.getX(), e.getY());
            }
        });
    }

    public void add(Component comp, int x, int y, int w, int h)
    {
        this.gbc.gridx = x;
        this.gbc.gridy = y;
        this.gbc.gridwidth = w;
        this.gbc.gridheight = h;
        this.gbl.setConstraints(comp, this.gbc);
        this.add(comp);
    }

    public Button addButton(String text, int x, int y, int w, int h)
    {
        this.gbc.fill = 0;
        this.gbc.anchor = 10;
        Button button = new Button(text);
        button.addActionListener(new GBPanelButtonListener());
        this.add(button, x, y, w, h);
        return button;
    }

    public Checkbox addCheckbox(String text, int x, int y, int w, int h)
    {
        this.gbc.fill = 2;
        this.gbc.anchor = 18;
        Checkbox checkbox = new Checkbox(text);
        this.add(checkbox, x, y, w, h);
        return checkbox;
    }

    public Choice addChoice(int x, int y, int w, int h)
    {
        this.gbc.fill = 0;
        this.gbc.anchor = 18;
        Choice choice = new Choice();
        this.add(choice, x, y, w, h);
        return choice;
    }

    public DoubleField addDoubleField(double initialValue, int x, int y, int w, int h)
    {
        this.gbc.fill = 2;
        this.gbc.anchor = 18;
        DoubleField var7 = new DoubleField(initialValue);
        this.add(var7, x, y, w, h);
        return var7;
    }

    public IntegerField addIntegerField(int initialValue, int x, int y, int w, int h)
    {
        this.gbc.fill = 2;
        this.gbc.anchor = 18;
        IntegerField integerField = new IntegerField(initialValue);
        this.add(integerField, x, y, w, h);
        return integerField;
    }

    public Label addLabel(String text, int x, int y, int w, int h)
    {
        this.gbc.fill = 0;
        this.gbc.anchor = 18;
        Label label = new Label(text);
        this.add(label, x, y, w, h);
        return label;
    }

    public List addList(int x, int y, int w, int h)
    {
        this.gbc.fill = 0;
        this.gbc.anchor = 18;
        List list = new List(h * 2, false);
        list.addActionListener(new GBPanelListListener());
        list.addItemListener(new GBPanelListItemListener());
        this.add(list, x, y, w, h);
        return list;
    }

    public TextArea addTextArea(String text, int x, int y, int w, int h)
    {
        this.gbc.fill = 0;
        this.gbc.anchor = 18;
        TextArea textArea = new TextArea(text, h * 2, w * 15);
        this.add(textArea, x, y, w, h);
        textArea.setFont(new Font("Courier", 0, 12));
        return textArea;
    }

    public TextField addTextField(String initialText, int x, int y, int w, int h)
    {
        this.gbc.fill = 2;
        this.gbc.anchor = 18;
        TextField textField = new TextField(initialText);
        this.add(textField, x, y, w, h);
        return textField;
    }

    public void buttonClicked(Button button)
    {
    }

    public void listDoubleClicked(List list, String var2)
    {
    }

    public void listItemSelected(List list)
    {
    }

    public void mouseClicked(int x, int y)
    {
    }

    public void mouseDragged(int x, int y)
    {
    }

    public void mouseMoved(int x, int y)
    {
    }

    public void mousePressed(int x, int y)
    {
    }

    public void mouseReleased(int x, int y)
    {
    }

    public static void pause()
    {
        System.out.print("\nHit Enter to continue: ");

        try
        {
            InputStreamReader var0 = new InputStreamReader(System.in);
            BufferedReader var1 = new BufferedReader(var0);
            var1.readLine();
        }
        catch (IOException var2)
        {
            System.exit(0);
        }
    }

    class GBPanelButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            buttonClicked((Button) e.getSource());
        }
    }

    class GBPanelListItemListener implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            List list = (List) e.getItemSelectable();
            listItemSelected(list);
        }
    }

    class GBPanelListListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listDoubleClicked((List) e.getSource(), e.getActionCommand());
        }
    }
}
