package students;

import students.items.Apples;
import students.items.Grain;
import students.items.Soil;
import students.items.Tomato;

import java.util.Scanner;

public class Farm {
    private int balance;
    private Field field;
    private int fieldWidth;
    private int fieldHeight;

    public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        field = new Field(fieldHeight, fieldWidth);
        balance = startingFunds;
    }

    /**
     *
     */
    private void detectThrow(int x, int y) throws Exception {
        if (x < 0 || x >= fieldHeight || y < 0 || y >= fieldWidth) {
            throw new Exception("(x,y) is not in range");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(field.toString());
            System.out.println();
            System.out.println("Bank balance: $" + balance);
            System.out.println();
            System.out.println("Enter your next action:\n" +
                    "  t x y: till\n" +
                    "  h x y: harvest\n" +
                    "  p x y: plant\n" +
                    "  s: field summary\n" +
                    "  w: wait\n" +
                    "  q: quit");
            String input = scanner.nextLine();
            String[] args = input.split("\\s+");
            if (args.length > 0) {
                if (args[0].equals("t")) {
                    try {
                        int x = Integer.parseInt(args[1])-1;
                        int y = Integer.parseInt(args[2])-1;
                        detectThrow(x, y);
                        field.till(x, y);
                    } catch (NumberFormatException e) {
                        System.out.println("enter \"t x y\", x and y is number");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (args[0].equals("h")) {
                    try {
                        int x = Integer.parseInt(args[1])-1;
                        int y = Integer.parseInt(args[2])-1;
                        detectThrow(x, y);
                        if (field.get(x, y).getValue() > 0) {
                            balance += field.get(x, y).getValue();
                        }
						field.tick();
                    } catch (NumberFormatException e) {
                        System.out.println("enter \"t x y\", x and y is number");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (args[0].equals("p")) {
                    try {
                        int x = Integer.parseInt(args[1])-1;
                        int y = Integer.parseInt(args[2])-1;
                        detectThrow(x, y);
                        if (field.get(x, y) instanceof Soil) {
                            System.out.println("Enter:\n" +
                                    " - 'a' to buy an apple for $2\n" +
                                    " - 'g' to buy grain for $1\n"+
                                    " - 't' to buy tomato for $3");
                            String bu = scanner.nextLine();
                            if (bu.equals("a")) {
                                if (balance >= 2) {
                                    field.plant(x, y, new Apples());
                                    balance -= 2;
                                } else {
                                    System.out.println("Insufficient Balance");
                                }
                            } else if (bu.equals("g")) {
                                if (balance >= 1) {
                                    field.plant(x, y, new Grain());
                                    balance -= 1;
                                } else {
                                    System.out.println("Insufficient Balance");
                                }
                            } else if (bu.equals("t")) {
                                if (balance >= 3) {
                                    field.plant(x, y, new Tomato(field.getItems()));
                                    balance -= 3;
                                } else {
                                    System.out.println("Insufficient Balance");
                                }
                            } else {
                                System.out.println("invalid command!");
                            }
                        } else {
                            System.out.println("plant a new food item must be in soil");
                        }
						field.tick();
                    } catch (NumberFormatException e) {
                        System.out.println("enter \"t x y\", x and y is number");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (args[0].equals("s")) {
                    field.tick();
                    System.out.println(field.getSummery());
                } else if (args[0].equals("w")) {
					field.tick();
                    continue;
                } else if (args[0].equals("q")){
                    break;
                }else {
					System.out.println("invalid command");
				}

            }else{
				System.out.println("invalid command");
			}
        }
    }

}
