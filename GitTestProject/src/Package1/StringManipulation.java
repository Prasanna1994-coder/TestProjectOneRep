package Package1;

public class StringManipulation {

	public static void main(String[] args) {
		String test = "He is a very very good boy, isn't he_t?";
		String[] n = test.split("[\\s!,?._'@]+");
		System.out.println(n.length);
		
		

	}

}
