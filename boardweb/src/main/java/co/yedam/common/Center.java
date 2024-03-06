package co.yedam.common;

import lombok.Data;

@Data
public class Center {
    private String address;
    private String centerName;
    private String centerType;
    private String createdAt;
    private String facilityName;
	private int id;
	//맵관련 필드
    private String lat;
    private String lng;
    private String org;
    
    private String phoneNumber;
    private String sido;
    private String sigungu;
    private String updatedAt;
    private String zipCode;
}
