package GUI;

import java.util.*;

public class PasswordGenerator {

	public static final String LowerCase_Characters = "abcdefghijklmnopqrstuvwxyz";
	public static final String UpperCase_Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String Numbers = "0123456789";
	public static final String Special_Symbols="!@#$%^&*()-_=+[]{};:.,<>/?";
	
	private final Random random;
	
	public PasswordGenerator() {random = new Random();}
	
	public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
		StringBuilder passwordBuilder = new StringBuilder();
		String validCharacters= "";
		if(includeUppercase) validCharacters += UpperCase_Characters;
		if(includeLowercase) validCharacters += LowerCase_Characters;
		if(includeNumbers) validCharacters += Numbers;
		if(includeSpecialSymbols) validCharacters += Special_Symbols;
		
		for(int i=0; i<length;i++) {
			int randomIndex = random.nextInt(validCharacters.length());
			char randomChar = validCharacters.charAt(randomIndex);
			passwordBuilder.append(randomChar);
		}
		return passwordBuilder.toString();
 	}
}
