<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Thông Tin Tờ Khai Y Tế</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .info-container { width: 700px; margin: 0 auto; padding: 20px; border: 1px solid #4CAF50; border-radius: 8px; background-color: #f0fff0; }
    h2 { text-align: center; color: #333; }
    table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }
    th { width: 30%; font-weight: bold; background-color: #e8f5e9; }
    .back-link { display: block; text-align: center; margin-top: 20px; }
  </style>
</head>
<body>
<div class="info-container">
  <h2>Thông Tin Tờ Khai Y Tế Đã Gửi</h2>

  <c:if test="${not empty submittedDeclaration}">
    <table>
      <tr><th>Họ tên:</th><td><c:out value="${submittedDeclaration.fullName}"/></td></tr>
      <tr><th>Năm sinh:</th><td><c:out value="${submittedDeclaration.yearOfBirth}"/></td></tr>
      <tr><th>Giới tính:</th><td><c:out value="${submittedDeclaration.gender}"/></td></tr>
      <tr><th>Quốc tịch:</th><td><c:out value="${submittedDeclaration.nationality}"/></td></tr>
      <tr><th>Số CMND/Hộ chiếu:</th><td><c:out value="${submittedDeclaration.idCardNumber}"/></td></tr>

      <tr><th colspan="2" style="text-align:center; background-color: #c8e6c9;">Thông tin đi lại</th></tr>
      <tr><th>Phương tiện:</th><td><c:out value="${submittedDeclaration.travelInfoVehicle}"/></td></tr>
      <tr><th>Số hiệu phương tiện:</th><td><c:out value="${submittedDeclaration.vehicleNumber}"/></td></tr>
      <tr><th>Số ghế:</th><td><c:out value="${submittedDeclaration.seatNumber}"/></td></tr>
      <tr><th>Ngày khởi hành:</th><td><c:out value="${submittedDeclaration.departureDate}"/></td></tr>
      <tr><th>Ngày kết thúc:</th><td><c:out value="${submittedDeclaration.arrivalDate}"/></td></tr>
      <tr><th>Nơi đã đến (14 ngày qua):</th><td><c:out value="${submittedDeclaration.visitedPlacesLast14Days}"/></td></tr>

      <tr><th colspan="2" style="text-align:center; background-color: #c8e6c9;">Địa chỉ liên lạc</th></tr>
      <tr><th>Tỉnh/Thành:</th><td><c:out value="${submittedDeclaration.contactProvince}"/></td></tr>
      <tr><th>Quận/Huyện:</th><td><c:out value="${submittedDeclaration.contactDistrict}"/></td></tr>
      <tr><th>Phường/Xã:</th><td><c:out value="${submittedDeclaration.contactWard}"/></td></tr>
      <tr><th>Địa chỉ nơi ở:</th><td><c:out value="${submittedDeclaration.contactAddress}"/></td></tr>
      <tr><th>Điện thoại:</th><td><c:out value="${submittedDeclaration.phoneNumber}"/></td></tr>
      <tr><th>Email:</th><td><c:out value="${submittedDeclaration.email}"/></td></tr>

      <tr><th colspan="2" style="text-align:center; background-color: #c8e6c9;">Triệu chứng (14 ngày qua)</th></tr>
      <tr><th>Sốt:</th><td>${submittedDeclaration.symptomFever ? 'Có' : 'Không'}</td></tr>
      <tr><th>Ho:</th><td>${submittedDeclaration.symptomCough ? 'Có' : 'Không'}</td></tr>
      <tr><th>Khó thở:</th><td>${submittedDeclaration.symptomShortnessOfBreath ? 'Có' : 'Không'}</td></tr>
      <tr><th>Đau họng:</th><td>${submittedDeclaration.symptomSoreThroat ? 'Có' : 'Không'}</td></tr>
      <tr><th>Nôn/Buồn nôn:</th><td>${submittedDeclaration.symptomVomiting ? 'Có' : 'Không'}</td></tr>
      <tr><th>Tiêu chảy:</th><td>${submittedDeclaration.symptomDiarrhea ? 'Có' : 'Không'}</td></tr>
      <tr><th>Xuất huyết ngoài da:</th><td>${submittedDeclaration.symptomSkinHemorrhage ? 'Có' : 'Không'}</td></tr>
      <tr><th>Nổi ban ngoài da:</th><td>${submittedDeclaration.symptomSkinRash ? 'Có' : 'Không'}</td></tr>

      <tr><th colspan="2" style="text-align:center; background-color: #c8e6c9;">Lịch sử phơi nhiễm (14 ngày qua)</th></tr>
      <tr><th>Đến trang trại/chợ động vật:</th><td>${submittedDeclaration.exposureToFarm ? 'Có' : 'Không'}</td></tr>
      <tr><th>Tiếp xúc gần người mắc nCoV:</th><td>${submittedDeclaration.exposureToNCoVPatient ? 'Có' : 'Không'}</td></tr>
    </table>
  </c:if>
  <c:if test="${empty submittedDeclaration}">
    <p>Không có thông tin tờ khai để hiển thị.</p>
  </c:if>

  <p class="back-link">
    <a href="${pageContext.request.contextPath}/medical/declare">Khai báo lại</a>
  </p>
</div>
</body>
</html>
