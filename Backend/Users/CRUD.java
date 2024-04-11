
// //to fix

// package Backend.Users;
// import java.io.*;
// import java.util.*;

// import Backend.Users.User.UserType;



// public class CRUD {
    
//         public static void main(String[] args) throws Exception{
//             Scanner scan=new Scanner(System.in); 
//             File file=new File("UserData.txt");
//             int choice=-1;
//             ArrayList<User> users=new ArrayList<User>();
//             ObjectOutputStream oos = null;
    
    
//             if (file.exists()) {
//                 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//                 users = (ArrayList<User>) ois.readObject();
//                 ois.close();
//             }
    
    
    
//             do {
//                 System.out.println("1.INSERT");
//                 System.out.println("2.DISPLAY");
//                 System.out.println("3.DELETE");
//                 System.out.println("4.UPDATE");
//                 System.out.println("0.EXIT");
//                 System.out.println("Enter your choice");
//                 choice=scan.nextInt();
//                 scan.nextLine();
//                 switch (choice) {
//                     case 1:
//                     System.out.println("Enter username:");
//                         String newUsername = scan.nextLine();
//                         System.out.println("Enter password:");
//                         String newPassword = scan.nextLine();
//                         System.out.println("Enter user type (PARENT, CHILD, STRANGER, GUEST):");
//                         UserType newUserType = UserType.valueOf(scan.nextLine().toUpperCase());
//                         users.add(new User(newUsername, newPassword, newUserType));
//                         saveUsers(users, file);
//                         break;
                        
                       
    
    
//                         case 2:
//                          displayUsers(users);
//                         break;
    
//                         case 3:
//                         System.out.println("Enter username to delete:");
//                         String deleteUsername = scan.nextLine();
//                         deleteUser(users, deleteUsername);
//                         saveUsers(users, file);
//                         break;
    
//                         case 4:
//                         System.out.println("Enter username to update:");
//                         String updateUsername = scan.nextLine();
//                         updateUser(users, updateUsername, scan);
//                         saveUsers(users, file);
//                         break;
    
//                 }
//             }while(choice!=0);
//         }
    
       
//     public static void displayUsers(ArrayList<User> users) {
//         for (User user : users) {
//             System.out.println(user);
//         }
//     }
    
//     // Method to save users to file
//     public static void saveUsers(ArrayList<User> users, File file) throws IOException {
//         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//         oos.writeObject(users);
//         oos.close();
//     }
    
//      // Method to delete user by username
//      public static void deleteUser(ArrayList<User> users, String username) {
//         Iterator<User> iterator = users.iterator();
//         while (iterator.hasNext()) {
//             User user = iterator.next();
//             if (user.getUsername().equals(username)) {
//                 iterator.remove();
//                 System.out.println("User deleted successfully.");
//                 return;
//             }
//         }
//         System.out.println("User not found.");
//     }
    
//     // Method to update user password by username
//     public static void updateUser(ArrayList<User> users, String username, Scanner scan) {
//         for (User user : users) {
//             if (user.getUsername().equals(username)) {
//                 System.out.println("Enter new password:");
//                 String newPassword = scan.nextLine();
//                 user.setPassword(newPassword);
//                 System.out.println("Password updated successfully.");
//                 return;
//             }
//         }
//         System.out.println("User not found.");
    
//     }
// }
    