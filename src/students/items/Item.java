package students.items;

public abstract class Item {
    private int age;
    private int maturationAge;
    private int deathAge;
    private int monetaryValue;

    /**
     * constructor  with no args
     */
    public Item(){

    }
    /**
     * constructor  with the maturation age, death age, and monetary value
     * @param maturationAge maturation age
     * @param deathAge death age
     * @param monetaryValue monetary value
     */
    public Item(int maturationAge, int deathAge, int monetaryValue){
        this.age=0;
        this.maturationAge=maturationAge;
        this.deathAge=deathAge;
        this.monetaryValue=monetaryValue;
    }
    /**
     * increases the age variable by 1
     */
    public void tick(){
        age++;
    }

    /**
     * sets the age of an item
     * @param age age
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * returns whether the item’s age is greater than it’s death age
     * @return true or false
     */
    public boolean died(){
        return age>deathAge;
    }

    /**
     * for food items, returns their value
     * ONLY if the item’s age is passed it’s maturation age (fully grown and ready for harvest)
     * @return monetary value
     */
    public int getValue(){
        if(age>=maturationAge&&!died()) return monetaryValue;
        return 0;
    }

    /**
     * check this Item against any other object, returning true if both objects have the same age,
     * deathAge, maturation, and monetary value.
     * @param obj other item
     * @return true or false
     */
    public boolean equals(Object obj){
        if(obj instanceof Item){
            Item item=(Item)obj;
            return age== item.age&&monetaryValue==item.monetaryValue
                    &&deathAge== item.deathAge&&maturationAge== item.maturationAge;
        }
        return false;
    }

    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     * @return string of item
     */
    public abstract String toString();
    public abstract Item clone();

    public int getMaturationAge() {
        return maturationAge;
    }

    public int getAge() {
        return age;
    }

    public void setMaturationAge(int maturationAge) {
        this.maturationAge = maturationAge;
    }

    public int getDeathAge() {
        return deathAge;
    }

    public void setDeathAge(int deathAge) {
        this.deathAge = deathAge;
    }

    public int getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(int monetaryValue) {
        this.monetaryValue = monetaryValue;
    }
}
