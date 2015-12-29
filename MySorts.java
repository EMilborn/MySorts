/*======================================
  Elias Milborn
  APCS1 pd10
  HW53 -- <n/a>
  2015-01-04   
  class MySorts -- implements various sorting algorithms
  ======================================*/

import java.util.ArrayList;

public class mySorts {
    
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    
    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	
	for (int pass = 0; pass < data.size(); pass++){//for each pass
	    for (int trav = data.size() - 2; trav >= pass; trav--){//for each check
		if (data.get(trav).compareTo(data.get(trav+1)) == 1){
		    data.set(trav, data.set(trav + 1, data.get(trav)));
		}
	    } 
	}
	
    }//end bubbleSortV -- O(n^2)
    
    
    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	ArrayList <Comparable> output = new ArrayList<Comparable>();
	
	for (Comparable a : input){
	    output.add(a);
	}
	
	bubbleSortV(output);
	
	return output;
    }//end bubbleSort -- O(n^2)
    
    public static void selectionSortV( ArrayList<Comparable> data ) {
	for (int p = 0; p < data.size() - 1; p++){//for each index (except the last)
	    
	    int low = p;//index of lowest unsorted number
	    
	    for (int s = p + 1; s < data.size(); s++){//cycles through each index to find the lowest
		if (data.get(low).compareTo(data.get(s)) == 1){//if the comparable at s is lower than the current low
		    low = s;
		}
	    }
	    
	    data.set(p, data.set(low, data.get(p)));//swaps comparable at p with the lowest unsorted comparable	    
	}
	
    }//end selectionSort -- O(n^2)
    
    
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	
	ArrayList<Comparable> output = new ArrayList<Comparable>();//creates variable output with the contents of input
	for (Comparable a : input){
	    output.add(a);
	}
	
	selectionSortV(output);//sorts the output
	
	return output;//returns output
	
    }//end selectionSort -- O(n^2)
    
    public static boolean isSorted( ArrayList<Comparable> data ) {
	
	boolean retBool = true;//assumes data is sorted because its a lot easier to prove that its not than it is

	for (int i = 0; i < data.size() - 1 && retBool; i++){//stops once it gets to the end or it has been proved that it is not sorted
	    if ((data.get(i).compareTo(data.get(i + 1))) == 1)
		retBool = false;
	}

	return retBool;

    }
    
    public static void bogoSortV( ArrayList<Comparable> data ) {

	while (!isSorted(data)){//while data isn't sorted
	    shuffle(data);//shuffle it
	}

    }//end bogoSort -- O(n!)
    
    
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input ) {
	ArrayList<Comparable> output = new ArrayList<Comparable>();//creates variable output with the contents of input
	for (Comparable a : input){
	    output.add(a);
	}
	
	bogoSortV(output);//sorts the output
	
	return output;//returns output
    }//end selectionSort -- O(n!)

    //main method for testing
    public static void main( String [] args ) {

    }//end main
    
}//end class SelectionSort

