package com.cg.oiqgs.supportingClass;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.oiqgs.UserInterface.UserInterface;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.mainclass.Agent;
import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.model.PolicyDetails;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;

public class PolicyCreation {
	static String roleCode;

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean doFlag = false;
		long accountNumber = 0;
		String validAccount;
		InsuranceQuotesService service = new InsuranceQuotesServiceImpl();

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Account Number");
			try {
				accountNumber = scanner.nextLong();
				validAccount = String.valueOf(accountNumber);
				String regexacnt = "[0-9]{10}";
				boolean input = Pattern.matches(regexacnt, validAccount);
				if (input == true) {

					try {
						boolean validation = service.accountValidation(accountNumber);
						if (validation == true)
							doFlag = true;
						else
							System.err.println("ACCOUNT DOESNT EXIST!!!!TRY AGAIN");
					} catch (Exception e) {
						System.err.println("SERVICE DOESNT ESTABLISHED");
					}
				} else
					System.err.println("PLEASE ENTER COMPLETE ACCOUNT NUMBER");
			} catch (Exception e) {
				System.err.println("ENTER ONLY INTEGER");
			}
		} while (!doFlag);
		doFlag = false;
		int choice;
		String segId = null;
		String bussinessSegment = null;
		do {
			try {
				scanner = new Scanner(System.in);
				List<Policy> list = service.getBusinessSegment();
				int i = 1;
				int j = 0;
				String[] busId = new String[list.size()];
				for (Policy policy : list) {
					System.out.println(i++ + "-" + policy.getBusSegName());
					busId[j] = policy.getBusSegId();
					j++;
				}
				System.out.println("Enter Your choices");
				try {
					choice = scanner.nextInt();
					if (choice > 0 && choice < 5) {
						doFlag = true;
						switch (choice) {
						case 1:
							segId = busId[0];
							bussinessSegment = "Business Auto";
							break;
						case 2:
							segId = busId[1];
							bussinessSegment = "Restaurant";
							break;
						case 3:
							segId = busId[2];
							bussinessSegment = "Apartment";
							break;
						case 4:
							segId = busId[3];
							bussinessSegment = "General Merchant";
							break;
						}
					} else
						System.err.println("ENTER VALID CHOICES");
				} catch (InputMismatchException e) {
					System.err.println("ONLY INTEGER");
				}
			} catch (OiqgsException e) {
				System.err.println("SERVICE DOESNT ESTABLISHED");
			}
		} while (!doFlag);
		doFlag = false;
		double policyPremium = 0;
		int questionId;
		String[] questId = null;
		String[] questAns = null;
		String[] questDesc = null;
		int listSize = 0;
		try {
			int i = 1;
			int j = 0;
			List<Policy> list = service.getPolicyQuestions(segId);
			listSize = list.size();
			questId = new String[list.size()];
			questAns = new String[list.size()];
		
			for (Policy policy : list) {
				do {
					scanner = new Scanner(System.in);
					System.out.println(i + ":" + "" + policy.getPolQuesDesc());
					
					questId[j] = policy.getPolQuesId();
					System.out.println("1:" + "" + policy.getPolQuesAns1());
					System.out.println("2:" + "" + policy.getPolQuesAns2());
					System.out.println("3:" + "" + policy.getPolQuesAns3());
					try {
						int option = scanner.nextInt();
						if (option > 0 && option < 4) {
							doFlag = true;
							switch (option) {
							case 1:
								policyPremium = policyPremium + policy.getPolQuesAns1Weightage();
								questAns[j] = policy.getPolQuesAns1();
								System.out.println();
								break;
							case 2:
								policyPremium = policyPremium + policy.getPolQuesAns2Weightage();
								questAns[j] = policy.getPolQuesAns2();
								System.out.println();
								break;
							case 3:
								policyPremium = policyPremium + policy.getPolQuesAns3Weightage();
								questAns[j] = policy.getPolQuesAns3();
								System.out.println();
								break;

							}
						} else
							System.err.println("ENTER VALID OPTION");
					} catch (InputMismatchException e) {
						System.err.println("ONLY INTEGER");
					}
				} while (!doFlag);
				j++;
				i++;
			}
		} catch (OiqgsException e) {
			System.err.println("SERVICE DOESNT ESTABLISHED");
		}

		Policy policy = new Policy();
		policy.setBussinessSegment(bussinessSegment);
		policy.setAccountNumber(accountNumber);
		policy.setPolicyPremium(policyPremium);
		try {
			long policyNumber = service.insertPolicy(policy);
			if (policyNumber > 0) {
				System.out.println("POLICY CREATED");
				System.out.println();
				System.out.println("YOUR POLICY ID:" + policyNumber);
			} else
				System.err.println("ERROR OCCURED DURING POLICY CREATION");
		} catch (OiqgsException e) {
			System.err.println("DATA DOESNT INSERTED");
		}
		int j = 0;
		for (int i = 0; i < listSize; i++) {
			PolicyDetails details = new PolicyDetails();
			details.setQuestId(questId[i]);
			details.setQuestAns(questAns[i]);
			try {
				int result = service.insertPolicyDetails(details);

				if (result > 0) {
					j++;
				}

			} catch (OiqgsException e) {
				System.err.println("SERVICE DOESNT ESTABLISHED");
			}
		}
		if (j == listSize)
			System.out.println("policy details inserted");
		else {
			System.err.println("ERROR OCCURED DURING PROFILE CREATION");
		}
		scanner.nextLine();
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
			if (roleCode.equalsIgnoreCase("Agent")) {
				if (choice1.equalsIgnoreCase("y")) {
					Agent agent = new Agent();
					agent.main(null);
				} else {
					UserInterface userInterface = new UserInterface();
					userInterface.main(null);
				}
			}
			if (roleCode.equalsIgnoreCase("Admin")) {
				if (choice1.equalsIgnoreCase("y")) {
					UnderWriter underWriter = new UnderWriter();
					underWriter.main(null);
				} else {
					UserInterface userInterface = new UserInterface();
					userInterface.main(null);
				}
			}
		} while (!doFlag);
	}

	public void getRoleCode(String role) {
		roleCode = role;

	}

}
