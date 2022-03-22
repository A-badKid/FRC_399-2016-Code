package org.usfirst.frc.team399.commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class Rev extends Command{
	private double shootervalue1;
	//private double timeout;
	
	public Rev(double shootervalue1){
		this.shootervalue1 = shootervalue1;
		//this.timeout = timeout;
		
	}

	@Override
	protected void initialize() {
		Supersystem.getInstance().shooter.setShooter(shootervalue1);
		//setTimeout(timeout);
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
		Supersystem.getInstance().shooter.setShooter(0.0);

		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().shooter.setShooter(0.0);
		
		// TODO Auto-generated method stub
		
	}

}
