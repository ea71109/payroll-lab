package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Payroll payroll = new Payroll();
    System.out.println("Welcome to the Payroll Program");

    System.out.println("How many hours did you work this week? ");
    int hoursWorked = in.nextInt();
    if (hoursWorked < 0)
    {
      hoursWorked = 0;
    }

    System.out.println("How many children do you have? ");
    int amountOfChildren = in.nextInt();
    // Validation for number of children worth 1/4 point
    if (amountOfChildren < 0)
    {
      amountOfChildren = 0;
    }

    double grossPay = payroll.calculateGrossPay(hoursWorked);
    double socialSecurity = payroll.calculateSocialSecurity(grossPay);
    double federalTax = payroll.calculateFederalIncome(grossPay);
    double stateTax = payroll.calculateStateIncome(grossPay);
    double unionDues = payroll.getUnionDues(grossPay);
    double insuranceTax = payroll.calculateInsurance(amountOfChildren, grossPay);

    double totalExpenses = socialSecurity + federalTax + stateTax + unionDues + insuranceTax;
    double netPay = grossPay - totalExpenses;

    System.out.println("Payroll Stub:\n");
    System.out.println("Hours: " + hoursWorked);
    System.out.println("Rate: 16.78 $/hr");
    System.out.printf("Gross: $ %.2f\n", grossPay);
    System.out.printf("\nSocSec: $ %.2f\n", socialSecurity);
    System.out.printf("FedTax: $ %.2f\n", federalTax);
    System.out.printf("StTax:  $ %.2f\n", stateTax);
    System.out.printf("Union: $ %.2f\n", unionDues);
    System.out.printf("Ins: $ %.2f\n\n", insuranceTax);
    System.out.printf("Net: $ %.2f\n\n", netPay);

    System.out.println("Thank you for using the Payroll Program!");
  }
}
