package utilities;

import com.github.javafaker.Faker;

public class FakerUtility 
{
	Faker faker=new Faker();
	public String generateFirstNmae() {
		return faker.name().firstName();
	}
	public String generateLastName()
	{
		return faker.name().lastName();
	}
	public String generateEmail() {
		return faker.internet().emailAddress();
	}
	public String generateAddress() {
		return faker.address().fullAddress();
	}
	public int generateRandomNumber() 
	{
		return (int) faker.number().randomNumber();
	}
	public String generatePhno()
	{
		return faker.phoneNumber().toString();
	}
	public String generateCompany()
	{
		return faker.company().logo();
	}
	public String generateColor()
	{
		return faker.color().name();
	}
	
	

}
