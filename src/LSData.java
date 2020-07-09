/**@auther Liam Watson
*The data objected used to store the data for the loadshedding schedule.*/

public class LSData implements Comparable<LSData>{
    private String stage, DoM, sTime, areas; //LS Data items
	/**
	* @param values to assign to variables 
	* Constructor assignes values to the variables
	*/
    public LSData(String stage, String DoM, String sTime, String areas){
        this.stage = stage;
        this.DoM = DoM;
        this.sTime = sTime;
        this.areas = areas;
    }
	/**
	* @return String stage
	*/
    public String getStage(){
        return stage;
    }
	/**
	* @return String day of month
	*/
    public String getDoM(){
        return DoM;
    }
	/**
	* @return String start time
	*/
    public String getSTime(){
        return sTime;
    }
	/**
	* @return String areas that load shedding will effect
	*/
    public String getAreas(){
        return areas;
    }
	/**
	* @return String the combination of stage, day of month and sTime used to compare
	*/
    public String getCombData(){
        return stage + "_" + DoM + "_" + sTime + "";
    }
	/**
	* @return int Compare to method.
	* @param tmp LSData to be compared
	*/
    public int compareTo(LSData tmp){
        return (this.getCombData().compareTo(tmp.getCombData()));
	
    }
	/**
	* @return String toString of the LSData method 
	*/
    public String toString(){
        return stage + "_" + DoM + "_" + sTime + " " + areas;
    }  
}
