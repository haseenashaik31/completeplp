package com.cg.oiqgs.mainclass;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.oiqgs.supportingClass.Account;
import com.cg.oiqgs.supportingClass.PolicyCreation;
import com.cg.oiqgs.supportingClass.ViewPolicy;

public class Agent {

	@SuppressWarnings({ "static-access", "resource" })
	public static void main(String[] args) {
		boolean doFlag = false;
		Scanner scanner = new Scanner(System.in);
		do {
			scanner = new Scanner(System.in);
			System.out.println("******Welcome to agent console*******");
			System.out.println("1:Account Creation ");
			System.out.println("2:Policy Creation ");
			System.out.println("3:View Policy ");
			System.out.println("4:Exist ");
			System.out.println();
			System.out.println("Enter Your Choices");
			try {
				int choice = scanner.nextInt();
				if (choice > 0 && choice < 5) {
					doFlag = true;
					switch (choice) {
					case 1:
						Account accountCreation = new Account();
						accountCreation.main(null);//calling account class main method
						break;
					case 2:
						PolicyCreation policyCreation = new PolicyCreation();
						policyCreation.main(null);//calling policy creation class main method
						break;
					case 3:
						ViewPolicy policy = new ViewPolicy();
						policy.main(null);//calling view policy class main method
						break;
					case 4:
						System.exit(0);
					}
				} else {
					System.err.println("ENTER VALID INPUT RANGE(1-4)");
				}
			} catch (InputMismatchException e) {
				System.err.println("INPUT MUST BE INTEGER");
			}
		} while (!doFlag);

	}

}
