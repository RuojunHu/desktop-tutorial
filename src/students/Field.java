package students;


import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

public class Field {
    private Item[][] items;

    public Field(int height, int width) {
        items = new Soil[height][width];
    }

	/**
	 * each time this is called, every Item in the field must have it’s tick() function
	 * called to increase the age of each item.
	 */
	public void tick(){
		for(int i=0;i< items.length;i++){
			for(int j=0;j<items[i].length;j++){
				items[i][j].tick();
				// If an Item is Soil, 20% of the time that location will turn into a new Weed.
				if(items[i][j] instanceof Soil&&Math.random()<0.2){
					items[i][j]=new Weed();
				}
				// If an item in the field has died after ageing, it turns into UntilledSoil.
				if(items[i][j].died()){
					items[i][j]=new UntilledSoil();
				}
			}
		}
	}

	/**
	 * overridden function prints out a numbered grid with the contents of each location.
	 * @return string
	 */
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append(" ");
		for(int i=0;i< items[0].length;i++){
			sb.append(" ").append(i).append(" ");
		}
		sb.append("\n");
		for(int i=0;i< items.length;i++){
			System.out.print(i);
			for(int j=0;j< items[i].length;j++) {
				sb.append(" ").append(items[i][j].toString()).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * takes in the location in the field to till and turn into new Soil, regardless
	 * of what’s there currently.
	 * @param x row
	 * @param y column
	 */
	public void till(int x,int y){
		items[x][y]=new Soil();
	}

	/**
	 * returns a copy of the item at that location.
	 * @param x row
	 * @param y column
	 * @return a copy of item
	 */
	public Item get(int x,int y){

	}

	/**
	 * stores a given Item at a given location
	 * @param x row
	 * @param y column
	 * @param item item
	 */
	public void plant(int x, int y, Item item){
		items[x][y]=item;
	}

	/**
	 * returns the total monetary value of each item in the field
	 * @return total monetary value
	 */
	public int getValue(){
		int sum=0;
		for(int i=0;i< items.length;i++){
			for(int j=0;j<items[i].length;j++) {
				sum+=items[i][j].getValue();
			}
		}
		return sum;
	}
}
