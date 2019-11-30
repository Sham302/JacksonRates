package com.spartaglobal.HTTPservices;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestObject {
private static FixerLatestHTTPService fixerLatestHTTPService = new FixerLatestHTTPService();

@BeforeClass
public static void setup(){
    fixerLatestHTTPService.executeLatestRatesGetRequest();
}

@Test
    public void test(){
//    System.out.println(FixerURLConfig.BASEURL + FixerURLConfig.LATESTRATEENDPOINT);
    System.out.println(fixerLatestHTTPService.getFixerLatestRatesJSONString());
}
}
