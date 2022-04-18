/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//wow a cool place to hold global CONSANTS
//if you're trying to change one of these somewhere else... no

public class Global {
    //joystick deadzone (probably needs to be reset)
    public static final double DEADZONE = 0.17;
    public static final double THRESHOLD = 0.5;

    //code for button ports
    public static final int JoystickDrive = 0;
    public static final int JoystickAux= 1;
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int SELECT = 7;
    public static final int START = 8;
    
    //PID Values for Going Straight First
    public static final double DRIVETRAIN_P = 0.011;
    public static final double DRIVETRAIN_I = 0.00065;
    public static final double DRIVETRAIN_D = 0;

    //PID Values for first value of angles, used whenever we have anglePID to keep robot straight
    public static final double DRIVESTRAIGHT_ANGLE_P = 0.02;
    public static final double DRIVESTRAIGHT_ANGLE_I = 0;
    public static final double DRIVESTRAIGHT_ANGLE_D = 0;

    //PID values for barrels bath
    public static final double BARRELS_P = 0.017;
    public static final double BARRELS_I = 0;
    public static final double BARRELS_D = 0;

    //how far we can be from setpoint before we stop going towards it
    //"close enough"
    public static final int DRIVE_DISTANCE_TOLERANCE = 5;

    //same thing as drive distance but for angle degrees not driving distance
    public static final int DRIVE_ANGLE_TOLERANCE = 3;

    //PID values for turn
    public static final double TURNANGLE_P = 0.0062;
    public static final double TURNANGLE_I = 0;
    public static final double TURNANGLE_D = 0;
    public static final double TURNANGLE_IZONE = 0;

    //PID Values for Track
    public static final double TRACK_P = 0.01;
    public static final double TRACK_I = 0;
    public static final double TRACK_D = 0;
    public static final int DRIVE_TRACK_TOLERANCE = 0;

    //PID Values for Hook 
    public static final double HOOK_P = 0.001;
    public static final double HOOK_TOLERANCE = 1;

    //Spinner
    public static final double SPINNER_ROTATION = -100;
    
    }
        
