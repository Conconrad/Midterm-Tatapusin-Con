import com.app.facade.Customer.Impl.CustomerFacade;
import com.app.facade.Customer.Impl.CustomerFacadeImpl;
import com.app.facade.ItemsFacade;
import com.app.facade.impl.ItemsFacadeImpl;
import com.app.model.customer.Customer;
import com.app.model.item.Item;
import com.data.dao.ItemsDao;
import com.data.dao.impl.ItemsDaoImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ItemsDao itemsDao = new ItemsDaoImpl();
        ItemsFacade = new ItemsFacadeImpl();

        try {
            int choice;
            do {
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        getAllItems();
                        break;
                    case 2:
                        getItemByitemId();
                        break;
                    case 0:
                        System.out.println("Exiting the App...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() {
    }

    private static void getAllItems() {
        try {
            List<Item>ItemsRecords = ItemsFacade.getAllItems();

            if (ItemsRecords != null && !ItemsRecords.isEmpty()) {
                System.out.println("Offense Records");
                for (Item itemsRecords : ItemsRecords) {
                    System.out.println("Customer ID: " + ItemsRecords.itemId());
                    System.out.println("Customer Name: " + ItemsRecords.itemDescription());
                    System.out.println("Customer Address: " + ItemsRecords.unitPrice());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No offense records found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while viewing all offenses: " + e.getMessage());
        }
    }

    private static void getItemByitemId() {
        try {
            System.out.println("\nChoose Customer ID:");

            System.out.print("Enter Customer ID: ");
            int violationId = scanner.nextInt();
            if (violationId < 0) {
                System.out.println("Invalid Violation ID. Please enter a non-negative integer.");
                return;
            }

            System.out.print("Enter Student ID: ");
            String studentId = scanner.next();

            System.out.print("Enter Offense Date (YYYY-MM-DD): ");
            String dateStr = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            Timestamp offenseDate = new Timestamp(parsedDate.getTime());

            Offense newOffense = new Offense();
            newOffense.setViolationId(violationId);
            newOffense.setStudentId(studentId);
            newOffense.setOffenseDate(offenseDate);

            boolean added = offenseFacade.addOffense(newOffense);

            if (added) {
                System.out.println("Offense added successfully!");
            } else {
                System.out.println("Failed to add offense.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid IDs.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
        } catch (Exception e) {
            System.err.println("An error occurred while adding an offense: " + e.getMessage());
        }
    }

}
