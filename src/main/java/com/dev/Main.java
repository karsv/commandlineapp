package com.dev;

import com.dev.service.SquareService;

public class Main {
    public static void main(String[] args) {
        SquareService squareService = new SquareService("QLGNAEKIRLRNGEAE");
        System.out.println(squareService.getResult("KING"));
    }
}
