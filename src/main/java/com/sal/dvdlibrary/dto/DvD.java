/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.dto;

/**
 *
 * @author salajrawi
 */
import java.util.Date;

public class DvD {
    private String title;
    private String ReleaseDate;
    private String MPAA;
    private String DirectorsName;
    private String Studio;
    private String UserRating;

    public DvD(String title) {
        this.title = title;
    }

    public void setDirectorsName(String newDirectorName) {
    }

    public void setUserRating(String newUserRating) {
    }

    public void setMPAA(String newMpaaRating) {
    }

    public void setReleaseDate(String newReleaseDate) {
    }

    public void setStudio(String newStudioName) {
    }
    //implement
}
