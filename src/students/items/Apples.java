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
     * copy constructor
     * @param apples apples
     */
    public Apples(Apples apples){
        setAge(apples.getAge());
        setMaturationAge(apples.getMaturationAge());
        setDeathAge(apples.getDeathAge());
        setMonetaryValue(apples.getMonetaryValue());
    }

    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     *
     * @return string of item
     */
    @Override
    public String toString() {
        if(getAge()>=getMaturationAge()) return "A";
        return "a";
    }

    @Override
    public Item clone() {
        return new Apples(this);
    }

    /**
     * the total number of apple objects that have been instantiated
     * @return total number of grain objects
     */
    public static int getGenerationCount(){
        return count;
    }
}
