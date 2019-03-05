import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StretchDriver {

	public static void main(String[] args) throws IOException, Exception
	{
		
		Scanner scan = new Scanner(new File("src/inputs.txt"));
		for (int k = 0; k < 5; k++)
		{
		StringTokenizer tokenizer = new StringTokenizer(scan.nextLine());
		Stretch s = new Stretch(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
		int startingAt = Integer.parseInt(tokenizer.nextToken());
	//	System.out.println(startingAt);
		tokenizer.nextToken();
		while (tokenizer.hasMoreTokens())
		{
			s.setInvalid(Integer.parseInt(tokenizer.nextToken()));
		}
		
		//Loop through possible values
		int i = 1;
		
		if (startingAt % s.cols == 0)
		{
			while (i > -1)
			{
				if (i % 5 == 0)
				{
					try {
						s.addARL(s.getCursor());
					} catch (Exception e) {
						break;
					}
				}
				if (i % 5 == 1)
				{
					try {
						s.addBRL(s.getCursor());
					} catch (Exception e) {
						break;
					}
				}
				if (i % 5 == 2)
				{
					try {
						s.addCRL(s.getCursor());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						break;
					}
				}
				if (i % 5 == 3)
				{
					try {
						s.addDRL(s.getCursor());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						break;
					}
				}
				if (i % 5 == 4)
				{
					try {
						s.addERL(s.getCursor());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						break;
					}
				}
				i++;	
			}
		}
		try {
			s.addA(startingAt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			break;
		}
		while (i > -1)
		{
			if (i % 5 == 0)
			{
				try {
					s.addA(s.getCursor());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					break;
				}
			}
			if (i % 5 == 1)
			{
				try {
					s.addB(s.getCursor());
				} catch (Exception e) {
					break;
					// TODO Auto-generated catch block
					
				}
			}
			if (i % 5 == 2)
			{
				try {
					s.addC(s.getCursor());
				} catch (Exception e) {
					break;
				}
			}
			if (i % 5 == 3)
			{
				try {
					s.addD(s.getCursor());
				} catch (Exception e) {
					break;
				}
			}
			if (i % 5 == 4)
			{
				try {
					s.addE(s.getCursor());
				} catch (Exception e) {
					break;
				}
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
}