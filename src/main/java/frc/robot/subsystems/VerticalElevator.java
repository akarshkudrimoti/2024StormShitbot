package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalElevator extends SubsystemBase {

    public CANSparkMax master;
    public CANSparkMax slave;
    RelativeEncoder encoder;

    SparkMaxPIDController pidController;

    public double currentHeight;

    public VerticalElevator() {

        master = new CANSparkMax(Constants.RobotComponents.verticalMaster, MotorType.kBrushless);
        slave = new CANSparkMax(Constants.RobotComponents.verticalSlave, MotorType.kBrushless);

        slave.follow(master, true);

        this.encoder = master.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 8192);

        this.pidController = master.getPIDController();
        pidController.setFeedbackDevice(encoder);

        pidController.setP(Constants.RobotComponents.verticalElevatorPID[0]);
        pidController.setI(Constants.RobotComponents.verticalElevatorPID[1]);
        pidController.setD(Constants.RobotComponents.verticalElevatorPID[2]);
        pidController.setFF(Constants.RobotComponents.verticalElevatorPID[3]);

        this.currentHeight = getCurrentHeight();

        this.encoder.setPositionConversionFactor(1/Constants.RobotComponents.REVS_PER_HEIGHT);

    }

    public double getCurrentHeight() {
        return 0; //TODO: do this
    }

    /**
     * Moves vertical elevator to a specific height (in [units]) //TODO: choose units
     * @param height (in [units])
     * @return error
     */
    public double moveTo(double height) { //TODO: finish this code

        if(height + currentHeight > Constants.RobotComponents.MAX_HEIGHT) {
            height =  Constants.RobotComponents.MAX_HEIGHT;
        } else if(currentHeight - height < Constants.RobotComponents.MIN_HEIGHT) {
            height = Constants.RobotComponents.MIN_HEIGHT;
        }

        pidController.setReference(height, ControlType.kSmartMotion);
        return 0;

    }

    public void moveUp() {
        master.set(1);
    }

    public void moveDown() {
        master.set(-1);
    }
    
}
