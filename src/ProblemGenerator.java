

import java.util.Scanner;

public class ProblemGenerator {
	static String problemType;
	static int addAns;
	static String addString;
	static int familyChoice;
	static int randomNum;
	//MAYBE MAKE A LIST OF POTENTIAL PROBLEMS AND CHOOSE FROM THAT LIST INSTEAD? 
	// LIST CAN HAVE PROBLEMS, AND A SECOND LIST FOR CORRESPONDING ANSWERS?
	public static int getFamilyChoice(){
		Scanner in = new Scanner(System.in);
		int familyChoice = in.nextInt();
		System.out.println("Enter a value from 1-12). This will be your number family");
		in.close();
		return familyChoice;
	}
	public String getproblemType(){
		return problemType;
	}
	
	public static String addString(int familyChoice, int randomNum){
		String addString ="" + (randomNum + familyChoice);
		return addString;
	}
	public static int getAddAns(int familyChoice, int randomNum){
		int addAns = familyChoice + randomNum;
		return addAns;
	}
		
	public static void main(String[] args) {
	int randomNum = (int )(Math.random() * 12 + 1);
	System.out.println(randomNum);
	getFamilyChoice();
	addString(familyChoice,randomNum);
	getAddAns(familyChoice,randomNum);
	System.out.println(addAns);
	System.out.println(addString);
	}

}
