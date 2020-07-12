package mj223vn_assign3.valhalla;
/**
 * A class representing Norse Gods.
 * @author marcus
 *
 */
public class NorseGod {
	String name;
	String race;
	String desc;
	
	public NorseGod(){}	
	
	public NorseGod(String name, String race, String desc){
		this.name = name;
		this.race = race;
		this.desc = desc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRace(String race) {
		this.race = race;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
