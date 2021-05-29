package entity;

import java.io.Serializable;

//untuk menyimpan data yg akan masuk
public class Mahasiswa implements Serializable {
    private String nim, nama, progdi, fakultas, phone, laporan ; 
//varibael laporan utk report ke client
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProgdi() {
        return progdi;
    }

    public void setProgdi(String progdi) {
        this.progdi = progdi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }
    
}
