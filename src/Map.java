import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Map {
    private static ArrayList<Room> rooms = new ArrayList<>();

    private static ArrayList<Monster> monsters = new ArrayList<>();

    private static ArrayList<Puzzle> puzzles = new ArrayList<>();

    private static ArrayList<Items> items = new ArrayList<>();

    /**
     * Method: getRooms()
     * @return rooms
     */
    public static ArrayList<Room> getRooms()
    {
        return rooms;
    }
    /**
     *Method addrooms()
     * adds to arrayList of rooms
     * @param r
     */
    public static void addrooms(Room r)
    {
        rooms.add(r);
    }
    public  void getRoom(int direction)
    {
        if(direction == 0 )
        {
            System.out.println("Sorry there's a wall there try again.");
        }
        else {

            if(rooms.get(direction - 1).getHasVisted())
            {
                System.out.println("You been here before");
            }
            if(direction == (rooms.get(direction - 1 ).getRoomID()))
            {
                Player.setCurrentLocation(direction - 1);
            }
        }
    }

    public static ArrayList<Puzzle> getPuzzles(){
        return puzzles;
    }
    /**
     * Method addPuzzles()
     * adds to arrayList of puzzles
     * @param p
     */
    public static void addPuzzles(Puzzle p){
        puzzles.add(p);
    }
    /**
     * Method removePuzzles
     * removes puzzles from map
     * @param p
     */
    public  void removePuzzle(Puzzle p )
    {
        puzzles.remove(p);
    }

    /**
     * Method getItems()
     * @return items
     */
    public static ArrayList<Items> getItems(){
        return items;
    }


    public static void setItems(ArrayList<Items> items) {
        Map.items = items;
    }
    /**
     * Method addItems()
     * adds items to ArrayList of Items
     * @param i
     */
    public static void addItems(Items i){
        items.add(i);
    }

    public static ArrayList<Monster> getMonsters(){
        return monsters;
    }
    public static void addMonster(Monster m){ monsters.add(m);}

    public static void removeMonster(Monster m){monsters.remove(m);}

    public static void randomizeItems(ArrayList<Items> i) {
        int count = 0;
        Random rInt = new Random();
        int ran = i.size();
        int[] deadNums = new int[ran];
        for(Room r:rooms){
            if(r.getHasItem()!=0){
                int p;
                do{
                    p = rInt.nextInt(ran);
                    //System.out.println(p);
                }
                while (Arrays.asList(deadNums).contains(p));
                //System.out.println("Here1");
                deadNums[count] = p;
                //System.out.println("Here");
                System.out.println(i.get(p).getItemName());
                r.setItem(i.get(p));
                count++;
            }
        }
    }

    public static void randomizePuzzles(ArrayList<Puzzle> p){
        //System.out.println("test");
        int count = 0;
        Random rInt = new Random();
        int ran = p.size();
        int[] deadNums = new int[ran];
        for(Room r:rooms){
            if(r.getHasPuzzle()!=0){
                int i;
                do{
                    i = rInt.nextInt(ran);
                    //System.out.println(i);
                }while (Arrays.asList(deadNums).contains(i));
                deadNums[count] = i;
                r.setPuzzle(p.get(i));
                count++;
                //System.out.println(count);
            }
            //System.out.println("test2");
        }
    }

}
