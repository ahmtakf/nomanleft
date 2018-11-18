package com.nullpointers.nomanleft;

import com.nullpointers.nomanleft.controller.GameManager;

public class Main {

    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        gameManager.startLevel(1);
    }

}