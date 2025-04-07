package students.items;

public class UntilledSoil extends Item{
    /**
     * contractor with no args
     */
    public UntilledSoil(){
        //UntilledSoil are items that have an infinite maturation and death age, and -1 value
        super(Integer.MAX_VALUE,Integer.MAX_VALUE,-1);
    }

    /**
     * copy constructor
     * @param untilledSoil untilledSoil
     */
    public UntilledSoil(UntilledSoil untilledSoil){
        setAge(untilledSoil.getAge());
        setMaturationAge(untilledSoil.getMaturationAge());
        setDeathAge(untilledSoil.getDeathAge());
        setMonetaryValue(untilledSoil.getMonetaryValue());
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
     *
     * @return string of item
     */
    @Override
    public String toString() {
        return "/";
    }

    @Override
    public Item clone() {
        return new UntilledSoil(this);
    }
}
