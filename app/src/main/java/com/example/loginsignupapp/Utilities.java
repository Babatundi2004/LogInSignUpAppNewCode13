package com.example.loginsignupapp;

import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


enum ErrorCodes
{
    IncorrectAuth, FieldsEmpty, True, False
}

enum RestCat
{
    Oriental, Fast, Sushi, Thai, Chinese
}


public class Utilities {

    private static Utilities instance;

    public Utilities()
    {
    }

    public static Utilities getInstance() {
        if (instance == null)
            instance = new Utilities();
        return instance;
    }

    public boolean validatePassword(AppCompatActivity activity,String password) {
        if (!(password.length() >= 8 && password.length() <= 70)) {
            Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // check for no spaces
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == ' ') {
                Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        int counterMinSmallChar=0;
        int counterMinNumber=0;
        int counterMinCapitalChar=0;
        int counterMinOneChar=0;
        // check if rest of chars are letters, numbers, underscore, dot
        for (int i = 1; i <= password.length(); i++)
        {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' )
                counterMinSmallChar++;
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' )
                counterMinCapitalChar++;
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
                counterMinNumber++;
            if (!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'||
                    password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'||
                    password.charAt(i) >= '0' && password.charAt(i) <= '9'))
                counterMinOneChar++;
        }
        if (counterMinNumber==0 || counterMinCapitalChar==0 || counterMinSmallChar==0 || counterMinOneChar==0)
            return false;

        return true;
    }

    public boolean validateEmail(AppCompatActivity activity , String email) {

        // check if @ exists, and you have only one
        String[] splitString = email.split("@");
        if (splitString.length != 2) {
            Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // checking if username if correct (before '@')
        String username = splitString[0].toLowerCase();
        String domain = splitString[1].toLowerCase();

        // String length: min 3 chars, max 70 chars
        if (!(username.length() >= 3 && username.length() <= 70)) {
            Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // check for no spaces
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        // checks if it starts with letter or underscore
        if (!(username.charAt(0) >= 'a' && username.charAt(0) <= 'z' ||
                username.charAt(0) == '_')) {
            Toast.makeText(activity, "Username or password is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // check if rest of chars are letters, numbers, underscore, dot
        for (int i = 1; i <= username.length(); i++) {
            if (!(username.charAt(i) >= 'a' && username.charAt(i) <= 'z' ||
                    username.charAt(i) >= '0' && username.charAt(i) <= '9' ||
                    username.charAt(0) == '.' ||
                    username.charAt(0) == '_')) {
                Toast.makeText(activity, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        // check domain start char
        if (!(domain.charAt(0) >= 'a' && domain.charAt(0) <= 'z' ||
                domain.charAt(0) >= '0' && domain.charAt(0) <= '9' ||
                domain.charAt(0) == '_')) {
            Toast.makeText(activity, "Username or password is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
    }

    public boolean validateUsername(AppCompatActivity activity, String username) {
        if (!(username.length() >= 3 && username.length() <= 70)) {
            Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // check for no spaces
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                Toast.makeText(activity, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        // checks if it starts with letter or underscore
        if (!(username.charAt(0) >= 'a' && username.charAt(0) <= 'z' ||
                username.charAt(0) == '_')) {
            Toast.makeText(activity, "Username or password is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // check if rest of chars are letters, numbers, underscore, dot
        for (int i = 1; i <= username.length(); i++) {
            if (!(username.charAt(i) >= 'a' && username.charAt(i) <= 'z' ||
                    username.charAt(i) >= '0' && username.charAt(i) <= '9' ||
                    username.charAt(0) == '.' ||
                    username.charAt(0) == '_')) {
                Toast.makeText(activity, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}

