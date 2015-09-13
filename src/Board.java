
public class Board {

	public Board(){
		
	}
	private String[] coordinates = {"a1","a2","a3","b1","b2","b3","c1","c2","c3"};
	//private String[] coordinates = {"X ","O ","X ","O ","X ","O ","O ","c2","O "};
	
	public void printBoard(){
		System.out.println(" ____ ____ ____ \n");
		System.out.println("| "+getValue(0,0)+" | "+getValue(1,0)+" | "+getValue(2,0)+" |");
		System.out.println(" ____ ____ ____\n");
		System.out.println("| "+getValue(0,1)+" | "+getValue(1,1)+" | "+getValue(2,1)+" |");
		System.out.println(" ____ ____ ____\n");
		System.out.println("| "+getValue(0,2)+" | "+getValue(1,2)+" | "+getValue(2,2)+" |");
		System.out.println(" ____ ____ ____\n\n");
	}//ends createBoard method

	public String getValue(int x, int y) {
		return coordinates[y*3+x];
	}

	public void setValue(int x, int y,String value) {
	
		coordinates[y*3+x]=value;
	}
	
}
