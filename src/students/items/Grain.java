package students.items;

public class Grain extends Food{
    private static int count=0;
    /**
     * Its maturation time is 2, death age is 6, and monetary value is 2
     */
    public Grain(){
        count++; // generate a grain, then count+1
        setAge(0);
        setMaturationAge(2);
        setDeathAge(6);
        setMonetaryValue(2);
    }

    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     * @return string of item
     */
    @Override
    public String toString() {
        if(getAge()>=getMaturationAge()) return "A";
        return "a";
    }

    /**
     * the total number of grain objects that have been instantiated
     * @return total number of grain objects
     */
    public static int getGenerationCount(){
        return count;
    }
}
