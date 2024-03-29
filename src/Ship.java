public class Ship implements Cloneable{
    boolean isWreck;
    int numOfPassengers;
    int locX;
    int locY;
    BlackBox blackBox;

    public Ship(int locX, int locY, int numOfPassengers){
        this.locX = locX;
        this.locY = locY;
        this.isWreck = false;
        this.numOfPassengers = numOfPassengers;
        this.blackBox = new BlackBox();
    }

    public void expirePassenger(){
        if (numOfPassengers > 1)
            numOfPassengers--;
        else {
            isWreck = true;
            blackBox.damage = 1;
        }
    }

    // the coast guard boat can save several passengers at once, hence the integer parameter passed to the method
    public void savePassengers(int number){
        if (numOfPassengers > number){
            numOfPassengers -= number;
        }
        else {
            numOfPassengers = 0;
            isWreck = true;
            blackBox.damage = 1;
        }
    }

    public Ship clone(){
        Ship ship = new Ship(this.locX, this.locY, this.numOfPassengers);
        ship.isWreck = this.isWreck;
        ship.blackBox = this.blackBox;
        return ship;
    }
}
