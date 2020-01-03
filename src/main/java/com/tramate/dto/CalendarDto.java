package com.tramate.dto;


public class CalendarDto {
   private int num;
   private int gnum;
   private int tnum;
   private String startdate;
   private String enddate;
   private String accept;
   private String reason;
   
   public String getReason() {
      return reason;
   }
   public void setReason(String reason) {
      this.reason = reason;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public int getGnum() {
      return gnum;
   }
   public void setGnum(int gnum) {
      this.gnum = gnum;
   }
   public int getTnum() {
      return tnum;
   }
   public void setTnum(int tnum) {
      this.tnum = tnum;
   }
   public String getStartdate() {
      return startdate;
   }
   public void setStartdate(String startdate) {
      this.startdate = startdate;
   }
   public String getEnddate() {
      return enddate;
   }
   public void setEnddate(String enddate) {
      this.enddate = enddate;
   }
   public String getAccept() {
      return accept;
   }
   public void setAccept(String accept) {
      this.accept = accept;
   }
   
}