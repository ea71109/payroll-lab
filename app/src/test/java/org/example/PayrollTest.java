package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayrollTest {
  // You can put your JUnit tests here
  // Feel free to create other files, as needed, to organize your tests
  Payroll payroll;

  @BeforeEach
  void setUp()
  {
    payroll = new Payroll();
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

  @Test
  public void testZeroHoursWorked()
  {
    assertEquals(0, payroll.calculateGrossPay(0));
  }

  @Test
  public void testOneHourWorked()
  {
    assertEquals(16.78, payroll.calculateGrossPay(1));
  }

  @Test
  public void testTwoHoursWorked()
  {
    assertEquals(33.56, payroll.calculateGrossPay(2));
  }

  @Test
  public void testFortyHoursWorked()
  {
    assertEquals(671.20, payroll.calculateGrossPay(40));
  }

  @Test
  public void testFortyOneHoursWorked()
  {
    assertEquals(696.37, payroll.calculateGrossPay(41));
  }

  @Test
  public void testEightyHoursWorked()
  {
    assertEquals(1678.00, payroll.calculateGrossPay(80));
  }

  @Test
  public void testTaxesWithZeroDollars()
  {
    assertEquals(0.0, payroll.calculateSocialSecurity(0.0));
    assertEquals(0.0, payroll.calculateFederalIncome(0));
    assertEquals(0.0, payroll.calculateStateIncome(0));
  }

  @Test
  public void testTaxesWithOneDollar()
  {
    assertEquals(0.06, payroll.calculateSocialSecurity(1));
    assertEquals(0.14, payroll.calculateFederalIncome(1));
    assertEquals(0.05, payroll.calculateStateIncome(1));
  }

  @Test
  public void testTaxesWithTwoDollars()
  {
    assertEquals(0.12, payroll.calculateSocialSecurity(2));
    assertEquals(0.28, payroll.calculateFederalIncome(2));
    assertEquals(0.10, payroll.calculateStateIncome(2));
  }

  @Test
  public void testTaxesWithManyDollars()
  {
    assertEquals(6.00, payroll.calculateSocialSecurity(100));
    assertEquals(14.00, payroll.calculateFederalIncome(100), 0.001);
    assertEquals(5.00, payroll.calculateStateIncome(100));
  }

  @Test
  public void testUnionDuesWithZeroDollars()
  {
    assertEquals(0.0, payroll.getUnionDues(0.0));
  }

  @Test void testUnionDuesWithOneDollar()
  {
    assertEquals(10.00, payroll.getUnionDues(1.00));
  }

  @Test void testUnionDuesWithManyDollars()
  {
    assertEquals(10.00, payroll.getUnionDues(200.00));
  }

  @Test void testInsuranceWithZeroDollars()
  {
    assertEquals(0.0, payroll.calculateInsurance(0, 0.0));
    assertEquals(0.0, payroll.calculateInsurance(4,0.0));
  }

  @Test void testInsuranceWithOneChild()
  {
    assertEquals(15.00, payroll.calculateInsurance(1, 500.00));
  }

  @Test void testInsuranceWithThreeChildren()
  {
    assertEquals(15.00, payroll.calculateInsurance(3, 500.00));
  }

  @Test void testInsuranceWithFourChildren()
  {
    assertEquals(35.00, payroll.calculateInsurance(4, 500.00));
  }

  @Test void testInsuranceWithManyChildren()
  {
    assertEquals(35.00, payroll.calculateInsurance(6, 500.00));
  }
}