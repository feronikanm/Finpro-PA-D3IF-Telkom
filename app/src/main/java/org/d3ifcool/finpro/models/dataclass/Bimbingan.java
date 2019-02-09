package org.d3ifcool.finpro.models.dataclass;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 27/01/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */
public class Bimbingan implements Parcelable {

    private String id;
    private String tanggal;
    private String isi;

    public Bimbingan(String id, String tanggal, String isi) {
        this.id = id;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.tanggal);
        dest.writeString(this.isi);
    }

    protected Bimbingan(Parcel in) {
        this.id = in.readString();
        this.tanggal = in.readString();
        this.isi = in.readString();
    }

    public static final Parcelable.Creator<Bimbingan> CREATOR = new Parcelable.Creator<Bimbingan>() {
        @Override
        public Bimbingan createFromParcel(Parcel source) {
            return new Bimbingan(source);
        }

        @Override
        public Bimbingan[] newArray(int size) {
            return new Bimbingan[size];
        }
    };
}
