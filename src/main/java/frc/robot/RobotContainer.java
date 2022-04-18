/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Load;
import frc.robot.commands.SetShooterSpeed;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
 //(connects code to buttons so we can make it do stuff)

public class RobotContainer {

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //this is what lets us select the autopaths

  public final DriveTrain driveTrain = new DriveTrain();
  public final TankDrive TankDrive = new TankDrive(driveTrain); //tankdrive controls driving in teleop

  //the commands that run aux things
  public final Loader loader = new Loader();
  
  public final Shooter shooter = new Shooter();
  public final SetShooterSpeed shootZero = new SetShooterSpeed(shooter, 0);
  public final SetShooterSpeed shootSlow = new SetShooterSpeed(shooter, .33);
  public final SetShooterSpeed shootMedium = new SetShooterSpeed(shooter, .67);
  public final SetShooterSpeed shootFast = new SetShooterSpeed(shooter, 1);
  
  //:O I think these are the 3 things
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  //joystick used for the... joysticks... on the controller
  //each of these is one of the controllers
  public static Joystick driveCont = new Joystick(Constants.JoystickDrive);
  public static Joystick auxCont = new Joystick(Constants.JoystickAux);

  public static Button rightBumper = new JoystickButton(driveCont, Constants.RIGHT_BUMPER);
  public static Button leftBumper = new JoystickButton(driveCont, Constants.LEFT_BUMPER);
  public static Button buttonA = new JoystickButton(driveCont, Constants.BUTTON_A);
  public static Button buttonY = new JoystickButton (driveCont, Constants.BUTTON_Y);
  public static Button buttonB = new JoystickButton(driveCont, Constants.BUTTON_B);
  public static Button buttonX = new JoystickButton(driveCont, Constants.BUTTON_X);
  public static Button start = new JoystickButton(auxCont, Constants.START);
  public static JoystickButton rightTrigger = new JoystickButton(driveCont, 3);
  public static JoystickButton leftTrigger = new JoystickButton(driveCont, 2);

  public RobotContainer () {
    this.configureButtonBindings(); //connects the buttons to the commands so they know when to run
   
    rightTrigger.whileHeld(new Load(loader));
    buttonA.whenPressed(shootZero);
    buttonB.whenPressed(shootSlow);
    buttonY.whenPressed(shootMedium);
    buttonX.whenPressed(shootFast);


    //sets the default commands (what the subsystems should be doing when they start)
    //I actually don't get what this is doing so... that's just a guess
    //they say "initializes" but? wouldn't it initialize whenever you call it why the setDefaultCommand thing
    //maybe I'm just confuzzled

    //initializes TankDrive
    // when teleop uncomment this
    driveTrain.setDefaultCommand(TankDrive);
    shooter.setDefaultCommand(shootZero);
    //puts the thing (m_chooser ig) that lets us choose which auto path to run
    SmartDashboard.putData("Auto mode", m_chooser);
  }
  
  //sets the buttons to run specific commands when they are held/pressed
  private void configureButtonBindings(){

  }
  
  //connects the chooser for autopaths on the dashboard to the actual code
  //called in robot
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  }



