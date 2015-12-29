public class ArrayUtils{

    /*=========================================
      int[] cdr(int rLow, int rHigh, int[] 
      input)
      Populates an int array with random ints 
      greater than or equal to rLow and less
      than rHigh.
      =========================================*/
    public static void popInt(int rLow, int rHigh, int[] input){
	//rLow is the inclusive lower limit for an element of the array
	//rHigh is the exclusive lower limit for element of the array
	int rRange = rHigh - rLow;
	//this number will be multiplied onto Math.random later on
	for (int i=0; i<input.length; i++){
	    input[i]=(int)(Math.random()*rRange + rLow);
	}
    }

    /*=========================================
      int[] arrayToString(int[] input)
      String[] arrayToString(String[] input)
      Returns a Stringified version of the 
      array
      =========================================*/
    public static String arrayToString(int[] input){
	String output="{";
	for (int i : input){
	    output+= i + ", ";//int, comma, and a space inbetween
	}
	if (input.length > 0) 
	    output = output.substring(0, output.length() - 2);
	//shaves off extra comma and space
	output+="}";
	return output;
    }
    public static String arrayToString(String[] input){
	String output="{";
	for (String i : input){
	    output+= i + ", ";//String, comma, and a space inbetween
	}
	if (input.length > 0) 
	    output = output.substring(0, output.length() - 2);
	//shaves off extra comma and space
	output+="}";
	return output;
    }

    /*=========================================
      int[] cdr(int[] input)
      String[] cdr(String[] input)
      Returns an array which is the cdr of the
      cdr section of the array input (in 
      scheme terms)
      =========================================*/
    public static int[] cdr(int[] input){
	
	int[] output = new int[input.length-1];
	
	for (int i = 1; i < input.length; i++){
	    output[i-1] = input[i];}
	
	return output;
    }
    public static String[] cdr(String[] input){
	
	String[] output = new String[input.length-1];
	
	for (int i = 1; i < input.length; i++){
	    output[i-1] = input[i];}
	
	return output;
    }


    /*=========================================
      int linSearch( int[] input, int target )
      String linSearch(String[] input, String target)
      returns the index of the first occurrence 
      of a target in an existing array, or -1 
      if not found, uses an iterative construction.
      =========================================*/
    public static int linSearch( int[] input, int target ){
	
	int output = -1;
	
	for (int i = 0; i < input.length && output == -1; i++){
	    //while not all elements of the array have been checked
	    //and the target has not yet been found
	    if (input[i] == target)
		output = i;//set the output to i if that element is the target
	}
	
	return output;
    }
    public static int linSearch( String[] input, String target ){
	
	int output = -1;
	
	for (int i = 0; i < input.length && output == -1; i++){
	    if (input[i].equals (target))
		output = i;
	}
	
	return output;
    }

  /*=========================================
      int linSearchR( int[] input, int target )
      int linSearchR( String[] input, String target)
      returns the index of the first occurrence 
      of a target in an existing array, or -1 
      if not found, 
      uses a recursive construction.
      =========================================*/

    public static int linSearchR( int[] input, int target ){

	if (freq(input, target)==0)
	    //I originally had if length of a == 0
	    //However this results in the output 
	    //being 1 less than the length rather than -1
	    //when the target is not in array input
	    return -1;

	if (input[0] == target)
	    return 0;

	return 1 + linSearchR(cdr(input), target);	  
}

 public static int linSearchR( String[] input, String target ){

	if (freq(input, target)==0)
	    //I originally had if length of a == 0
	    //However this results in the output 
	    //being 1 less than the length rather than -1
	    //when the target is not in array input
	    return -1;

	if (input[0].equals(target))
	    return 0;

	return 1 + linSearchR(cdr(input), target);	  
}

   /*========================================
      int freq( int[] input, int target )
      int freq(String[] input, String target)
      return the number of occurrences of a 
      target in an existing array
      Uses an iterative construction
      =========================================*/
    public static int freq( int[] input, int target ){

	int output=0;

	for (int i = 0; i < input.length; i++){
	    if (input[i] == target)
		output+=1;
	}

	return output;
    }
    public static int freq( String[] input, String target ){

	int output=0;

	for (int i = 0; i < input.length; i++){
	    if (input[i].equals (target))
		output+=1;
	}

	return output;
    }    
    
    /*=========================================
      int freqRec( int[] input, int target )
      int freqRec( String[] input, String target)
      return the number of occurrences of a 
      target in an existing array
      uses a recursuve construction
      =========================================*/
    public static int freqRec( int[] input, int target ){

	if (input.length == 0)
	    return  0;

	if(input[0]==target)
	    return 1 + freqRec(cdr(input), target);

	return freqRec(cdr(input), target);
    }
        public static int freqRec( String[] input, String target ){

	if (input.length == 0)
	    return  0;

	if(input[0].equals(target))
	    return 1 + freqRec(cdr(input), target);

	return freqRec(cdr(input), target);
    }
    
   /*=========================================
      =========================================*/
    public static void main(String[] args){
	int[] test1 = new int[5];//creates a test array with length 5
	int[] test2 = new int[3];//creates a test array with length 3
	String[] test3 = {"a", "b", "c", "d", "d"};

	popInt(90, 100, test1);//fills test1 with integers in the range [90, 100)
	popInt(1, 5, test2);//fills test2 with integers in the range [1, 5)
	
	System.out.println("Test #1 ints in range [90, 100):");
	System.out.println(arrayToString(test1));
	System.out.println("location of 91 iterative and recursive:");
	System.out.println(linSearch(test1, 91));
	System.out.println(linSearchR(test1, 91));
	System.out.println("frequency of 91 iterative and recursive:");
	System.out.println(freq(test1, 91));
	System.out.println(freqRec(test1, 91));

	System.out.println("Test #2 ints in range [1, 5):");
	System.out.println(arrayToString(test2));
	System.out.println("location of 91 iterative and recursive:");
	System.out.println(linSearch(test2, 91));
	System.out.println(linSearchR(test2, 91));
	System.out.println("frequency of 91 iterative and recursive:");
	System.out.println(freq(test2, 91));
	System.out.println(freqRec(test2, 91));

	System.out.println("Test #3 {a, b, c, d, d}");
	System.out.println(arrayToString(test3));
	System.out.println("location of d iterative and recursive:");
	System.out.println(linSearch(test3, "d"));
	System.out.println(linSearchR(test3, "d"));
	System.out.println("location of e iterative and recursive:");
	System.out.println(linSearch(test3, "e"));
	System.out.println(linSearchR(test3, "e"));
	System.out.println("frequency of d iterative and recursive:");
	System.out.println(freq(test3, "d"));
	System.out.println(freqRec(test3, "d"));
	System.out.println("frequency of e iterative and revursive:");
	System.out.println(freq(test3, "e"));
	System.out.println(freqRec(test3, "e"));
    }
}
