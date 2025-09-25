package com.example.ocrdemo.parser;

import com.example.ocrdemo.entity.AadhaarDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AadhaarParser {

    public static AadhaarDetails parse(String ocrText) {
        AadhaarDetails details = new AadhaarDetails();

        // Extract Name (assume first line before DOB)
        String[] lines = ocrText.split("\\n");
        if (lines.length > 0) {
            details.setName(lines[0].trim());
        }

        // Extract DOB
        Pattern dobPattern = Pattern.compile("\\b(\\d{2}/\\d{2}/\\d{4})\\b");
        Matcher dobMatcher = dobPattern.matcher(ocrText);
        if (dobMatcher.find()) {
            details.setDob(dobMatcher.group(1));
        }

        // Extract Gender
        if (ocrText.toUpperCase().contains("MALE")) {
            details.setGender("MALE");
        } else if (ocrText.toUpperCase().contains("FEMALE")) {
            details.setGender("FEMALE");
        }

        return details;
    }
}
