package apck_IO;
import java.io.*;
import java.util.Scanner;


public abstract class IO {
	
	private static BufferedReader keyb = new BufferedReader( new InputStreamReader(System.in) );
	
	//Ausgabe
	public static void writeln() {
		
		System.out.println();
	}
	
		//Zeichen(-ketten)
		//String
		public static void write(String s) {
			
			System.out.print("" + s);
		}
		
		public static void writeln(String s) {
			
			System.out.println("" + s);
		}
		
		//Char
		public static void write(char c) {
			
			System.out.print("" + c);
		}
		
		public static void writeln(char c) {
			
			System.out.println("" + c);
		}
		
		//Ganzzahlen
		//Integer
		public static void write(int i) {
			
			System.out.print("" + i);
		}
		
		public static void writeln(int i) {
			
			System.out.println("" + i);
		}
		
		//Long
		public static void write(long l) {
					
			System.out.print("" + l);
		}
				
		public static void writeln(long l) {
					
			System.out.println("" + l);
		}
		
		//Byte
		public static void write(byte b) {
			
			System.out.print("" + b);
		}
		
		public static void writeln(byte b) {
			
			System.out.println("" + b);
		}
		
		//Fließkommazahlen
		//Double
		public static void write(double d) {
			
			System.out.print("" + d);
		}
		
		public static void writeln(double d) {
			
			System.out.println("" + d);
		}
		
		//Float
		public static void write(float f) {
			
			System.out.print("" + f);
		}
		
		public static void writeln(float f) {
			
			System.out.println("" + f);
		}
		
		//Wahrheitswerte
		//Boolean
		public static void write(boolean b) {
			
			System.out.print("" + b);
		}
		
		public static void writeln(boolean b) {
			
			System.out.println("" + b);
		}
	// -------------------------------------------------------------------------
	//Eingabe
		//Zeichen(-ketten)
		//Char
		public static char promptAndReadChar(String prompt) {
					
			return promptAndReadString(prompt).charAt(0);
		}
				
		//String
			//Exception, wenn etwas inkonsistentes übergeben wird
		public static String promptAndReadString(String prompt) {
					
				write(prompt);
				try {
					return keyb.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);				
					}
		}
		
		//Ganzzahlen
		//Integer
		public static int promptAndReadInteger (String prompt) {
			
			@SuppressWarnings("resource")
			Scanner eingabe = new Scanner(System.in);
			
			write(prompt);
			return eingabe.nextInt();
		}
		
		//Long
		public static long promptAndReadLong(String prompt) {
			
			@SuppressWarnings("resource")
			Scanner eingabe = new Scanner(System.in);
			
			write(prompt);
			return eingabe.nextLong();
		}
		
		//Byte
		public static byte promptAndReadByte(byte prompt) {
			
			@SuppressWarnings("resource")
			Scanner eingabe = new Scanner(System.in);
			
			write(prompt);
			return eingabe.nextByte();
		}
		
		//Fließkommazahlen
		//Double
		public static double promptAndReadDouble(String prompt) {
					
			@SuppressWarnings("resource")
			Scanner eingabe = new Scanner(System.in);
					
			write(prompt);
			return eingabe.nextDouble();
		}
		
		//Float
		public static float promptAndReadFloat(String prompt) {
			
			@SuppressWarnings("resource")
			Scanner eingabe = new Scanner(System.in);
			write(prompt);
			return eingabe.nextFloat();
		}
		
		//Wahrheitswerte
		//Boolean
		public static boolean promptAndReadBoolean(String prompt) {
			
			return (new Boolean(promptAndReadString(prompt)).booleanValue());
		}
		
		
}
