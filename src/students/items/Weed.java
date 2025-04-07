package students.items;

public class Weed extends Item{
    /**
     * contractor with no args
     */
    public Weed(){
        //Weeds are items that have an infinite maturation and death age, and -1 value
        super(Integer.MAX_VALUE,Integer.MAX_VALUE,-1);
    }
    /**
     * copy constructor
     * @param weed weed
     */
    public Weed(Weed weed){
        setAge(weed.getAge());
        setMaturationAge(weed.getMaturationAge());
        setDeathAge(weed.getDeathAge());
        setMonetaryValue(weed.getMonetaryValue());
    }
    /**
     * override the function make it never die
     */
    public void tick(){
        // They can never die, so , the age always is 0
        setAge(0);
    }
    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     * @return string of item
     */
    @Override
    public String toString() {
        return "#";
    }

    @Override
    public Item clone() {
        return new Weed(this);
    }
}
