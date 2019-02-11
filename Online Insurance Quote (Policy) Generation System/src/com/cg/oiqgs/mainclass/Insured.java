package com.cg.oiqgs.mainclass;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.oiqgs.supportingClass.Account;
import com.cg.oiqgs.supportingClass.ViewPolicy;

public class Insured {

	@SuppressWarnings({ "static-access", "resource" })
	public static void main(String[] args) {

		boolean doFlag = false;
		Scanner scanner = new Scanner(System.in);
		do {
			scanner = new Scanner(System.in);
			System.out.println("******Welcome to agent console*******");
			System.out.println("1:Account Creation ");
			System.out.println("2:View Policy ");
			System.out.println("3:Exist ");
			System.out.println();
			System.out.println("Enter Your Choices");
			try {
				int choice = scanner.nextInt();
				if (choice > 0 && choice < 4) {
					doFlag = true;
					switch (choice) {
					case 1:
						Account accountCreation = new Account();
						accountCreation.main(null);//calling account class main method
						break;
					case 2:
						ViewPolicy policy = new ViewPolicy();
						policy.main(null);//calling view policy class
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.err.println("ENTER VALID INPUT RANGE(1-3)");
				}
			} catch (InputMismatchException e) {
				System.err.println("INPUT MUST BE INTEGER");
			}
		} while (!doFlag);

	}

}
