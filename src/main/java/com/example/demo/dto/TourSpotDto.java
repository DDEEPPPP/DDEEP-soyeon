package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourSpotDto {

    private String alltag;
    private String contentsid;
    private ContentsCd contentscd;
    private String title;
    private Region1Cd region1cd;
    private Region2Cd region2cd;
    private String address;
    private String roadaddress;
    private String tag;
    private String introduction;
    private double latitude;
    private double longitude;
    private String postcode;
    private String phoneno;
    private RepPhoto repPhoto;
}
