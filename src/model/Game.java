
package model;

import java.util.Set;
import java.util.TreeSet;

public class Game
{
    public final Set<String> usedWords;
    public final LetterGrid letterGrid;
    public final long startTime;
    public final int duration;
    public int points;

    public Game(int duration, int width, int height)
    {
        this.usedWords = new TreeSet<>();
        this.letterGrid = new LetterGrid(this, width, height);
        this.startTime = System.currentTimeMillis();
        this.duration = duration;
    }

    public boolean submitWord(String word)
    {
        if (!usedWords.contains(word) && Dictionary.getInstance().contains(word))
        {
            points += word.length() * 10;
            return usedWords.add(word);
        }

        return false;
    }
}
