package Package1;

import java.util.Arrays;

public class AnagramsTest {

	public static void main(String[] args) {
		String str0 = "Prasanna";
		char[] charArr = str0.toLowerCase().toCharArray();
		
		for(int i=0;i<charArr.length;i++) {
			for(int j=i+1;j<charArr.length;j++) {
				if(charArr[i]>charArr[j]) {
					char temp = charArr[i];
					charArr[i] = charArr[j];
					charArr[j] = temp;
				}
			}
		}
		str0 = String.valueOf(charArr);
		System.out.println(str0);
		//str0.toLowerCase()
		//System.out.println(String.valueOf(charArr).equals(anObject));
	}
}