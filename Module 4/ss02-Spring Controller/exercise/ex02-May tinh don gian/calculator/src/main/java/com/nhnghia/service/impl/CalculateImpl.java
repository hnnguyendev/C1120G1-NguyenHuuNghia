package com.nhnghia.service.impl;

import com.nhnghia.service.ICalculate;
import org.springframework.stereotype.Service;

@Service
public class CalculateImpl implements ICalculate {
    @Override
    public double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    @Override
    public double subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    public double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    @Override
    public double division(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
}
