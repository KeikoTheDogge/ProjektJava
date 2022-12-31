package pl.pwr.edu;

//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class LoginHandler {
//
//    public static boolean login(){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Log into our new BETTER-NFZ-MEDIC-SITE");
//
//        try {
//            /* Stworzenie HashMapy z pliku doclog */
//            HashMap<String, String> docLo = FileEdit.getDocLog();
//
//            // Podanie informacji i pobranie loginu
//            //System.out.print("Login: ");
//            //String log = input.nextLine();
//
//            // Jeżeli istnieje taki login w bazie (plik.txt)
//            if (docLo.containsKey(log)) {
//                // Jeżeli istnieje taki login, to pobierz dla niego z hashmapy hasło
//                String password = docLo.get(log);
//
//                // Podanie hasła
//                System.out.print("Password: ");
//                String pas = input.nextLine();
//                // Jeżeli podane hasło jest takie samo jak pobrane -> zaloguj
//                if (pas.equals(password)) {
//                    System.out.println("Welcome to NFZ-SPACE-MEDIC-X-SITE");
//                    return true;
//                } else{
//                    throw new WrongPassword();
//                }
//
//            } else {
//                throw new WrongLogin();
//            }
//
//
//        } catch (IOException | WrongLogin e) {
//            System.out.println("Wrong login - access denied.");
//        } catch (WrongPassword e) {
//            System.out.println("Wrong password - access denied.");
//        }
//        return false;
//    }
//
//}
