package com.example.tp5;

import androidx.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GeoIP {

    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String zip;
    private String timezone;

    public GeoIP() {
        this.status = "";
        this.country = "";
        this.countryCode = "";
        this.region = "";
        this.regionName = "";
        this.city = "";
        this.zip = "";
        this.timezone = "";
    }

    @NonNull
    @Override
    public String toString() {
        String outString = "";
        outString = "statut : " + status + "\n" + "pays : " + country + "\n" + "code pays : " + countryCode + "\n" + "code region : " + region + "\n" + "region : " + regionName + "\n" + "ville : " + city + "\n" + "code postal : " + zip + "\n" + "fuseau horaire : " + timezone;
        return outString;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }




}

