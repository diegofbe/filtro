package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Filter {

    public static void main(String[] args)
    {
        Filter filter = new Filter();
        filter.execute("resources/text.txt");
    }

    private void execute(String fileName)
    {
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            FileWriter writer = new FileWriter("output.txt");

            Scanner input = new Scanner(file);
            noFilter(input,writer);
            input = new Scanner(file);
            filterCharT(input,writer);
            input = new Scanner(file);
            filterLength(input,writer);
            input = new Scanner(file);
            filterPalin(input,writer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void noFilter(Scanner input, FileWriter writer)
    throws IOException
    {
        writer.write("Texto sin filtro\n");

        while (input.hasNextLine())
        {
            String word = input.nextLine();

            writer.write(word);
            writer.write("\n");
        }
        writer.write("\n");
    }

    private void filterCharT(Scanner input, FileWriter writer)
    throws IOException
    {
        writer.write("Palabras que empiezan con t/T\n");

        while (input.hasNextLine()) {
            String word = input.next();

            if (word.substring(0, 1).equals("t") || word.substring(0, 1).equals("T")) {
                writer.write(word);
                writer.write("\n");
            }
        }
        writer.write("\n");
    }

    private void filterLength(Scanner input, FileWriter writer)
    throws IOException
    {
        writer.write("Palabras Con 5 letras\n");

        while (input.hasNextLine()) {
            String word = input.next();

            if (word.length()==5)
            {
                writer.write(word);
                writer.write("\n");
            }
        }
        writer.write("\n");
    }

    private void filterPalin(Scanner input, FileWriter writer)
            throws IOException
    {
        writer.write("Palabras palindromos\n");

        while (input.hasNextLine()) {
            String word = input.next();

            String invert = new StringBuilder(word).reverse().toString();

            if (invert.toLowerCase().equals(word.toLowerCase()) && word.length()>2)
            {
                writer.write(word+"\n");
            }
        }
        writer.close();
    }
}
