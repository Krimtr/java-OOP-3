package pl.networks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
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
        int loadedItems;
        Iterator iterator = items.iterator();
        while (!items.isEmpty())
        {
            loadedItems = 0;
            while (iterator.hasNext())
            {
                Item item = (Item) iterator.next();
                if(newRocket.canCarry(item))
                {
                    newRocket.carry(item);
                    //items.remove(item);
                    iterator.remove();
                    loadedItems++;
                }
            }
            // If no items is loaded rocket is full
            if (loadedItems < 1)
            {
                loadU1(items);
            }

        }
        U1Rockets.add(newRocket);
    }

    public void loadU2(ArrayList<Item> items)
    {
        U2 newRocket = new U2();
        int loadedItems;
        Iterator iterator = items.iterator();
        while (!items.isEmpty())
        {
            loadedItems = 0;
            while (iterator.hasNext())
            {
                Item item = (Item) iterator.next();
                if(newRocket.canCarry(item))
                {
                    newRocket.carry(item);
                    //items.remove(item);
                    iterator.remove();
                    loadedItems++;
                }
            }
            // If no items is loaded rocket is full
            if (loadedItems < 1)
            {
                loadU2(items);
            }

        }
        U2Rockets.add(newRocket);
    }

    public String runSimulation()
    {
        int U1TotalCost = 0;
        int U2TotalCost = 0;
        int U1RocketsUsed = 0;
        int U2RocketsUsed = 0;
        String result;

        for (U1 rocket: this.U1Rockets)
        {
            do
            {
                U1TotalCost += rocket.getCost();
                U1RocketsUsed++;
            }while (!rocket.launchLand(rocket.getLaunchCrash()) || !rocket.launchLand(rocket.getLandCrash()));
        }

        for (U2 rocket: this.U2Rockets)
        {
            do
            {
                U2TotalCost += rocket.getCost();
                U2RocketsUsed++;
            }while (!rocket.launchLand(rocket.getLaunchCrash()) || !rocket.launchLand(rocket.getLandCrash()));
        }

        result = "Simulation results:\n" +
                "U1 rockets total cost: " + U1TotalCost + "\nU1 rockets used: " + U1RocketsUsed + "\nMinimum U1 rockets needed: " + this.U1Rockets.size() +
                "\nU2 rockets total cost: " + U2TotalCost + "\nU2 rockets used: " + U2RocketsUsed + "\nMinimum U2 rockets needed: " + this.U2Rockets.size();
        return result;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }

    public ArrayList<U1> getU1Rockets()
    {
        return U1Rockets;
    }

    public ArrayList<U2> getU2Rockets()
    {
        return U2Rockets;
    }
}
