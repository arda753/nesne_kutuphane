package Bilgiler;


import Bilgiler.IAdminUyeBilgileri;


public class KayitliAdminBilgileri implements IAdminUyeBilgileri {
    
    
    private String isim;
    private String soyisim;
    private String k_adi;
    

    public KayitliAdminBilgileri(String isim, String soyisim, String k_adi) {
        
        this.isim = isim;
        this.soyisim = soyisim;
        this.k_adi = k_adi;
          
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

    
    
}
