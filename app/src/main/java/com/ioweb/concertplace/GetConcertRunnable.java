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

    @Override
    public void run() {
        //ArrayList<Artiste> dataBase = new ArrayList<Artiste>();
        String []  tableOfNames = Artiste.getTableOfArtistResearche();
        ConcertResearcheService result = new ConcertResearcheService();
        for (int i=0; i<tableOfNames.length; i++) {
            try {
                List<ConcertEventOfRequest> listOfEvents = result.researchOfConcerts(tableOfNames[i]);
                int listLength = listOfEvents.size();
                for (int j=0; j<listLength ; j++ ) {
                    dataBase.add(new Artiste(listOfEvents.get(j).getVenue().getCity(),
                            listOfEvents.get(j).getVenue().getPlace(),
                            tableOfNames[i],
                            listOfEvents.get(j).getDatetime() ));
                  /* dataBase.add(new Artiste(tableOfArtistResearche[i],
                           listOfEvents.get(j).getVenue().getPlace(),
                           listOfEvents.get(j).getVenue().getCity(),
                           listOfEvents.get(j).getVenue().getCountry(),
                           listOfEvents.get(j).getDatetime() ));*/
                }
            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}

