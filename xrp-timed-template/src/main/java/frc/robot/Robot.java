// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

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
  private Encoder Leftencoder = new Encoder(6,7);
  private Encoder Rightencoder = new Encoder(4,5);

  double wheeldiameter = 2.3622;
  double trackwidth = 6.1;
  double pulsePerRev = 585;

  double circumference = Math.PI * wheeldiameter;
  double distPerPulse = circumference/pulsePerRev;


  public Robot() {
    RightMotor.setInverted(true);
    Leftencoder.setDistancePerPulse(distPerPulse);
    Rightencoder.setDistancePerPulse(distPerPulse);
  }

  @Override
  public void teleopInit()
  {
   Leftencoder.reset();
   Rightencoder.reset();
    // type code in here - runs once
  }

  public void drivedistance(double drivedistance) {
    if ((Leftencoder.getDistance() + Rightencoder.getDistance()) / 2 <= drivedistance) {
      LeftMotor.set(0.5);
      RightMotor.set(0.5);
    }else {
      LeftMotor.set(0);
      RightMotor.set(0);
    }
  }

  @Override
  public void teleopPeriodic() {
  drivedistance(10);

    // type code in here - runs forever
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
