package banking;



import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	private static String promptString = ">> ";
	private static String box = "¤";
	private static int standardDelay = 1;
	private static Scanner in = new Scanner(System.in);

	public static void printWelcome() {
		String[] welcomeMessage = {
				" __      __     _                        _          ___              _    _              ___            _               ",
				" \\ \\    / /___ | | __  ___  _ __   ___  | |_  ___  | _ ) __ _  _ _  | |__(_) _ _   __ _ / __| _  _  ___| |_  ___  _ __  ",
				"  \\ \\/\\/ // -_)| |/ _|/ _ \\| '  \\ / -_) |  _|/ _ \\ | _ \\/ _` || ' \\ | / /| || ' \\ / _` |\\__ \\| || |(_-<|  _|/ -_)| '  \\ ",
				"   \\_/\\_/ \\___||_|\\__|\\___/|_|_|_|\\___|  \\__|\\___/ |___/\\__,_||_||_||_\\_\\|_||_||_|\\__, ||___/ \\_, |/__/ \\__|\\___||_|_|_|",
				"                                                                                  |___/       |__/                      " };
		for (int x = 0; x < welcomeMessage.length; x++){
			for(int y=0;y<welcomeMessage[x].length();y++){
				printRed(welcomeMessage[x].charAt(y)+"");
			}
			println();
		}
			
		for (int x = 0; x < welcomeMessage[3].length(); x++){
			printRed("-");
		}
		
		println();
	}

	public static void printPrompt() {
		System.out.print(promptString);
	}

	public static String getInput(ArrayList<String> allowed) {
		allowed.add("quit");
		String input = "";
		do {
			printPrompt();
			input = in.nextLine();
			if(!allowed.contains(input))
				println("Not an allowed input!");
		} while (!allowed.contains(input));
		return input;
	}
	public static String getInput() {
		printPrompt();
		String input = in.nextLine();
		return input;
	}
	public static int getIntInput(int lowerBound, int upperBound) {
		String input = "";
		do {
			printPrompt();
			input = in.nextLine();
			if(!isDigit(input) || Integer.parseInt(input) > upperBound
				 || Integer.parseInt(input) < lowerBound ){
				println("Not an allowed input");
			}
		} while (!isDigit(input) || Integer.parseInt(input) > upperBound
				|| Integer.parseInt(input) < lowerBound);
		return Integer.parseInt(input);
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	private static boolean isDigit(String s) {
		if (s.length() == 0)
			return false;
		for (int x = 0; x < s.length(); x++) {
			if(x == 0 && s.charAt(x) == '-')
				continue;
			if (!Character.isDigit(s.charAt(x))) {
				return false;
			}
		}
		return true;
	}

	public static void printHeader(String s) {
		s = box + "     " + s + "     " + box;
		printLine(box, s.length());
		println(s);
		printLine(box, s.length());
	}

	public static void printLine(String sign, int times) {
		for (int x = 0; x < times; x++){
			print(sign);
		}
		println();
	}
	
	public static void printRed(String s){
		sleep(standardDelay);
		for(int x=0;x<s.length();x++){
			System.err.print(s.charAt(x));
			sleep(standardDelay);
		}
	}

	public static void print(String s) {
		for(int x=0;x<s.length();x++){
			System.out.print(s.charAt(x));
			sleep(standardDelay);
		}
		
	}

	public static void println(String s) {
		for(int x=0;x<s.length();x++){
			System.out.print(s.charAt(x));
			sleep(standardDelay);
		}
		System.out.println();
	}

	public static void println() {
		System.out.println();
	}

	
	public static Double parsD(String s){
		return Double.parseDouble(s);
	}

	

}
