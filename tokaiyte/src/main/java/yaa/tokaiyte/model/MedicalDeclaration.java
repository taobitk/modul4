package yaa.tokaiyte.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MedicalDeclaration {

    @NotEmpty(message = "Họ tên không được để trống")
    @Size(min = 2, max = 100, message = "Họ tên phải từ 2 đến 100 ký tự")
    private String fullName;

    @Min(value = 1900, message = "Năm sinh không hợp lệ")
    private int yearOfBirth;

    @NotEmpty(message = "Giới tính không được để trống")
    private String gender;

    @NotEmpty(message = "Quốc tịch không được để trống")
    private String nationality;

    @NotEmpty(message = "Số CMND/Hộ chiếu không được để trống")
    private String idCardNumber; // Số hộ chiếu hoặc số CMND

    // Thông tin đi lại
    @NotEmpty(message = "Loại phương tiện không được để trống")
    private String travelInfoVehicle; // Tàu bay, Tàu thuyền, Ô tô, Khác
    private String vehicleNumber; // Số hiệu phương tiện
    private String seatNumber; // Số ghế

    @NotEmpty(message = "Ngày khởi hành không được để trống")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Ngày khởi hành phải theo định dạng dd/MM/yyyy")
    private String departureDate; // Ngày khởi hành (dd/MM/yyyy)

    @NotEmpty(message = "Ngày kết thúc không được để trống")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Ngày kết thúc phải theo định dạng dd/MM/yyyy")
    private String arrivalDate; // Ngày kết thúc (dd/MM/yyyy)

    private String visitedPlacesLast14Days; // Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?

    // Địa chỉ liên lạc
    @NotEmpty(message = "Tỉnh/Thành phố không được để trống")
    private String contactProvince;
    @NotEmpty(message = "Quận/Huyện không được để trống")
    private String contactDistrict;
    @NotEmpty(message = "Phường/Xã không được để trống")
    private String contactWard;
    @NotEmpty(message = "Địa chỉ nơi ở không được để trống")
    private String contactAddress;

    @NotEmpty(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;
    private String email;

    // Triệu chứng (có thể dùng mảng String[] hoặc List<String> nếu cho chọn nhiều)
    // Để đơn giản, dùng boolean cho từng triệu chứng
    private boolean symptomFever; // Sốt
    private boolean symptomCough; // Ho
    private boolean symptomShortnessOfBreath; // Khó thở
    private boolean symptomSoreThroat; // Đau họng
    private boolean symptomVomiting; // Nôn/buồn nôn
    private boolean symptomDiarrhea; // Tiêu chảy
    private boolean symptomSkinHemorrhage; // Xuất huyết ngoài da
    private boolean symptomSkinRash; // Nổi ban ngoài da

    // Lịch sử phơi nhiễm
    private boolean exposureToFarm; // Đến trang trại/chợ động vật
    private boolean exposureToNCoVPatient; // Tiếp xúc gần người mắc nCoV

    // Constructors, Getters, and Setters
    public MedicalDeclaration() {
    }

    // (Thêm constructor nếu cần)

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public String getIdCardNumber() { return idCardNumber; }
    public void setIdCardNumber(String idCardNumber) { this.idCardNumber = idCardNumber; }
    public String getTravelInfoVehicle() { return travelInfoVehicle; }
    public void setTravelInfoVehicle(String travelInfoVehicle) { this.travelInfoVehicle = travelInfoVehicle; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getDepartureDate() { return departureDate; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public String getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }
    public String getVisitedPlacesLast14Days() { return visitedPlacesLast14Days; }
    public void setVisitedPlacesLast14Days(String visitedPlacesLast14Days) { this.visitedPlacesLast14Days = visitedPlacesLast14Days; }
    public String getContactProvince() { return contactProvince; }
    public void setContactProvince(String contactProvince) { this.contactProvince = contactProvince; }
    public String getContactDistrict() { return contactDistrict; }
    public void setContactDistrict(String contactDistrict) { this.contactDistrict = contactDistrict; }
    public String getContactWard() { return contactWard; }
    public void setContactWard(String contactWard) { this.contactWard = contactWard; }
    public String getContactAddress() { return contactAddress; }
    public void setContactAddress(String contactAddress) { this.contactAddress = contactAddress; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isSymptomFever() { return symptomFever; }
    public void setSymptomFever(boolean symptomFever) { this.symptomFever = symptomFever; }
    public boolean isSymptomCough() { return symptomCough; }
    public void setSymptomCough(boolean symptomCough) { this.symptomCough = symptomCough; }
    public boolean isSymptomShortnessOfBreath() { return symptomShortnessOfBreath; }
    public void setSymptomShortnessOfBreath(boolean symptomShortnessOfBreath) { this.symptomShortnessOfBreath = symptomShortnessOfBreath; }
    public boolean isSymptomSoreThroat() { return symptomSoreThroat; }
    public void setSymptomSoreThroat(boolean symptomSoreThroat) { this.symptomSoreThroat = symptomSoreThroat; }
    public boolean isSymptomVomiting() { return symptomVomiting; }
    public void setSymptomVomiting(boolean symptomVomiting) { this.symptomVomiting = symptomVomiting; }
    public boolean isSymptomDiarrhea() { return symptomDiarrhea; }
    public void setSymptomDiarrhea(boolean symptomDiarrhea) { this.symptomDiarrhea = symptomDiarrhea; }
    public boolean isSymptomSkinHemorrhage() { return symptomSkinHemorrhage; }
    public void setSymptomSkinHemorrhage(boolean symptomSkinHemorrhage) { this.symptomSkinHemorrhage = symptomSkinHemorrhage; }
    public boolean isSymptomSkinRash() { return symptomSkinRash; }
    public void setSymptomSkinRash(boolean symptomSkinRash) { this.symptomSkinRash = symptomSkinRash; }
    public boolean isExposureToFarm() { return exposureToFarm; }
    public void setExposureToFarm(boolean exposureToFarm) { this.exposureToFarm = exposureToFarm; }
    public boolean isExposureToNCoVPatient() { return exposureToNCoVPatient; }
    public void setExposureToNCoVPatient(boolean exposureToNCoVPatient) { this.exposureToNCoVPatient = exposureToNCoVPatient; }
}
