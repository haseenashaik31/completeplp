package com.cg.oiqgs.supportingClass;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.oiqgs.UserInterface.UserInterface;
import com.cg.oiqgs.exception.OiqgsException;

import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.UserRole;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;

public class ProfileCreation {

	@SuppressWarnings({ "resource", "unused", "static-access" })
	public static void main(String[] args) {
		System.out.println("*****Profile Creation*****");
		Scanner scanner = new Scanner(System.in);
		InsuranceQuotesService service = new InsuranceQuotesServiceImpl();
		boolean doFlag = false;
		String userName;
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter UserName");
			userName = scanner.next();
			try {
				boolean userValid = service.userValidation(userName);
				if (userValid == true) {
					doFlag = true;

				} else {

					System.err.println("UserName already present try again !!!");
				}
			} catch (OiqgsException e) {
				System.err.println("Provide valid username");
			}

		} while (!doFlag);

		System.out.println("Enter Password");
		String password = scanner.next();
		doFlag = false;
		int choices;
		String roleCode = null;
		do {
			scanner=new Scanner(System.in);
			System.out.println("Select Role Code");
			System.out.println("1:User");
			System.out.println("2:Agent");
			System.out.println("3:Admin");
			System.out.println();
			System.out.println("select your role code");
			try {
				choices = scanner.nextInt();
				if (choices > 0 && choices < 4) {
					doFlag = true;
					switch (choices) {
					case 1:
						roleCode = "INSURED";
						break;
					case 2:
						roleCode = "AGENT";
						break;
					case 3:
						roleCode = "ADMIN";
						break;

					default:

						break;
					}
				} else {
					System.err.println("Select Valid Choice[1-3]");
				}
			} catch (InputMismatchException e) {
				System.err.println("ONLY INTEGER");
			}

		} while (!doFlag);

		UserRole role = new UserRole();
		role.setUserName(userName);
		role.setPassword(password);
		role.setRoleCode(roleCode);

		try {
			int insert = service.insertProfile(role);
			System.out.println("profile added !!!");
		} catch (OiqgsException e) {
			System.err.println("ERROR OCCURED WHILE INSERTING PROFILE");
		} finally {
			scanner.nextLine();
			System.out.println();
			doFlag = false;
			do {
				System.out.println("Do you want to continue.....(y/n)");
				String choice1 = scanner.nextLine();
				String regex = "[A-Za-z]{1}";
				boolean val = Pattern.matches(regex, choice1);
				if (val == true)
					doFlag = true;
				else
					System.err.println("give proper input");
					if (choice1.equalsIgnoreCase("y")) {
						UnderWriter underWriter = new UnderWriter();
						underWriter.main(null);
					} else {
						UserInterface userInterface = new UserInterface();
						userInterface.main(null);
					}
				
			} while (!doFlag);

		}

	}
}
