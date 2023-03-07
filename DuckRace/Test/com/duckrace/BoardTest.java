package com.duckrace;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BoardTest {
    Board duckBoard;

    @Before
    public void init(){
        duckBoard = new Board();
    }

    @Test
    public void loadRacerMap_shouldLoadMap(){
       // assertTrue(duckBoard.loadRacerMap());
    }



//    @Test
//    public void

    @Test
    public void saveRacerMap_shouldSaveAllRacerInfo_toFile() throws IOException {
        duckBoard.saveRacerMap();
    }
}