package keywords;

import org.openqa.selenium.support.ui.Select;

public class validationKeywords extends GenericKeywords {

	public void validateTitle() {
		
	}
	
	public void validateText() {
		log("Validating Titile");
	}
	
	public void validateElementPresent() {
		
	}
	
	public void validateLogin() {
		
	}
	
	
	public void validateSelectedValueInDropdwon(String locatorKey, String option) {
		Select s= new Select(getElemnt(locatorKey));
		String text=s.getFirstSelectedOption().getText();
		if(!text.equals(option)) {
			reportFailure("Option "+option+" not present in Drop Down "+locatorKey,true);
		}
	}
	
	public void validateSelectedValueNOTInDropdwon(String locatorKey, String option) {
		Select s= new Select(getElemnt(locatorKey));
		String text=s.getFirstSelectedOption().getText();
		if(text.equals(option)) {
			reportFailure("Option "+option+" not present in Drop Down "+locatorKey,true);
		}
	}
	
	
}
