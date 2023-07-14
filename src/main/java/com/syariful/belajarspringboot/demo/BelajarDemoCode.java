package com.syariful.belajarspringboot.demo;

import java.util.ArrayList;

public class BelajarDemoCode {
    public static void main(String[] args) {
        contohArrayListTipeDataString();
        contohArrayListTipeDataInteger();
    }

    private static void contohArrayListTipeDataInteger() {
        ArrayList<Integer> dataSemuaNIK = new ArrayList<>();

        dataSemuaNIK.add(45678); // 0
        dataSemuaNIK.add(54367); // 1
        dataSemuaNIK.add(65443);// 2
        dataSemuaNIK.add(67834);// 3

        System.out.println(dataSemuaNIK);

        System.out.println(dataSemuaNIK.get(3));
    }

    private static void contohArrayListTipeDataString() {
        // contoh array string
        ArrayList<String> dataSemuaMobil = new ArrayList<>();

        // contoh isi arraynya
        dataSemuaMobil.add("Mobil A"); // index ke - 0
        dataSemuaMobil.add("Mobil B"); // index ke - 1
        dataSemuaMobil.add("Mobil C"); // index ke - 2
        dataSemuaMobil.add("Mobil D"); // index ke - 3

        System.out.println(dataSemuaMobil);

        System.out.println(dataSemuaMobil.get(2));
    }
}
