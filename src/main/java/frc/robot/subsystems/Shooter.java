
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

//i have no idea what im doing

public class Shooter extends SubsystemBase {
    //assigns a can id or smthg idk
    private static final String kCANBus = "canivore";

    // left and right motor launchers
   private final TalonFX m_leftLauncher = new TalonFX(0, kCANBus);
   private final TalonFX m_rightLauncher = new TalonFX(1, kCANBus);

   public Shooter() {
    m_leftLauncher.setInverted(true);
    m_rightLauncher.setInverted(false);

   }

}