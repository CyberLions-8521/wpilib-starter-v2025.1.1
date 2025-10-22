// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

/** Add your docs here. */
public class VexV5Controller {

    private GenericHID m_controller;

    public VexV5Controller(int port) {
        m_controller = new GenericHID(port);
    }

    public double getLeftX() {
        return m_controller.getRawAxis(0);
    }
    
    public double getLeftY() {
        return m_controller.getRawAxis(1);
    }
      
    public double getRightX() {
        return m_controller.getRawAxis(2);
    }
    
    public double getRightY() {
        return m_controller.getRawAxis(3);
    }
    
    public boolean getButtonA() {
        return m_controller.getRawButton(2);
    }
    
    public boolean getButtonB() {
        return m_controller.getRawButton(1);
    }
    
    public boolean getButtonX() {
        return m_controller.getRawButton(4);
    }
    
    public boolean getButtonY() {
        return m_controller.getRawButton(3);
    }
}
