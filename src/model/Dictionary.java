package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;

public class Dictionary extends TreeSet<String>
{
    private static Dictionary instance = new Dictionary();

    private Dictionary()
    {
        try
        {
            //Words are from http://www.cs.duke.edu/courses/cps100/spring05/assign/boggle/code/bogwords.txt
            addAll(Files.readAllLines(Paths.get("./src/model/bogwords.txt"), StandardCharsets.UTF_8));
            System.out.println("words : " + this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean contains(String word)
    {
        return super.contains(word.toLowerCase());
    }

    public static Dictionary getInstance()
    {
        return instance;
    }
}