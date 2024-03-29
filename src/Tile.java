package src;

public class Tile {

    // Fields

    private int row;
    private int column;
    private String token;
    private boolean availabilty = true;

    // Constructor

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Methods

    /**
     * Checks if tile is available
     * 
     * @return boolean
     */
    public boolean isAvailable() {
        return availabilty;
    }

    /**
     * Gets the x and y position of the tile
     * and returns it as an array
     * 
     * @return position [row, column]
     */
    public int[] getPosition() {
        int[] position = { this.row, this.column };
        return position;
    }

    // get token
    public String getToken() {
        return this.token;
    }

    /**
     * Checks if tile is available
     * Sets the symbol of the tile
     * Changes availabilty to false
     * 
     * @param token
     */
    public void setToken(String token) {
        if (availabilty) {
            this.token = token;
        }
    }

    // sets the tile availability to false
    public void setToOccupied() {
        this.availabilty = false;
    }

}