package array;
public class Test{
	public static void main(String[] args){
		// Solution1_6

		String[] str =	{"This", "is", "a", "loooooooooooooooong", "string"};
		for(String s:str)
			System.out.println(s+":"+new Solution1_6().compress(s));
	}
}

