package com.cafeapps.model;

import java.util.ArrayList;
import java.util.List;

public class DetailCafe {
    private String nama;
    private Location location;
    private String alamat;
    private String deskripsi;
    private List<Fasilitas> fasilitas = new ArrayList<Fasilitas>();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public List<Fasilitas> getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(List<Fasilitas> fasilitas) {
        this.fasilitas = fasilitas;
    }

    public class Fasilitas{
        private String nama;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }
    }

    public class DetailCafeData extends Base {
        private DetailCafe DATA;

        public DetailCafe getDATA() {
            return DATA;
        }

        public void setDATA(DetailCafe DATA) {
            this.DATA = DATA;
        }
    }

}
