/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import com.itexps.bank_of_suburbs.Account;
import com.itexps.bank_of_suburbs.AccountType;
import com.itexps.bank_of_suburbs.Bank;
import com.itexps.bank_of_suburbs.Customer;
import com.itexps.bank_of_suburbs.CustomerType;
import com.itexps.bank_of_suburbs.Employee;
import com.itexps.bank_of_suburbs.EmployeeType;
import com.itexps.bank_of_suburbs.FullTimeEmployee;
import com.itexps.bank_of_suburbs.PartTimeEmployee;
import com.itexps.bank_of_suburbs.Transaction;
import com.itexps.bank_of_suburbs.TransactionType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author patel
 */
public class BankTest {
    Bank bank;
    public BankTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        
        ArrayList<Employee> employees = new ArrayList <Employee>(); 
        
        Employee e1 = new FullTimeEmployee(70000, 10, "Max", "Jonas", "max@123.com", "1237896060", "N North Ave" , EmployeeType.FullTimeEmployee);
        Employee e2 = new PartTimeEmployee(35, 35,11, "John", "Brown", "john@123.com", "3337896060", "N Plum Ave" , EmployeeType.PartTimeEmployee);
        Employee e3 = new PartTimeEmployee(25, 45,15, "Emily", "Patric", "emily@123.com", "5537896060", "E Main St" , EmployeeType.PartTimeEmployee);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        ArrayList<Customer> customers = new ArrayList <Customer>();
        ArrayList<Account> accounts = new ArrayList <Account>();
        ArrayList<Transaction> transactions = new ArrayList <Transaction>();
        
        Transaction t1 = new Transaction("t11", TransactionType.Credit, 1000, LocalDateTime.now());
        Transaction t2 = new Transaction("t12", TransactionType.Debit, 2000, LocalDateTime.now());
        
        transactions.add(t1);
        transactions.add(t2);
         
        Account a1 = new Account("a11", AccountType.Checking, 7000, transactions);
        Account a2 = new Account("a12", AccountType.Saving, 5000, transactions);
        Account a3 = new Account("a13", AccountType.FixedDeposit, 8000, transactions);
        Account a4 = new Account("a14", AccountType.Checking, 5000, transactions);
        Account a5 = new Account("a15", AccountType.Saving, 6000, transactions);
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);

        Customer c1 = new Customer("c01", "Robin", "Wood", "robin@123.com", "3344556677", "robinwood", "robin123", CustomerType.Individual, accounts);
        Customer c2 = new Customer("c02", "Mary", "Jonas", "mary@123.com", "5444556677", "maryjonas", "mary123", CustomerType.Individual, accounts);        
        Customer c3 = new Customer("c03", "Alex", "Wilson", "alex@123.com", "5544556677", "alexwilson", "alex123", CustomerType.Business, accounts);
        Customer c4 = new Customer("c04", "Rob", "Paul", "rob@123.com", "3344006677", "robpaul", "rob123", CustomerType.Business, accounts);
        Customer c5 = new Customer("c05", "James", "Smith", "james@123.com", "6744556677", "jamessmith", "james123", CustomerType.Business, accounts);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);     
        
        bank = new Bank("B001", "Chase", "7868909808", "N Pine St", employees, customers);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    
    @Test
    public void BankTest() {
        
        assertEquals(bank.getName(),"Chase");
        assertEquals(bank.getId(), "B001");
        assertEquals(bank.getAddress(), "N Pine St");
        assertEquals(bank.getPhone(), "7868909808");
        
        //Employee
        assertEquals(bank.getEmployees().size(), 3 );
        assertEquals(bank.getEmployees().get(0).getEid(), 10);
        assertEquals(bank.getEmployees().get(1).getEid(),11);
        assertEquals(bank.getEmployees().get(2).getEid(), 15);
        assertEquals(bank.getEmployees().get(0).getFirstname(), "Max");
        assertEquals(bank.getEmployees().get(1).getFirstname(), "John");
        assertEquals(bank.getEmployees().get(2).getFirstname(), "Emily");
        assertEquals(bank.getEmployees().get(0).getLastname(), "Jonas");
        assertEquals(bank.getEmployees().get(1).getLastname(), "Brown");
        assertEquals(bank.getEmployees().get(2).getLastname(), "Patric");
        assertEquals(bank.getEmployees().get(0).getEmail(), "max@123.com");
        assertEquals(bank.getEmployees().get(1).getEmail(), "john@123.com");
        assertEquals(bank.getEmployees().get(2).getEmail(), "emily@123.com");
        assertEquals(bank.getEmployees().get(0).getPhone(), "1237896060");
        assertEquals(bank.getEmployees().get(1).getPhone(), "3337896060");
        assertEquals(bank.getEmployees().get(2).getPhone(), "5537896060");
        assertEquals(bank.getEmployees().get(0).getAddress(), "N North Ave");
        assertEquals(bank.getEmployees().get(1).getAddress(), "N Plum Ave");
        assertEquals(bank.getEmployees().get(2).getAddress(), "E Main St");  
        assertEquals(bank.getEmployees().get(0).getEmpType(), EmployeeType.FullTimeEmployee);
        assertEquals(bank.getEmployees().get(1).getEmpType(), EmployeeType.PartTimeEmployee );
        assertEquals(bank.getEmployees().get(2).getEmpType(), EmployeeType.PartTimeEmployee );
        
        //Customer   
        assertEquals(bank.getCustomers().size(), 5);
        assertEquals(bank.getCustomers().get(0).getId(), "c01");
        assertEquals(bank.getCustomers().get(1).getId(), "c02");
        assertEquals(bank.getCustomers().get(2).getId(), "c03");
        assertEquals(bank.getCustomers().get(3).getId(), "c04");
        assertEquals(bank.getCustomers().get(4).getId(), "c05");
        assertEquals(bank.getCustomers().get(0).getFirstname(), "Robin");
        assertEquals(bank.getCustomers().get(1).getFirstname(), "Mary");
        assertEquals(bank.getCustomers().get(2).getFirstname(), "Alex");
        assertEquals(bank.getCustomers().get(3).getFirstname(), "Rob");
        assertEquals(bank.getCustomers().get(4).getFirstname(), "James");
        assertEquals(bank.getCustomers().get(0).getLastname(), "Wood");
        assertEquals(bank.getCustomers().get(1).getLastname(), "Jonas");
        assertEquals(bank.getCustomers().get(2).getLastname(), "Wilson");
        assertEquals(bank.getCustomers().get(3).getLastname(), "Paul");
        assertEquals(bank.getCustomers().get(4).getLastname(), "Smith");
        assertEquals(bank.getCustomers().get(0).getEmail(), "robin@123.com");
        assertEquals(bank.getCustomers().get(1).getEmail(), "mary@123.com");
        assertEquals(bank.getCustomers().get(2).getEmail(), "alex@123.com");
        assertEquals(bank.getCustomers().get(3).getEmail(), "rob@123.com");
        assertEquals(bank.getCustomers().get(4).getEmail(), "james@123.com");
        assertEquals(bank.getCustomers().get(0).getUname(), "robinwood");
        assertEquals(bank.getCustomers().get(1).getUname(), "maryjonas");
        assertEquals(bank.getCustomers().get(2).getUname(), "alexwilson");
        assertEquals(bank.getCustomers().get(3).getUname(), "robpaul");
        assertEquals(bank.getCustomers().get(4).getUname(), "jamessmith");       
        assertEquals(bank.getCustomers().get(0).getCustType(), CustomerType.Individual);
        assertEquals(bank.getCustomers().get(1).getCustType(), CustomerType.Individual);
        assertEquals(bank.getCustomers().get(2).getCustType(), CustomerType.Business);
        assertEquals(bank.getCustomers().get(3).getCustType(), CustomerType.Business);
        assertEquals(bank.getCustomers().get(4).getCustType(), CustomerType.Business);
        
        
        //Account      
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getId(), "a11");
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getId(), "a14");
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getId(), "a12");
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getId(), "a15");
        assertEquals(bank.getCustomers().get(4).getAccounts().get(2).getId(), "a13");  
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getBalance(), 7000.0f);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getBalance(), 5000.0f);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getBalance(), 5000.0f);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getBalance(), 6000.0f);
        assertEquals(bank.getCustomers().get(4).getAccounts().get(2).getBalance(), 8000.0f);     
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getAccType(), AccountType.Checking);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getAccType(), AccountType.Checking);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getAccType(), AccountType.Saving);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getAccType(), AccountType.Saving);
        assertEquals(bank.getCustomers().get(4).getAccounts().get(2).getAccType(), AccountType.FixedDeposit);
        
        //Transaction
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(0).getTid(), "t11");
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(1).getTid(), "t12");
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(0).getTid(), "t11");
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(1).getTid(), "t12");
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(0).getTid(), "t11");
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(1).getTid(), "t12");
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(1).getTid(), "t12");
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(0).getTid(), "t11");              
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(0).getTamount(), 1000.0f);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(0).getTamount(), 1000.0f);
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(1).getTamount(), 2000.0f);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(1).getTamount(), 2000.0f);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(0).getTamount(), 1000.0f);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(0).getTamount(), 1000.0f);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(1).getTamount(), 2000.0f);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(1).getTamount(), 2000.0f);
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(0).getTransactionType(), TransactionType.Credit);
        assertEquals(bank.getCustomers().get(0).getAccounts().get(0).getTransactions().get(1).getTransactionType(), TransactionType.Debit);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(0).getTransactionType(), TransactionType.Credit);
        assertEquals(bank.getCustomers().get(1).getAccounts().get(3).getTransactions().get(1).getTransactionType(), TransactionType.Debit);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(0).getTransactionType(), TransactionType.Credit);
        assertEquals(bank.getCustomers().get(2).getAccounts().get(1).getTransactions().get(1).getTransactionType(), TransactionType.Debit);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(0).getTransactionType(), TransactionType.Credit);
        assertEquals(bank.getCustomers().get(3).getAccounts().get(4).getTransactions().get(1).getTransactionType(), TransactionType.Debit);
           
    }    
    
}
