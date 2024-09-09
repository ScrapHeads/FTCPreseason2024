package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;

public class moveArm extends CommandBase {
        private final double power;
        private final Arm arm;

        public moveArm(Arm arm, double power) {
            this.power = power;
            this.arm = arm;

        }

        @Override
        public void initialize(){
                arm.moveArm(power);
        }

        @Override
        public void end(boolean isInterrupted) {
                arm.moveArm(0);
        }
}
