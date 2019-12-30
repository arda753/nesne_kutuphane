package Bilgiler;


import Bilgiler.IAdminUyeBilgileri;


public class KayitliUyelerinBilgileri implements IAdminUyeBilgileri {
    
    private int id;
    private String isim;
    private String soyisim;
    private String k_adi;
    private String sifre;
    private String yetki;

    public KayitliUyelerinBilgileri(int id, String isim, String soyisim, String k_adi, String sifre, String yetki) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.k_adi = k_adi;
        this.sifre = sifre;
        this.yetki = yetki;
    }

    
    public int getId() {
        return id; 
    }

    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getIsim() {
        return isim;
    }

    @Override
    public void setIsim(String isim) {
        this.isim=isim;
    }

    @Override
    public String getSoyisim() {
        return soyisim;
    }

    @Override
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    @Override
    public String getK_adi() {
        return k_adi;
    }

    @Override
    public void setK_adi(String k_adi) {
        this.k_adi = k_adi;
    }

   
    public String getSifre() {
        return sifre;
    }

   
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    
    public String getYetki() {
        return yetki;
    }

    
    public void setYetki(String yetki) {
        this.yetki = yetki;
    }
    
}

