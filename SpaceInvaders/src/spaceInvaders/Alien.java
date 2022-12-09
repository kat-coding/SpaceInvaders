package spaceInvaders;

/**
 * @author Katherine Watkins
 * SDEV 301
 * This class constructs Alien objects with methods to decode the integer
 */

public class Alien {
    private short aliens;

    /**
     *
     * @param aliens is a single Alien integer for constructor
     */
    public Alien(short aliens) {
        this.aliens = aliens;
    }

    /**
     * This method will take the aliens int and using a mask will
     * create a string based on the bitwise values (X for 1, space for 0)
     *
     * @return this method returns Integer value transformed to String
     */

    public String transformShort() {
        String transformed = "";
        for (int i = 0; i < 16; i++) {
//  create mask
            int mask = 1;
            mask = mask << i;
//  get index with mask
            int result = aliens & mask;
            if (mask == result) {
                transformed += "X";
            } else {
                transformed += " ";
            }
        }
        return transformed;
    }


    @Override
    public String toString () {

        return  aliens + " = '" + this.transformShort() +"'";
    }
}
