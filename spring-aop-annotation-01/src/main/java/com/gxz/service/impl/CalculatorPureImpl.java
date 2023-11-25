package com.gxz.service.impl;

import com.gxz.service.Calculator;
import org.springframework.stereotype.Component;

@Component
public class CalculatorPureImpl  implements Calculator {

    public int add(int i, int j) {
        int result = i + j;
        return result;
    }


    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }


    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }


    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}