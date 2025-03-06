package org.example.demo_travel.travel;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TravelVO {
    private int no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
    private String imgname;
    private MultipartFile file;

}//end class
