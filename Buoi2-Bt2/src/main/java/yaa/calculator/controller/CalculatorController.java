package yaa.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/") 
    public String showCalculatorForm() {
        return "calculator-form";
    }

    @PostMapping("/calculate") // Xử lý phép tính khi submit form
    public String calculate(
            @RequestParam(name = "firstOperand", required = false) Double firstOperand,
            @RequestParam(name = "secondOperand", required = false) Double secondOperand,
            @RequestParam(name = "operator", required = false) String operator,
            Model model) {

        String resultMessage = "";
        Double calculationResult = null;

        if (firstOperand == null || secondOperand == null || operator == null || operator.isEmpty()) {
            resultMessage = "Please enter both operands and select an operator.";
        } else {
            try {
                switch (operator) {
                    case "Addition(+)":
                        calculationResult = firstOperand + secondOperand;
                        break;
                    case "Subtraction(-)":
                        calculationResult = firstOperand - secondOperand;
                        break;
                    case "Multiplication(X)":
                        calculationResult = firstOperand * secondOperand;
                        break;
                    case "Division(/)":
                        if (secondOperand == 0) {
                            resultMessage = "Cannot divide by zero!";
                        } else {
                            calculationResult = firstOperand / secondOperand;
                        }
                        break;
                    default:
                        resultMessage = "Invalid operator selected.";
                }
            } catch (Exception e) {
                resultMessage = "Error during calculation: " + e.getMessage();
            }
        }

        // Gửi lại các giá trị đầu vào để hiển thị trên form
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("selectedOperator", operator); // Gửi lại phép toán đã chọn

        if (calculationResult != null) {
            model.addAttribute("result", calculationResult);
        }
        if (!resultMessage.isEmpty()) {
            model.addAttribute("errorMessage", resultMessage);
        }

        return "calculator-form"; // Trả về cùng một view để hiển thị form và kết quả
    }
}