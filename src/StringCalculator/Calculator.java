package StringCalculator;

public class Calculator {
	public static int counter =0;
	//Add Function
	public static int add(String text){
		
		//condition for emptyString
		if(text.equals("")){
			return 0;
		}
		else{
			
			//Condition for delimiter
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			String numList[] = splitNumbers(text, delimiter + "|\n");
			counter++;
			return sum(numList);
		}
	}

	//function to convert string to int datatype
	private static int convertToInt(String number){
		return Integer.parseInt(number);
	}

	//function to split string
	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}

	// function to check negative number, greater then 1000, and doing total
	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negativeString = "";

        for(String number : numbers){
        	
        	//logic of checking negative number
        	if(convertToInt(number) < 0){
        		if(negativeString.equals(""))
        			negativeString = number;
        		else
        			negativeString += ("," + number);
        	}
        	
        	//logic to check for 100
        	if(convertToInt(number) < 1000)
		    	total += convertToInt(number);
		}
        
        //Exception if negative function found
		if(!negativeString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
		}
		return total;
	}
	public static int GetCallCount() {
		return counter;
	}
}
