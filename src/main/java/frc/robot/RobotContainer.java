/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import org.graalvm.compiler.lir.profiling.MoveProfilingPhase_OptionDescriptors;

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

//import frc.robot.commands.Shoot;

//import frc.robot.commands.Shooting;

import frc.robot.commands.TankDrive;

//**********************AFJSLIFUHALEIFUHAELIFUHLIEFHMOODUNCOMMENTME

//import frc.robot.commands.ZeroSpeed;
//**********************AFJSLIFUHALEIFUHAELIFUHLIEFHMOODREVIVEME

//import frc.robot.commands.Zoom;

//**********************AFJSLIFUHALEIFUHAELIFUHLIEFHMOOD
//import frc.robot.commands.CycleSpeed;
//**********************AFJSLIFUHALEIFUHAELIFUHLIEFHMOOD

//import frc.robot.commands.UnwindLift;
//import frc.robot.commands.FlapManual;
//import frc.robot.commands.FullSpeedAhead;

//import frc.robot.commands.Loadnoodle;

//import frc.robot.commands.DeployHook;
//import frc.robot.subsystems.ControlSpinner;
//import frc.robot.subsystems.ConveyorMotors;
import frc.robot.subsystems.DriveTrain;
//import frc.robot.subsystems.Flap;
//import frc.robot.subsystems.Hook;
//import frc.robot.subsystems.HookPneumatic;
//import frc.robot.subsystems.Lift;
//import frc.robot.subsystems.Limelight;
//import frc.robot.subsystems.RelayCompressor;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;


// import frc.robot.subsystems.Launcher;
// import frc.robot.subsystems.Slowmotor;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
 //(connects code to buttons so we can make it do stuff)

public class RobotContainer {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  // joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);  --find port number from driver station?
  // Button button = new JoystickButton(stick, buttonNumber);

  //creates the joysick in the code
  
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //this is what lets us select the autopaths

  //Changed to public static final to be able to use them across the board and in auto
  //If commands do not work b/c of this, make it private final and figure out how to 
  //pass the subsystem to the auto commands
  
  //public final ConveyorMotors conveyorMotors = new ConveyorMotors();'
  //private final Hook hook = new Hook(); 
  //private final Lift lift = new Lift();
  //private final Flap flap = new Flap();
  //public ControlSpinner controlSpinner = new ControlSpinner();
  //private final RelayCompressor relayCompressor = new RelayCompressor();
  //private final HookPneumatic hookPneumatic = new HookPneumatic();
  //private final Limelight limeLight = new Limelight();
  //private final ticks ticks = new ticks(0);

  public final DriveTrain driveTrain = new DriveTrain();
  public final TankDrive TankDrive = new TankDrive(driveTrain); //tankdrive controls driving in teleop

  //the commands that run aux things

  //SUSAN
  //public final Launcher launcher = new Launcher();
  public final Loader loader = new Loader();
  //public final Load loadNoodle = new Load(loader, 0);
  
  public final Shooter shooter = new Shooter();
  public final SetShooterSpeed shootZero = new SetShooterSpeed(shooter, 0);
  public final SetShooterSpeed shootSlow = new SetShooterSpeed(shooter, .33);
  public final SetShooterSpeed shootMedium = new SetShooterSpeed(shooter, .67);
  public final SetShooterSpeed shootFast = new SetShooterSpeed(shooter, 1);

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  
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
  public static Joystick driveCont = new Joystick(Global.JoystickDrive);
  public static Joystick auxCont = new Joystick(Global.JoystickAux);

  public static Button rightBumper = new JoystickButton(driveCont, Global.RIGHT_BUMPER);
  public static Button leftBumper = new JoystickButton(driveCont, Global.LEFT_BUMPER);
  public static Button buttonA = new JoystickButton(driveCont, Global.BUTTON_A);
  public static Button buttonY = new JoystickButton (driveCont, Global.BUTTON_Y);
  public static Button buttonB = new JoystickButton(driveCont, Global.BUTTON_B);
  public static Button buttonX = new JoystickButton(driveCont, Global.BUTTON_X);
  public static Button start = new JoystickButton(auxCont, Global.START);
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


    //susan aux
    // loader.setDefaultCommand(new Load(loader));
    shooter.setDefaultCommand(shootZero);
    
    //puts the thing (m_chooser ig) that lets us choose which auto path to run
    SmartDashboard.putData("Auto mode", m_chooser);
   // m_chooser.setDefaultOption("Nothing", new NothingTest()); //defaults to select nothing path...
    //addOptions adds another choosey-button thing on the dashboard
    //takes in the ("text label thing", new commandYouWantItToRun)

    
    //m_chooser.addOption("Test", m_testing);
    
    
    SmartDashboard.putData("Auto Mode", m_chooser);

  }
  
  //sets the buttons to run specific commands when they are held/pressed
  private void configureButtonBindings(){

    //SUSAN

    // rightBumper.whileHeld(new Loadnoodle(.4));
		// rightBumper.whenReleased(new Loadnoodle(0));

		// leftBumper.whenPressed(new CycleSpeed(true));
		// leftBumper.whenReleased(new CycleSpeed(false));

		// buttonA.whileHeld(new Shoot());
		// buttonA.whenReleased(new ZeroSpeed());


    // Y on 2nd driver controller moves hook arm up
    //auxButtonY.whileHeld(new HookManual(0.6, hook));
    // A on 2nd driver controller moves hook arm down
    //auxButtonA.whileHeld(new HookManual(-0.55, hook));
    // B on 2nd driver controller moves the wench and lifts the robot
    //auxButtonB.whileHeld(new LiftManual(1, lift));
    // X on 2nd driver controller deploys the flap
    //auxButtonX.whileHeld(new FlapManual(flap, false, false));
    // Right Bumper on 2nd driver controller moves the control spinner wheel
    //auxRightBumper.whileHeld(new ControlSpinnerManual(controlSpinner, 1));
    // Left Bumper on 2nd driver controller unwinds the wench
    //auxLeftBumper.whileHeld(new UnwindLift(lift, 1));
    // Right Trigger on 1st driver controller makes robot go vroom vroom

    //rightTrigger.whileHeld(new FullSpeedAhead(driveTrain));
    //rightTrigger.whileHeld(new Zoom(driveTrain));



    // Right Trigger on 2nd driver controller deploys the hook pneumatic
    //auxRightTrigger.whileHeld(new DeployHook(hookPneumatic, true));
  }
  
  //connects the chooser for autopaths on the dashboard to the actual code
  //called in robot
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  }



