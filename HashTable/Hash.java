import java.lang.Math;
public class Hash
{
	public int hash(Object obj)
	{
		String s = obj.toString();
		int[] code = new int[s.length()];
		for (int x=0; x<s.length(); x++)
		{
			char c = s.charAt(x);
			code[x] = (int) c;
		}
		int hashCode = 0;
		for (int i=1; i < code.length; i++)
		{
			hashCode += code[i - 1] * i;
		}
		return hashCode;
	}
	
	public String getCoderName()
	{
		return "Akash Kumar";
	}
}