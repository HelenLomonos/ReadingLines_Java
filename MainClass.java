package ReadingLines;
import java.io.*;
import java.util.Vector;

public class Main
{
	public static Vector<String> ReadingLinesFromTxt(String fileName, int fromLine, int numLines) throws IOException
	{
	    BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
		int i = 0;
		int j = 0;
		
        String currentLine;
        
		Vector<String> lines = new Vector<String>();
		
		while((currentLine = reader.readLine() )!= null)
		{
			if(i == fromLine - 1)
			{
				lines.add(currentLine);
				while((currentLine = reader.readLine() )!= null && j != numLines - 1)
		              {
					    lines.add(currentLine);
					    j++;
		              }
				
				break;
		    }
			i++;
		}
	    reader.close();
		return lines;
	}
	public static void main(String[] args) throws Exception 
	{
	
		try
		{
			int fromLine = Integer.valueOf(args[1]);
			int numLines = Integer.valueOf(args[2]);
			
			if(fromLine < 0 || numLines < 0)
				throw new Exception();
			
		    Vector<String> lines = ReadingLinesFromTxt(args[0], Integer.valueOf(args[1]),Integer.valueOf(args[2]) );
		
	        if(lines.size() != numLines)
			   throw new Exception();
		
		    for(String line : lines)
		    {
			  System.out.println(line);
		    }
		}
		
		catch(Exception ex)
		{
			System.out.println("Error! Wrong parameters! Restart program!");
		}
		
	}
}