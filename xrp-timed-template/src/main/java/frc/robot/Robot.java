// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import frc.robot.VexV5Controller;
import edu.wpi.first.wpilibj.Encoder;


public class Robot extends TimedRobot {
  private XRPMotor leftMotor = new XRPMotor(0);
  private XRPMotor rightMotor = new XRPMotor(1);
  // sets the instance variables left and right motor to the corresponding motors
  private Encoder leftEncoder = new Encoder(4,5);
  private Encoder rightEncoder = new Encoder(6,7);
  // encoders track distances via revolutions

  private double wheelDiameter = 2.3622;
  private double trackWidth = 6.1;
  private double pulsesPerRev = 585;
  double circumference = Math.PI * wheelDiameter;
  double distancePerPulse = circumference / pulsesPerRev;
  // can use "getDistancePerPulse" instead

  public void driveForward(double distance) {
    if (((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2 ) > distance) {
      leftMotor.stopMotor();
      rightMotor.stopMotor();
    }
  }
  
  public Robot() {
    rightMotor.setInverted(true);
  }

  @Override
  public void teleopInit()
  {
    // type code in here - runs once
    leftEncoder.setDistancePerPulse(distancePerPulse);
    rightEncoder.setDistancePerPulse(distancePerPulse);
    // sets distance per pulse (tick) to the given value for distancePerPulse
    
    leftEncoder.reset();
    rightEncoder.reset();
    // reset it so distance doesn't save between on/off periods
  }

  @Override
  public void teleopPeriodic()
  {
    leftMotor.set(.5);
    rightMotor.set(.5);

    if (((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2 ) > 10) {
      leftMotor.stopMotor();
      // rightMotor.stopMotor();



      
    }
  }








  /* // Optional robot methods - uncomment to use
  @Override
  public void robotPeriodic() {}
  @Override
  public void autonomousInit() {}
  @Override
  public void autonomousPeriodic() {}
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {}
  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}
  */

  }