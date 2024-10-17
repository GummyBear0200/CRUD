
package testunggg;
import java.util.Scanner;

public class menu{
    Scanner sc = new Scanner(System.in);    
    config conf = new config();

  
    
    public void mainmenu() {
        int choice;

        do {
            System.out.println("----------- Main Menu -----------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                  add();
                    break;

                case 2:
                   view();
                    break;

                case 3:
                    view();
                    update();
                    view();
                    break;

                case 4:
                    view();
                   delete();
                   view();
                   break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 5); 
    }
    
    public void add(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.print("Student Last Name: ");
        String lname = sc.next();
        System.out.print("Student Email: ");
        String email = sc.next();
        System.out.print("Student Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_students (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, status);


    }
    private void view() {
        String votersQuery = "SELECT * FROM tbl_students";
        String[] votersHeaders = {"ID", "First Name", "last Name", "Email", "Status"};
        String[] votersColumns = {"s_id", "s_fname", "s_lname", "s_email", "s_status"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    private void update(){
        int id;
        System.out.println("Enter ID to edit:");
        
        id = sc.nextInt();
   System.out.print("Student New First Name: ");
        String fname = sc.next();
        System.out.print("Student NEw Last Name: ");
        String lname = sc.next();
        System.out.print("Student new Email: ");
        String email = sc.next();
        System.out.print("Student Status: ");
        String status = sc.next();
        
        String sqlUpdate = "UPDATE tbl_students SET s_fname = ? ,s_lname = ?, s_email = ?, s_status = ? WHERE s_id = ?";
        conf.updateRecord(sqlUpdate, fname, lname, email, status, id);
        
        
        
    }
    private void delete (){
        int id;
        
        System.out.println("Enter Id to delete:");
        id = sc.nextInt();
        
        

      
        String sqlDelete = "DELETE FROM tbl_students WHERE s_id = ?";
        conf.deleteRecord(sqlDelete, id);
        System.out.println("Deleted Successfully");
        
    }
    
    
    
    }


