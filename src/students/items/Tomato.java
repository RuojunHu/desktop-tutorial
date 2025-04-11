package students.items;

/**
 * This is an extension class, and if it is not harvested in time after maturity, there is a 10% probability
 * that it will affect the food items in the 8 surrounding blocks, causing them to die. Because other
 * food items dislike tomato.
 */
public class Tomato extends Food{
    private static int count=0;
    private Item[][] items;
    /**
     * increases the age variable by 1
     */
    public void tick(){
        setAge(getAge()+1);
        if(getAge()>=getMaturationAge()&&!died()){
            rot();
        }
    }
    /**
     * Its maturation time is 2, death age is 6, and monetary value is 2
     */
    public Tomato(Item[][] items){
        count++; // generate a grain, then count+1
        this.items=items;
        setAge(0);
        setMaturationAge(2);
        setDeathAge(6);
        setMonetaryValue(10);
    }
    private static final int[][] D={{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,0},{-1,-1},{-1,1}};
    /**
     * copy constructor
     * @param tomato tomato
     */
    public Tomato(Tomato tomato){
        setAge(tomato.getAge());
        setMaturationAge(tomato.getMaturationAge());
        setDeathAge(tomato.getDeathAge());
        setMonetaryValue(tomato.getMonetaryValue());
    }
    /**
     * an abstract function implemented by subclasses returning the string representation of each item.
     * @return string of item
     */
    @Override
    public String toString() {
        if(getAge()>=getMaturationAge()) return "T";
        return "t";
    }

    /**
     * if it is not harvested in time after maturity, there is a 10% probability that
     * it will affect the food items in the 8 surrounding blocks
     */
    public void rot(){

        for(int i=0;i< items.length;i++){
            for(int j=0;j<items[0].length;j++){
                if(items[i][j] instanceof Tomato){
                    for(int[] dd:D){
                        int x=i+dd[0];
                        int y=j+dd[1];
                        if(x<0||x>= items.length||y<0||y>=items[0].length) continue;
                        if(items[x][y] instanceof Food){
                            if(Math.random()<0.1){
                                items[x][y].setAge(items[x][y].getDeathAge());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Item clone() {
        return new Tomato(this);
    }
}
