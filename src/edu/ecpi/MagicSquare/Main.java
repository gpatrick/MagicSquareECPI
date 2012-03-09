package edu.ecpi.MagicSquare;

public class Main {
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Usage: magicSquare n");
			System.exit(1);
		}
		
		Square s = new Square(Integer.parseInt(args[0]));
		s.compute();
		System.out.println("S = \n" + s);
	}
}
