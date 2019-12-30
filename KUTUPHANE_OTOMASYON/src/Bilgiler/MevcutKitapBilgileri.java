package Bilgiler;


import Bilgiler.ButunKitapBilgileri;


public class MevcutKitapBilgileri extends ButunKitapBilgileri {
    
    private int id;
    private String kitap_adi;
    private String yazar_adi;
    private String yazar_soyadi;
    private String yayin_evi;
    private String kitap_turu;
    private int miktar;
    

    public MevcutKitapBilgileri(int id, String kitap_adi, String yazar_adi, String yazar_soyadi, String yayin_evi, String kitap_turu, int miktar) {
        this.id = id;
        this.kitap_adi = kitap_adi;
        this.yazar_adi = yazar_adi;
        this.yazar_soyadi = yazar_soyadi;
        this.yayin_evi = yayin_evi;
        this.kitap_turu = kitap_turu;
        this.miktar = miktar;
        
    }
    

    
    @Override
    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

   
    @Override
    public void setYazar_adi(String yazar_adi) {
        this.yazar_adi = yazar_adi;
    }

    
    @Override
    public void setYazar_soyadi(String yazar_soyadi) {
        this.yazar_soyadi = yazar_soyadi;
    }
    
    
    @Override
    public void setYayin_evi(String yayin_evi) {
        this.yayin_evi = yayin_evi;
    }

    
    @Override
    public void setKitap_turu(String kitap_turu) {
        this.kitap_turu = kitap_turu;
        
    }
    
    public int setBorcKitap(int giden){
        
        this.miktar -= giden; 
        
        
        return miktar;
    }
    
    public int setİadeKitap(int iade){
        
        this.miktar += iade;
        return miktar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String getKitap_adi() {
        return kitap_adi;
    }
    
    @Override
    public String getYazar_adi() {
        return yazar_adi;
    }
    
    @Override
    public String getYazar_soyadi() {
        return yazar_soyadi;
    }
    
    @Override
    public String getYayin_evi() {
        return yayin_evi;
    }
 
    @Override
    public String getKitap_turu() {
        return kitap_turu;
    }
    
    @Override
    public int getMiktar() {
        return miktar;
    }
    

    
    
}
