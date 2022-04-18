/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Global;
//import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command. You can replace me with your own command.
 */
public class TankDrive extends CommandBase {

  private final DriveTrain m_drivetrain;

  public TankDrive(DriveTrain drivetrain) {
    // Uses add requirements to bring the subsystem in
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
    // System.out.print("hello tank drive");

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // sets wheelspeed to 0 when the robot turns on
    // m_drivetrain.Wheelspeed(0.0005, 0.0005);
    m_drivetrain.setTeleop();

  }

  // Called repeatedly when this Command is scheduled to run

  // AHAHAHAHAHA
  // This make it go forward good, but if you try to go backwards its opposits
  // since you are just subtracting its fine when both values are same sign for
  // forward
  // but making go backward they cancell out
  // fix it later maybe
  // yup
  // luv u <3
  @Override
  public void execute() {

    double amountGoR = RobotContainer.driveCont.getRawAxis(5);
    double amountGoL = RobotContainer.driveCont.getRawAxis(1);
    double leftGo;
    double rightGo;

    double fastValue = (RobotContainer.driveCont.getRawAxis(Constants.GO_FAST_AXIS) / 2);

    if (Math.abs(amountGoR) >= Global.DEADZONE) {
      rightGo = amountGoR;
    } else {
      rightGo = 0.0005;
    }

    if (Math.abs(amountGoL) >= Global.DEADZONE) {
      leftGo = amountGoL;
    } else {
      leftGo = 0.0005;
    }

    m_drivetrain.Wheelspeed(0.5 * leftGo - fastValue * -Math.signum(amountGoL),
        0.5 * rightGo +  fastValue * Math.signum(amountGoR));

    // // sets wheelspeed when joysticks are moved forward/backward/up/down
    // if (Math.abs(amountGoR) <= Global.DEADZONE
    // && Math.abs(amountGoL) <= Global.DEADZONE) {
    // //m_drivetrain.Wheelspeed(0.0005, 0.0005);
    // m_drivetrain.Wheelspeed(0, 0);
    // } else if (Math.abs(amountGoL) <= Global.DEADZONE
    // && Math.abs(amountGoR) > Global.DEADZONE) {
    // m_drivetrain.Wheelspeed(-0.01, 0.5*amountGoR
    // - (RobotContainer.driveCont.getRawAxis(3)/2)*-Math.signum(amountGoR));
    // } else if (Math.abs(amountGoL) > Global.DEADZONE
    // && Math.abs(amountGoR) <= Global.DEADZONE) {
    // m_drivetrain.Wheelspeed(0.5*amountGoL
    // -(RobotContainer.driveCont.getRawAxis(3)/2)*-Math.signum(amountGoR),-0.01);

    // } else {
    // //this should still work, has to negative for some reason?
    // m_drivetrain.Wheelspeed(0.5*amountGoL -
    // (RobotContainer.driveCont.getRawAxis(3)/2)*-Math.signum(amountGoL),
    // 0.5*amountGoR -
    // (RobotContainer.driveCont.getRawAxis(3)/2)*-Math.signum(amountGoR));
    // }

  }

  /*
   * THIS IS FOR BRAKING IN THE FUTURE // Called repeatedly when this Command is
   * scheduled to run
   * 
   * @Override public void execute() { // sets wheelspeed when joysticks are moved
   * forward/backward/up/down if (Math.abs(RobotContainer.driveCont.getRawAxis(5))
   * <= Global.DEADZONE && Math.abs(RobotContainer.driveCont.getRawAxis(1)) <=
   * Global.DEADZONE) { m_drivetrain.Wheelspeed(0.0005, 0.0005); } else if
   * (Math.abs(RobotContainer.driveCont.getRawAxis(1)) <= Global.DEADZONE &&
   * Math.abs(RobotContainer.driveCont.getRawAxis(5)) > Global.DEADZONE) {
   * m_drivetrain.Wheelspeed(0, 0.5*RobotContainer.driveCont.getRawAxis(5) +
   * (RobotContainer.driveCont.getRawAxis(3)/2)); } else if
   * (Math.abs(RobotContainer.driveCont.getRawAxis(1)) > Global.DEADZONE &&
   * Math.abs(RobotContainer.driveCont.getRawAxis(5)) <= Global.DEADZONE) {
   * m_drivetrain.Wheelspeed(0.5*RobotContainer.driveCont.getRawAxis(1)
   * +(RobotContainer.driveCont.getRawAxis(3)/2), 0); } else { //this should still
   * work, has to negative for some reason?
   * m_drivetrain.Wheelspeed(0.5*RobotContainer.driveCont.getRawAxis(1)+
   * (RobotContainer.driveCont.getRawAxis(3)/2),
   * 0.5*RobotContainer.driveCont.getRawAxis(5) +
   * (RobotContainer.driveCont.getRawAxis(3)/2)); }
   * 
   * }
   */

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // sets wheelspeed to 0 when the robot is turned off
    m_drivetrain.Wheelspeed(0.0005, 0.0005);
    interrupted = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  /*
   * @Override protected void interrupted() { //sets wheelspeed to 0 when the
   * robot is estopped DriveTrain.Wheelspeed(0,0); }
   */
}
