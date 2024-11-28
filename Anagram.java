/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
			// Tests the isAnagram function.
			System.out.println(isAnagram("silent","listen"));  // true
			System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
			System.out.println(isAnagram("Madam Curie","Radium came")); // true
			System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

			// Tests the preProcess function.
			System.out.println(preProcess("What? No way!!!"));

			
			// Tests the randomAnagram function.
			System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
			
			// Performs a stress test of randomAnagram 
			String str = "1234567";
			Boolean pass = true;
			//// 10 can be changed to much larger values, like 1000
			for (int i = 0; i < 10; i++) {
				String randomAnagram = randomAnagram(str);
				System.out.println(randomAnagram);
				pass = pass && isAnagram(str, randomAnagram);
				if (!pass) break;
			}
			System.out.println(pass ? "test passed" : "test Failed");	
	}	
		// Returns true if the two given strings are anagrams, false otherwise.
		public static boolean isAnagram(String str1, String str2) {
			str1 = preProcess(str1);
			str2 = preProcess(str2);
			if(str1.length() != str2.length())
				return false;
			else {
				boolean tofind = true;
				for(int i = 0; i < str1.length() && tofind; i++){

					tofind = false; 
					boolean removed = false;
					for (int j = 0; j < str2.length() && !removed ; j++){

						if(str1.charAt(i) == str2.charAt(j)) {
							str2 = removeLetter(str2, str1.charAt(i));
							removed = true;
							tofind = true;
						}
					}	
				}	
			return tofind;	

		}
	}
		
		// Returns a preprocessed version of the given string: all the letter characters are converted
		// to lower-case, and all the other characters are deleted, except for spaces, which are left
		// as is. For example, the string "What? No way!" becomes "whatnoway"
		public static String preProcess(String str) {
			String news = "" ;
			str = str.toLowerCase();
			for(int i = 0 ; i < str.length(); i++)
				if(str.charAt(i)>= 'a' && str.charAt(i) <= 'z')
					news += str.charAt(i);
			return news;
		} 
		
		// Returns a random anagram of the given string. The random anagram consists of the same
		// characters as the given string, re-arranged in a random order. 
		public static String randomAnagram(String str) {
			char[] narr = new char[str.length()];
			String nstr = "";
			for(int i = 0 ; i < str.length(); i++){ //run over the string
				boolean found = false;
				while(!found)
				{
					int ind = (int) Math.random()*str.length(); 
					if(narr[ind] == 0){

					 //to find the empty place in the new array
						found = true;
						narr[ind] = str.charAt(i);
					}	

				}
			}
			for(int k = 0 ; k < str.length(); k++) // creating the new string from the array
				nstr += narr[k];

			return nstr; 
		}
		//receives a string and a char and creates new string without the char
		//will remove the char only once even if appears few times in the string
		public static String removeLetter(String str, char c){
		
			String news = "";
			boolean tofind = false;
			int index = 0;
			for(int i = 0; i < str.length() && !tofind; i++)
				if(str.charAt(i) == c){
					index = i;
					tofind = true;	
				}
			int counter = 0;
			while(counter < str.length()){
				
				if(counter != index)
					news += str.charAt(counter);
				counter++ ;	
			}
			return news;
		}
		
			

	

}
