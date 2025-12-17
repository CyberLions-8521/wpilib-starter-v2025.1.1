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
  private XRPMotor lmotor = new XRPMotor(0);
  private XRPMotor rmotor = new XRPMotor(1);
  private double speed = 0.5;
  private Encoder leftEncoder = new Encoder(4,5);
  private Encoder rightEncoder = new Encoder(6,7);
  private double wheelDiameter = 2.3622;
  private double trackWidth = 6.1;
  private double pulsesPerRev = 585;
  private double circumference = Math.PI * wheelDiameter;
  private double distancePerPulse = circumference / pulsesPerRev;

  public Robot() {
    rmotor.setInverted(true);
  }
  public void moveFoward(double d) {
    if ( ( (leftEncoder.getDistance() + rightEncoder.getDistance() ) / 2) > d) {
      lmotor.stopMotor();
      rmotor.stopMotor();
  }
  }
  @Override
  public void teleopInit()
  {
    // type code in here - runs once\
    leftEncoder.setDistancePerPulse(distancePerPulse);
    rightEncoder.setDistancePerPulse(distancePerPulse);

    leftEncoder.reset();
    rightEncoder.reset();
  }


  @Override
  public void teleopPeriodic()
  {
    lmotor.set(speed);
    rmotor.set(speed);
    moveFoward(10);
    lmotor.set(speed);
    if (leftEncoder.getDistance() > 20) {
      lmotor.stopMotor();
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
