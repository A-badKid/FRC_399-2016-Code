package org.usfirst.team399.auton;

import org.usfirst.frc.team399.commands.TankDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OverOtherDefenses extends CommandGroup{
	
	public OverOtherDefenses(){
		this.addSequential(new TankDrive(-1.0,-1.0,1.5));
		//adjust time for moat, rockwall?
		//adjust power later
	}

}
