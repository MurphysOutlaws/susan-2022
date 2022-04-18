/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  //variables to represent a motor for each wheel
  private final CANSparkMax right_front = new CANSparkMax(RobotMap.right_front_motor, MotorType.kBrushless);
  private final CANSparkMax left_front = new CANSparkMax(RobotMap.left_front_motor, MotorType.kBrushless);
  private final CANSparkMax right_back = new CANSparkMax(RobotMap.right_back_motor, MotorType.kBrushless);
  private final CANSparkMax left_back = new CANSparkMax(RobotMap.left_back_motor, MotorType.kBrushless);

  //variables for each encoder
  private RelativeEncoder m_rightencoder = right_front.getEncoder();
  private RelativeEncoder m_leftencoder = left_front.getEncoder();
  private RelativeEncoder m_rightback = right_back.getEncoder();
  private RelativeEncoder m_leftback = left_back.getEncoder();

  public static AnalogInput sonar = new AnalogInput(0);
 
    public DriveTrain() {
      //when a new drivetrain is created the gyro fused heading is set to 0, encoders are reset
      //and... whatever enterCalibrationMode does
      resetEncoders();
      resetGyro();
    }

  //when called sets into brake mode, resets encoders and fused heading again
  public void setAuto() {
    right_front.setIdleMode(IdleMode.kBrake);
    left_front.setIdleMode(IdleMode.kBrake);
    right_back.setIdleMode(IdleMode.kBrake);
    left_back.setIdleMode(IdleMode.kBrake);
    resetEncoders();
  }

  //when called sets into coast mode, resets encoders and fused heading again
  public void setTeleop(){
    right_front.setIdleMode(IdleMode.kCoast);
    left_front.setIdleMode(IdleMode.kCoast);
    right_back.setIdleMode(IdleMode.kCoast);
    left_back.setIdleMode(IdleMode.kCoast);
    resetEncoders();
  }
   
  // sets wheelspeeds of motors 
  public void Wheelspeed(double leftspeed, double rightspeed){  
    right_front.set(rightspeed);
    left_front.set(-leftspeed);
    right_back.set(rightspeed);
    left_back.set(-leftspeed);
  }
  
  //sets all encoders to 0
  public void resetEncoders(){
    m_rightencoder.setPosition(0);
    m_leftencoder.setPosition(0);
    m_leftback.setPosition(0);
    m_rightback.setPosition(0);

  }
  
  //returns encoder positions
  public double getLeftCanEncoder(){
     return m_leftencoder.getPosition();
  }
  public double getRightCanEncoder(){
    return -m_rightencoder.getPosition();
  }
  public double getRightBackEncoder(){
    return -m_rightback.getPosition();
  }
  public double getLeftBackEncoder(){
    return m_leftback.getPosition();
  }

  //sets fused heading and yaw to 0
  public void resetGyro(){
    //gyro.setFusedHeading(0);
    //gyro.setYaw(0);
  }


  //updates smartdashboard values, does this periodically
  public void update(){
    SmartDashboard.putNumber("Left Encoder", m_leftencoder.getPosition());
    SmartDashboard.putNumber("Right Encoder", m_rightencoder.getPosition());
    SmartDashboard.putNumber("Right Back Encoder", m_rightback.getPosition());
    SmartDashboard.putNumber("Left Back Encoder", m_leftback.getPosition());
    SmartDashboard.putNumber("Right Joystick Y", RobotContainer.driveCont.getRawAxis(5));
    SmartDashboard.putNumber("Left Joystick Y", RobotContainer.driveCont.getRawAxis(1));
    SmartDashboard.putNumber("Trigger", RobotContainer.driveCont.getRawAxis(3));
  }
  
  public void initDefaultCommand(){
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public static double getSonar(){
    return sonar.getAverageVoltage();
  }
     
}
