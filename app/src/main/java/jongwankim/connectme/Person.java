package jongwankim.connectme;

import java.util.ArrayList;

/**
 * Created by owner on 3/26/17.
 */

public class Person {
    private String last;
    private String first;
    private boolean status = false;
    private boolean unmarked = true;
    private String username;
    private String password;
    private double latitude;
    private double longitude;

    private ArrayList<Person> list = new ArrayList<Person>();

    public Person(){

    }

    public void setLat(double d){
        latitude = d;
    }

    public double getLat(){
        return latitude;
    }

    public void setLong(double d){
        longitude = d;
    }

    public double getLong(){
        return longitude;
    }

    public void setUserName(String s){
        username = s;
    }

    public String getUserName(){
        return username;
    }

    public void setPassword(String s){
        password = s;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstName(){
        return first;
    }

    public String getLastName(){
        return last;
    }

    public void setFirstName(String s){
        first = s;
    }

    public void setLastName(String s){
        last = s;
    }

    public void setSafe(){
        status = true;
        unmarked = false;
    }

    public boolean getSafe(){
        return status;
    }

    public boolean getUnmarked(){
        return unmarked;
    }
}
