package com.cg.oiqgs.supportingClass;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.oiqgs.UserInterface.UserInterface;
import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.Report;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;

public class ReportGeneration {

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
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
						List<Report> validation = service.getReport(accountNumber);
						if (!(validation.isEmpty())) {
							doFlag=true;
							System.out.println("INSURED_NAME" + "		" + "INSURED_STREET" + "	  	"
									+ "INSURED_CITY" + "	     	" + "INSURED_STATE" + "		" + "INSURED_ZIP"
									+ "		" + "BUSINESS_SEGMENT" + "		" + "POLICY_QUESTION"
									+ "					" + "ANSWER" + "					"
									+ "POLICY_PREMIUM");
							for (Report report : validation) {
								System.out.println(report.getInsuredName() + "			" + report.getInsuredStreet()
										+ "			" + report.getInsuredCity() + "	        	" + report.getInsuredState()
										+ "		" + report.getInsuredZip() + "	        	" + report.getBussinessSegment()
										+ "		" + report.getPolicyQuestions() + "				"
										+ report.getQuestAns() + "				" + report.getPolicyPremium());
							}
						}
						else
							System.err.println("Account Not Found!!! try again");
					} catch (Exception e) {
						System.err.println("SERVICE DOESNT ESTABLISHED");
					}
				} else
					System.err.println("PLEASE ENTER COMPLETE ACCOUNT NUMBER");
			} catch (Exception e) {
				System.err.println("ENTER ONLY INTEGER");
			}finally {
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
		} while (!doFlag);

	}

}
