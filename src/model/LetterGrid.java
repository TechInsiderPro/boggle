package model;

public class LetterGrid
{
    public final Game game;
    public final char[][] grid;

    private double[] charDistribution =
            {
                    8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015, 6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.360, 0.150, 1.974, 0.074
            };

    public LetterGrid(Game game, int width, int height)
    {
        this.game = game;
        this.grid = new char[height][width];
        this.populateGrid();
    }

    private void populateGrid()
    {
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                this.grid[r][c] = getRandomLetter();
    }

    private char getRandomLetter()
    {
        double ranNum = Math.random() * 100;
        double currTotal = 0;
        for (int i = 0; i < this.charDistribution.length; i++)
        {
            currTotal += this.charDistribution[i];
            if (ranNum <= currTotal)
                return (char) (i + 65);
        }

        return '?';
    }

    public char getLetterAt(Coord coord)
    {
        return grid[coord.getRow()][coord.getCol()];
    }

    public String getWordAt(CoordSet coordSet)
    {
        String word = "";
        for (Coord coord : coordSet)
            word += getLetterAt(coord);

        return word;
    }

    public int getWidth()
    {
        return grid.length;
    }

    public int getHeight()
    {
        return grid[0].length;
    }

    public String toString()
    {
        String desc = "";

        for (char[] row : grid)
        {
            desc += "\n";
            for (char col : row)
                desc += col + " ";
        }

        return desc;
    }
}
