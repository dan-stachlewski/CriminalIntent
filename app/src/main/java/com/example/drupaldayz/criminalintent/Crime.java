package com.example.drupaldayz.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Create by Dan Stachlewski on 29/6/18
 */

//This is all we need for the Crime Class & CriminalIntent's Model Layer

public class Crime {

    //Create the Crime's Properties that store data about a crime
    //UUID is a Java Utility Class & is an easy way to generate universally unique ID values
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    //Create a Constructor that initialized the Id & Date Properties
    public Crime() {
        //this is how to generate a UUID
        mId = UUID.randomUUID();
        //this is how to generate the current date - default date for a crime
        mDate = new Date();
    }

    //Generate Getter & Setters by Right-mouse-click > Generate > Getter & Setters > Choose all Properties

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
