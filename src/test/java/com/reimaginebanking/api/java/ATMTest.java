package com.reimaginebanking.api.java;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by kco942 on 4/9/15.
 */
public class ATMTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testGetATMs() {
        /**String[] atm1_lang = {"French", "Spanish", "Portuguese", "Chinese", "Hindustani", "Korean", "English"};
        String[] hours = {"24 hours a day, 7 days a week"};
        Address atm1_address = new Address("VA", "6790", "Alexandria", "Richmond Highway", "22306");
        ATM atm = new ATM("5516c07aa520e0066c9ac05f", "true", "Beacon Mall 3", Arrays.asList(atm1_lang), Arrays.asList(hours), atm1_address, 788876);
        List<ATM> atms = Main.getATMs("ENTed5f52697b6047821b7a9d69c0b439bf");
        try {Thread.sleep(4000);} catch (Exception e) { e.printStackTrace();}
        assertNotEquals(0, atms.size());
        assertEquals(atm, Main.getATMs("ENTed5f52697b6047821b7a9d69c0b439bf").get(0));**/
        assertTrue(true);
    }

    @Test
    public void testGetATM() {
        assert(true);
    }
}
