package yaa.buoi2bth4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/")
    public String getTimeByTimezone(ModelMap model,
    @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {

        // Bước 3: Xử lý để lấy thời gian hiện tại của một thành phố trên thế giới
        // Lấy ra thời gian hiện tại trên server
        Date date = new Date();

        // Lấy ra time zone hiện tại của server (mặc định)
        TimeZone local = TimeZone.getDefault();

        // Lấy ra time zone của thành phố được yêu cầu từ tham số 'city'
        TimeZone locale = TimeZone.getTimeZone(city);

        // Tính thời gian chênh lệch (offset) của timezone server so với UTC (tính bằng mili giây)
        long localOffset = local.getRawOffset();
        if (local.inDaylightTime(date)) { // Kiểm tra xem có đang trong giờ mùa hè không
            localOffset = localOffset + local.getDSTSavings();
        }

        // Tính thời gian chênh lệch (offset) của timezone thành phố yêu cầu so với UTC
        long localeOffset = locale.getRawOffset();
        if (locale.inDaylightTime(date)) { // Kiểm tra giờ mùa hè cho thành phố yêu cầu
            localeOffset = localeOffset + locale.getDSTSavings();
        }

        // Tính thời gian hiện tại của thành phố cụ thể
        // Thời gian server (date.getTime()) là tính theo UTC + localOffset.
        // Để có thời gian UTC: date.getTime() - localOffset
        // Để có thời gian của thành phố yêu cầu: (date.getTime() - localOffset) + localeOffset
        // Hoặc cách khác (như hướng dẫn gốc, nhưng có thể cần cẩn thận với DST):
        // long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Cách tính chính xác hơn khi có Daylight Saving Time (DST):
        long serverTimeInUTC = date.getTime() - local.getOffset(date.getTime()); // Thời gian server quy về UTC
        long cityTime = serverTimeInUTC + locale.getOffset(date.getTime()); // Thời gian thành phố yêu cầu

        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của thành phố cụ thể
        date.setTime(cityTime);

        // Bước 4: Chuyển dữ liệu về view
        model.addAttribute("city", city); // Tên thành phố/timezone đã chọn
        model.addAttribute("date", date); // Đối tượng Date đã được điều chỉnh theo timezone của 'city'

        return "index";
    }
}