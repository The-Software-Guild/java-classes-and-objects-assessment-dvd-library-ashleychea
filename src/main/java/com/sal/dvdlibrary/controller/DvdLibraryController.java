/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.controller;

import com.sal.dvdlibrary.dao.DvdLibraryDaoException;
import com.sal.dvdlibrary.dao.dvdLibraryDao;
import com.sal.dvdlibrary.dto.DvD;
import com.sal.dvdlibrary.ui.DvdLibraryView;

/**
 *
 * @author salajrawi
 */
public class DvdLibraryController {

    private final DvdLibraryView view;
    private final dvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryView view, dvdLibraryDao dao) {
        //Initialize View and Dao

        this.view = view;
        this.dao = dao;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                  //Implement Switch case
                    case 1:
                        view.print("Add a DVD");
                        addDVD();
                        break;
                    case 2:
                        view.print("Remove a DVD");
                        removeDvd();
                        break;
                    case 3:
                        view.print("Display all DVDs");
                        listDvds();
                        break;
                    case 4:
                        view.print("Search for all DVDs");
                        printDvds();
                        break;
                    case 5:
                        view.print("Edit DVD");
                        editDvd();
                        break;
                    case 6:
                        view.print("Exit");
                        keepGoing = false;
                        break;
                    default:
                        view.print("Command not known");
                }
            }
            view.print("Adios!");
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
         exitMessage();
    }

    private void addDVD() {
    }

    private void printDvds() {
    }


    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    /*
     a method called listDvds that will get a list of all Dvd objects in 
    the system from the DAO and then hand that list to the view to display to the user.
     */
    private void addDVDs() throws DvdLibraryDaoException {
        //implement
        String title = view.print("Please enter the title of the movie ");
        
    }
    private void listDvds() throws DvdLibraryDaoException {
       //implement
    }

    /*
    This method asks the view to display the View dvd banner and get the title from the user
     */
    private void viewDvd() throws DvdLibraryDaoException {
       //implement
    }

    /*
    This method will ask the view to display the Remove dvd banner and ask the user for the title of the dvd to be removed
     */
    private void removeDvd() throws DvdLibraryDaoException {
        //implement
        view.displayCreateDvDBanner();
        String title = view.getDvdTitleChoice();

    }
    
    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        DvD currentDVD = dao.getDvd(title);
        if (currentDVD == null) {
            view.displayNullDVD();
        } else {
            view.displayDvd(currentDVD);
            int editMenuSelection;
            boolean keepGoing = true;
            do {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection) {
                    case 1:
                        view.print("edit release date");
                        editReleaseDate(title);
                        break;
                    case 2:
                        view.print("edit MPAA rating");
                        editMPAA(title);
                        break;
                    case 3:
                        view.print("edit directors name");
                        editDirectorName(title);
                        break;
                    case 4:
                        view.print("edit the user rating");
                        editUserRating(title);
                        break;
                    case 5:
                        view.print("edit the studio name");
                        editStudioName(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            } while (keepGoing);
        }
    }
    private int getEditMenuSelection(){
        return view.printEditMenuAndGetSelection();
    }
    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();
        String newReleaseDate = view.getNewReleaseDate();
        dao.editReleaseDate(title, newReleaseDate);
        view.displayEditDvdSuccess();
        view.print("The new release date is " + newReleaseDate);
    }
    private void editMPAA(String title) throws DvdLibraryDaoException {
        view.displayEditMpaaBanner();
        String newMpaaRating = view.getNewMpaaRating();
        dao.editMPAA(title, newMpaaRating);
        view.displayEditDvdSuccess();
        view.print("The new Mpaa rating is " + newMpaaRating);
    }
    private void editDirectorName(String title) throws DvdLibraryDaoException {
        view.displayEditDirectorNameBanner();
        String newDirectorName = view.getNewDirectorName();
        dao.editDirectorName(title, newDirectorName);
        view.displayEditDvdSuccess();
        view.print("The new directors name is " + newDirectorName);
    }
    private void editUserRating(String title) throws DvdLibraryDaoException {
        view.displayEditUserRating();
        String newUserRating = view.getNewUserRating();
        dao.editUserRating(title, newUserRating);
        view.displayEditDvdSuccess();
        view.print("The new user rating is " + newUserRating);
    }
    private void editStudioName(String title) throws DvdLibraryDaoException {
        view.displayEditStudio();
        String newStudioName = view.getNewStudio();
        dao.editStudio(title, newStudioName);
        view.displayEditDvdSuccess();
        view.print("The new studio name is " + newStudioName);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
