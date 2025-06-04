<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Tờ Khai Y Tế</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .form-container { width: 800px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
    .form-group { margin-bottom: 15px; }
    .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
    .form-group input[type="text"],
    .form-group input[type="email"],
    .form-group input[type="number"],
    .form-group select,
    .form-group textarea { width: 98%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
    .form-group input[type="radio"],
    .form-group input[type="checkbox"] { margin-right: 5px; }
    .form-group .radio-group label,
    .form-group .checkbox-group label { font-weight: normal; margin-right: 15px; }
    .error { color: red; font-size: 0.9em; margin-top: 3px; }
    .submit-btn { background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 1.1em; }
    h1, h3 { text-align: center; }
    .note { font-size: 0.9em; color: #555; text-align: center; margin-bottom: 10px; }
    .warning { font-size: 0.9em; color: red; text-align: center; margin-bottom: 20px; font-weight: bold;}
    fieldset { border: 1px solid #ddd; padding: 15px; margin-bottom: 20px; border-radius: 5px; }
    legend { font-weight: bold; color: #333; }
  </style>
</head>
<body>
<div class="form-container">
  <h1>TỜ KHAI Y TẾ</h1>
  <p class="note">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
  <p class="warning">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

  <form:form method="POST" action="${pageContext.request.contextPath}/medical/declare" modelAttribute="medicalDeclaration">
    <fieldset>
      <legend>Thông tin cá nhân</legend>
      <div class="form-group">
        <form:label path="fullName">Họ tên (ghi chữ IN HOA) (*)</form:label>
        <form:input path="fullName" cssClass="form-control"/>
        <form:errors path="fullName" cssClass="error"/>
      </div>

      <div class="form-group" style="display: flex; justify-content: space-between;">
        <div style="width: 30%;">
          <form:label path="yearOfBirth">Năm sinh (*)</form:label>
          <form:select path="yearOfBirth" cssClass="form-control">
            <form:option value="" label="--- Chọn năm ---"/>
            <form:options items="${years}"/>
          </form:select>
          <form:errors path="yearOfBirth" cssClass="error"/>
        </div>
        <div style="width: 30%;">
          <form:label path="gender">Giới tính (*)</form:label>
          <form:select path="gender" cssClass="form-control">
            <form:option value="" label="--- Chọn giới tính ---"/>
            <form:options items="${genders}"/>
          </form:select>
          <form:errors path="gender" cssClass="error"/>
        </div>
        <div style="width: 30%;">
          <form:label path="nationality">Quốc tịch (*)</form:label>
          <form:select path="nationality" cssClass="form-control">
            <form:option value="" label="--- Chọn quốc tịch ---"/>
            <form:options items="${nationalities}"/>
          </form:select>
          <form:errors path="nationality" cssClass="error"/>
        </div>
      </div>

      <div class="form-group">
        <form:label path="idCardNumber">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*)</form:label>
        <form:input path="idCardNumber" cssClass="form-control"/>
        <form:errors path="idCardNumber" cssClass="error"/>
      </div>
    </fieldset>

    <fieldset>
      <legend>Thông tin đi lại (*)</legend>
      <div class="form-group radio-group">
        <form:radiobuttons path="travelInfoVehicle" items="${vehicles}" delimiter="&nbsp;&nbsp;&nbsp;&nbsp;" />
        <form:errors path="travelInfoVehicle" cssClass="error"/>
      </div>
      <div class="form-group" style="display: flex; justify-content: space-between;">
        <div style="width: 48%;">
          <form:label path="vehicleNumber">Số hiệu phương tiện</form:label>
          <form:input path="vehicleNumber" placeholder="VD: VN123" cssClass="form-control"/>
        </div>
        <div style="width: 48%;">
          <form:label path="seatNumber">Số ghế</form:label>
          <form:input path="seatNumber" cssClass="form-control"/>
        </div>
      </div>
      <div class="form-group" style="display: flex; justify-content: space-between;">
        <div style="width: 48%;">
          <form:label path="departureDate">Ngày khởi hành (*)</form:label>
          <form:input path="departureDate" placeholder="dd/MM/yyyy" cssClass="form-control"/>
          <form:errors path="departureDate" cssClass="error"/>
        </div>
        <div style="width: 48%;">
          <form:label path="arrivalDate">Ngày kết thúc (*)</form:label>
          <form:input path="arrivalDate" placeholder="dd/MM/yyyy" cssClass="form-control"/>
          <form:errors path="arrivalDate" cssClass="error"/>
        </div>
      </div>
      <div class="form-group">
        <form:label path="visitedPlacesLast14Days">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? (*)</form:label>
        <form:textarea path="visitedPlacesLast14Days" rows="3" cssClass="form-control"/>
        <form:errors path="visitedPlacesLast14Days" cssClass="error"/>
      </div>
    </fieldset>

    <fieldset>
      <legend>Địa chỉ liên lạc tại Việt Nam</legend>
      <div class="form-group">
        <form:label path="contactProvince">Tỉnh/Thành phố (*)</form:label>
        <form:input path="contactProvince" cssClass="form-control"/>
        <form:errors path="contactProvince" cssClass="error"/>
      </div>
      <div class="form-group">
        <form:label path="contactDistrict">Quận/Huyện (*)</form:label>
        <form:input path="contactDistrict" cssClass="form-control"/>
        <form:errors path="contactDistrict" cssClass="error"/>
      </div>
      <div class="form-group">
        <form:label path="contactWard">Phường/Xã (*)</form:label>
        <form:input path="contactWard" cssClass="form-control"/>
        <form:errors path="contactWard" cssClass="error"/>
      </div>
      <div class="form-group">
        <form:label path="contactAddress">Địa chỉ nơi ở (*)</form:label>
        <form:input path="contactAddress" cssClass="form-control"/>
        <form:errors path="contactAddress" cssClass="error"/>
      </div>
      <div class="form-group">
        <form:label path="phoneNumber">Điện thoại (*)</form:label>
        <form:input path="phoneNumber" cssClass="form-control"/>
        <form:errors path="phoneNumber" cssClass="error"/>
      </div>
      <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email" type="email" cssClass="form-control"/>
        <form:errors path="email" cssClass="error"/>
      </div>
    </fieldset>

    <fieldset>
      <legend>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? (*)</legend>
      <table style="width:100%;">
        <tr>
          <td>Sốt (*):</td>
          <td><form:radiobutton path="symptomFever" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomFever" value="false"/> Không</td>
          <td>Nôn/buồn nôn (*):</td>
          <td><form:radiobutton path="symptomVomiting" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomVomiting" value="false"/> Không</td>
        </tr>
        <tr>
          <td>Ho (*):</td>
          <td><form:radiobutton path="symptomCough" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomCough" value="false"/> Không</td>
          <td>Tiêu chảy (*):</td>
          <td><form:radiobutton path="symptomDiarrhea" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomDiarrhea" value="false"/> Không</td>
        </tr>
        <tr>
          <td>Khó thở (*):</td>
          <td><form:radiobutton path="symptomShortnessOfBreath" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomShortnessOfBreath" value="false"/> Không</td>
          <td>Xuất huyết ngoài da (*):</td>
          <td><form:radiobutton path="symptomSkinHemorrhage" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomSkinHemorrhage" value="false"/> Không</td>
        </tr>
        <tr>
          <td>Đau họng (*):</td>
          <td><form:radiobutton path="symptomSoreThroat" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomSoreThroat" value="false"/> Không</td>
          <td>Nổi ban ngoài da (*):</td>
          <td><form:radiobutton path="symptomSkinRash" value="true"/> Có &nbsp;&nbsp; <form:radiobutton path="symptomSkinRash" value="false"/> Không</td>
        </tr>
      </table>
        <%-- Thêm form:errors cho các trường boolean nếu cần thiết, nhưng thường thì radio button sẽ luôn có giá trị --%>
    </fieldset>

    <fieldset>
      <legend>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có (*)</legend>
      <div class="form-group checkbox-group">
        <form:checkbox path="exposureToFarm" value="true"/> Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vật
      </div>
      <div class="form-group checkbox-group">
        <form:checkbox path="exposureToNCoVPatient" value="true"/> Tiếp xúc gần (&lt;2m) với người mắc bệnh viêm đường hô hấp do nCoV
      </div>
    </fieldset>

    <div class="form-group" style="text-align: center; margin-top: 30px;">
      <input type="submit" value="GỬI TỜ KHAI" class="submit-btn"/>
    </div>
  </form:form>
  <p class="note" style="margin-top: 20px;">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
</div>
</body>
</html>
