import java.util.Scanner;

public class Email {
    private String firstName, lastName, password, department, alternateEmail, email;
    private String companySuffix = "company.com";
    private int mailboxCapacity=500, defaultPasswordLength = 10;

    // Constructor to receive the first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("You password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() +"."+lastName.toLowerCase()+"@"+ department +"."+ companySuffix;
    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + "\nDepartment Code\n1 for Sale\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if(depChoice == 1) return "sales";
        else if(depChoice == 2) return "dev";
        else if(depChoice == 3) return "acct";
        else return "";
    }

    //Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPRQESTUWYZ123456%$^%%";
        char[] password = new char[length];

        for(int i=0 ; i<length ; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + " \nCompany Email: " + email + " \nMailbox Capacity: " + mailboxCapacity +"mb";
    }
}
