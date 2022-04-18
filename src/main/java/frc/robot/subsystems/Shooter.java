// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {

   //change this boolean to 'false' to turn off safe mode
   //change this boolean to 'true' to turn on safe mode
   public static boolean safeMode = false;
	
	//These are the launcher victors, named left for left wheel and right for right wheel
    public static VictorSP left = new VictorSP(RobotMap.LEFT_SHOOTER);
    public static VictorSP right = new VictorSP(RobotMap.RIGHT_SHOOTER);


  /** Creates a new Shooter. */
  public Shooter() { 
      left.setInverted(true);
  }

    public static void setSpeed (double speed) {
        left.set(speed);
        right.set(speed);
    }

    public static void zeroSpeed () {
        left.set(0);
        right.set(0);
    }

    public static double getLeftSpeed () {
    	return left.get();
    }
    
    public static double getRightSpeed() {
    	return right.get();
    }

    //This puts the speed variable on the SmartDashboard and it is run in Robot under "update"
    public void update() {
    	SmartDashboard.putNumber("Left Speed", getLeftSpeed());
        SmartDashboard.putNumber("Right Speed", getRightSpeed());
        SmartDashboard.putBoolean("Safe Mode", safeMode);
    }
}
