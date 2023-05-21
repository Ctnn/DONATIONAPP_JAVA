package com.eraybd.project;

public class BagisModel {
    String BagisTur;
    String Bagis_Aciklama;


    public BagisModel(String bagisTur, String bagis_Aciklama) {
        BagisTur = bagisTur;
        Bagis_Aciklama = bagis_Aciklama;
    }

    public String getBagisTur() {
        return BagisTur;
    }

    public String getBagis_Aciklama() {
        return Bagis_Aciklama;
    }
}
