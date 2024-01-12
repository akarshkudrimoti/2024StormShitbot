package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TankDrive extends SubsystemBase{

    // Define Talon SRX motor controllers
    //change this to wpilib shit
    private TalonSRX frontLeftMotor = new TalonSRX(RobotMap.DRIVE_LEFT_MASTER);
    frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

    private TalonSRX rearLeftMotor = new TalonSRX(RobotMap.DRIVE_LEFT_FOLLOW);
    rearLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    this.rearLeftMotor.set(ControlMode.Follower, RobotMap.DRIVE_LEFT_MASTER);


    private TalonSRX frontRightMotor = new TalonSRX(RobotMap.DRIVE_RIGHT_MASTER);
    frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

    private TalonSRX rearRightMotor = new TalonSRX(RobotMap.DRIVE_RIGHT_FOLLOW);
    rearRightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    this.rearRightMotor.set(ControlMode.Follower, RobotMap.DRIVE_LEFT_MASTER);


    rearLeftMotor.follow(frontLeftMotor);
    rearLeftMotor.follow(frontRightMotor);


    // Create DifferentialDrive instanc

    // Constructor
    public TankDrive() {
        // Set up any additional configuration if needed
    }

    // Method to drive the robot with tank drive
    public void tankDrive(double leftSpeed, double rightSpeed) {
        .tankDrive(leftSpeed, rightSpeed);
    }

    // Additional methods or configuration as needed
}




    
}

    


