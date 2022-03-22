package org.usfirst.frc.team399.commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class DistancedDrive extends Command {
	private double encoderDistance;
	private double desiredDistance;
	private double leftPow;
	private double rightPow;
	public DistancedDrive(double desiredDistance,double leftPow,double rightPow){
		this.desiredDistance = desiredDistance;
		this.leftPow = leftPow;
		this.rightPow = rightPow;
	}
	@Override
	protected void initialize() {
		while(encoderDistance < desiredDistance){
			Supersystem.getInstance().drive.tankDrive(leftPow,rightPow);
		}
		
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
		Supersystem.getInstance().drive.tankDrive(0.0,0.0);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().drive.tankDrive(0.0,0.0);
		// TODO Auto-generated method stub
		
	}

}
