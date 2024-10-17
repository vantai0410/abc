package check_data_format.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {

    private String phoneNumber;
    private String email;
    private Date date;

    public Format() {
    }

    public Format(String phoneNumber, String email, Date date) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String checkPhone(String phone) {
        if (!phone.matches("\\d+")) {
            return "Invalid phone number";
        }
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        return "";
    }

    public String checkDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return "Invalid date";
        }
        return "";
    }

    public String checkEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()) {
            return "Invalid email";
        }
        return "";
    }

}


