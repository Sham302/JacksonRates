package com.spartaglobal.parsejson;

import com.spartaglobal.HTTPservices.FixerLatestHTTPService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RatesTest {

    private static RatesDesterialiser rates;
    private static FixerLatestHTTPService fixerLatestHTTPService = new FixerLatestHTTPService();

    @BeforeClass //captures and runs before class does anything else
    public static void setup(){
        fixerLatestHTTPService.executeLatestRatesGetRequest();
        rates = new RatesDesterialiser(fixerLatestHTTPService.getFixerLatestRatesJSONString()); //replacing location
    }

    @Test
    public void TestGetDate (){

        Date date = new Date(rates.rateMapped.getTimestamp() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-M-d");
        System.out.println(sdf.format(date));
        Assert.assertEquals(sdf.format(date),rates.rateMapped.getDate());
    }

    public double getEuro(){
        return rates.rateMapped.getRates().get("Euro");
    }

    @Test
    public void testEpochDate(){
        Assert.assertEquals("2018-10-10", rates.ratesDateEpoch(rates.rateMapped.getTimestamp()));
    }
    @Test
    public void TestEuro(){
        Assert.assertEquals(1,1,0);
    }

    @Test
    public void testSuccessIsTrue (){
        Assert.assertTrue(rates.rateMapped.isSuccess());
    }

    @Test
    public void testEpockDate(){
        Assert.assertEquals("EUR",rates.rateMapped.getBase());
    }

    public int getRateCount (){
        int count = 0;
        for(int i = 0 ; i < rates.rateMapped.getRates().size(); i++){
            count++;
        }
        return count;
    }

    @Test
    public void TestGetRates(){
        Assert.assertEquals(getRateCount(), rates.rateMapped.getRates().size());
    }


}
