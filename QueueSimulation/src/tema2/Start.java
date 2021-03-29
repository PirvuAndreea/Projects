package tema2;
import java.util.*;



import java.io.*;
public class Start {

	public static void main(String[] args) throws  IOException   {
		// TODO Auto-generated method stub
		
		
		 String inFile = "in-test-3.txt";
	        String outFile = "out-test-3.txt";
	        Manager m = new Manager(inFile, outFile);
	        Thread thread = new Thread(m);
	        thread.start();
		
		
	}

}
