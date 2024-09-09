package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;

public class moveClaw extends CommandBase {
    private final double pos;
    private final Claw claw;

    public moveClaw(Claw claw, double pos) {
        this.claw = claw;
        this.pos = pos;
    }
    @Override
    public void initialize(){
        claw.moveClaw(pos);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
