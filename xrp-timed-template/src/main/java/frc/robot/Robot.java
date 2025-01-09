// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.xrp.XRPMotor;


public class Robot extends TimedRobot {
  private XRPMotor mLeft = new XRPMotor(0);
  private XRPMotor mRight = new XRPMotor(1);
  private XboxController controller = new XBoxController(0);

  public Robot() {

  }

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
    // mLeft.setInverted(true);
    mRight.setInverted(true);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //sets speed based on XBOX controller
    mLeft.set(-controller.getLeftY());
    mRight.set(-controller.getRightY()); 
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
