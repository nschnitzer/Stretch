import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StretchDriver {

	public static void main(String[] args) throws IOException 
	{
		
		Scanner scan = new Scanner(new File("src/inputs.txt"));
		StringTokenizer tokenizer = new StringTokenizer(scan.nextLine());
		Stretch s = new Stretch(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
		int startingAt = Integer.parseInt(tokenizer.nextToken());
		tokenizer.nextToken();
		while (tokenizer.hasMoreTokens())
		{
			s.setInvalid(Integer.parseInt(tokenizer.nextToken()));
		}
		
		s.addA(startingAt);
		
		//Loop through possible values
		int i = 1;
		while (i > -1)
		{
			System.out.println(s.getCursor());
			if (i % 5 == 0)
			{
				s.addA(s.getCursor());
			}
			if (i % 5 == 1)
			{
				s.addB(s.getCursor());
			}
			if (i % 5 == 2)
			{
				s.addC(s.getCursor());
			}
			if (i % 5 == 3)
			{
				s.addD(s.getCursor());
			}
			if (i % 5 == 4)
			{
				s.addE(s.getCursor());
			}
			i++;
		}
		
		
		/*
		Stretch s = new Stretch(6,10);
		//s.setInvalid(4);
		//s.setInvalid(34);
		System.out.println(s.addA(11));
		System.out.println(s.getCursor());
		s.addB(14);
		s.printValidMatrix();
		s.printMatrix();
		*/
	}

}
