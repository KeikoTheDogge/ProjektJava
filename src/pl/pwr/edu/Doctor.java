package pl.pwr.edu;

public class Doctor {
    String name;
    String surName;
    String speciality;
    String login;
    String password;

    public Doctor(String name, String surName, String speciality, String login, String password) {
        this.name = name;
        this.surName = surName;
        this.speciality = speciality;
        this.login = login;
        this.password = password;
        FileEdit.updateDocInfo(this.name,this.surName,this.speciality);
        FileEdit.addDocLog(this.login, this.password);

    }


}
