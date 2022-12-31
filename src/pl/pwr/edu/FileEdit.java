package pl.pwr.edu;

import java.io.*;
import java.util.HashMap;

public class FileEdit {

    static String fileName = "resources/doclog";
    static String docInfo = "resources/docInformation.txt";


    public static HashMap<String, String> getDocLog() throws IOException {
        HashMap<String, String> docLogin = new HashMap<>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String nextLine;

        while ((nextLine = bufferedReader.readLine()) != null) {

            String[] part = nextLine.split("@");

            String login = part[0];
            String password = part[1];

            docLogin.put(login, password);

        }
        /* DEBUG */
        // for (String login : docLogin.keySet()) {
        //    System.out.println("Login: " + login + ", hasło: " + docLogin.get(login));
        //}
        return docLogin;

    }

    public static void addDocLog(String login, String password) {

        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                System.out.println(nextLine);

            }
            bufferedWriter.write("\n" + login + "@" + password);

        } catch (IOException e) {
            System.err.println("Błąd wejścia/wyjścia");
        }


    }

    public static void updateDocInfo(String name, String surName, String specialization) {
        try (
                FileReader fileReader = new FileReader(docInfo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(docInfo, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                System.out.println(nextLine);

            }
            bufferedWriter.write( name + " " + surName + " " + specialization+ "\n");

        } catch (IOException e) {
            System.err.println("Błąd wejścia/wyjścia");
        }
    }
}
