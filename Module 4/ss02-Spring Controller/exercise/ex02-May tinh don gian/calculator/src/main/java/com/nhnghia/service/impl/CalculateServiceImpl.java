package com.nhnghia.service.impl;

import com.nhnghia.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements ICalculateService {

    @Override
    public double calculate(double firstOperand, double secondOperand, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Can not divide by Zero");
                }
        }
        return result;
    }
}
