package com.cg.oiqgs.supportingClass;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.oiqgs.UserInterface.UserInterface;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.mainclass.Agent;
import com.cg.oiqgs.mainclass.Insured;
import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;

public class ViewPolicy {
	static String userName;
	static String roleCode;

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		InsuranceQuotesService service = new InsuranceQuotesServiceImpl();

		try {
			List<Policy> list = null;
			if (roleCode.equalsIgnoreCase("Agent") || roleCode.equalsIgnoreCase("Insured"))
				list = service.getPolicyDetails(userName);
			else if (roleCode.equalsIgnoreCase("Admin"))
				list = service.getPolicyDetails();

			if (!(list.isEmpty())) {
				System.out.println("POLICY NUMBER" + "		" + "BUSINESS SEGMENT" + "		" + "POLICY PREMIUM"
						+ "		" + "ACCOUNT NUMBER");
				for (Policy policy : list) {
					System.out.println(policy.getPolicyNumber() + "		" + policy.getBussinessSegment() + "		"
							+ policy.getPolicyPremium() + "		" + policy.getAccountNumber());
				}
			} else
				System.err.println("NO policy is created for this profile..contact admin to create policy ");
		} catch (OiqgsException e) {
			e.printStackTrace();
		}finally {
			boolean doFlag = false;
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
					}
					else {
						UserInterface userInterface = new UserInterface();
						userInterface.main(null);
					}
					}
					else if(roleCode.equalsIgnoreCase("Insured"))
					{
						if (choice1.equalsIgnoreCase("y")) {
							Insured insured=new Insured();
							insured.main(null);
					}
						else {
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
				if (roleCode.equalsIgnoreCase("Insured")) {
					if (choice1.equalsIgnoreCase("y")) {
						Insured insured=new Insured();
						insured.main(null);
					} else
						System.exit(0);
				}
			} while (!doFlag);

		
			}
	}

	public void getUserName(String user) {
		userName = user;
	}

	public void getRoleCode(String role) {
		roleCode = role;

	}

}
