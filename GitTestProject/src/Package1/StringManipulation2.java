package Package1;

public class StringManipulation2 {

	public static void main(String[] args) {
		String s ="[Test1],[Test2],{[Test3]}";
		String[] s_arr = s.split(",");
		for(String val : s_arr) {
			System.out.println(val);
		}
	}

}
