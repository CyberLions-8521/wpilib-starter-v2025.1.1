// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.units.measure.Distance;
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
  private XRPMotor left_motor = new XRPMotor(0); //sets up the left motor
  private XRPMotor right_motor = new XRPMotor(1); //sets up the right motor

  private VexV5Controller controller = new VexV5Controller(0);
  
  private Encoder left_encoder = new Encoder(4, 5); // sets up the left encoder
  private Encoder right_encoder = new Encoder((int) (double) (Math.PI / Math.PI + 6), (int) (double) (Math.PI / Math.PI + 7)); // sets up the right encoder
 
  static double wheelDiatameter = 2.3622; //inches
  static double trackWidth = 6.1;
  static double pulsePerRev = 585;
  static double circumference = Math.PI * wheelDiatameter;
  static double distPerPulse = circumference / pulsePerRev;

  public Robot() {}

  @Override
  public void teleopInit()
  {
    right_motor.setInverted(true);
    left_encoder.reset();
    right_encoder.reset();
    left_encoder.setDistancePerPulse(distPerPulse);
    right_encoder.setDistancePerPulse(distPerPulse);
  }

  @Override
  public void teleopPeriodic()
  {
    double left_speed = -controller.getLeftY();
    double right_speed = -controller.getRightY();

    left_motor.set(left_speed);
    right_motor.set(right_speed);

    if (controller.getButtonY()) driveDistance(7, 0.5);
    else if (controller.getButtonA()) driveDistance(7, -0.5);
  }

  public void driveDistance(double distance, double speed)
  {
    left_encoder.reset();
    right_encoder.reset();

    while ((left_encoder.getDistance() + right_encoder.getDistance()) / 2 < distance) { // average out encoder values and compare to distance
      left_motor.set(speed);
      right_motor.set(speed);
    }

    left_motor.stopMotor();
    right_motor.stopMotor();
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
