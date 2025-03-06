package org.example.boot17_openapi_travel.travel;

import lombok.Data;

@Data
public class Body {
    private Items items;
    private Object numOfRows;
    private Object pageNo;
    private Object totalCount;
}
