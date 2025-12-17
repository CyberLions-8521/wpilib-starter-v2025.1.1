// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Encoder;

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


public class Robot extends TimedRobot {
private XRPMotor LeftMotor = new XRPMotor(0); 
private XRPMotor RightMotor = new XRPMotor(1); 
private Encoder LeftEncoder = new Encoder(6,7);
private Encoder RightEncoder = new Encoder(4,5);

double WheelDiameter = 2.3622; 
double TrackWith = 6.1;
double PulsePerRev = 585;

double circumference = Math.PI * WheelDiameter;
double DistPerPulse = circumference/PulsePerRev;


  public Robot() {
    LeftEncoder.setDistancePerPulse(DistPerPulse);
    RightEncoder.setDistancePerPulse(DistPerPulse);

    RightMotor.setInverted(true);
  }

  @Override
  public void teleopInit()
  {
    resetEncoders();
    // type code in here - runs once
  }


  //.setInverted(true)
  @Override
  public void teleopPeriodic()
  {
    // LeftEncoder.getDistance();
    // RightEncoder.getDistance();

    if (getAverageDist() <= 10) {
      moveForward();
    }
    else {
      LeftMotor.set(0);
      RightMotor.set(0);
    }

    // LeftMotor.set(0.5);
    // RightMotor.set(-0.5); 


    // if ((LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2 > 10) {
    //   LeftMotor.set(0.5);
    //   RightMotor.set(0);
    // }
    // else {
    //   LeftMotor.set(0);
    //   RightMotor.set(0);
    //   LeftEncoder.reset();
    //   RightEncoder.reset(); 
    // }

    // if ((LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2 <= 10) {
    //   LeftMotor.set(0.5);
    //   RightMotor.set(0.5);
    // }
    // else {
    //   LeftMotor.set(0);
    //   RightMotor.set(0);
    // }


    // type code in here - runs forever
  }

  public void moveForward() {
    LeftMotor.set(0.5);
    RightMotor.set(0.5);
  }

  public double getAverageDist() {
    return (LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2;
  }

  public void resetEncoders() {
    LeftEncoder.reset();
    RightEncoder.reset(); 
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
