package model;

public class Coord
{

    private int col, row;

    public Coord(int col, int row)
    {
        this.col = col;
        this.row = row;
    }

    public boolean isAdjacentTo(Coord b)
    {
        return (b.getCol() <= this.getCol() + 1 && b.getCol() >= this.getCol() - 1)
                && (b.getRow() <= this.getRow() + 1 && b.getRow() >= this.getRow() - 1)
                && !super.equals(b);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (col != coord.col) return false;
        return row == coord.row;
    }

    public int getCol()
    {
        return col;
    }

    public int getRow()
    {
        return row;
    }
}
