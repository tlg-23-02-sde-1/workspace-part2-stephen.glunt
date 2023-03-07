package com.duckrace;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = loadRacerMap();

    public Board() {
        loadStudentIdMap();
    }

    private Map<Integer,String> loadStudentIdMap(){
        return loadStudentIdMap("src/conf/student-ids.csv");
    }

    private Map<Integer,String> loadStudentIdMap(String filePath){
        Map<Integer, String> idMap = new HashMap<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(var line : lines){
            String[] values = line.split(",");
            idMap.put(Integer.valueOf(values[0]), values[1]);
        }

        return idMap;
    }

   public void update(int id, Reward reward){
        if (!racerMap.containsKey(id)){
            racerMap.put(id, new DuckRacer(id,studentIdMap.get(id)));
        }
            racerMap.get(id).win(reward);
   }

   public void dumpRacerMap(){
       Collection<DuckRacer> allRacers = racerMap.values();
       for(var racer : allRacers){
           System.out.println(racer);
       }
   }


    public void printBoardToConsole(){
        System.out.println("id    name          wins    rewards");
        System.out.println("__    ____          ____    _______");
        for(var item : racerMap.entrySet()){
            //System.out.println(item.getValue().toFile());
            String rewards = item.getValue().getRewards().toString();
            rewards = rewards.replace("]","").replace("[", "");
            System.out.printf("%2d    %-10s    %3d     %s\n", item.getValue().getId(), item.getValue().getName(), item.getValue().getWins(), rewards);
        }
        System.out.println();
    }

    public void printBoardToFile(){

    }

    public Map<Integer,DuckRacer> loadRacerMap(){
        Map<Integer, DuckRacer> rMap = new TreeMap<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of("src/conf/racerMap.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
        for(var line : lines){
            String[] tokens = line.split("\\[");
            String[] values = tokens[0].split(",");
            Integer key = Integer.valueOf(values[0]);
            int id = Integer.parseInt(values[1]);
            String name = values[2];
            String[] prizes = tokens[1].replace("]","").split(", ");
            DuckRacer duck = new DuckRacer(id, name);
            for(var win : prizes){
                duck.win(Reward.valueOf(win));
            }
            rMap.put(key, duck);
        }
        return rMap;
    }

    public void saveRacerMap() throws IOException {
        String fileName = "src/conf/racerMap.csv";
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for(Map.Entry<Integer,DuckRacer> entry : racerMap.entrySet()){
            pw.println(entry.getKey() + "," + entry.getValue().toFile());
        }
        pw.close();
    }
}