package com.exxeta;

public class LocStat {

    private String filename;
    private int totalLoc;
    private int total;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getTotalLoc() {
        return totalLoc;
    }

    public void setTotalLoc(int totalLoc) {
        this.totalLoc = totalLoc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override public String toString() {
        return "LocStat: " +
            "filename='" + filename + '\'' +
            ", totalLoc=" + totalLoc +
            ", total=" + total;
    }
}
