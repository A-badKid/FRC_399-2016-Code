
package org.usfirst.frc.team399.robot;

import org.usfirst.frc.team399.Config.Ports;
import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.team399.auton.OverOtherDefenses;
import org.usfirst.team399.auton.UnderLowBar;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser = null;
    Command autonCommand = null;
    
    OverOtherDefenses overotherdefense;
	
    Joystick driverL = new Joystick(Ports.Controls.DRIVER_PORT_A);
    Joystick driverR = new Joystick(Ports.Controls.DRIVER_PORT_B);
    Joystick operator = new Joystick(Ports.Controls.OPERATOR_PORT);
    
    Supersystem bot = Supersystem.getInstance();
    
    AHRS ahrs;
    double angle;
    double targetangle = 90;
    boolean firststate = true;
    boolean secondstate = false;
    boolean thirdstate = false;
    AnalogInput pixycam = new AnalogInput(Ports.Pixycam.PIXYCAM_PORT);
	

    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//    	chooser = new SendableChooser();
//    	chooser.addObject("Over Other Defenses", new OverOtherDefenses());
//		SmartDashboard.putData("Autonomous Chooser" , chooser);
    	overotherdefense = new OverOtherDefenses();
		autonCommand = overotherdefense;
    	
//    	chooser = new SendableChooser();
//    	chooser.addObject("Over Other Defenses", new OverOtherDefenses());
//    	chooser.addObject("Low Bar", new UnderLowBar());
//    	SmartDashboard.putData("Autonomous Chooser", chooser);
//    
    	bot = Supersystem.getInstance();
		
    	ahrs = new AHRS(SPI.Port.kMXP);
	
		
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
//    	autonCommand = (Command) chooser.getSelected();
    	if( autonCommand != null){
    		autonCommand.start();
    		
    	}
//    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
//		System.out.println("Auto selected: " + autoSelected);
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
//    	switch(autoSelected) {
//    	case "Under the LowBar":
//    		
//        //Put custom auto code here   
//            break;
//    	case defaultAuto:
//    	default:
//    	//Put default auto code here
//            break;
//    	}
    	Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    	bot.drive.tankDrive(-driverL.getRawAxis(1), driverR.getRawAxis(1));

    	bot.intake.runIntake(operator.getRawAxis(1));
    	bot.shooter.setShooter(operator.getRawAxis(5));
    	//bot.intake.setIntake(operator.getRawAxis(3));
    	if(operator.getPOV() == 0){
    		bot.intake.setIntake(-1.0);
    	}else if(operator.getPOV() == 180){
    		bot.intake.setIntake(1.0);
    	}else{
    		bot.intake.setIntake(0.0);
    	}
    	
  
    	if(operator.getRawButton(5)){
    		bot.manipulator.setManipulator(-0.5);
    	}else{
    		bot.manipulator.setManipulator(0.0);
    	}
//    	if (operator.getRawButton(7)){
//    		bot.manipulator.setManipulator(0.5);
//    	}else{
//    		bot.manipulator.setManipulator(0.0);
//    	}
    	while (operator.getRawButton(6)){
    		bot.manipulator.setManipulator(0.5);
    	}
//    	Just commented out 1/26 uncomment later when restoring Harambe
//    	if(operator.getRawButton(4)){
//    		bot.shooterpivot.setShooterPivotValue(0.5);
//    	}else if(operator.getRawButton(1)){
//    		bot.shooterpivot.setShooterPivotValue(-0.5);
//    	}else {
//    		bot.shooterpivot.setShooterPivotValue(0.0);
//    	}
    	//ShooterActuator
    	
 
    	if(operator.getRawButton(3)){
    		bot.shooteractuator.setShoot(true);
    	}else {
    		bot.shooteractuator.setShoot(false);
    	}
    	
    	if(operator.getRawButton(2)){
    		ahrs.reset();
    		bot.rightenc.reset();
    		bot.manipulator.setManipulator(-0.5);
    	}else if(operator.getRawButton(1)){
    		bot.manipulator.setManipulator(0.5);
    	}else {
    		bot.manipulator.setManipulator(0.0);
    	}
    	
    	angle = ahrs.getAngle();
    	
    	double count = bot.rightenc.get();
    	//Self-straightening Drive
//    	double leftpow = -0.2 + angle * 0.05;
//    	double rightpow = -0.2 - angle * 0.05;
//    	System.out.println("Left power:" + leftpow);
//    	System.out.println("Right power:" + rightpow);
    	
//    	System.out.print("Count :" + count);
//    	if(operator.getRawButton(10)){
//    		bot.drive.tankDrive(leftpow, rightpow);
//    	}
    	

//    			if(operator.getRawButton(9)){
//    				bot.drive.tankDrive(turn2,-turn2);
//    			}
    
 
    	

    	//Vision 1/20
//    	double pixyvoltage = pixycam.getVoltage();
//    	double turn2 = (1.65 - pixyvoltage)*0.3;    	
//    	
//    	if(operator.getRawButton(9)){
//    		bot.drive.tankDrive(0.5,0.5);
//    	}else {
//    		bot.drive.tankDrive(0.0,0.0);
//    	}
//    	
//    	if(operator.getRawButton(10)){
//    		bot.drive.tankDrive(-0.5,-0.5);
//    	}else {
//    		bot.drive.tankDrive(0.0,0.0);
//    	}
//    			if(operator.getRawButton(10) && pixyvoltage < 1.65 ){
//    				bot.drive.tankDrive(-turn2,turn2);
//    			}else if (operator.getRawButton(10) && pixyvoltage > 1.65){
//    				bot.drive.tankDrive(turn2,-turn2);
//    			}else {
//    				bot.drive.tankDrive(0.0,0.0);
//    			}
//    			
//    	System.out.println(pixyvoltage);
//    	if(operator.getRawButton(9)){
//    			if(count < 1200){
//    				bot.drive.tankDrive(-0.2,-0.2);
//    			}else{
//    				bot.drive.tankDrive(-turn,turn);
//    			}
    	
    		
    	//Test semi auton
//    	if(operator.getRawButton(9)){
//    		if(angle < targetangle && firststate){
//    			bot.drive.tankDrive(-0.5,0.5);
//    		}
//    		if(angle >= targetangle && firststate){
//    			firststate = false;
//    			secondstate = true;
//    			thirdstate = false;
//    		}
//    		if(secondstate){
//    			new WaitCommand(1000);
//    			firststate = false;
//    			secondstate = false;
//    			thirdstate = true;
//    			targetangle = 0;
//    		}
//    		if(angle > targetangle && thirdstate){
//    			bot.drive.tankDrive(0.5,-0.5);
//    		}
//    		
//    		
//    		
//    	}
    	double leftpow1 = 0.3 + angle * 0.05;
    	double rightpow1 = -0.3 - angle * 0.05;
    	if(operator.getRawButton(9)){
    		if( count < 1351 && firststate){
    			bot.drive.tankDrive(0.3,-0.3);
    		}else {
    			bot.drive.tankDrive(0.0,0.0);
    		}
    	}
    	
    	if(operator.getRawButton(10)){
    		bot.drive.tankDrive(leftpow1,rightpow1);
    	}

    	System.out.println(driverR.getRawAxis(1));
//    	System.out.println(firststate);
//    	System.out.println(secondstate);
//    	System.out.println(thirdstate);
    	
    	
    
//    	bot.rightenc.setMaxPeriod(100);
//    	bot.rightenc.setMinRate(4);
//    	bot.rightenc.setDistancePerPulse(3);
//    	bot.rightenc.setReverseDirection(false);
//    	System.out.println(bot.rightenc.getDistance());
    	
    	//Test code for encoder 1/11
//    	bot.rightenc.setDistancePerPulse(0.0523333333);
    	
//    	if(operator.getRawButton(9) && count < 1350.6){
//    			bot.drive.tankDrive(-1.0,-1.0);
//    		
//    	}
//    	if(operator.getRawButton(10)){
//    		bot.rightenc.reset();
//    	}
//    	
//    	System.out.println(count);
 
    	
    	
    	
    	
    	
    	
    	
    
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
