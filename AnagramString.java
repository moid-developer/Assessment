import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class AnagramString{
	public static void main(String[] args){
		String str1=null;
		String str2=null;
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter two String ::");
		str1=sc.next();
		str2=sc.next();
		System.out.println(str1+" "+str2);
		if(checkString(str1,str2))
			System.out.println("String is Anagram");
		else
			System.out.println("String is not Anagram");
	}
	public static Boolean checkString(String str1,String str2){
		Map<String,Integer> charMap1=new HashMap<String,Integer>();
		Map<String,Integer> charMap2=new HashMap<String,Integer>();
		Integer count=0;
		if(str1.length()!=str2.length()){
			return false;
		}
		else{
			for(int i=0;i<str1.length();i++){
				count=0;
			if(!charMap1.containsKey(str1.charAt(i))){
				for(int k=0;k<str1.length();k++){
					if(str1.charAt(i)==str1.charAt(k))
					count++;
				}
				charMap1.put(""+str1.charAt(i),count);
			}
			}//first outer loop

			for(int i=0;i<str2.length();i++){
				count=0;
				if(!charMap2.containsKey(str2.charAt(i))){
					for(int k=0;k<str2.length();k++){
						if(str2.charAt(i)==str2.charAt(k))
						count++;
					}
					charMap2.put(""+str2.charAt(i),count);
				}
			}//secound outer loop
			if(charMap1.equals(charMap2))
				return true;
			
			else
				return false;
		}//close outer else block
	}
}
