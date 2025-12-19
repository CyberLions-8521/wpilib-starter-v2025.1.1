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

  double speed = 0.5; 

  double circumference = Math.PI * WheelDiameter;
  double DistPerPulse = circumference/PulsePerRev;


  public Robot() {
    LeftEncoder.setDistancePerPulse(DistPerPulse);
    RightEncoder.setDistancePerPulse(DistPerPulse);

    RightMotor.setInverted(true);
  }

  // driving a certain distance
  public void driveDist(double d) {
    if (getAverageDist() <= d) {
      moveForward();
    }
    else {
      LeftMotor.set(0);
      RightMotor.set(0);
    }
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
    driveDist(20); 
    resetEncoders();
    turn(20);
  }

  // turn d distance
  public void turn(double d) {
    if (getAverageDist() <= 10) {
      LeftMotor.set(0.5);
      RightMotor.set(-0.5);
    }
    else {
      stopMoving();
    }
    }

  // motors start moving
  public void moveForward() {
    LeftMotor.set(0.5);
    RightMotor.set(0.5);
  }

  // motors stop moving
  public void stopMoving() {
    LeftMotor.set(0);
    RightMotor.set(0);
  }

  // get the average distance/total distance 
  public double getAverageDist() {
    return (LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2;
  }

  // reset the Encoders
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
