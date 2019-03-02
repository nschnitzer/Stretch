
public class Shape 
{
	private boolean endPiece;
	private boolean connected;
	private String type;
	
	public Shape(String t, boolean e, boolean c)
	{
		endPiece = e;
		connected = c;
		type = t;
	}
	
	public boolean isEndPiece()
	{
		return endPiece;
	}
	
	public boolean isConnected()
	{
		return connected;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String toString()
	{
		if (isEndPiece())
		{
			return "*\t";
		}
		else
		{
			return type+"\t";
		}
	}

}
