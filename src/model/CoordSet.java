package model;

import java.util.LinkedList;

public class CoordSet extends LinkedList<Coord>
{

    @Override
    public boolean add(Coord coord)
    {
        if ((size() > 0 && !coord.isAdjacentTo(getLast())) || contains(coord))
            return false;
        else
        {
            super.add(coord);
            return true;
        }
    }
}
