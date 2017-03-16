package com.managment.members;

import java.util.Arrays;

public class Member {
	
	private String fulName;
    private String nicNo;
    private String address;
    private String contactNo;
    private String mobileNo;
    private String emialId;
    private String faceBook;
    private String dateOfBirth;
    private int age;
    private String martialStaus;
    private String gender;
    private byte [] image;
    private byte [] encodeImage;
    private String imgBase;
    private String postioninUNP;
    private String imageName;
  //  private String agentId;
    private String deviceName;
    
    
	public String getFulName() {
		return fulName;
	}
	public void setFulName(String fulName) {
		this.fulName = fulName;
	}
	public String getNicNo() {
		return nicNo;
	}
	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmialId() {
		return emialId;
	}
	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}
	public String getFaceBook() {
		return faceBook;
	}
	public void setFaceBook(String faceBook) {
		this.faceBook = faceBook;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMartialStaus() {
		return martialStaus;
	}
	public void setMartialStaus(String martialStaus) {
		this.martialStaus = martialStaus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public byte[] getEncodeImage() {
		return encodeImage;
	}
	public void setEncodeImage(byte[] encodeImage) {
		this.encodeImage = encodeImage;
	}
	public String getImgBase() {
		return imgBase;
	}
	public void setImgBase(String imgBase) {
		this.imgBase = imgBase;
	}
	public String getPostioninUNP() {
		return postioninUNP;
	}
	public void setPostioninUNP(String postioninUNP) {
		this.postioninUNP = postioninUNP;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	@Override
	public String toString() {
		return "Member [fulName=" + fulName + ", nicNo=" + nicNo + ", address=" + address + ", contactNo=" + contactNo
				+ ", mobileNo=" + mobileNo + ", emialId=" + emialId + ", faceBook=" + faceBook + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + ", martialStaus=" + martialStaus + ", gender=" + gender
				+ ", encodeImage=" + Arrays.toString(encodeImage) + ", postioninUNP=" + postioninUNP + ", imageName="
				+ imageName + ", deviceName=" + deviceName + "]";
	}   
    
}