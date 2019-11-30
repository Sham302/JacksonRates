package com.spartaglobal.parsejson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RatesDesterialiser {  //changes json string
    public RatesDTO rateMapped;

    public RatesDesterialiser(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            rateMapped = objectMapper.readValue(new FileReader(jsonString), RatesDTO.class); //object mapper takes strings and deconstructs it
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
private Date parseEpoch(Long epoch){
        return new Date(epoch * 1000);
}

public String ratesDateEpoch(Long epoch){
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    return dateFormat.format(parseEpoch(epoch));
}

public int rateCount(){
        return rateMapped.getRates().size();
}


}



