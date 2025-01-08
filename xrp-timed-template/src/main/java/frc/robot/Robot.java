// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.xrp.XRPMotor;


public class Robot extends TimedRobot {
  private XRPMotor m_left = new XRPMotor(0);
  private XRPMotor m_right = new XRPMotor(1);
  private XboxController controller = new XboxController(0);


  public Robot() {}


  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    m_right.setInverted(true);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    /* WHY THE CONTROLLER STICKS ARE INVERTED
    When viewed with each positive axis pointing toward you, counter-clockwise (CCW) is a positive value and clockwise (CW) is a negative value.
    Because the controller is pointed away from you, the opposite is true.
    Shifting the joystick forward is a counterclockwise turn with respect to the Y axis, so a negative value is returned.
    Making the sticks negative are so up is up and down is down.
    https://docs.wpilib.org/en/stable/docs/software/basic-programming/coordinate-system.html
    */

    double left_stick = -controller.getLeftY();
    double right_stick = -controller.getRightY();

    m_left.set(left_stick);
    m_right.set(right_stick);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
