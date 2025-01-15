// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  public Drivebase(int leftID, int rightID) {
    XRPMotor m_left = new XRPMotor(leftID);
    XRPMotor m_right = new XRPMotor(rightID);
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  void arcadeDrive(double fwd, double turn){
    m_drive.arcadeDrive(fwd, turn);
  }
}
