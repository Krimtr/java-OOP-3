package pl.networks;

import java.util.Random;

public class Rocket implements SpaceShip {

    private int cost;
    private int weight;
    private int maxWeight;
    private float launchCrash;
    private float landCrash;



    public Rocket(int cost, int weight, int maxWeight, float launchCrash, float landCrash)
    {
        this.cost = cost;
        this.weight = weight * 1000;
        this.maxWeight = maxWeight * 1000;
        this.launchCrash = launchCrash;
        this.landCrash = landCrash;
    }

    @Override
    public boolean launchLand(float chance) {
        Random rand = new Random();
        float diceRoll = rand.nextFloat() * 100;
        float failChance = chance * (this.getWeight() / this.getMaxWeight());
        if (diceRoll > failChance)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean canCarry(Item item) {
        int weightLeft = this.maxWeight - this.weight;
        if (weightLeft >= item.getWeight())
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

    @Override
    public void carry(Item item) {
        this.weight += item.getWeight();
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getCost()
    {
        return cost;
    }

    public int getMaxWeight()
    {
        return maxWeight;
    }

    public float getLaunchCrash()
    {
        return launchCrash;
    }

    public float getLandCrash()
    {
        return landCrash;
    }
}
