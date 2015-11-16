package Demo;

import java.util.ArrayList;

public class Tries {

	int count;
	Node root;
	
	public Tries()
	{
		root = new Node();
		count = 0;
	}
	
	public void add(String keyy)
	{
		String key = keyy.toLowerCase();
		count++;
		Node curr = root;
		for(int i = 0; i<key.length(); i++)
		{
			int c;
			if ( key.charAt(i) == 32 )
				c = 26;
			else
				c = key.charAt(i) - 'a';
			if(curr.children[c] == null)
				curr.children[c] = new Node();
			curr = curr.children[c];
		}
		curr.val = count;
	}

	public ArrayList<String> intellisense( String input , boolean flag)
	{
		Node curr = root;
		input = input.toLowerCase();
		int n = input.length();
		int j = 0;
		for(int i = 0; i< n; i++)
		{
			j = input.charAt(i) - 'a';
			if(curr.children[j] == null)
				return null;
			curr = curr.children[j];	
		}
		return printutil(curr,input, new ArrayList<String>(), flag);
	}
	
	public ArrayList<String> printutil(Node x, String res, ArrayList<String> List, boolean flag)
	{
		if( x == null)
			return null;
		if( x.val != 0)
			//System.out.println(res);
		{
			if (!flag)
				List.add(res);
			else
			{
				int z =(int)res.charAt(0);
				char temp = (char) (z-32);
				String act ="";
				for(int k = 0; k<res.length(); k++)
				{
					if(k==0)
						act = act + temp;
					else
						act = act + res.charAt(k);
				}
				List.add(act);
			}
		}
			
		for( int i = 0; i< 27; i++)
		{
			String temp = null;
			if(x.children[i] != null)
			{
				temp = res;
				if(i == 26)
				{
					res = res + " ";
				}
				else
				{
					char c = (char)(i + 97);
					String temp2 = Character.toString(c);
					res+= temp2;
				}
     			List = printutil(x.children[i],res,List,flag);
			}
			if(temp!= null)
				res = temp;
		}
		return List;
	}
}

