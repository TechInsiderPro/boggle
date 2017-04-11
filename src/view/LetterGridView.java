package view;

import model.Coord;
import model.CoordSet;
import model.Dictionary;
import model.LetterGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LetterGridView extends View
{
    private LetterGrid letterGrid;
    private CoordSet selection;
    private Color selectionColor;
    private GridButton[][] gridButtonArray;

    LetterGridView(LetterGrid letterGrid)
    {
        this.letterGrid = letterGrid;
        selection = new CoordSet();
        selectionColor = Color.red;

        setLayout(new GridBagLayout());
        addGridButtonsToComp();
    }

    private void addGridButtonsToComp()
    {
        this.gridButtonArray = new GridButton[letterGrid.getHeight()][letterGrid.getWidth()];

        for (gbc.gridy = 0; gbc.gridy < letterGrid.getHeight(); gbc.gridy++)
            for (gbc.gridx = 0; gbc.gridx < letterGrid.getWidth(); gbc.gridx++)
            {
                GridButton button = new GridButton(letterGrid.getLetterAt(new Coord(gbc.gridx, gbc.gridy)) + "", new Coord(gbc.gridx, gbc.gridy));
                this.add(button, gbc.gridx, gbc.gridy, 1, 1);
                this.gridButtonArray[gbc.gridy][gbc.gridx] = button;
            }

        gbc.gridx++;
        gbc.gridy = 0;
        this.add(new ClearButton(), gbc);

        gbc.gridy++;
        this.add(new SubmitButton(), gbc);

        gbc.gridy++;
        this.add(new PointsLabel(), gbc);
    }

    private void clearSelection()
    {
        for (Coord coord : selection)
            this.gridButtonArray[coord.getRow()][coord.getCol()].setForeground(Color.black);

        this.selection = new CoordSet();
    }

    private boolean submitSelection()
    {
        String word = this.letterGrid.getWordAt(this.selection);
        this.clearSelection();
        return this.letterGrid.game.submitWord(word);
    }

    class GridButton extends JButton
    {

        GridButton(String text, final Coord coord)
        {
            super(text);
            this.addActionListener(new ActionListener()
            {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (!selection.add(coord) && coord.equals(selection.getLast()))
                    {
                        selection.removeLast();
                        setForeground(Color.black);
                    }

                    if (Dictionary.getInstance().contains(letterGrid.getWordAt(LetterGridView.this.selection)))
                        selectionColor = Color.green;
                    else
                        selectionColor = Color.red;

                    for (Coord tempCoord : selection)
                        gridButtonArray[tempCoord.getRow()][tempCoord.getCol()].setForeground(selectionColor);

                    System.out.println(letterGrid.getWordAt(LetterGridView.this.selection));
                    System.out.println(Dictionary.getInstance().contains(letterGrid.getWordAt(LetterGridView.this.selection)));
				}
			});
        }
    }

    class ClearButton extends JButton
    {
        ClearButton()
        {
            super("Clear");
            this.addActionListener(new ActionListener()
            {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					clearSelection();
				}
			});
        }
    }

    class SubmitButton extends JButton
    {
        SubmitButton()
        {
            super("Submit");
            this.addActionListener(new ActionListener()
            {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println(submitSelection());
				}
			});
        }
    }

    class PointsLabel extends JLabel
    {
        @Override
        public void repaint()
        {
            setText("Pt: " + LetterGridView.this.letterGrid.game.points);
        }
    }
}
