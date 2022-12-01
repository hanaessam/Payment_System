package payment_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import forms.Form;
import services.Donations;
import services.InternetPayment;
import services.Landline;
import services.MobileRecharge;
import services.ServiceFactory;

public class Main {
	static Scanner myObj = new Scanner(System.in);  
	
	public static void prompt() {
		
		System.out.println("Our Services: ");
		System.out.println("1- Mobile Recharge Services");
		System.out.println("2- Internet Payment Services");
		System.out.println("3- Landline Services ");
		System.out.println("4- Donation Services ");
		System.out.println("Enter your service: ");
		int switchNum = myObj.nextInt();
		switch (switchNum) {
		  case 1:
			  System.out.println("---Mobile Recharge Services---");
			  ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
			  mobileRechaServiceFactory.createForm();
		    break;
		  case 2:
				System.out.println("---Internet Payment Services---");
				ServiceFactory internetPaymentFactory = new InternetPayment();
				internetPaymentFactory.createForm();
		    break;
		  case 3:
			  System.out.println("---Landline Service---");
			  ServiceFactory landlineServiceFactory = new Landline();
			  landlineServiceFactory.createForm();
		    break;
		  case 4:
			  System.out.println("---Donation Services---");
			  ServiceFactory donationServiceFactory = new Donations();
			  donationServiceFactory.createForm();
		    break;
		}
	}
	
	
	public static void main(String[] args) {
		List<User> newUsers = new ArrayList<>();
		String newUsername ;
		String newPassword ;
		User newUser = new User();
	
		int choice;
		
		do{
			System.out.println("------Welcome to fawry system------");
			System.out.println("1- Sign up");
			System.out.println("2- Log in");
			System.out.println("3- Exit");
			System.out.println("Enter 1, to sign up or 2 to log in, 3 for exit");
			
			choice = myObj.nextInt(); 
			
			
			if(choice == 1) {	
				
				System.out.println("Enter your username: ");
				newUsername = myObj.nextLine();
				myObj.nextLine();
				newUser.setUsername(newUsername);
				System.out.println("Enter your password: ");
				newPassword = myObj.nextLine();
				newUser.setPassword(newPassword);
				newUsers.add(newUser);
				System.out.println(newUsers.isEmpty());
				prompt();
				
			} else if(choice == 2){ 
	
				for (int i = 0; i < newUsers.size(); i++) {
					System.out.println("list: ");
					System.out.println(newUsers.get(i).getUsername());
				}
				System.out.println("Enter your username(login): ");
				newUsername = myObj.nextLine();
				myObj.nextLine();
				System.out.println("Enter your password (login): ");
				newPassword = myObj.nextLine();
				for (int i = 0; i < newUsers.size(); i++) {
					if(newUsers.get(i).getUsername() == newUsername && newUsers.get(i).getPassword() == newPassword) {
						prompt();
					}else {
						System.out.println("Enter your username: ");
						newUsername = myObj.nextLine();
				
						newUser.setUsername(newUsername);
						System.out.println("Enter your password: ");
						newPassword = myObj.nextLine();
						newUser.setPassword(newPassword);
						newUsers.add(newUser);
						prompt();
						for (int i1 = 0; i1 < newUsers.size(); i1++) {
							System.out.println(newUsers.get(i1).getUsername());
						}
					}
				}
				
			}
			   
		}while(choice != 3);
		
		
		

	}

}
