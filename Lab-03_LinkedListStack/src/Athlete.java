import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Athlete class
 * @author Mike Stahr
 *
 * Fields of expected file import (fields are separated by a single tab):
 * 	athleteID		athleteType		first_name		last_name		email		wins
 */
public class Athlete {

	//====================================================================================== Properties
	private int athleteID;
	private String athleteType, first_name, last_name, email;
	private int wins;
	
	//====================================================================================== Constructors
	public Athlete(Scanner fin) {
		this(fin.nextLine());
	}
	
	public Athlete(String line) {
		this(line.split("\t"));
	}
	
	public Athlete(String[] parts) {
		this(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
	}
	
	public Athlete(int athleteID, String athleteType, String first_name, String last_name, String email, int wins) {
		super();
		setAthleteID(athleteID);
		setAthleteType(athleteType);
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setWins(wins);
	}
	//====================================================================================== Methods
	public String fullName() {
		return first_name + " " + last_name;
	}
	
	@Override
	public String toString() {
		return String.format("%-35s %20s %10d", fullName(), athleteType, wins);
	}
	
	//====================================================================================== Getters / Setters
	public int getAthleteID() 		{	return athleteID;	}
	public String getAthleteType() 	{	return athleteType;	}
	public String getFirst_name() 	{	return first_name;	}
	public String getLast_name() 	{	return last_name;	}
	public String getEmail() 		{	return email;		}
	public int getWins() 			{	return wins;		}
	
	public void setAthleteID(int athleteID) {
		if(wins < 0) 
			throw new InvalidParameterException("athleteID wins must be > 0 (AthleteID: " + athleteID + ")");
		this.athleteID = athleteID;
	}
	public void setAthleteType(String athleteType) {
		this.athleteType = athleteType;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setWins(int wins) {
		if(wins < 0) 
			throw new InvalidParameterException("Athlete wins must be >= 0 (AthleteID: " + athleteID + ")");
		this.wins = wins;
	}
	
}
