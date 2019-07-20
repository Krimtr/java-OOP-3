package pl.networks;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world");

        Simulation simulation1 = new Simulation();
        //Phase 1
        simulation1.loadItems("Phase1");
        simulation1.loadU1(simulation1.getItems());
        simulation1.loadItems("Phase1");
        simulation1.loadU2(simulation1.getItems());
        System.out.println(simulation1.runSimulation());

        Simulation simulation2 = new Simulation();
        //Phase 2
        simulation2.loadItems("Phase2");
        simulation2.loadU1(simulation2.getItems());
        simulation2.loadItems("Phase2");
        simulation2.loadU2(simulation2.getItems());
        System.out.println(simulation2.runSimulation());

    }
}
