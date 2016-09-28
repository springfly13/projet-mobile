package com.ioweb.concertplace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fly on 27/09/2016.
 */
public class GetConcertRunnable implements Runnable {

    public ArrayList<Artiste> getDataBase() {
        return dataBase;
    }

    ArrayList<Artiste> dataBase = new ArrayList<Artiste>();

    public void setTabOfNamesForSearch(String[] tabOfNamesForSearch) {
        this.tabOfNamesForSearch = tabOfNamesForSearch;
    }

    String tabOfNamesForSearch [];

    @Override
    public void run() {
        //ArrayList<Artiste> dataBase = new ArrayList<Artiste>();
        String []  tableOfNames = tabOfNamesForSearch;
        ConcertResearcheService result = new ConcertResearcheService();
        for (int i=0; i<tableOfNames.length; i++) {
            try {
                List<ConcertEventOfRequest> listOfEvents = result.researchOfConcerts(tableOfNames[i]);
                for (ConcertEventOfRequest event : listOfEvents) {
                    dataBase.add(new Artiste(tableOfNames[i],
                            event.getVenue().getPlace(),
                            event.getVenue().getCity(),
                            event.getVenue().getCountry(),
                            event.getDatetime() ));
                }
            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}

