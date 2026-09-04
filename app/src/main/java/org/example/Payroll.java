package org.example;

public class Payroll
{
    private final double rate = 16.78;
    private final double overtimeRate = rate * 1.5;

    private final double socialSecurityTax = 0.06;
    private final double federalIncomeTax = 0.14;
    private final double stateIncomeTax = 0.05;

    private final double unionDues = 10.00;
    private final double standardDependentRate = 15.00;
    private final double excessDependentRate = 35.00;

    public double calculateGrossPay(int numberOfHours)
    {
        if (numberOfHours > 40)
        {
            int regularHours = 40;
            int overtimeHours = numberOfHours - 40;
            return (regularHours * rate) + (overtimeHours * overtimeRate);
        }
        return rate * numberOfHours;
    }

    public double calculateSocialSecurity(double grossPay)
    {
        return grossPay * socialSecurityTax;
    }

    public double calculateFederalIncome(double grossPay)
    {
        return grossPay * federalIncomeTax;
    }

    public double calculateStateIncome(double grossPay)
    {
        return grossPay * stateIncomeTax;
    }

    public double getUnionDues(double grossPay)
    {
        if (grossPay == 0)
        {
            return 0;
        }
        return unionDues;
    }

    public double calculateInsurance(int numberOfChildren, double grossPay)
    {
        if (grossPay == 0)
        {
            return 0;
        }
        else if (numberOfChildren > 3)
        {
            return excessDependentRate;
        }
        return standardDependentRate;
    }
}
