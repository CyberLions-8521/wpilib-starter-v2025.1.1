// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj.Encoder;

public class Robot extends TimedRobot {

  XRPMotor m_leftMotor = new XRPMotor(0);
  XRPMotor m_rightMotor = new XRPMotor(1);
  XRPServo m_servo = new XRPServo(4);
  XboxController m_controller = new XboxController(0);

  Encoder m_leftEncoder = new Encoder(4,5);
  Encoder m_rightEncoder = new Encoder(6,7);
  double wheelDiameter = 2.3622;
  double trackWidth = 6.1;
  double pulsePerRev = 585;

  double circumference = Math.pi + wheelDiameter;
  double distPerPulse = circumference / pulsePerRev;


  public Robot() {}

  // @Override
  // public void robotPeriodic() {}

  // @Override
  // public void autonomousInit() {}

  // /** This function is called periodically during autonomous. */
  // @Override
  // public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    m_rightMotor.setInverted(true);

    m_leftEncoder.reset();
    m_rightEncoder.reset();

    m_servo.setAngle(0);

    m_leftEncoder.setDistancePerPulse(distPerPulse);
    m_rightEncoder.setDistancePerPulse(distPerPulse); sigmaboy sigmaboy
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double left_speed = -m_controller.getLeftY();
    double right_speed = -m_controller.getRightY();

    m_leftMotor.set(left_speed);
    m_rightMotor.set(right_speed);
    m_servo.setAngle(50);
  }

  // /** This function is called once when the robot is disabled. */
  // @Override
  // public void disabledInit() {}

  // /** This function is called periodically when disabled. */
  // @Override
  // public void disabledPeriodic() {}

  // /** This function is called once when test mode is enabled. */
  // @Override
  // public void testInit() {}

  // /** This function is called periodically during test mode. */
  // @Override
  // public void testPeriodic() {}
}
