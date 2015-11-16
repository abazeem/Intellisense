package Demo;
import java.util.ArrayList;


public class TestTries {

	public ArrayList<String> getList(String str, Tries trie)
	{
		boolean flag = false;
		char a = str.charAt(0);
		if (Character.isUpperCase(a))
			flag = true;
		ArrayList<String> list = new ArrayList<String>();
		list = trie.intellisense(str, flag);
		return list;
	}
	
}
