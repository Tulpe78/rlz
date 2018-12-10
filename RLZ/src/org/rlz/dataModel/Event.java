package org.rlz.dataModel;

public class Event {
	
    protected int id;
    protected int saison;
    protected String execDate;
    protected String name;
    protected String descn;

	public Event() {
	}
    
	public Event(int id) {
		this.id = id;
	}
	
    public Event(int id, int saison, String execDate, String name, String descn) {
        this.saison = saison;
        this.execDate = execDate;
        this.name = name;
        this.descn = descn;
        this.id = id;
    }
     
    public Event(int saison, String execDate, String name, String descn) {
        this.saison = saison;
        this.execDate = execDate;
        this.name = name;
        this.descn = descn;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getSaison() {
        return saison;
    }
 
    public void setSaison(int saison) {
        this.saison = saison;
    }
    
    public String getExecDate() {
        return execDate;
    }
 
    public void setExecDate(String execDate) {
        this.execDate = execDate;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDescn() {
        return descn;
    }
 
    public void setDescn(String descn) {
        this.descn = descn;
    }

}
