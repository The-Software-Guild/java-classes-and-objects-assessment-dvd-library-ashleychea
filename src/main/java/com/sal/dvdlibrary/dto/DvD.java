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
        this.DirectorsName = DirectorsName;
    }

    public void setUserRating(String newUserRating) {
        this.UserRating = UserRating;

    }

    public void setMPAA(String newMpaaRating) {
        this.MPAA = MPAA;
    }

    public void setReleaseDate(String newReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public void setStudio(String newStudioName) {

    }

    public String getDvdId() {
        return DvdId();
    }

    private String DvdId() {
        return null;
    }

    public void setCohort(String cohort) {
    }

    public void setLastName(String lastName) {
    }

    public void setFirstName(String firstName) {
    }
    //implement
}
