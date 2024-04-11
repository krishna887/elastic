package com.example.task2_api_elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "sample")
public class SampleData {
    @Id
    private String id;

    private int zip;
    private int posH;
    private String bC;
    private int negA;
    private int bCls;
    private int npi;
    private int tinT;
    private int nrP;
    private int _dT;
    private int mdH;
    private double negR;
    private String bCT;
    private int negT;
    private int tin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPosH() {
        return posH;
    }

    public void setPosH(int posH) {
        this.posH = posH;
    }

    public String getbC() {
        return bC;
    }

    public void setbC(String bC) {
        this.bC = bC;
    }

    public int getNegA() {
        return negA;
    }

    public void setNegA(int negA) {
        this.negA = negA;
    }

    public int getbCls() {
        return bCls;
    }

    public void setbCls(int bCls) {
        this.bCls = bCls;
    }

    public int getNpi() {
        return npi;
    }

    public void setNpi(int npi) {
        this.npi = npi;
    }

    public int getTinT() {
        return tinT;
    }

    public void setTinT(int tinT) {
        this.tinT = tinT;
    }

    public int getNrP() {
        return nrP;
    }

    public void setNrP(int nrP) {
        this.nrP = nrP;
    }

    public int get_dT() {
        return _dT;
    }

    public void set_dT(int _dT) {
        this._dT = _dT;
    }

    public int getMdH() {
        return mdH;
    }

    public void setMdH(int mdH) {
        this.mdH = mdH;
    }

    public double getNegR() {
        return negR;
    }

    public void setNegR(double negR) {
        this.negR = negR;
    }

    public String getbCT() {
        return bCT;
    }

    public void setbCT(String bCT) {
        this.bCT = bCT;
    }

    public int getNegT() {
        return negT;
    }

    public void setNegT(int negT) {
        this.negT = negT;
    }

    public int getTin() {
        return tin;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }
}
