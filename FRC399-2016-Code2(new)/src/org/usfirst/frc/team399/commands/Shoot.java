package org.usfirst.frc.team399.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team399.Systems.Supersystem;

public class Shoot extends Command {
	boolean actuatorvalue;
	double tiout;
	
	public Shoot(boolean actuatorvalue){
		this.actuatorvalue = actuatorvalue;
		//this.tiout = tiout;
	}

	@Override
	protected void initialize() {
		Supersystem.shooteractuator.setShoot(actuatorvalue);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.shooteractuator.setShoot(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.shooteractuator.setShoot(false);
		// TODO Auto-generated method stub
		
	}

}
