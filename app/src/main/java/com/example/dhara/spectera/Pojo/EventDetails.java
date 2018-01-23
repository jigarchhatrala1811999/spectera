package com.example.dhara.spectera.Pojo;

/**
 * Created by dhara on 22-01-2018.
 */

public class EventDetails {
    String eventname,teamid,userid;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public EventDetails(String eventname, String teamid, String userid) {

        this.eventname = eventname;
        this.teamid = teamid;
        this.userid = userid;
    }
}
