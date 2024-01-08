package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourSpotResponse {
        private String result;
        private String resultMessage;
        private int totalCount;
        private int resultCount;
        private int pageSize;
        private int pageCount;
        private int currentPage;
        private TourSpotDto[] items;
}
