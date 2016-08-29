package com.model.bean;

/**
 * Created by zhouweitao on 16/8/29.
 */
public class Regions {

    private String code;
    private String parent_code;
    private String name;
    private String alias;
    private String pinyin;
    private String abbr;
    private String zip;
    private int level;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "code='" + code + '\'' +
                ", parent_code='" + parent_code + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", abbr='" + abbr + '\'' +
                ", zip='" + zip + '\'' +
                ", level=" + level +
                '}';
    }
}
