package com.example.tobeisun.firstapp;

/**
 * Created by t.obeisun on 2/22/2018.
 */

public class Database {
    int id;String Name ;String Number, Email,Username ,Password ;

    public void setName (String name)
    {
        this.Name=name;
    }
    public String getName()
    {
        return this.Name;
    }

    public void setNumber (String number)
    {
        this.Number= number;
    }



    public  String getNumber ()
    {
       return this.Number ;
    }

    public void setEmail(String email)
    {
        this.Email=email;
    }

    public String getEmail()
    {
        return this.Email ;
    }



    public void setUsername(String username)
    {
        this.Username=username;
    }
    public String getUsername()
    {
        return this.Username ;
    }


    public void setPassword(String password)
    {
        this.Password=password;
    }

    public String getPassword()
    {
        return Password ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
