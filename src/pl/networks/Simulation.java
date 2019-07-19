package pl.networks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation
{
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<U1> U1Rockets = new ArrayList<U1>();
    private ArrayList<U2> U2Rockets = new ArrayList<U2>();

    public void loadItems(String phase)
    {
        File file = new File(phase+".txt");
        Scanner scanner;
        String name = "";
        int weight = 0;
        try
        {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String temp[] = scanner.nextLine().split("=");
                name = temp[0];
                weight = Integer.parseInt(temp[1]);
                items.add(new Item(name,weight));
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public void loadU1(ArrayList<Item> items)
    {
        U1 newRocket = new U1();

        while (!items.isEmpty())
        {
            
        }
    }
}
