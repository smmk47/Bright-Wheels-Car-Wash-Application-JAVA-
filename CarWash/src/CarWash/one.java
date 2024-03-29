package CarWash;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
//Person class (parent class)
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;

import com.toedter.calendar.JDateChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;

 class Records {
    private List<Payment> payments;
    private List<Booking> bookings;

    public Records() {
        this.payments = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    // Payment-related methods
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    // Booking-related methods
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    // Other methods as needed

    public void showAllPayments() {
        System.out.println("All Payments:");
        for (Payment payment : payments) {
            System.out.println(payment.generateSlip());
        }
    }

    public void showAllBookings() {
        System.out.println("All Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId() +
                    "\nTime: " + booking.getBookingTime() +
                    "\nDate: " + booking.getBookingDate() +
                    "\nStatus: " + booking.getBookingStatus());
        }
    }
}



class Feedback {
	    // Variables
	    private String description;
	    private int rating;
	    private int feedbackID;
	    private String serviceType;

	    // Constructor
	    public Feedback(String description, int rating, int feedbackID, String serviceType) {
	        this.description = description;
	        this.rating = rating;
	        this.feedbackID = feedbackID;
	        this.serviceType = serviceType;
	    }

	    public Feedback() {
	       
	    }
	    
	    // Function to store feedback
	    public void storeFeedback() {
	        // You can implement code here to store feedback in a database or file.
	        // This could involve connecting to a database and inserting the feedback data.
	        // For simplicity, we'll just print the feedback details.
	        System.out.println("Feedback stored successfully.");
	    }

	    // Function to display feedback
	    public void displayFeedback() {
	        // You can implement code here to retrieve and display feedback from storage.
	        // This could involve querying a database and displaying the feedback data.
	        // For simplicity, we'll just print the feedback details.
	    	
	        System.out.println("Feedback ID: " + feedbackID);
	        System.out.println("Service Type: " + serviceType);
	        System.out.println("Rating: " + rating);
	        System.out.println("Description: " + description);
	        
	    }

	    // Getter and Setter methods for variables (if needed)
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    public int getFeedbackID() {
	        return feedbackID;
	    }

	    public void setFeedbackID(int feedbackID) {
	        this.feedbackID = feedbackID;
	    }

	    public String getServiceType() {
	        return serviceType;
	    }

	    public void setServiceType(String serviceType) {
	        this.serviceType = serviceType;
	    }

	    // Main method for testing
	   
	}

 
class Verification {
    private int verificationID;
    private int customerID;
    private String verificationStatus;

    // Constructor
    public Verification() {
        
    }
    public Verification(int verificationID, int customerID, String verificationStatus) {
        this.verificationID = verificationID;
        this.customerID = customerID;
        this.verificationStatus = verificationStatus;
    }

    // Getter and Setter methods for Verification ID
    public int getVerificationID() {
        return verificationID;
    }

    public void setVerificationID(int verificationID) {
        this.verificationID = verificationID;
    }

    // Getter and Setter methods for Customer ID
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter and Setter methods for Verification Status
    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    // Verify method
    public void verify() {
        // Add verification logic here
        System.out.println("Verification process for ID " + verificationID + " is in progress...");
        // You can implement the verification logic based on your requirements
        // For example, update verificationStatus after verification
        this.verificationStatus = "Verified";
        System.out.println("Verification completed. Status: " + verificationStatus);
    }
    
}


class Registration {
    private int registrationID;
    private int customerID;
    private String registrationStatus;
    
    Verification ver = new Verification();
    
    // Constructor
    public Registration() {
        
        
    }

    
    
    public Registration(int registrationID, int customerID, String registrationStatus) {
        this.registrationID = registrationID;
        this.customerID = customerID;
        this.registrationStatus = registrationStatus;
        ver.setCustomerID(customerID);
        ver.setVerificationID(registrationID);
        ver.setVerificationStatus("Pending");
    }
    
    // Getter and Setter methods for Registration ID
    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    // Getter and Setter methods for Customer ID
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter and Setter methods for Registration Status
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    // Register method
    public void register() {
        // Add registration logic here
        System.out.println("Registration process for ID " + registrationID + " is in progress...");
        // You can implement the registration logic based on your requirements
        // For example, update registrationStatus after registration
        this.registrationStatus = "Registered";
        System.out.println("Registration completed. Status: " + registrationStatus);
    }
    
    

}
class Inventory {
    private int productID;
    private String product;
    private int quantity;

    // Constructor
    public Inventory(int productID, String product, int quantity) {
        this.productID = productID;
        this.product = product;
        this.quantity = quantity;
    }

    // Getter and Setter methods for ProductID
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Getter and Setter methods for Product
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    // Getter and Setter methods for Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to add a product
    public void addProduct(int productID, String product, int quantity) {
        this.productID = productID;
        this.product = product;
        this.quantity += quantity;
    }

    // Method to remove a product
    public void removeProduct(int quantityToRemove) {
        if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
        } else {
            System.out.println("Error: Not enough quantity to remove.");
        }
    }

    // Method to update a product
    public void updateProduct(String newProduct, int newQuantity) {
        this.product = newProduct;
        this.quantity = newQuantity;
    }
}

class Payment {
    private int paymentID;
    private int amount;
    private String status;
    private String date;
    private String mode;

    public Payment(int paymentID, int amount, String status, String date, String mode) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.status = status;
        this.date = date;
        this.mode = mode;
    }

    public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int x) {
        this.paymentID = x;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void paymentMode(String newMode) {
        this.mode = newMode;
        System.out.println("Payment mode updated to " + newMode);
    }

    public String generateSlip() {
        return "Payment Slip\nPayment ID: " + paymentID + "\nAmount: " + amount + "\nStatus: " + status + "\nDate: " + date + "\nMode: " + mode;
    }

    public void updateRecords(int newAmount, String newStatus) {
        this.amount = newAmount;
        this.status = newStatus;
        System.out.println("Payment records updated");
    }

    public boolean validatePaymentInfo() {
        return paymentID != 0 && amount >= 0 && status != null && date != null && mode != null;
    }
    }

//Service class (base class)
class Service {

 private String serviceType;
 private int serviceID;  // New variable

 // Constructors
 public Service(String serviceName, int serviceID) {
     this.serviceType = serviceName;
     this.serviceID = serviceID;
 }

 public Service() {
     // Default constructor
 }

 // Getters and setters
 public String getServiceType() {
     return serviceType;
 }

 public void setServiceType(String serviceType) {
     this.serviceType = serviceType;
 }

 public int getServiceID() {
     return serviceID;
 }

 public void setServiceID(int serviceID) {
     this.serviceID = serviceID;
 }

 // Display method
 public void display() {
     System.out.println("Service Type: " + serviceType);
     System.out.println("Service ID: " + serviceID);
 }
}

//SimpleService class (derived class)
class SimpleService extends Service {
 // Additional properties or methods specific to SimpleService, if needed
 private int serviceCost;
 private String description;

 // Constructor
 public SimpleService(String serviceName, int serviceCost, int serviceID, String description) {
     super(serviceName, serviceID);
     this.serviceCost = serviceCost;
     this.description = description;
 }

 public SimpleService() {
     // Default constructor
 }

 // Getter and setter for SimpleService
 public int getServiceCost() {
     return serviceCost;
 }

 public void setServiceCost(int serviceCost) {
     this.serviceCost = serviceCost;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 // Display method
 public void display() {
     super.display();
     System.out.println("Service Cost: " + serviceCost);
     System.out.println("Description: " + description);
 }
}

//UltimateService class (derived class)
class UltimateService extends Service {
 // Additional properties or methods specific to UltimateService, if needed
 private int serviceCost;
 private String description;

 // Constructor
 public UltimateService(String serviceName, int serviceCost, int serviceID, String description) {
     super(serviceName, serviceID);
     this.serviceCost = serviceCost;
     this.description = description;
 }

 public UltimateService() {
     // Default constructor
 }

 // Getter and setter for UltimateService
 public int getServiceCost() {
     return serviceCost;
 }

 public void setServiceCost(int serviceCost) {
     this.serviceCost = serviceCost;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 // Display method
 public void display() {
     super.display();
     System.out.println("Service Cost: " + serviceCost);
     System.out.println("Description: " + description);
 }
}

//PremiumService class (derived class)
class PremiumService extends Service {
 // Additional properties or methods specific to PremiumService, if needed
 private int serviceCost;
 private String description;

 // Constructor
 public PremiumService(String serviceName, int serviceCost, int serviceID, String description) {
     super(serviceName, serviceID);
     this.serviceCost = serviceCost;
     this.description = description;
 }

 public PremiumService() {
     // Default constructor
 }

 // Getter and setter for PremiumService
 public int getServiceCost() {
     return serviceCost;
 }

 public void setServiceCost(int serviceCost) {
     this.serviceCost = serviceCost;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 // Display method
 public void display() {
     super.display();
     System.out.println("Service Cost: " + serviceCost);
     System.out.println("Description: " + description);
 }
}

//RepairingService class (derived class)
class RepairingService extends Service {
 // Additional properties or methods specific to RepairingService, if needed
 private int serviceCost;
 private String description;

 // Constructor
 public RepairingService(String serviceName, int serviceCost, int serviceID, String description) {
     super(serviceName, serviceID);
     this.serviceCost = serviceCost;
     this.description = description;
 }

 public RepairingService() {
     // Default constructor
 }

 // Getter and setter for RepairingService
 public int getServiceCost() {
     return serviceCost;
 }

 public void setServiceCost(int serviceCost) {
     this.serviceCost = serviceCost;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 // Display method
 public void display() {
     super.display();
     System.out.println("Service Cost: " + serviceCost);
     System.out.println("Description: " + description);
 }
}


 class Booking {
    private int bookingId;
    private String bookingTime;
    private String bookingDate;
    private String bookingStatus;

    Payment payment;
    Service service;
    
    public Service getService() {
        return service;
    }

    public void setService(Service s) {
        this.service=s;
		
    }
    public void setPayment(Payment p) {
        this.payment=p;
		
    }
    public Payment getPAyment() {
    	return payment;
    }
    
    
    
    public Booking() {
      
    }
    
    public Booking(int bookingId, String bookingTime, String selectedDate, String bookingStatus) {
        this.bookingId = bookingId;
        this.bookingTime = bookingTime;
        this.bookingDate = selectedDate;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBFeedback() {
        return "kuch ni hy idhar , Feeback ki class banani hy abhi wait karo";
    }

    public void setFeedback(String feedback) {
        
    }

    public void Pay_payment(String feedback) {
        
    }


    public void showAvailableSlots() {
        System.out.println("Available Slots: " + bookingTime + " on " + bookingDate);
    }

    public void giveFeedback(String feedback) {
        //this.feedback = feedback;
        //System.out.println("Feedback submitted: " + this.feedback);
    }
}

 class Person {
    private String name;
    private String address;
    private String email;
    private String phone;

    // Constructors
    public Person() {
        
    }
    
    public Person(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}


//Customer class (inherits from Person)
class Customer extends Person {
 private int customerId;
 private String password; // Password should generally be kept private and may need additional security measures
 Booking booking = new Booking();
 Registration reg = new Registration();
 
 // Constructor
 public Customer() {
    
 }
 
 public Customer(String name, String address, String email, String phone, int customerId, String password) {
     super(name, address, email, phone);
     this.customerId = customerId;
     this.password = password;
     
     reg.setCustomerID(customerId);
     reg.setRegistrationStatus("Registered");
     
 }

 // Getter methods
 public int getCustomerId() {
     return customerId;
 }

 public String getPassword() {
     return password;
 }

 
 // Setter methods
 public void SetBooking(Booking x) {

	 this.booking=x;
 
 }
 public Booking GetBookng() {

	 return booking;
 
 }
 
 // Setter methods
 public void setCustomerId(int customerId) {
     this.customerId = customerId;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 // Display method (overrides the displayInfo method in Person)
 @Override
 public void displayInfo() {
     super.displayInfo(); // Call the displayInfo method from the parent class
     System.out.println("Customer ID: " + customerId);
     System.out.println("Password: " + password);
 }
 public void BookService(Service s, Payment p) {
	 
	 booking.payment=p;
	 booking.service=s;
	 
 }
}

//Employee class (inherits from Person)
class Employee extends Person {

 private int employeeId;
 private String password; // Password should generally be kept private and may need additional security measures
 private int salary;
 private String workshift;
 private String designation;

 // Constructor
 public Employee() {
     
 }
 
 public Employee(String name, String address, String email, String phone, int employeeId) {
     super(name, address, email, phone);
     this.employeeId = employeeId;
 }

 public Employee(String name, String address, String email, String phone,
         int employeeId, String password, int salary, String workshift, String designation) {
// Call the parameterized constructor of the superclass (Person)
super(name, address, email, phone);
this.employeeId = employeeId;
this.password = password;
this.salary = salary;
this.workshift = workshift;
this.designation = designation;
}
 
 // Getter methods
 public int getEmployeeId() {
     return employeeId;
 }

 public String getPassword() {
     return password;
 }

 public int getSalary() {
     return salary;
 }

 public String getWorkshift() {
     return workshift;
 }

 public String getDesignation() {
     return designation;
 }

 // Setter methods
 public void setEmployeeId(int employeeId) {
     this.employeeId = employeeId;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public void setSalary(int salary) {
     this.salary = salary;
 }

 public void setWorkshift(String workshift) {
     this.workshift = workshift;
 }

 public void setDesignation(String designation) {
     this.designation = designation;
 }

 // Display method (overrides the displayInfo method in Person)
 @Override
 public void displayInfo() {
     super.displayInfo(); // Call the displayInfo method from the parent class
     System.out.println("Employee ID: " + employeeId);
     System.out.println("Password: " + password);
     System.out.println("Salary: " + salary);
     System.out.println("Workshift: " + workshift);
     System.out.println("Designation: " + designation);
 }
}















public class one {

    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create the login window
                    LoginWindow loginWindow = new LoginWindow();
                    
                    loginWindow. initialize();
                    
                    
                    loginWindow.frame.setVisible(true);
                  
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



class LoginWindow {

    JFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JComboBox<String> userTypeComboBox;
    Customer customer1 = new Customer();
    Employee employee1 = new Employee();

     
    JTextField textField;
    JTextField textField_1;
    JTextField textField_2;
    
    private static final String USER_CUSTOMER = "Customer";
    private static final String USER_EMPLOYEE = "Employee";
    private static final String USER_ADMIN = "Admin";

    public LoginWindow() {
       
    }

    
    public void initialize() {
    	
    		String one;
    		
        	
    		
    		
    		try {
    	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	            if ("Nimbus".equals(info.getName())) {
    	                UIManager.setLookAndFeel(info.getClassName());
    	                break;
    	            }
    	        }
    	    } catch (Exception e) {
    	        // If Nimbus is not available, you can set the default look and feel or another one.
    	        e.printStackTrace();
    	    }
    	    frame = new JFrame("Welcome To BrightWheels Car Wash ");
    	    frame.setBounds(100, 100, 800, 400);
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.getContentPane().setLayout(null);

    	    ImageIcon icon = new ImageIcon("icon.png"); // Replace with your image path
    	    frame.setIconImage(icon.getImage());

    	    ImageIcon backgroundIcon = new ImageIcon("icon.png"); // Replace with your image path

    	   
    	 // Create a JLabel for the background
    	    JLabel backgroundLabel = new JLabel(backgroundIcon);
    	    backgroundLabel.setBounds(25, 38, 395, 286); // Adjust the size to match your frame size
    	    frame.getContentPane().add(backgroundLabel);
    	    
    	    
    	    
    	    JLabel lblWelcomeToBrightwheels = new JLabel("Welcome To BrightWheels Car Wash ");
    	    lblWelcomeToBrightwheels.setBounds(495, 38, 256, 20);
    	    frame.getContentPane().add(lblWelcomeToBrightwheels);
    	    
    	    JLabel lblUsername = new JLabel("Username:");
    	    lblUsername.setBounds(430, 97, 80, 20);
    	    frame.getContentPane().add(lblUsername);

    	    JLabel lblPassword = new JLabel("Password:");
    	    lblPassword.setBounds(430, 143, 80, 20);
    	    frame.getContentPane().add(lblPassword);

    	    final JTextField usernameField = new JTextField();
    	    usernameField.setBounds(559, 97, 150, 20);
    	    frame.getContentPane().add(usernameField);
    	    usernameField.setColumns(10);

    	    final JPasswordField passwordField = new JPasswordField();
    	    passwordField.setBounds(559, 143, 150, 20);
    	    frame.getContentPane().add(passwordField);

    	    final JComboBox<String> userTypeComboBox = new JComboBox<String>();
    	    userTypeComboBox.addItem(USER_CUSTOMER);
    	    userTypeComboBox.addItem(USER_EMPLOYEE);
    	    userTypeComboBox.addItem(USER_ADMIN);
    	    userTypeComboBox.setBounds(559, 206, 150, 20);
    	    frame.getContentPane().add(userTypeComboBox);

    	     one = (String) userTypeComboBox.getSelectedItem();

    	    JButton btnLogin = new JButton("Login");
    	    btnLogin.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            String username = usernameField.getText();
    	            String password = new String(passwordField.getPassword());
    	            String selectedUserType = (String) userTypeComboBox.getSelectedItem();
    	            // Check if the username is a number
    	            try {
    	                int number = Integer.parseInt(username);

    	                if (authenticateUser(number, password, selectedUserType)) {
    	                    JOptionPane.showMessageDialog(null, "Login successful as " + selectedUserType);
    	                    openRoleSpecificWindow(selectedUserType);
    	                } else {
    	                    JOptionPane.showMessageDialog(null, "Login failed. Invalid credentials.");
    	                }
    	            } catch (NumberFormatException ex) {
    	                JOptionPane.showMessageDialog(null, "Invalid username format. Please enter a number.");
    	            }
    	        }
    	    });
    	    btnLogin.setBounds(559, 258, 89, 23);
    	    frame.getContentPane().add(btnLogin);

    	    JButton btnRegister = new JButton("Register");
    	    btnRegister.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            // Call a method to handle the registration window
    	            String selectedUserType = (String) userTypeComboBox.getSelectedItem();

    	            //openRoleSpecificWindow(selectedUserType);

    	            //String selectedUserType = (String) userTypeComboBox.getSelectedItem();
    	        	//System.out.println("Register it  boys");
    	        	registerCustomer();
    	        	//openRegistrationWindow(selectedUserType);
    	        }
    	    });
    	    btnRegister.setBounds(559, 300, 89, 23);
    	    frame.getContentPane().add(btnRegister);

    	    JLabel lblSelectRole = new JLabel("Select Role:");
    	    lblSelectRole.setBounds(430, 206, 80, 20);
    	    frame.getContentPane().add(lblSelectRole);

    	  
    	    
    	    //panel.add(registercustomerButton);

    	    
    	    
    	    // Make the frame visible
    	    frame.setVisible(true);
    	    
    }

    
    public void clearFrame() {
        frame.dispose(); // Dispose the current frame
        // Initialize a new frame
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize(); // Initialize the components for the new frame
        frame.setVisible(true); // Make the new frame visible
    }
    
    
    
    private void openRegistrationWindow(String x) {
    	if (x=="Customer") {
    		//registercustomer();
    	}
    	else{
    		
    	}
    	
       // JOptionPane.showMessageDialog(null, "Open Registration Window");
    }

    

    private void registerCustomer() {
    	 clearFrame();
     	frame.dispose(); 
    	
    	     JTextField textField;
    	     JTextField textField_1;
    	     JTextField textField_2;
    	     final JTextField textField_3;
    	     final JTextField textField_4;
    	     final JTextField textField_5;
    	     final JTextField textField_6;
    	     final JTextField textField_7;
    	     final JTextField textField_8;
    	
    	    
    	     
    	frame = new JFrame("Register Customer");
        frame.setSize(400, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        
        // Create and add "Book Service" button
       
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblNewLabel = new JLabel("Enter Name:");
        lblNewLabel.setBounds(61, 56, 86, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Enter Email:");
        lblNewLabel_1.setBounds(61, 103, 86, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Enter Address");
        lblNewLabel_2.setBounds(61, 152, 100, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Enter Phone:");
        lblNewLabel_3.setBounds(61, 200, 86, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Enter CNIC:");
        lblNewLabel_4.setBounds(61, 252, 100, 14);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Choose Password:");
        lblNewLabel_5.setBounds(61, 296, 100, 14);
        panel.add(lblNewLabel_5);
        
        textField_3 = new JTextField();
        textField_3.setBounds(171, 91, 150, 39);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(171, 141, 150, 36);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(171, 188, 150, 39);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(171, 241, 150, 36);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(171, 288, 150, 30);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setBounds(171, 47, 150, 33);
        panel.add(textField_8);
        textField_8.setColumns(10);

        JButton registercustomerButton = new JButton("Register Button");
        registercustomerButton.setBounds(171, 341, 150, 30);
        registercustomerButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				//bookService();
 				
 				 // Extract values from text fields
 			    String name = textField_8.getText();
 			    String email = textField_3.getText();
 			    String address = textField_4.getText();
 			    String phone = textField_5.getText();
 			    String cnic = textField_6.getText();
 			    String password = textField_7.getText();

 			    // Insert values into the SQL table
 			    //insertCustomerIntoDatabase(name, email, address, phone, cnic, password);

 			    try {
 			        // Establish database connection (replace with your actual connection details)
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");

 			        // SQL query to insert data into the Customer table
 			        String query = "INSERT INTO Customer (Name, Address, Email, Phone, CustomerID, CustomerPassword) VALUES (?, ?, ?, ?, ?, ?)";

 			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
 			            // Set values for the prepared statement
 			            preparedStatement.setString(1, name);
 			            preparedStatement.setString(2, address);
 			            preparedStatement.setString(3, email);
 			            preparedStatement.setString(4, phone);
 			            preparedStatement.setInt(5, Integer.parseInt(cnic));
 			            preparedStatement.setString(6, password);

 			            // Execute the update
 			            preparedStatement.executeUpdate();

 			            
 			            insertVerification(generateID(),Integer.parseInt(cnic),"Pending");
 			            insertRegistration(generateID(),Integer.parseInt(cnic),"Registered");     
 			            
 			            // Display a success message (you may want to show this in a dialog or handle it differently)
 			            JOptionPane.showMessageDialog(frame, "Registration successful!");
 			        } catch (SQLException ex) {
 			            // Handle any SQL exceptions
 			            ex.printStackTrace();
 			            JOptionPane.showMessageDialog(frame, "Error during registration. Please try again.");
 			        }
 			    } catch (SQLException ex) {
 			        // Handle database connection exceptions
 			        ex.printStackTrace();
 			        JOptionPane.showMessageDialog(frame, "Error connecting to the database. Please try again.");
 			    }
 				
 				
 			}
 		}); // Replace bookService() with your actual action

        
        
        panel.add(registercustomerButton);

        
        JButton backButton = new JButton("Back");
        backButton.setBounds(34, 341, 80, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 clearFrame();
              	frame.dispose(); 
                initialize();
            }
        });
        panel.add(backButton);
        
        // Make the frame visible
        frame.setVisible(true);
        
       
    }

    
    
   /* private boolean authenticateUser(String username, String password, String selectedUserType) {
        if (USER_CUSTOMER.equals(selectedUserType)) {
        	
        	System.out.println("validate boys");

        	
        	
        	
            return true;
        } else if ( USER_EMPLOYEE.equals(selectedUserType)) {
        	
        	
            return true;
        } else if ("admin".equals(username) && "password3".equals(password) && USER_ADMIN.equals(selectedUserType)) {
        	
        	
        	
            return true;
        }
        return false;
    }
    */
    
    private boolean authenticateUser(int userID, String password, String selectedUserType) {
        // JDBC URL, username, and password of MySQL server
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String dbUser = "root";
        String dbPassword = "qwerty654321";
        
        // Create a connection to the database
        try {
            Connection connection = connect();

            if (USER_CUSTOMER.equals(selectedUserType)) {
                // Check if the customer exists and is verified
                String customerQuery = "SELECT * FROM Customer WHERE CustomerID = ? AND CustomerPassword = ?";
                PreparedStatement customerStatement = connection.prepareStatement(customerQuery);
                customerStatement.setInt(1, userID);
                customerStatement.setString(2, password);

                ResultSet customerResult = customerStatement.executeQuery();

                if (customerResult.next()) {
                    // Customer exists, now check verification status
                    int customerID = customerResult.getInt("CustomerID");
                    String verificationQuery = "SELECT verificationStatus FROM Verification WHERE customerID = ?";
                    PreparedStatement verificationStatement = connection.prepareStatement(verificationQuery);
                    verificationStatement.setInt(1, customerID);

                    ResultSet verificationResult = verificationStatement.executeQuery();

                    if (verificationResult.next()) {
                        String verificationStatus = verificationResult.getString("verificationStatus");
                        // Check if the customer is verified
                        if ("Verified".equals(verificationStatus)) {
                            // Customer is verified, return true
                        	
                        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");
                            Statement stmt = con.createStatement();

                            // Display customer information where CustomerID is 1
                           customer1= displayCustomerInformation(stmt, userID,password);
                           customer1.displayInfo();
                            return true;
                        }else {
                        	
                            JOptionPane.showMessageDialog(frame, "Customer Not Verified!");

                        }
                        
                    }else {
                        JOptionPane.showMessageDialog(frame, "Invalid Information Provided For Customer!");

                    }
                    
                }
            } else if (USER_EMPLOYEE.equals(selectedUserType)) {
                // Check if the employee exists
                String employeeQuery = "SELECT * FROM Employee WHERE EmployeeID = ? AND EmployeePassword = ?";
                PreparedStatement employeeStatement = connection.prepareStatement(employeeQuery);
                employeeStatement.setInt(1, userID);
                employeeStatement.setString(2, password);

                ResultSet employeeResult = employeeStatement.executeQuery();

                if (employeeResult.next()) {
                    // Employee exists, return true
                	 // Correct JDBC URL format, include colon after 'mysql'
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");
                    Statement stmt = con.createStatement();

                    // Display customer information where CustomerID is 1
                   employee1= displayEmployeeInformation(stmt, userID,password);
                   employee1.displayInfo();
                    return true;
                }{
                    JOptionPane.showMessageDialog(frame, "Invalid Information Provided For Employee!");

                }
                
            } else if (USER_ADMIN.equals(selectedUserType)) {
                // Check if the admin exists
                String adminQuery = "SELECT * FROM Admin WHERE AdminID = ? AND AdminPassword = ?";
                PreparedStatement adminStatement = connection.prepareStatement(adminQuery);
                adminStatement.setInt(1, userID);
                adminStatement.setString(2, password);

                ResultSet adminResult = adminStatement.executeQuery();

                if (adminResult.next()) {
                    // Admin exists, return true
                    return true;
                }else {
                    JOptionPane.showMessageDialog(frame, "Invalid Information Provided For Admin!");

                	
                }
                
                
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // User not found or not verified (if a customer)
        return false;
    }


    
    
    public Customer displayCustomerInformation(Statement stmt, int customerId, String password) {
        try {
            String sql = "SELECT * FROM Customer WHERE CustomerID = " + customerId + " AND CustomerPassword = '" + password + "'";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("CustomerID");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String customerPassword = resultSet.getString("CustomerPassword");

                // Display customer information
                // System.out.println("Customer Information:");
                // System.out.println("Customer ID: " + id);
                // System.out.println("Name: " + name);
                // System.out.println("Address: " + address);
                // System.out.println("Email: " + email);
                // System.out.println("Phone: " + phone);
                // System.out.println("Customer Password: " + customerPassword);

                // Create and return a Customer object
                return new Customer(name, address, email, phone, id, customerPassword);
            }

            // Close the ResultSet
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee displayEmployeeInformation(Statement stmt, int employeeId, String password) {
        try {
            
            String sql = "SELECT * FROM Employee WHERE EmployeeID = ? AND EmployeePassword = ?";
            PreparedStatement preparedStatement = stmt.getConnection().prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            while (resultSet.next()) {
                int id = resultSet.getInt("EmployeeID");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("Phone");
                int Salary = resultSet.getInt("salary");
                String workshift = resultSet.getString("WorkShift");
                String designation = resultSet.getString("Designation");
                String EmployeePassword = resultSet.getString("EmployeePassword");

               
                Employee employee = new Employee(name, address, email, phone, id, EmployeePassword, Salary, workshift, designation);

                return employee;
            }

            // Close the ResultSet
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Customer displayAdminInformation(Statement stmt, int customerId, String password) {
        try {
            String sql = "SELECT * FROM Customer WHERE CustomerID = " + customerId +" AND CustomerPassword = " + password ;
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("CustomerID");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                String customerPassword = resultSet.getString("CustomerPassword");

                
                Customer customerx = new Customer(name,address,email,phone,id,customerPassword);

                return customerx;
            }

            // Close the ResultSet
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    private void openRoleSpecificWindow(String userRole) {
        switch (userRole) {
            case USER_CUSTOMER:
                openCustomerWindow();
                break;
            case USER_EMPLOYEE:
                openEmployeeWindow();
                break;
            case USER_ADMIN:
                openAdminWindow();
                break;
            default:
                break;
        }
    }

    
   

    
    private void openCustomerWindow() {
        // Create the main frame
    	clearFrame();
    	frame.dispose();
    	
        frame = new JFrame("Customer Information");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Display customer information labels
        JLabel nameLabel =    new JLabel("Name:     " + customer1.getName());
        JLabel addressLabel = new JLabel("Address:  " + customer1.getAddress());
        JLabel emailLabel =   new JLabel("Email:    " + customer1.getEmail());
        JLabel phoneLabel =   new JLabel("Phone:    "  + customer1.getPhone());

        nameLabel.setBounds(10, 20, 300, 25);
        addressLabel.setBounds(10, 50, 300, 25);
        emailLabel.setBounds(10, 80, 300, 25);
        phoneLabel.setBounds(10, 110, 300, 25);

        panel.add(nameLabel);
        panel.add(addressLabel);
        panel.add(emailLabel);
        panel.add(phoneLabel);

        // Create and add "Book Service" button
        JButton bookServiceButton = new JButton("Book Service");
        bookServiceButton.setBounds(10, 150, 150, 30);
        bookServiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bookService();
				
				
			}
		}); // Replace bookService() with your actual action

        panel.add(bookServiceButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 208, 150, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// clearFrame();
               	frame.dispose(); 
                 initialize();
            }
        });
        panel.add(logoutButton);
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        JButton FeedbackButton_1 = new JButton("Give FeedBack");
        FeedbackButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        	GiveFeedBack();
        	}
        });
        FeedbackButton_1.setBounds(173, 146, 150, 30);
        panel.add(FeedbackButton_1);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void GiveFeedBack() {
    	 // Create the main frame
    	clearFrame();
    	frame.dispose();
    	
        frame = new JFrame("FeedBack Window");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel = new JLabel("Select Booking To FeedBack");
        lblNewLabel.setBounds(27, 27, 156, 32);
        panel.add(lblNewLabel);
        
        
        final JComboBox<Integer> comboBoxBookingIDs = new JComboBox<>();
        comboBoxBookingIDs.setBounds(208, 32, 115, 22);
        panel.add(comboBoxBookingIDs);

        // ...

        // Initialize Booking IDs in the JComboBox during frame initialization
        try {
            
            Connection connection = connect();

            // Query to retrieve Booking IDs for the specific customer with Finished status
            String bookingIdQuery = "SELECT bookingId FROM Booking WHERE customerID = ? AND bookingStatus = 'Finished'";
            PreparedStatement bookingIdStatement = connection.prepareStatement(bookingIdQuery);
            bookingIdStatement.setInt(1, customer1.getCustomerId());

            ResultSet bookingIdResultSet = bookingIdStatement.executeQuery();

            // Populate the JComboBox with fetched Booking IDs
            while (bookingIdResultSet.next()) {
                int bookingID = bookingIdResultSet.getInt("bookingId");
                comboBoxBookingIDs.addItem(bookingID);
            }

            // Close database resources
            bookingIdResultSet.close();
            bookingIdStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database-related errors here
        }
        
        final JLabel lblBookingID = new JLabel("New label");
        lblBookingID.setBounds(56, 129, 127, 14);
        panel.add(lblBookingID);
        
        final JLabel lblServiceName = new JLabel("New label");
        lblServiceName.setBounds(56, 159, 127, 14);
        panel.add(lblServiceName);
        
        final JLabel lbBookingDate = new JLabel("New label");
        lbBookingDate.setBounds(56, 195, 127, 14);
        panel.add(lbBookingDate);
        
        JLabel lblGiveRating = new JLabel("Give Rating:");
        lblGiveRating.setBounds(56, 257, 72, 29);
        panel.add(lblGiveRating);
        
        final JComboBox<Integer> comboBoxRating = new JComboBox<>();
        comboBoxRating.setBounds(159, 253, 115, 22);

     // Add rating options from 1 to 5
     for (int i = 1; i <= 5; i++) {
         comboBoxRating.addItem(i);
     }
        panel.add(comboBoxRating);
        
        JLabel lblGiveFeedBackText = new JLabel("Give FeedBack:");
        lblGiveFeedBackText.setBounds(56, 297, 84, 30);
        panel.add(lblGiveFeedBackText);
        
        final JTextField textField_10 = new JTextField();
        textField_10.setBounds(159, 286, 203, 55);
        panel.add(textField_10);
        textField_10.setColumns(10);

        
        // Create and add "Book Service" button
        JButton bookServiceButton = new JButton("Show Deatils");
        bookServiceButton.setBounds(27, 69, 101, 30);
        bookServiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println("Show Details button clicked." + (int) comboBoxBookingIDs.getSelectedItem());

			      

			        try {
			            // Establish a database connection (replace placeholders with actual connection details)
			            Connection connection = connect();

			            // Query to retrieve booking details
			            String query = "SELECT b.bookingId, p.ServiceName, b.bookingDate " +
			                    "FROM Booking b " +
			                    "INNER JOIN Payments p ON b.bookingId = p.BookingID " +
			                    "WHERE b.bookingId = ? AND b.bookingStatus = 'Finished'";

			            PreparedStatement preparedStatement = connection.prepareStatement(query);
			            preparedStatement.setInt(1, (int) comboBoxBookingIDs.getSelectedItem());

			            ResultSet resultSet = preparedStatement.executeQuery();

			            if (resultSet.next()) {
			                int bookingIdFromDatabase = resultSet.getInt("bookingId");
			                String serviceNameFromDatabase = resultSet.getString("ServiceName");
			                String bookingDateFromDatabase = resultSet.getString("bookingDate");

			                // Debug statements to check values
			                System.out.println("Booking ID from database: " + bookingIdFromDatabase);
			                System.out.println("Service Name from database: " + serviceNameFromDatabase);
			                System.out.println("Booking Date from database: " + bookingDateFromDatabase);

			                // Populate labels with fetched data
			                lblBookingID.setText("Booking ID    : " + bookingIdFromDatabase);
			                lblServiceName.setText("Service Name  : " + serviceNameFromDatabase);
			                lbBookingDate.setText("Booking Date  : " + bookingDateFromDatabase);
			            } else {
			                System.out.println("No matching records found in the database.");
			            }

			            // Close database resources
			            resultSet.close();
			            preparedStatement.close();
			            connection.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            // Handle database-related errors here
			        }
				
			}
		}); // Replace bookService() with your actual action

        panel.add(bookServiceButton);
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        JButton FeedbackButton_1 = new JButton("Give FeedBack");
        FeedbackButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		 // Get selected values from the UI components
                int selectedBookingID = (int) comboBoxBookingIDs.getSelectedItem();
                int selectedRating = (int) comboBoxRating.getSelectedItem();
                String feedbackDescription = textField_10.getText();
                String serviceType = "YourServiceType";  // Replace with the actual service type

                try {
                    // Establish a database connection (replace placeholders with actual connection details)
                    Connection connection = connect();

                    // Query to insert feedback into the Feedback table
                    String insertQuery = "INSERT INTO Feedback (Description, Rating, ServiceType, BookingID, CustomerID) " +
                            "VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setString(1, feedbackDescription);
                    insertStatement.setInt(2, selectedRating);
                    insertStatement.setString(3, serviceType);
                    insertStatement.setInt(4, selectedBookingID);
                    insertStatement.setInt(5, customer1.getCustomerId());  // Assuming customer1 is your customer object

                    // Execute the INSERT query
                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Feedback successfully inserted into the database.");
                    } else {
                        System.out.println("Failed to insert feedback.");
                    }

                    // Close database resources
                    insertStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle database-related errors here
                }
        	}
        });
        FeedbackButton_1.setBounds(113, 360, 150, 30);
        panel.add(FeedbackButton_1);
        
        
        
        JButton BackButton = new JButton("Back");
        BackButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	openCustomerWindow();

        		
        	}
        });
        BackButton.setBounds(10, 424, 92, 30);
        panel.add(BackButton);
        
        
        // Make the frame visible
        frame.setVisible(true);
    	
    }
    // Example action for the "Book Service" button
 // Example action for the "Book Service" button
    private void bookService() {
    	clearFrame();
    	frame.dispose();
        // Create a new frame for booking a service
        frame = new JFrame("Booking Frame");
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(null);

        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSelectService = new JLabel("Select Service:");
        lblSelectService.setBounds(50, 50, 100, 20);
        frame.getContentPane().add(lblSelectService);

        // Display service options in a JComboBox
        String[] serviceOptions = {"Simple", "Premium", "Ultimate", "Car Repairing"};
        final JComboBox<String> serviceComboBox = new JComboBox<>(serviceOptions);
        serviceComboBox.setBounds(160, 50, 150, 20);
        frame.getContentPane().add(serviceComboBox);

        JLabel lblSelectDate = new JLabel("Select Date:");
        lblSelectDate.setBounds(50, 80, 100, 20);
        frame.getContentPane().add(lblSelectDate);

        // Display a calendar for selecting the date
        final JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(160, 80, 150, 20);
        frame.getContentPane().add(dateChooser);

        
		String SDate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
		
    	//System.out.println("Selected Date: in strndfd" + SDate);

        JLabel lblSelectTime = new JLabel("Select Time:");
        lblSelectTime.setBounds(50, 110, 100, 20);
        frame.getContentPane().add(lblSelectTime);

        
        
        // Display time slots in a JComboBox
        String[] timeSlots = {"10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM",
                "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM"};
        final JComboBox<String> timeComboBox = new JComboBox<>(timeSlots);
        timeComboBox.setBounds(160, 110, 150, 20);
        frame.getContentPane().add(timeComboBox);

        
        
        // Create and add a button to confirm the booking
        JButton confirmBookingButton = new JButton("Confirm Booking");
        confirmBookingButton.setBounds(160, 140, 150, 25);
        confirmBookingButton.addActionListener(new ActionListener() {
            @SuppressWarnings("null")
			@Override
            public void actionPerformed(ActionEvent e) {
                // Get selected service, date, and time
            	// Get selected service, date, and time
            	String selectedService = (String) serviceComboBox.getSelectedItem();
            	java.util.Date selectedDateUtil =  dateChooser.getDate();
            	String selectedTime = (String) timeComboBox.getSelectedItem();

            	// Create a new java.sql.Date object
            	String d1  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

            	// Print selected details
            	System.out.println("Booking service: " + selectedService);
            	System.out.println("Selected date: " + d1);
            	System.out.println("Selected time: " + selectedTime);

            	int x= generateID();
            	Booking booking = new Booking(x, selectedTime, d1, "pending");
            	customer1.SetBooking(booking);
            	
            	Service x1 = new Service();
            
            	// public RepairingService(String serviceName, double serviceCost, int serviceID, String description) {

            	Payment p = new Payment();
            	p.setPaymentID(generateID());
            	
            	if(selectedService== "Simple") {
                	 x1 = new SimpleService(selectedService,400,1,"");
                	 p.setAmount(400);
                	 updateQuantityx(1);
            	}
            	else if(selectedService== "Premium") {
                	 x1 = new PremiumService(selectedService,500,2,"");
                	 p.setAmount(500);
                	 updateQuantityx(2);
            	}
            	else if(selectedService== "Ultimate") {
                	 x1 = new UltimateService(selectedService,600,2,"");
                	 p.setAmount(600);
                	 updateQuantityx(3);
            	}
            	else {
                	 x1 = new RepairingService(selectedService,700,2,"");
                	 p.setAmount(700);
                	 updateQuantityx(3);
            	}
            	
            	customer1.BookService(x1,  p);
            	customer1.booking.service.display();
            	
            	
            	
            	//write into database
            	{
            		
            		

            		
            		try {
            			
            			 try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

                         // Correct JDBC URL format, include colon after 'mysql'
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");
                         Statement stmt = con.createStatement();
            		    // Assuming you have a Connection object named 'connection'
            		    String sql = "INSERT INTO Booking (customerID, bookingId, bookingTime, bookingDate, bookingStatus) VALUES (?, ?, ?, ?, ?)";
            		    
            		    // Assuming you have a PreparedStatement object named 'preparedStatement' obtained from 'connection'
            		    PreparedStatement preparedStatement = con.prepareStatement(sql);
            		    
            		    // Set values for parameters
            		    preparedStatement.setInt(1, customer1.getCustomerId());               // Assuming customerId is an int
            		    preparedStatement.setInt(2, x);             // Assuming generateID() generates a unique bookingId
            		    preparedStatement.setString(3, selectedTime);          // Assuming selectedTime is a String
            		    preparedStatement.setString(4, d1);            // Assuming selectedDate is a java.sql.Date
            		    preparedStatement.setString(5, "pending");             // Assuming the default status is "pending"

            		    // Execute the update
            		    int rowsAffected = preparedStatement.executeUpdate();

            		    // Check if the insertion was successful
            		    if (rowsAffected > 0) {
            		        System.out.println("Booking inserted successfully.");
            		    } else {
            		        System.out.println("Failed to insert booking.");
            		    }

            		    // Close the PreparedStatement
            		    preparedStatement.close();

            		} catch (SQLException e1) {
            		    e1.printStackTrace();
            		}

            		
            	}
            	
            	//PaymentWindow();
            	createPaymentWindow2();
            	

            }
        });

        frame.getContentPane().add(confirmBookingButton);

        // Make the booking frame visible
        frame.setVisible(true);
    }

    
    private void updateQuantityx(int x) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")) {
            String sql = "UPDATE Inventory SET Quantity = Quantity - ? WHERE Quantity >= ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, x);
                preparedStatement.setInt(2, x);
                preparedStatement.executeUpdate();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private void PaymentWindow() {
    	
    	clearFrame();
    	frame.dispose(); 
    	
        JFrame frame;
        final JTextField cardNumberField;
        JPasswordField pinCodeField;
        final JComboBox<String> paymentModeComboBox;

        frame = new JFrame("Payment Window");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
        
        // Center the payment frame on the screen
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberField = new JTextField();

        JLabel pinCodeLabel = new JLabel("PIN Code:");
        pinCodeField = new JPasswordField();

        JLabel paymentModeLabel = new JLabel("Payment Mode:");
        String[] paymentModes = {"Online", "On the Station"};
        paymentModeComboBox = new JComboBox<>(paymentModes);

        JButton processButton = new JButton("Process Payment");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  processPayment();
            	
            	  String CN = cardNumberField.getText();
                  
                      int number = Integer.parseInt(CN);
            	
                      int customerID = customer1.getCustomerId();  // Replace with the actual customer ID
                      System.out.println("Customer ID: " + customerID);

                      int bookingID = customer1.booking.getBookingId();  // Replace with the actual booking ID
                      System.out.println("Booking ID: " + bookingID);

                      String serviceName = customer1.booking.service.getServiceType();  // Replace with the actual service name
                      System.out.println("Service Name: " + serviceName);

                      int paymentID = customer1.booking.payment.getPaymentID();  // Replace with the actual payment ID
                      System.out.println("Payment ID: " + paymentID);

                      int amount = customer1.booking.payment.getAmount();  // Assuming the amount is entered in the cardNumberField
                      System.out.println("Amount: " + amount);

                      String status = "UnPaid";  // Replace with the actual status
                      if((String) paymentModeComboBox.getSelectedItem()=="Online") {
                          status="Paid";
                      }
                      System.out.println("Payment Status: " + status);

                      String mode = (String) paymentModeComboBox.getSelectedItem();
                      System.out.println("Payment Mode: " + mode);

                      LocalDate currentDate = LocalDate.now();
                      System.out.println("Current Date: " + currentDate);


                 // Assuming you have a Connection object named 'connection'
                 try {
                	    Connection connection = connect();
                	    String insertQuery = "INSERT INTO payments (CustomerID, CustomerCardNo, CustomerPIN, BookingID, ServiceName, paymentID, amount, status, date, mode) " +
                	                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                	    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                	        preparedStatement.setInt(1, customerID);
                	        preparedStatement.setInt(2, paymentID);
                	        preparedStatement.setInt(3, number); // Assuming CustomerCardNo is an integer
                	        preparedStatement.setInt(4, bookingID);
                	        preparedStatement.setString(5, serviceName);
                	        preparedStatement.setInt(6, paymentID);
                	        preparedStatement.setInt(7, amount);
                	        preparedStatement.setString(8, status);
                	        preparedStatement.setString(9, currentDate.toString());
                	        preparedStatement.setString(10, mode);

                	        preparedStatement.executeUpdate();
                	        System.out.println("Payment record inserted successfully");
                	    }
                	} catch (SQLException ex) {
                	    ex.printStackTrace();
                	    // Handle exceptions appropriately
                	}
            }
        });

        mainPanel.add(cardNumberLabel);
        mainPanel.add(cardNumberField);
        mainPanel.add(pinCodeLabel);
        mainPanel.add(pinCodeField);
        mainPanel.add(paymentModeLabel);
        mainPanel.add(paymentModeComboBox);
        mainPanel.add(new JLabel());  // Placeholder for better layout
        mainPanel.add(processButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    

private void createPaymentWindow3() {
    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        // If Nimbus is not available, fall back to the default look and feel.
        e.printStackTrace();
    }

    clearFrame();
    frame.dispose();

    // Create a new frame for payment
    frame = new JFrame("Payment Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 250);

    // Using BoxLayout for the main panel
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBackground(new Color(245, 245, 245)); // Light gray background

    // Creating components
    JLabel cardNumberLabel = new JLabel("Card Number:");
    final JTextField cardNumberField = new JTextField(15);
    JLabel pinCodeLabel = new JLabel("PIN Code:");
    JPasswordField pinCodeField = new JPasswordField(15);
    JLabel paymentModeLabel = new JLabel("Payment Mode:");
    String[] paymentModes = {"Online", "On the Station"};
    final JComboBox<String> paymentModeComboBox = new JComboBox<>(paymentModes);
    JButton processButton = new JButton("Process Payment");
    JButton backButton = new JButton("Back");

    // Setting fonts and other properties
    Font labelFont = new Font("Arial", Font.BOLD, 12);
    cardNumberLabel.setFont(labelFont);
    pinCodeLabel.setFont(labelFont);
    paymentModeLabel.setFont(labelFont);
    processButton.setFont(labelFont);
    backButton.setFont(labelFont);

    processButton.setBackground(new Color(100, 149, 237)); // Cornflower blue button
    processButton.setForeground(Color.WHITE); // White text on buttons
    backButton.setBackground(new Color(192, 192, 192)); // Light grey background
    backButton.setForeground(Color.BLACK); // Black text on button

    // Adding ActionListeners for buttons
    processButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Existing ActionListener code...
        	

     	   int customerID = customer1.getCustomerId(); // Replace with the actual customer ID
            int bookingID = customer1.booking.getBookingId(); // Replace with the actual booking ID

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to the database
                //String url = "jdbc:mysql://your_database_url";
                //String username = "root";
                //String password = "qwerty654321!";
                //Connection connection = DriverManager.getConnection(url, username, password);
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");

                // Update the booking status to "Confirmed"
                String updateQuery = "UPDATE Booking SET bookingStatus = 'Confirmed' WHERE customerID = ? AND bookingId = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setInt(1, customerID);
                    preparedStatement.setInt(2, bookingID);

                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Booking status updated to Confirmed for customerID: " + customerID + " and bookingID: " + bookingID);
                    

                  	  String CN = cardNumberField.getText();
                        
                            int number = Integer.parseInt(CN);
                  	
                            int customerID1 = customer1.getCustomerId();  // Replace with the actual customer ID
                            System.out.println("Customer ID: " + customerID1);

                            int bookingID1 = customer1.booking.getBookingId();  // Replace with the actual booking ID
                            System.out.println("Booking ID: " + bookingID1);

                            String serviceName = customer1.booking.service.getServiceType();  // Replace with the actual service name
                            System.out.println("Service Name: " + serviceName);

                            int paymentID = customer1.booking.payment.getPaymentID();  // Replace with the actual payment ID
                            System.out.println("Payment ID: " + paymentID);

                            int amount = customer1.booking.payment.getAmount();  // Assuming the amount is entered in the cardNumberField
                            System.out.println("Amount: " + amount);

                            String status = "UnPaid";  // Replace with the actual status
                            if((String) paymentModeComboBox.getSelectedItem()=="Online") {
                                status="Paid";
                            }
                            System.out.println("Payment Status: " + status);

                            String mode = (String) paymentModeComboBox.getSelectedItem();
                            System.out.println("Payment Mode: " + mode);

                            LocalDate currentDate = LocalDate.now();
                            System.out.println("Current Date: " + currentDate);


                       // Assuming you have a Connection object named 'connection'
                       try {
                      	    Connection connection1 = connect();
                      	    String insertQuery = "INSERT INTO payments (CustomerID, CustomerCardNo, CustomerPIN, BookingID, ServiceName, paymentID, amount, status, date, mode) " +
                      	                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                      	    try (PreparedStatement preparedStatement1 = connection1.prepareStatement(insertQuery)) {
                      	        preparedStatement1.setInt(1, customerID1);
                      	        preparedStatement1.setInt(2, paymentID);
                      	        preparedStatement1.setInt(3, number); // Assuming CustomerCardNo is an integer
                      	        preparedStatement1.setInt(4, bookingID1);
                      	        preparedStatement1.setString(5, serviceName);
                      	        preparedStatement1.setInt(6, paymentID);
                      	        preparedStatement1.setInt(7, amount);
                      	        preparedStatement1.setString(8, status);
                      	        preparedStatement1.setString(9, currentDate.toString());
                      	        preparedStatement1.setString(10, mode);

                      	        preparedStatement1.executeUpdate();
                      	        System.out.println("Payment record inserted successfully");
                      	    }
                      	} catch (SQLException ex) {
                      	    ex.printStackTrace();
                      	    // Handle exceptions appropriately
                      	}
                        
                        
                    
                    } else {
                        System.out.println("No booking found for customerID: " + customerID + " and bookingID: " + bookingID);
                    }
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                // Handle exceptions as needed
            }
        
     
        }
    });

    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Code to handle the back action
        	frame.dispose();
        	openCustomerWindow();

        }
    });

    // Adding components to the main panel
    mainPanel.add(cardNumberLabel);
    mainPanel.add(cardNumberField);
    mainPanel.add(pinCodeLabel);
    mainPanel.add(pinCodeField);
    mainPanel.add(paymentModeLabel);
    mainPanel.add(paymentModeComboBox);
    mainPanel.add(processButton);
    mainPanel.add(backButton);

    frame.add(mainPanel);
    frame.setVisible(true);
}

    
    private void createPaymentWindow2() {
    	try {
	        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    clearFrame();
	    frame.dispose();

	    frame = new JFrame("Payment Frame");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 250);
	    frame.getContentPane().setLayout(null); // Setting the layout to null

	    // Creating and positioning components
	    JLabel cardNumberLabel = new JLabel("Card Number:");
	    cardNumberLabel.setBounds(30, 25, 100, 30); // x, y, width, height
	    final JTextField cardNumberField = new JTextField(15);
	    cardNumberField.setBounds(140, 25, 165, 30);

	    JLabel pinCodeLabel = new JLabel("PIN Code:");
	    pinCodeLabel.setBounds(30, 66, 100, 30);
	    JPasswordField pinCodeField = new JPasswordField(15);
	    pinCodeField.setBounds(140, 66, 165, 30);

	    JLabel paymentModeLabel = new JLabel("Payment Mode:");
	    paymentModeLabel.setBounds(30, 107, 120, 30);
	    String[] paymentModes = {"Online", "On the Station"};
	    final JComboBox<String> paymentModeComboBox = new JComboBox<>(paymentModes);
	    paymentModeComboBox.setBounds(140, 107, 145, 30);

	    JButton processButton = new JButton("Process Payment");
	    processButton.setBounds(135, 148, 150, 30);
	    JButton backButton = new JButton("Back");
	    backButton.setBounds(30, 148, 80, 30);

	    // Adding ActionListeners for buttons
	    processButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Existing ActionListener code...
	        	

	      	     int customerID = customer1.getCustomerId(); // Replace with the actual customer ID
	             int bookingID = customer1.booking.getBookingId(); // Replace with the actual booking ID

	             try {
	                 // Load the JDBC driver
	                 Class.forName("com.mysql.cj.jdbc.Driver");

	                 // Connect to the database
	                 //String url = "jdbc:mysql://your_database_url";
	                 //String username = "root";
	                 //String password = "qwerty654321!";
	                 //Connection connection = DriverManager.getConnection(url, username, password);
	                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");

	                 // Update the booking status to "Confirmed"
	                 String updateQuery = "UPDATE Booking SET bookingStatus = 'Confirmed' WHERE customerID = ? AND bookingId = ?";
	                 try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                     preparedStatement.setInt(1, customerID);
	                     preparedStatement.setInt(2, bookingID);

	                     int rowsUpdated = preparedStatement.executeUpdate();

	                     if (rowsUpdated > 0) {
	                         System.out.println("Booking status updated to Confirmed for customerID: " + customerID + " and bookingID: " + bookingID);
	                     

	                   	         String CN = cardNumberField.getText();
	                         
	                             int number = Integer.parseInt(CN);
	                   	
	                             int customerID1 = customer1.getCustomerId();  // Replace with the actual customer ID
	                             System.out.println("Customer ID: " + customerID1);

	                             int bookingID1 = customer1.booking.getBookingId();  // Replace with the actual booking ID
	                             System.out.println("Booking ID: " + bookingID1);

	                             String serviceName = customer1.booking.service.getServiceType();  // Replace with the actual service name
	                             System.out.println("Service Name: " + serviceName);

	                             int paymentID = customer1.booking.payment.getPaymentID();  // Replace with the actual payment ID
	                             System.out.println("Payment ID: " + paymentID);

	                             int amount = customer1.booking.payment.getAmount();  // Assuming the amount is entered in the cardNumberField
	                             System.out.println("Amount: " + amount);

	                             String status = "UnPaid";  // Replace with the actual status
	                             if((String) paymentModeComboBox.getSelectedItem()=="Online") {
	                                 status="Paid";
	                             }
	                             System.out.println("Payment Status: " + status);

	                             String mode = (String) paymentModeComboBox.getSelectedItem();
	                             System.out.println("Payment Mode: " + mode);

	                             LocalDate currentDate = LocalDate.now();
	                             System.out.println("Current Date: " + currentDate);


	                        // Assuming you have a Connection object named 'connection'
	                        try {
	                       	    Connection connection1 = connect();
	                       	    String insertQuery = "INSERT INTO payments (CustomerID, CustomerCardNo, CustomerPIN, BookingID, ServiceName, paymentID, amount, status, date, mode) " +
	                       	                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	                       	    try (PreparedStatement preparedStatement1 = connection1.prepareStatement(insertQuery)) {
	                       	        preparedStatement1.setInt(1, customerID1);
	                       	        preparedStatement1.setInt(2, paymentID);
	                       	        preparedStatement1.setInt(3, number); // Assuming CustomerCardNo is an integer
	                       	        preparedStatement1.setInt(4, bookingID1);
	                       	        preparedStatement1.setString(5, serviceName);
	                       	        preparedStatement1.setInt(6, paymentID);
	                       	        preparedStatement1.setInt(7, amount);
	                       	        preparedStatement1.setString(8, status);
	                       	        preparedStatement1.setString(9, currentDate.toString());
	                       	        preparedStatement1.setString(10, mode);

	                       	        preparedStatement1.executeUpdate();
	                       	        System.out.println("Payment record inserted successfully");
	                       	    }
	                       	} catch (SQLException ex) {
	                       	    ex.printStackTrace();
	                       	    // Handle exceptions appropriately
	                       	}
	                         
	                         
	                     
	                     } else {
	                         System.out.println("No booking found for customerID: " + customerID + " and bookingID: " + bookingID);
	                     }
	                 }
	             } catch (ClassNotFoundException | SQLException ex) {
	                 ex.printStackTrace();
	                 // Handle exceptions as needed
	             }
	         
	        	
	        }
	    });

	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            openCustomerWindow();
	        }
	    });

	    frame.getContentPane().add(cardNumberLabel);
	    frame.getContentPane().add(cardNumberField);
	    frame.getContentPane().add(pinCodeLabel);
	    frame.getContentPane().add(pinCodeField);
	    frame.getContentPane().add(paymentModeLabel);
	    frame.getContentPane().add(paymentModeComboBox);
	    frame.getContentPane().add(processButton);
	    frame.getContentPane().add(backButton);

	    frame.setVisible(true);
    }

    private void openEmployeeWindow() {
    	
    	clearFrame();
    	frame.dispose();
    	
    	
    	frame = new JFrame("Employee Window");
        frame.setSize(400, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        
        // Create and add "Book Service" button
       
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(48, 38, 67, 21);
        panel.add(lblName);
        
        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(48, 83, 67, 21);
        panel.add(lblID);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(48, 115, 67, 32);
        panel.add(lblEmail);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(48, 158, 67, 21);
        panel.add(lblAddress);
        
        JLabel lblWorkShift = new JLabel("Work Shift");
        lblWorkShift.setBounds(48, 190, 67, 21);
        panel.add(lblWorkShift);
        
       
        
        JLabel lblDisplayName = new JLabel("New label");
        lblDisplayName.setBackground(Color.GRAY);
        lblDisplayName.setBounds(195, 41, 90, 18);
        panel.add(lblDisplayName);
        
        JLabel lblDisplayID = new JLabel("New label");
        lblDisplayID.setBackground(Color.GRAY);
        lblDisplayID.setBounds(195, 84, 90, 18);
        panel.add(lblDisplayID);
        
        JLabel lblDisplayEmail = new JLabel("New label");
        lblDisplayEmail.setBackground(Color.GRAY);
        lblDisplayEmail.setBounds(195, 124, 90, 14);
        panel.add(lblDisplayEmail);
        
        JLabel lblDisplayAddress = new JLabel("New label");
        lblDisplayAddress.setBackground(Color.GRAY);
        lblDisplayAddress.setBounds(195, 161, 90, 14);
        panel.add(lblDisplayAddress);
        
        JLabel lblDisplayWorkShift = new JLabel("New label");
        lblDisplayWorkShift.setBackground(Color.GRAY);
        lblDisplayWorkShift.setBounds(195, 193, 90, 14);
        panel.add(lblDisplayWorkShift);
       
        
        
        
        // Assuming you have an Employee ID and Password, replace these with actual values
        int employeeID = employee1.getEmployeeId();
        String employeePassword = employee1.getPassword();

        // Connect to the database and retrieve employee details
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")){

            // Query to retrieve employee details based on ID and Password
            String query = "SELECT * FROM Employee WHERE EmployeeID = ? AND EmployeePassword = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, employeeID);
                preparedStatement.setString(2, employeePassword);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Populate the labels with retrieved data
                        lblDisplayName.setText(resultSet.getString("name"));
                        lblDisplayID.setText(Integer.toString(resultSet.getInt("EmployeeID")));
                        lblDisplayEmail.setText(resultSet.getString("email"));
                        lblDisplayAddress.setText(resultSet.getString("address"));
                        lblDisplayWorkShift.setText(resultSet.getString("WorkShift"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        
        
        
        JButton btnNewButton = new JButton("Update Service Status");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		DisplayBookings();
        		
        	}
        });
        btnNewButton.setBounds(35, 276, 146, 42);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Update Inventory");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        	updateinventorywindow();
        	
        		
        	}
        });
        btnNewButton_1.setBounds(203, 276, 146, 42);
        panel.add(btnNewButton_1);
        
        JButton btnBack = new JButton("Logout");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 clearFrame();
                	frame.dispose(); 
        	initialize();
        	}
        	
        });
        btnBack.setBounds(93, 340, 146, 42);
        panel.add(btnBack);
        
        
        // Make the frame visible
        frame.setVisible(true);    	
    }
    
    private void updateinventorywindow() {
    	
    	
    	clearFrame();
    	frame.dispose();
    	
    	  JTextField textField;
    	     JTextField textField_1;
    	     JTextField textField_2;
    	     JTextField textField_3;
    	     JTextField textField_4;
    	     JTextField textField_5;
    	     JTextField textField_6;
    	     JTextField textField_7;
    	     JTextField textField_8;
    	     final JTextField textField_10;
    	
    	frame = new JFrame("Update Inventory");
        frame.setSize(400, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        
        // Create and add "Book Service" button
       
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        JLabel lblName = new JLabel("Choose Product:");
        lblName.setBounds(44, 87, 94, 21);
        panel.add(lblName);
      

        final JComboBox<String> comboBox = new JComboBox();
        

        try (  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")) {
            String sql = "SELECT Product FROM Inventory";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String product = resultSet.getString("Product");
                        comboBox.addItem(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        comboBox.setBounds(171, 86, 129, 22);
        panel.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("Avaiable Stock:");
        lblNewLabel.setBounds(44, 171, 94, 21);
        panel.add(lblNewLabel); 
      
        
        final JLabel lblDisplayStock = new JLabel("");
        lblDisplayStock.setBounds(171, 174, 129, 18);
        panel.add(lblDisplayStock);
        final int q=0;
        JButton btnShowStock = new JButton("Show Stock");
        btnShowStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 String selectedProduct = (String) comboBox.getSelectedItem();
        	        if (selectedProduct != null) {
        	            try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")) {
        	                String sql = "SELECT Quantity FROM Inventory WHERE Product=?";
        	                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	                    preparedStatement.setString(1, selectedProduct);
        	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
        	                        if (resultSet.next()) {
        	                          int   q1 = resultSet.getInt("Quantity");
        	                           // q=q1;
        	                            
        	                            lblDisplayStock.setText("Stock: " + q1);
        	                        }
        	                    }
        	                }
        	            } catch (SQLException e1) {
        	                e1.printStackTrace();
        	            }
        	        }
        	}
        });
        btnShowStock.setBounds(215, 131, 89, 23);
        panel.add(btnShowStock);
        
        
       
        
        
       
        
        JLabel lblNewLabel_1 = new JLabel("Add Stock:");
        lblNewLabel_1.setBounds(44, 227, 94, 21);
        panel.add(lblNewLabel_1);
        
        textField_10 = new JTextField();
        textField_10.setBounds(171, 227, 129, 21);
        panel.add(textField_10);
        textField_10.setColumns(10);
      
        
        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		 String selectedProduct = (String) comboBox.getSelectedItem();
     	        if (selectedProduct != null) {
     	            try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")) {
     	                String sql = "SELECT Quantity FROM Inventory WHERE Product=?";
     	                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
     	                    preparedStatement.setString(1, selectedProduct);
     	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
     	                        if (resultSet.next()) {
     	                          int   q1 = resultSet.getInt("Quantity");
     	                           // q=q1;
     	                            
     	                          {
     	                        	  
     	                        	 String selectedProduct1 = (String) comboBox.getSelectedItem();
     	                	        if (selectedProduct1 != null) {
     	                	            try ( Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!")) {
     	                	                String sql1 = "UPDATE Inventory SET Quantity=? WHERE Product=?";
     	                	                try (PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1)) {
     	                	                    int newQuantity = Integer.parseInt(textField_10.getText())+q1;
     	                	                    preparedStatement1.setInt(1, newQuantity);
     	                	                    preparedStatement1.setString(2, selectedProduct1);
     	                	                    preparedStatement1.executeUpdate();
     	                	                    // Update the display after the update
     	                	                    
     	                	                }
     	                	            } catch (SQLException e1) {
     	                	                e1.printStackTrace();
     	                	            }
     	                	        }
     	                        	  
     	                          }
     	                          
     	                        
     	                           // lblDisplayStock.setText("Stock: " + q1);
     	                        }
     	                    }
     	                }
     	            } catch (SQLException e1) {
     	                e1.printStackTrace();
     	            }
     	        }
        		
        		
        		
        		
        		
        		
        	}
        });
        btnNewButton_1.setBounds(119, 277, 146, 42);
        panel.add(btnNewButton_1);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                openEmployeeWindow();
        	}
        });
        btnBack.setBounds(10, 330, 146, 42);
        panel.add(btnBack);
        
        
        // Make the frame visible
        frame.setVisible(true);
    	
    }

    private void DisplayBookings() {
    	
    	clearFrame();
    	frame.dispose();
    	
    	frame = new JFrame("Display Bookings");
        frame.setSize(400, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the customer information
        JPanel panel = new JPanel();
        panel.setLayout(null);

        
        // Create and add "Book Service" button
       
        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        JLabel lblName = new JLabel("Bookings: ");
        lblName.setBounds(62, 87, 67, 21);
        panel.add(lblName);
       
        String[] Bks = Gbookings();
        
        final JComboBox<String> comboBox = new JComboBox<>(Bks);
        comboBox.setBounds(171, 86, 129, 22);
        panel.add(comboBox);
        
        JButton btnNewButton_1 = new JButton("Update Status");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		String selectedBookingId = (String) comboBox.getSelectedItem();

                if (selectedBookingId != null) {
                    try {
                        // Load the JDBC driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // Connect to the database
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");

                        // Update the booking status to "Finished" for the selected booking ID
                        String updateQuery = "UPDATE Booking SET bookingStatus = 'Finished' WHERE bookingId = ?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                            preparedStatement.setInt(1, Integer.parseInt(selectedBookingId));

                            int rowsUpdated = preparedStatement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("Booking status updated to Finished for bookingID: " + selectedBookingId);
                            } else {
                                System.out.println("No booking found for bookingID: " + selectedBookingId);
                            }
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                        // Handle exceptions as needed
                    }
                }
        		
        	}
        });
        btnNewButton_1.setBounds(119, 277, 146, 42);
        panel.add(btnNewButton_1);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                openEmployeeWindow();
        	}
        });
        btnBack.setBounds(10, 330, 146, 42);
        panel.add(btnBack);
       
        
        
        // Make the frame visible
        frame.setVisible(true);
    }
    
    private String[] Gbookings() {
    	ArrayList<Object> confirmedBookingIds = new ArrayList<>();

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "qwerty654321!");

            // Retrieve all booking IDs with booking status "Confirmed"
            String selectQuery = "SELECT bookingId FROM Booking WHERE bookingStatus = 'Confirmed'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int bookingId = resultSet.getInt("bookingId");
                    confirmedBookingIds.add(String.valueOf(bookingId));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions as needed
        }

        // Convert the list of booking IDs to an array
        return confirmedBookingIds.toArray(new String[0]);

    	
    	
    }
    private void openAdminWindow() {
    	
    	clearFrame();
    	frame.dispose();
    	

         frame = new JFrame("Admin Window");
         frame.setSize(400, 421);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Apply the same look and feel (Nimbus)
         try {
             UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
             SwingUtilities.updateComponentTreeUI(frame);
         } catch (Exception e) {
             e.printStackTrace();
         }

         // Create a panel to hold the admin options
         JPanel panel = new JPanel();
         panel.setLayout(null);

         frame.getContentPane().add(panel);

         final JButton btnManageCustomer = new JButton("Manage Customers");
         btnManageCustomer.setBackground(new Color(0, 102, 204));
         btnManageCustomer.setForeground(Color.WHITE);
         btnManageCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 btnManageCustomer.setBackground(new Color(51, 153, 255));
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
                 btnManageCustomer.setBackground(new Color(0, 102, 204));
             }
         });
         btnManageCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
         btnManageCustomer.setBounds(105, 48, 180, 30);
         panel.add(btnManageCustomer);

         final JButton btnManageEmployees = new JButton("Manage Employees");
         btnManageEmployees.setBackground(new Color(0, 102, 204));
         btnManageEmployees.setForeground(Color.WHITE);
         btnManageEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 btnManageEmployees.setBackground(new Color(51, 153, 255));
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
                 btnManageEmployees.setBackground(new Color(0, 102, 204));
             }
         });
         btnManageEmployees.setFont(new Font("Arial", Font.PLAIN, 14));
         btnManageEmployees.setBounds(105, 106, 180, 30);
         panel.add(btnManageEmployees);

         final JButton btnUpdateVerification = new JButton("Update Verification");
         btnUpdateVerification.setBackground(new Color(0, 102, 204));
         btnUpdateVerification.setForeground(Color.WHITE);
         btnUpdateVerification.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 btnUpdateVerification.setBackground(new Color(51, 153, 255));
                 
                 
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
                 btnUpdateVerification.setBackground(new Color(0, 102, 204));
             }
         });
         btnUpdateVerification.setFont(new Font("Arial", Font.PLAIN, 14));
         btnUpdateVerification.setBounds(107, 171, 178, 30);
         panel.add(btnUpdateVerification);

         final JButton btnCheckRecords = new JButton("Check Booking Records");
         btnCheckRecords.setBackground(new Color(0, 102, 204));
         btnCheckRecords.setForeground(Color.WHITE);
         btnCheckRecords.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 btnCheckRecords.setBackground(new Color(51, 153, 255));
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
                 btnCheckRecords.setBackground(new Color(0, 102, 204));
             }
         });
         btnCheckRecords.setFont(new Font("Arial", Font.PLAIN, 14));
         btnCheckRecords.setBounds(105, 226, 180, 30);
         panel.add(btnCheckRecords);

         // Add action listeners for the buttons
         btnManageCustomer.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ManageCustomers();
             }
         });

         btnManageEmployees.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ManageEmloyees();
             }
         });

         btnUpdateVerification.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 UpdateVerification();
        	 }
         });
         
         btnCheckRecords.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 CheckAndDisplayBookingRecords();
        	 }
         }
        		 );
         
         
         JButton btnBack = new JButton("Logout");
         btnBack.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		 clearFrame();
                	frame.dispose();
                 initialize();
         	}
         });
         btnBack.setBounds(10, 330, 146, 42);
         panel.add(btnBack);
         
         JButton btnCheckRecordsPayments = new JButton("Check Payments Records");
         btnCheckRecordsPayments.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		CheckAndDisplayPaymentRecords();
         		
         	}
         });
         btnCheckRecordsPayments.setForeground(Color.WHITE);
         btnCheckRecordsPayments.setFont(new Font("Arial", Font.PLAIN, 14));
         btnCheckRecordsPayments.setBackground(new Color(0, 102, 204));
         btnCheckRecordsPayments.setBounds(105, 277, 180, 30);
         panel.add(btnCheckRecordsPayments);
         // Make the frame visible
         frame.setVisible(true);
    }
    
	private void UpdateVerification() {
    	
		clearFrame();
    	frame.dispose();
		
    	 frame = new JFrame();
         frame.setBounds(100, 100, 450, 300);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().setLayout(null);

         ImageIcon icon = new ImageIcon("icon.png"); // Replace with your image path
         frame.setIconImage(icon.getImage());

         ImageIcon backgroundIcon = new ImageIcon("icon.png");

        
         
         final JComboBox<Integer> comboBox = new JComboBox<>();
         comboBox.setBounds(194, 35, 115, 22);
         frame.getContentPane().add(comboBox);
         
         
         try {
        	 Connection conn=connect();
             String query = "SELECT CustomerID FROM Verification WHERE VerificationStatus = 'Pending'";
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();

             while (rs.next()) {
                 int customerId = rs.getInt("CustomerID");
                 comboBox.addItem(customerId);
             }

             stmt.close();
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle database query error
         }
         
         JLabel lblCustomerID = new JLabel("Select Customer ID:");
         lblCustomerID.setBounds(51, 35, 104, 22);
         frame.getContentPane().add(lblCustomerID);
         
         JLabel lblCustomerName = new JLabel("Customer Name:");
         lblCustomerName.setBounds(51, 68, 104, 22);
         frame.getContentPane().add(lblCustomerName);
         
         JLabel lblCustomerEmail = new JLabel("Customer Email:");
         lblCustomerEmail.setBounds(51, 101, 104, 22);
         frame.getContentPane().add(lblCustomerEmail);
         
         JLabel lblCustomerAdd = new JLabel("Customer Address:");
         lblCustomerAdd.setBounds(51, 134, 104, 22);
         frame.getContentPane().add(lblCustomerAdd);
         
         JLabel lblNewLabel_1_2 = new JLabel("Customer Phone No:");
         lblNewLabel_1_2.setBounds(51, 170, 104, 22);
         frame.getContentPane().add(lblNewLabel_1_2);
         
         final JLabel lblDisplayName = new JLabel("Name");
         lblDisplayName.setBounds(194, 68, 104, 22);
         frame.getContentPane().add(lblDisplayName);
         
         final JLabel lblDisplayPhone = new JLabel("Phone");
         lblDisplayPhone.setBounds(194, 170, 104, 22);
         frame.getContentPane().add(lblDisplayPhone);
         
         final JLabel lblDisplayAddress = new JLabel("Address");
         lblDisplayAddress.setBounds(194, 134, 104, 22);
         frame.getContentPane().add(lblDisplayAddress);
         
         final JLabel lblDisplayEmail = new JLabel("Email");
         lblDisplayEmail.setBounds(194, 101, 104, 22);
         frame.getContentPane().add(lblDisplayEmail);
         
         JButton btnShowData = new JButton("Show Data");
         btnShowData.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         
         		try {
         			Integer selectedValue = (Integer) comboBox.getSelectedItem();
         			int x = selectedValue.intValue();
         			Connection conn=connect();
                    String query = "SELECT Name, Email, Address, Phone FROM Customer WHERE CustomerID = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, x);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        lblDisplayName.setText(rs.getString("Name"));
                        lblDisplayEmail.setText(rs.getString("Email"));
                        lblDisplayAddress.setText(rs.getString("Address"));
                        lblDisplayPhone.setText(rs.getString("Phone"));
                    } else {
                        // Handle customer not found
                    }

                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    // Handle database query error
                }
         	
         	}
         });
         btnShowData.setBounds(323, 35, 89, 23);
         frame.getContentPane().add(btnShowData);
         
         JButton btnNewButton = new JButton("Update Status");
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		try {
         			Connection conn=connect();
         			Integer selectedValue = (Integer) comboBox.getSelectedItem();
         			int x = selectedValue.intValue();
                    String query = "UPDATE Verification SET VerificationStatus = 'Verified' WHERE CustomerID = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, x);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Verification status updated successfully
                    } else {
                        // Handle update failure
                    }

                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    // Handle database update error
                }
         		
         	}
         });
         btnNewButton.setBounds(138, 203, 160, 28);
         frame.getContentPane().add(btnNewButton);
         
         JButton btnBack = new JButton("Back");
         btnBack.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		  clearFrame();
  	            frame.dispose();
  	            openAdminWindow();
         	}
         });
         btnBack.setBounds(10, 227, 89, 23);
         frame.getContentPane().add(btnBack);
         
         frame.setVisible(true);
    }
    private void ManageCustomers() {
    	
    	clearFrame();
        frame.dispose();

        frame = new JFrame("Update Customer");
        frame.setTitle("Admin Window");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Apply the same look and feel (Nimbus)
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(null);

        frame.getContentPane().add(panel);

        JLabel lblFindCustomer = new JLabel("Find Customer");
        lblFindCustomer.setForeground(Color.DARK_GRAY);
        lblFindCustomer.setBackground(Color.BLUE);
        lblFindCustomer.setFont(new Font("Arial", Font.BOLD, 20));
        lblFindCustomer.setBounds(150, 25, 200, 30);
        panel.add(lblFindCustomer);

        JLabel lblEnterID = new JLabel("Enter Customer ID:");
        lblEnterID.setBounds(50, 60, 130, 22);
        panel.add(lblEnterID);

        final JTextField textFieldID = new JTextField();
        textFieldID.setBounds(194, 61, 86, 20);
        panel.add(textFieldID);
        textFieldID.setColumns(10);

        // Additional fields for updating customer data
        final JTextField txtName = new JTextField();
        txtName.setBounds(194, 100, 150, 20);
        panel.add(txtName);

        final JTextField txtAddress = new JTextField();
        txtAddress.setBounds(194, 140, 150, 20);
        panel.add(txtAddress);

        final JTextField txtEmail = new JTextField();
        txtEmail.setBounds(194, 180, 150, 20);
        panel.add(txtEmail);

        final JTextField txtPhone = new JTextField();
        txtPhone.setBounds(194, 220, 150, 20);
        panel.add(txtPhone);

        final JButton btnFindCustomer = new JButton("Find");
        btnFindCustomer.setBackground(new Color(0, 102, 204));
        btnFindCustomer.setForeground(Color.WHITE);
        btnFindCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFindCustomer.setBackground(new Color(51, 153, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFindCustomer.setBackground(new Color(0, 102, 204));
            }
        });
        btnFindCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
        btnFindCustomer.setBounds(200, 380, 120, 30);
        panel.add(btnFindCustomer);

        // Add similar design improvements to other buttons...

        // Action for the "Find" button
        btnFindCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = textFieldID.getText();
                Connection conn = connect();
                String query = "SELECT * FROM Customer WHERE CustomerID = ?";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, customerId);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        txtName.setText(rs.getString("Name"));
                        txtAddress.setText(rs.getString("Address"));
                        txtEmail.setText(rs.getString("Email"));
                        txtPhone.setText(rs.getString("Phone"));
                        // CustomerPassword is not retrieved for security reasons
                    }
                    rs.close();
                    pst.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Action for the "Update" button
        final JButton btnUpdateCustomer = new JButton("Update");
        btnUpdateCustomer.setBackground(new Color(0, 102, 204));
        btnUpdateCustomer.setForeground(Color.WHITE);
        btnUpdateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateCustomer.setBackground(new Color(51, 153, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateCustomer.setBackground(new Color(0, 102, 204));
            }
        });
        btnUpdateCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
        btnUpdateCustomer.setBounds(200, 420, 120, 30);
        panel.add(btnUpdateCustomer);

        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = textFieldID.getText();
                Connection conn = connect();
                String query = "UPDATE Customer SET Name = ?, Address = ?, Email = ?, Phone = ? WHERE CustomerID = ?";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, txtName.getText());
                    pst.setString(2, txtAddress.getText());
                    pst.setString(3, txtEmail.getText());
                    pst.setString(4, txtPhone.getText());
                    pst.setString(5, customerId);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Customer updated successfully!");
                    pst.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Action for the "Delete" button
        final JButton btnDeleteCustomer = new JButton("Delete");
        btnDeleteCustomer.setBackground(new Color(0, 102, 204));
        btnDeleteCustomer.setForeground(Color.WHITE);
        btnDeleteCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteCustomer.setBackground(new Color(51, 153, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteCustomer.setBackground(new Color(0, 102, 204));
            }
        });
        btnDeleteCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
        btnDeleteCustomer.setBounds(200, 460, 120, 30);
        panel.add(btnDeleteCustomer);

        btnDeleteCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = textFieldID.getText();
                Connection conn = connect();
                String query = "DELETE FROM Customer WHERE CustomerID = ?";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, customerId);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Customer deleted successfully!");
                    pst.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        
        JButton btnBack = new JButton("Back");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	  clearFrame();
	            frame.dispose();
	            openAdminWindow();
	    	}
	    });
	    btnBack.setForeground(Color.WHITE);
	    btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnBack.setBackground(new Color(0, 102, 204));
	    btnBack.setBounds(60, 500, 120, 30);
	    panel.add(btnBack);

        frame.setVisible(true);
    }
    
    
    
 private void ManageEmloyees() {
	 clearFrame();
	    frame.dispose();

	    frame = new JFrame("Update Employee");
	    frame.setTitle("Admin Window");
	    frame.setSize(600, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Apply a cool look and feel (Nimbus)
	    try {
	        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(frame);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    JPanel panel = new JPanel();
	    panel.setLayout(null);

	    frame.getContentPane().add(panel);

	    JLabel lblFindEmployee = new JLabel("Find Employee");
	    lblFindEmployee.setForeground(Color.DARK_GRAY);
	    lblFindEmployee.setBackground(Color.BLUE);
	    lblFindEmployee.setFont(new Font("Arial", Font.BOLD, 20));
	    lblFindEmployee.setBounds(150, 25, 200, 30);
	    panel.add(lblFindEmployee);

	    JLabel lblEnterID = new JLabel("Enter Employee ID:");
	    lblEnterID.setBounds(50, 60, 130, 22);
	    panel.add(lblEnterID);

	    final JTextField textFieldID = new JTextField();
	    textFieldID.setBounds(194, 61, 150, 20);
	    panel.add(textFieldID);
	    textFieldID.setColumns(10);

	    // Additional fields for updating employee data
	    final JTextField txtName = new JTextField();
	    txtName.setBounds(194, 100, 150, 20);
	    panel.add(txtName);

	    final JTextField txtAddress = new JTextField();
	    txtAddress.setBounds(194, 140, 150, 20);
	    panel.add(txtAddress);

	    final JTextField txtEmail = new JTextField();
	    txtEmail.setBounds(194, 180, 150, 20);
	    panel.add(txtEmail);

	    final JTextField txtPhone = new JTextField();
	    txtPhone.setBounds(194, 220, 150, 20);
	    panel.add(txtPhone);

	    final JTextField txtSalary = new JTextField();
	    txtSalary.setBounds(194, 260, 150, 20);
	    panel.add(txtSalary);

	    final JTextField txtWorkShift = new JTextField();
	    txtWorkShift.setBounds(194, 300, 150, 20);
	    panel.add(txtWorkShift);

	    final JTextField txtDesignation = new JTextField();
	    txtDesignation.setBounds(194, 340, 150, 20);
	    panel.add(txtDesignation);

	    final JTextField txtPassword = new JTextField();
	    txtPassword.setBounds(194, 376, 150, 20);
	    panel.add(txtPassword);
	    
	    final JButton btnFindEmployee = new JButton("Find");
	    btnFindEmployee.setBackground(new Color(0, 102, 204));
	    btnFindEmployee.setForeground(Color.WHITE);
	    btnFindEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btnFindEmployee.setBackground(new Color(51, 153, 255));
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btnFindEmployee.setBackground(new Color(0, 102, 204));
	        }
	    });
	    btnFindEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnFindEmployee.setBounds(342, 420, 120, 30);
	    panel.add(btnFindEmployee);

	    final JButton btnUpdateEmployee = new JButton("Update");
	    btnUpdateEmployee.setBackground(new Color(0, 102, 204));
	    btnUpdateEmployee.setForeground(Color.WHITE);
	    btnUpdateEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btnUpdateEmployee.setBackground(new Color(51, 153, 255));
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btnUpdateEmployee.setBackground(new Color(0, 102, 204));
	        }
	    });
	    btnUpdateEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnUpdateEmployee.setBounds(194, 420, 120, 30);
	    panel.add(btnUpdateEmployee);

	    final JButton btnDeleteEmployee = new JButton("Delete");
	    btnDeleteEmployee.setBackground(new Color(0, 102, 204));
	    btnDeleteEmployee.setForeground(Color.WHITE);
	    btnDeleteEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btnDeleteEmployee.setBackground(new Color(51, 153, 255));
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btnDeleteEmployee.setBackground(new Color(0, 102, 204));
	        }
	    });
	    btnDeleteEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnDeleteEmployee.setBounds(60, 420, 120, 30);
	    panel.add(btnDeleteEmployee);

	    // Action for the "Find" button
	    btnFindEmployee.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String employeeId = textFieldID.getText();
	            Connection conn = connect();
	            String query = "SELECT * FROM Employee WHERE EmployeeID = ?";
	            try (PreparedStatement pst = conn.prepareStatement(query)) {
	                pst.setString(1, employeeId);
	                ResultSet rs = pst.executeQuery();
	                if (rs.next()) {
	                    txtName.setText(rs.getString("name"));
	                    txtAddress.setText(rs.getString("address"));
	                    txtEmail.setText(rs.getString("email"));
	                    txtPhone.setText(rs.getString("Phone"));
	                    txtSalary.setText(rs.getString("salary"));
	                    txtWorkShift.setText(rs.getString("WorkShift"));
	                    txtDesignation.setText(rs.getString("Designation"));
	                    txtPassword.setText(rs.getString("EmployeePassword"));
	                }
	                rs.close();
	                pst.close();
	                conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    });

	    // Action for the "Update" button
	    btnUpdateEmployee.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String employeeId = textFieldID.getText();
	            Connection conn = connect();
	            String query = "UPDATE Employee SET name = ?, address = ?, email = ?, Phone = ?, salary = ?, WorkShift = ?, Designation = ?, EmployeePassword=? WHERE EmployeeID = ?";
	            try (PreparedStatement pst = conn.prepareStatement(query)) {
	                pst.setString(1, txtName.getText());
	                pst.setString(2, txtAddress.getText());
	                pst.setString(3, txtEmail.getText());
	                pst.setString(4, txtPhone.getText());
	                pst.setString(5, txtSalary.getText());
	                pst.setString(6, txtWorkShift.getText());
	                pst.setString(7, txtDesignation.getText());
	                pst.setString(8, employeeId);
	                pst.setString(9, txtPassword.getText());
	                pst.executeUpdate();
	                JOptionPane.showMessageDialog(frame, "Employee updated successfully!");
	                pst.close();
	                conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    });

	    // Action for the "Delete" button
	    btnDeleteEmployee.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String employeeId = textFieldID.getText();
	            Connection conn = connect();
	            String query = "DELETE FROM Employee WHERE EmployeeID = ?";
	            try (PreparedStatement pst = conn.prepareStatement(query)) {
	                pst.setString(1, employeeId);
	                pst.executeUpdate();
	                JOptionPane.showMessageDialog(frame, "Employee deleted successfully!");
	                pst.close();
	                conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    });

	    
	    final JButton btnRegisterEmployee = new JButton("Register");
	    btnRegisterEmployee.setBackground(new Color(0, 102, 204));
	    btnRegisterEmployee.setForeground(Color.WHITE);
	    btnRegisterEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btnRegisterEmployee.setBackground(new Color(51, 153, 255));
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btnRegisterEmployee.setBackground(new Color(0, 102, 204));
	        }
	    });
	    btnRegisterEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnRegisterEmployee.setBounds(200, 500, 120, 30);
	    panel.add(btnRegisterEmployee);
	    
	    JLabel lblEnterID_1 = new JLabel(" Employee Name:");
	    lblEnterID_1.setBounds(50, 103, 130, 22);
	    panel.add(lblEnterID_1);
	    
	    JLabel lblEnterID_2 = new JLabel("Employee Add:");
	    lblEnterID_2.setBounds(50, 143, 130, 22);
	    panel.add(lblEnterID_2);
	    
	    JLabel lblEnterID_3 = new JLabel("Employee Email:");
	    lblEnterID_3.setBounds(50, 183, 130, 22);
	    panel.add(lblEnterID_3);
	    
	    JLabel lblEnterID_4 = new JLabel("Employee Phone:");
	    lblEnterID_4.setBounds(50, 218, 130, 22);
	    panel.add(lblEnterID_4);
	    
	    JLabel lblEnterID_5 = new JLabel("Employee Salary:");
	    lblEnterID_5.setBounds(50, 263, 130, 22);
	    panel.add(lblEnterID_5);
	    
	    JLabel lblEmployeeShift = new JLabel("Employee Shift:");
	    lblEmployeeShift.setBounds(50, 303, 130, 22);
	    panel.add(lblEmployeeShift);
	    
	    JLabel lblEmployeeDesignation = new JLabel("Employee Designation:");
	    lblEmployeeDesignation.setBounds(50, 343, 130, 22);
	    panel.add(lblEmployeeDesignation);
	    
	  
	    
	    JLabel lblEmployeePassword = new JLabel("Employee Password:");
	    lblEmployeePassword.setBounds(50, 379, 130, 22);
	    panel.add(lblEmployeePassword);

	    // Action for the "Register" button
	    btnRegisterEmployee.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {


	        	
	        	String name = txtName.getText();
	            String address = txtAddress.getText();
	            String email = txtEmail.getText();
	            String phone = txtPhone.getText();
	            String salary = txtSalary.getText();
	            String workShift = txtWorkShift.getText();
	            String designation = txtDesignation.getText();
	            String password =txtPassword.getText() ;
	            // Validate input fields (add more validation as needed)
	            if (name.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() ||
	                    salary.isEmpty() || workShift.isEmpty() || designation.isEmpty()) {
	                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            Connection conn = connect();

	            // Insert into Employee table
	            String query = "INSERT INTO Employee (name, address, email, Phone, salary, WorkShift, Designation, EmployeePassword) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
	            try (PreparedStatement pst = conn.prepareStatement(query)) {
	                pst.setString(1, name);
	                pst.setString(2, address);
	                pst.setString(3, email);
	                pst.setString(4, phone);
	                pst.setString(5, salary);
	                pst.setString(6, workShift);
	                pst.setString(7, designation);
	                pst.setString(8, password);
	                pst.executeUpdate();

	                JOptionPane.showMessageDialog(frame, "Employee registered successfully!");
	               // clearFields(); // Clear input fields after registration
	                txtName.setText("");
	                txtAddress.setText("");
	                txtEmail.setText("");
	                txtPhone.setText("");
	                txtSalary.setText("");
	                txtWorkShift.setText("");
	                txtDesignation.setText("");
	                textFieldID.setText(""); 
	                txtPassword.setText("");
	                pst.close();
	                conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(frame, "Error occurred during registration", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    
	    JButton btnBack = new JButton("Back");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		  clearFrame();
		            frame.dispose();
		            openAdminWindow();	    	}
	    });
	    btnBack.setForeground(Color.WHITE);
	    btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnBack.setBackground(new Color(0, 102, 204));
	    btnBack.setBounds(60, 500, 120, 30);
	    panel.add(btnBack);
	    frame.setVisible(true);
    
    	
	    
	    
    }
 
 
 public void CheckAndDisplayPaymentRecords() {
	    frame = new JFrame("Check Payment Records");
	    frame.setSize(800, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel = new JPanel(new BorderLayout());

	    // Create a table model to hold the payment data
	    DefaultTableModel tableModel = new DefaultTableModel();

	    // Add columns to the table model
	    tableModel.addColumn("Customer ID");
	    tableModel.addColumn("Customer Card No");
	    tableModel.addColumn("Customer PIN");
	    tableModel.addColumn("Booking ID");
	    tableModel.addColumn("Service Name");
	    tableModel.addColumn("Payment ID");
	    tableModel.addColumn("Amount");
	    tableModel.addColumn("Status");
	    tableModel.addColumn("Date");
	    tableModel.addColumn("Mode");

	    // Create the JTable with the table model
	    final JTable table = new JTable(tableModel);

	    // Create a scroll pane to hold the table
	    JScrollPane scrollPane = new JScrollPane(table);

	    try {
	        // Connect to your database (modify the connection URL, username, and password)
	        Connection conn = connect();
	        Statement stmt = conn.createStatement();

	        // Execute a query to fetch payment records (modify the SQL query)
	        String query = "SELECT * FROM payments";
	        ResultSet rs = stmt.executeQuery(query);

	        // Iterate through the result set and add data to the table
	        while (rs.next()) {
	            Object[] rowData = {
	                rs.getInt("CustomerID"),
	                rs.getInt("CustomerCardNo"),
	                rs.getInt("CustomerPIN"),
	                rs.getInt("BookingID"),
	                rs.getString("ServiceName"),
	                rs.getInt("paymentID"),
	                rs.getInt("amount"),
	                rs.getString("status"),
	                rs.getDate("date"),
	                rs.getString("mode")
	            };
	            tableModel.addRow(rowData);
	        }

	        // Close the database connection
	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Add the scroll pane to the panel
	    panel.add(scrollPane, BorderLayout.NORTH);

	    frame.getContentPane().add(panel);

	    JButton btnNewButton = new JButton("Back");
	    btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            clearFrame();
	            frame.dispose();
	            openAdminWindow();
	        }
	    });
	    panel.add(btnNewButton, BorderLayout.SOUTH);

	    JButton btnNewButton_1 = new JButton("Download");
	    btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // The download logic remains the same as in the previous example
	            // ...
	        	 // Prompt user for file save location
	            JFileChooser fileChooser = new JFileChooser();
	            int userSelection = fileChooser.showSaveDialog(frame);

	            if (userSelection == JFileChooser.APPROVE_OPTION) {
	                File fileToSave = fileChooser.getSelectedFile();

	                Document document = new Document(PageSize.A4.rotate());

	                try {
	                    PdfWriter.getInstance(document, new FileOutputStream(fileToSave + ".pdf"));
	                    document.open();

	                    // Add a title to the PDF
	                    document.add(new Paragraph("Payments Records"));

	                    // Create a PdfPTable with the same number of columns as your JTable
	                    PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

	                    // Add column headers to the PDF table
	                    for (int i = 0; i < table.getColumnCount(); i++) {
	                        pdfTable.addCell(new Phrase(table.getColumnName(i)));
	                    }

	                    // Add data to the PDF table
	                    for (int i = 0; i < table.getRowCount(); i++) {
	                        for (int j = 0; j < table.getColumnCount(); j++) {
	                            pdfTable.addCell(new Phrase(table.getValueAt(i, j).toString()));
	                        }
	                    }

	                    // Add the PDF table to the document
	                    document.add(pdfTable);

	                    JOptionPane.showMessageDialog(frame, "Table downloaded successfully as PDF.");
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(frame, "Error downloading table as PDF.");
	                } finally {
	                    // Close the document
	                    if (document != null) {
	                        document.close();
	                    }
	                }
	            }
	        
	            // Add the PDF table to the document
	           // document.add(pdfTable);

	        }
	    });

	    panel.add(btnNewButton_1, BorderLayout.CENTER);
	    frame.setVisible(true);
	}

 public void CheckAndDisplayBookingRecords() {
	 frame = new JFrame("Check Records");
	    frame.setSize(800, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel = new JPanel(new BorderLayout());

	    // Create a table model to hold the booking data
	    DefaultTableModel tableModel = new DefaultTableModel();

	    // Add columns to the table model (adjust these according to your database structure)
	    tableModel.addColumn("Customer ID");
	    tableModel.addColumn("Booking ID");
	    tableModel.addColumn("Booking Time");
	    tableModel.addColumn("Booking Date");
	    tableModel.addColumn("Booking Status");

	    // Create the JTable with the table model
	    final JTable table = new JTable(tableModel);

	    // Create a scroll pane to hold the table
	    JScrollPane scrollPane = new JScrollPane(table);

	    try {
	        // Connect to your database (modify the connection URL, username, and password)
	        Connection conn = connect();
	        Statement stmt = conn.createStatement();

	        // Execute a query to fetch booking records (modify the SQL query)
	        String query = "SELECT customerID, bookingId, bookingTime, bookingDate, bookingStatus FROM Booking";
	        ResultSet rs = stmt.executeQuery(query);

	        // Iterate through the result set and add data to the table
	        while (rs.next()) {
	            Object[] rowData = {
	                rs.getInt("customerID"),
	                rs.getInt("bookingId"),
	                rs.getString("bookingTime"),
	                rs.getString("bookingDate"),
	                rs.getString("bookingStatus")
	            };
	            tableModel.addRow(rowData);
	        }

	        // Close the database connection
	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Add the scroll pane to the panel
	    panel.add(scrollPane, BorderLayout.NORTH);

	    frame.getContentPane().add(panel);
	    
	    JButton btnNewButton = new JButton("Back");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		 clearFrame();
             	frame.dispose();
              openAdminWindow();
	    		
	    	}
	    });
	    panel.add(btnNewButton, BorderLayout.SOUTH);
	    
	    JButton btnNewButton_1 = new JButton("Download");
	    btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Prompt user for file save location
	            JFileChooser fileChooser = new JFileChooser();
	            int userSelection = fileChooser.showSaveDialog(frame);

	            if (userSelection == JFileChooser.APPROVE_OPTION) {
	                File fileToSave = fileChooser.getSelectedFile();

	                Document document = new Document(PageSize.A4.rotate());

	                try {
	                    PdfWriter.getInstance(document, new FileOutputStream(fileToSave + ".pdf"));
	                    document.open();

	                    // Add a title to the PDF
	                    document.add(new Paragraph("Booking Records"));

	                    // Create a PdfPTable with the same number of columns as your JTable
	                    PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

	                    // Add column headers to the PDF table
	                    for (int i = 0; i < table.getColumnCount(); i++) {
	                        pdfTable.addCell(new Phrase(table.getColumnName(i)));
	                    }

	                    // Add data to the PDF table
	                    for (int i = 0; i < table.getRowCount(); i++) {
	                        for (int j = 0; j < table.getColumnCount(); j++) {
	                            pdfTable.addCell(new Phrase(table.getValueAt(i, j).toString()));
	                        }
	                    }

	                    // Add the PDF table to the document
	                    document.add(pdfTable);

	                    JOptionPane.showMessageDialog(frame, "Table downloaded successfully as PDF.");
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(frame, "Error downloading table as PDF.");
	                } finally {
	                    // Close the document
	                    if (document != null) {
	                        document.close();
	                    }
	                }
	            }
	        }
	    });

	    panel.add(btnNewButton_1, BorderLayout.CENTER);
	    frame.setVisible(true);

	    // Fetch and display booking data
	}
 
 
 
 public  void insertVerification(int verificationID, int customerID, String verificationStatus) {
     try (Connection connection = connect()) {
         String sql = "INSERT INTO Verification (verificationID, customerID, verificationStatus) VALUES (?, ?, ?)";
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, verificationID);
             preparedStatement.setInt(2, customerID);
             preparedStatement.setString(3, verificationStatus);
             preparedStatement.executeUpdate();
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public  void insertRegistration(int registrationID, int customerID, String registrationStatus) {
     try (Connection connection = connect()) {
         String sql = "INSERT INTO Registration (registrationID, customerID, registrationStatus) VALUES (?, ?, ?)";
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, registrationID);
             preparedStatement.setInt(2, customerID);
             preparedStatement.setString(3, registrationStatus);
             preparedStatement.executeUpdate();
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 
 
 private Connection connect() {
	    // Replace with your database connection details
	    String url = "jdbc:mysql://localhost:3306/test";
	    String user = "root";
	    String password = "qwerty654321!";
	    try {
	        return DriverManager.getConnection(url, user, password);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
 
    public int generateID() {
        Random random = new Random();
        int min = 1000; // Smallest 4-digit number (10^7)
        int max = 9999; // Largest 4-digit number (10^8 - 1)
        return random.nextInt(max - min + 1) + min;
    }
    
}
