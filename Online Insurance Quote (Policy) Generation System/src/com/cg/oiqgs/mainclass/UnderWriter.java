package com.cg.oiqgs.mainclass;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.oiqgs.supportingClass.Account;
import com.cg.oiqgs.supportingClass.PolicyCreation;
import com.cg.oiqgs.supportingClass.ProfileCreation;
import com.cg.oiqgs.supportingClass.ReportGeneration;
import com.cg.oiqgs.supportingClass.ViewPolicy;

public class UnderWriter {

	@SuppressWarnings({ "static-access", "resource" })
	public void main(String[] args) {
		boolean doFlag = false;
		Scanner scanner = new Scanner(System.in);
		do {
			scanner = new Scanner(System.in);
			System.out.println("******Welcome to admin console*******");
			System.out.println("1:New Profile Creation ");
			System.out.println("2:Account Creation ");
			System.out.println("3:Policy Creation ");
			System.out.println("4:View Policy ");
			System.out.println("5:Report Generation");
			System.out.println("6:Exist");
			System.out.println();
			System.out.println("Enter Your Choices");
			try {
				int choice = scanner.nextInt();
				if (choice > 0 && choice < 7) {
					doFlag = true;
					switch (choice) {
					case 1:
						ProfileCreation creation = new ProfileCreation();
						creation.main(null);//calling profile creation class main method
						break;
					case 2:
						Account accountCreation = new Account();
						accountCreation.main(null);//calling account class main method
						break;
					case 3:
						PolicyCreation policyCreation = new PolicyCreation();
						policyCreation.main(null);//calling policy creation class main method
						break;
					case 4:
						ViewPolicy policy = new ViewPolicy();
						policy.main(null);// calling view policy class main method
						break;
					case 5:
						ReportGeneration generation = new ReportGeneration();
						generation.main(null);//calling report generation class main method
						break;
					case 6:
						System.exit(0);
					}
				} else {
					System.err.println("ENTER VALID INPUT RANGE(1-5)");
				}
			} catch (InputMismatchException e) {
				System.err.println("INPUT MUST BE INTEGER");
			}
		} while (!doFlag);
	}

}
