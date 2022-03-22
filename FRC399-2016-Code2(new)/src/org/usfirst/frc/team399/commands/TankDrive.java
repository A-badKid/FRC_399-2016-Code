package org.usfirst.frc.team399.commands;
import org.usfirst.frc.team399.Systems.Supersystem;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	private double leftPow;
	private double rightPow;
	private double timeout;
	
	public TankDrive(double leftPow,double rightPow, double timeout) {
		this.leftPow = leftPow;
		this.rightPow = rightPow;
		this.timeout = timeout;
	}

	@Override
	protected void initialize() {
		Supersystem.getInstance().drive.tankDrive(leftPow,rightPow);
		setTimeout(timeout);
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
