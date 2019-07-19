package pl.networks;

public interface SpaceShip {
    boolean launchLand(float chance);

    boolean canCarry(Item item);
    void carry(Item item);
}
