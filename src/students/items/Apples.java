package students.items;

public class Apples extends Food{
    private static int count=0;
    /**
     * Its maturation time is 3, death age is 5, and monetary value is 3
     */
    public Apples(){
        count++; // generate a grain, then count+1
        setMaturationAge(3);
        setAge(0);
        setMonetaryValue(3);
        setDeathAge(5);
    }
    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     *
     * @return string of item
     */
    @Override
    public String toString() {
        return null;
    }
    /**
     * the total number of apple objects that have been instantiated
     * @return total number of grain objects
     */
    public static int getGenerationCount(){
        return count;
    }
}
