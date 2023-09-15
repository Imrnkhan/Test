//import java.time.LocalDate;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//class User {
//    private String fullName;
//    private String contactNumber;
//    private LocalDate dateOfBirth;
//    private String password;
//
//    public User(String fullName, String contactNumber, LocalDate dateOfBirth, String password) {
//        this.fullName = fullName;
//        this.contactNumber = contactNumber;
//        this.dateOfBirth = dateOfBirth;
//        this.password = password;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String newPassword) {
//        this.password = newPassword;
//    }
//}
//
//public class MobileOrderingApp {
//    private static final List<User> users = new ArrayList<>();
//    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    private static final Pattern passwordPattern = Pattern.compile("^[a-zA-Z].*[0-9]$");
//    private static User loggedInUser = null;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        boolean quit = false;
//
//        while (!quit) {
//            System.out.println("Welcome to the Mobile Ordering App!");
//
//            if (loggedInUser != null) {
//                System.out.println("Logged in as: " + loggedInUser.getFullName());
//                System.out.println("1. Reset Password");
//                System.out.println("2. Logout");
//            } else {
//                System.out.println("1. Sign up");
//                System.out.println("2. Sign in");
//            }
//
//            System.out.println("3. Quit application");
//            System.out.print("Select an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    if (loggedInUser != null) {
//                        resetPassword(scanner);
//                    } else {
//                        signup(scanner);
//                    }
//                    break;
//                case 2:
//                    if (loggedInUser != null) {
//                        loggedInUser = null;
//                        System.out.println("Logged out.");
//                    } else {
//                        login(scanner);
//                    }
//                    break;
//                case 3:
//                    quit = true;
//                    System.out.println("Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid option. Please select again.");
//                    break;
//            }
//        }
//
//        scanner.close();
//    }
//
//    private static void signup(Scanner scanner) {
//        System.out.println("Sign up process:");
//
//        String fullName;
//        String contactNumber;
//        LocalDate dateOfBirth;
//        String password;
//        String passwordConfirmation;
//
//        do {
//            System.out.print("Enter your full name: ");
//            fullName = scanner.nextLine();
//
//            System.out.print("Enter your contact number (starting with 0): ");
//            contactNumber = scanner.nextLine();
//
//            System.out.print("Enter your date of birth (DD/MM/YYYY): ");
//            String dobStr = scanner.nextLine();
//            dateOfBirth = parseDate(dobStr);
//
//            System.out.print("Enter your password: ");
//            password = scanner.nextLine();
//
//            System.out.print("Confirm your password: ");
//            passwordConfirmation = scanner.nextLine();
//
//            if (!isValidContactNumber(contactNumber)) {
//                System.out.println("Invalid contact number format. It should have 10 digits and start with 0.");
//            } else if (!isValidPassword(password)) {
//                System.out.println("Invalid password format. It should start with alphabets and end with a numeric.");
//            } else if (!password.equals(passwordConfirmation)) {
//                System.out.println("Password confirmation does not match.");
//            } else if (!isValidDateOfBirth(dateOfBirth)) {
//                System.out.println("Invalid date of birth format or age less than 21.");
//            } else {
//                users.add(new User(fullName, contactNumber, dateOfBirth, password));
//                System.out.println("Signup successful!");
//                break;
//            }
//
//            System.out.println("Please re-enter your details.");
//        } while (true);
//    }
//
//    private static void login(Scanner scanner) {
//        System.out.println("Login process:");
//        System.out.print("Enter your contact number: ");
//        String contactNumber = scanner.nextLine();
//        System.out.print("Enter your password: ");
//        String password = scanner.nextLine();
//
//        for (User user : users) {
//            if (user.getContactNumber().equals(contactNumber) && user.getPassword().equals(password)) {
//                loggedInUser = user;
//                System.out.println("Login successful!");
//                return;
//            }
//        }
//
//        System.out.println("Login failed. Please check your credentials.");
//    }
//
//    private static void resetPassword(Scanner scanner) {
//        System.out.println("Reset Password:");
//        System.out.print("Enter your new password: ");
//        String newPassword = scanner.nextLine();
//
//        loggedInUser.setPassword(newPassword);
//        System.out.println("Password reset successful!");
//    }
//
//    private static boolean isValidContactNumber(String contactNumber) {
//        return contactNumber.matches("^0\\d{9}$");
//    }
//
//    private static boolean isValidPassword(String password) {
//        Matcher matcher = passwordPattern.matcher(password);
//        return matcher.matches();
//    }
//
//    private static LocalDate parseDate(String dateStr) {
//        try {
//            return LocalDate.parse(dateStr, dateFormat);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    private static boolean isValidDateOfBirth(LocalDate dateOfBirth) {
//        if (dateOfBirth == null) {
//            return false;
//        }
//        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
//        return age >= 21;
//    }
//}

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    private String fullName;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private String password;

    public User(String fullName, String contactNumber, LocalDate dateOfBirth, String password) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}

public class MobileOrderingApp {
    private static final List<User> users = new ArrayList<>();
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Pattern passwordPattern = Pattern.compile("^[a-zA-Z].*[0-9]$");
    private static User loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Welcome to the Mobile Ordering App!");

            if (loggedInUser != null) {
                System.out.println("Logged in as: " + loggedInUser.getFullName());
                System.out.println("1. Reset Password");
                System.out.println("2. Logout");
            } else {
                System.out.println("1. Sign up");
                System.out.println("2. Sign in");
            }

            System.out.println("3. Quit application");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (loggedInUser != null) {
                        resetPassword(scanner);
                    } else {
                        signup(scanner);
                    }
                    break;
                case 2:
                    if (loggedInUser != null) {
                        loggedInUser = null;
                        System.out.println("Logged out.");
                    } else {
                        login(scanner);
                    }
                    break;
                case 3:
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void signup(Scanner scanner) {
        System.out.println("Sign up process:");

        String fullName;
        String contactNumber;
        LocalDate dateOfBirth;
        String password;
        String passwordConfirmation;

        do {
            System.out.print("Enter your full name: ");
            fullName = scanner.nextLine();

            System.out.print("Enter your contact number (starting with 0): ");
            contactNumber = scanner.nextLine();

            System.out.print("Enter your date of birth (DD/MM/YYYY): ");
            String dobStr = scanner.nextLine();
            dateOfBirth = parseDate(dobStr);

            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            System.out.print("Confirm your password: ");
            passwordConfirmation = scanner.nextLine();

            if (!isValidContactNumber(contactNumber)) {
                System.out.println("Invalid contact number format. It should have 10 digits and start with 0.");
            } else if (!isValidPassword(password)) {
                System.out.println("Invalid password format. It should start with alphabets and end with a numeric.");
            } else if (!password.equals(passwordConfirmation)) {
                System.out.println("Password confirmation does not match.");
            } else if (!isValidDateOfBirth(dateOfBirth)) {
                System.out.println("Invalid date of birth format or age less than 21.");
            } else {
                users.add(new User(fullName, contactNumber, dateOfBirth, password));
                System.out.println("Signup successful!");
                break;
            }

            System.out.println("Please re-enter your details.");
        } while (true);
    }

    private static void login(Scanner scanner) {
        System.out.println("Login process:");
        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getContactNumber().equals(contactNumber) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Login failed. Please check your credentials.");
    }

    private static void resetPassword(Scanner scanner) {
        System.out.println("Reset Password:");
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        loggedInUser.setPassword(newPassword);
        System.out.println("Password reset successful!");
    }

    private static boolean isValidContactNumber(String contactNumber) {
        return contactNumber.matches("^0\\d{9}$");
    }

    private static boolean isValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    private static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, dateFormat);
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isValidDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 21;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static List<User> getUsers() {
        return users;
    }
}



