package StringPackage;

public class StringClass1 {

	public static void main(String[] args) {
		//Method1
		String s1 = "$12";
		String s2 = "$13";
		String s1_Sub = s1.substring(1);
		String s2_Sub = s2.substring(1);
		
		int total = Integer.valueOf(s1_Sub)+Integer.valueOf(s2_Sub);
		
		System.out.println("$"+total);
		//Method2
		String[] s1_sec = s1.split("[^\\d]+");
		String[] s2_sec = s2.split("[^\\d]+");
		int total1 = Integer.valueOf(s1_sec[1])+Integer.valueOf(s2_sec[1]);
		System.out.println("$"+total1);
/*		for(String v : s1_sec) {
			System.out.println(v);
		}*/

	}

}
