package com.cafeapps.model;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private String id;
    private String rating;
    private String nama;
    private String jenis;
    private String alamat;
    private String url_foto;
    private Location location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public class CafeData extends Base {
        private Cafe DATA;

        public Cafe getDATA() {
            return DATA;
        }

        public void setDATA(Cafe DATA) {
            this.DATA = DATA;
        }
    }

    public class CafeList extends Base {
        List<Cafe> DATA;

        public List<Cafe> getDATA() {
            return DATA;
        }

        public void setDATA(List<Cafe> DATA) {
            this.DATA = DATA;
        }
    }
}
