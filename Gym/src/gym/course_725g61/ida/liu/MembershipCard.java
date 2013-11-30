package gym.course_725g61.ida.liu;

import java.util.ArrayList;
import java.util.Date;

public abstract class MembershipCard {
	private String cardNumber;
	private int balance;
	private Date aquired;
	private Date expires;
	
 	private ArrayList<ExerciseUnity> exercises;
 	
 	public abstract boolean validForVisit(ExerciseUnity excercise);
 	
 	
}
