package com.github.ixiongdi.sdut;

public class MP4 {

    private String name;

    private Long size;

    private String dstName;


    public MP4(String name, Long size, String dstName) {
        this.name = name;
        this.size = size;
        this.dstName = dstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDstName() {
        return dstName;
    }

    public void setDstName(String dstName) {
        this.dstName = dstName;
    }
}
