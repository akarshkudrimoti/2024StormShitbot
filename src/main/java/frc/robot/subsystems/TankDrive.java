package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase{

    // Define Talon SRX motor controllers
    //change this to wpilib shit
    // Define Talon SRX motor controllers
    private TalonSRX frontLeftMotor = new TalonSRX(0);
    private TalonSRX rearLeftMotor = new TalonSRX(1);
    private TalonSRX frontRightMotor = new TalonSRX(2);
    private TalonSRX rearRightMotor = new TalonSRX(3);



    // Create DifferentialDrive instanc

    // Constructor
    public TankDrive() {
        // Set up any additional configuration if needed
        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(true);

        this.rearLeftMotor.follow(frontLeftMotor);
        this.rearRightMotor.follow(frontRightMotor);
    }

    // Method to drive the robot with tank drive
    public void tankDrive(double leftSpeed, double rightSpeed) {
        frontLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
        frontRightMotor.set(ControlMode.PercentOutput, rightSpeed);
    }

    // Additional methods or configuration as needed
}


    


