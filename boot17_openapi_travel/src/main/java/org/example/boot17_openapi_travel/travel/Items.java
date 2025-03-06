package org.example.boot17_openapi_travel.travel;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Items {
    private List<Map<String, String>> item;

}
