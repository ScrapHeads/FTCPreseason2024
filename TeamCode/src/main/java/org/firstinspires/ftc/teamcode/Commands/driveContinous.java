package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class driveContinous extends CommandBase {
    private final Drivetrain drivetrain;
    private final GamepadEx driver;
    Telemetry telemetry;

    public driveContinous(Drivetrain drivetrain, GamepadEx driver) {
        this.drivetrain = drivetrain;
        this.driver = driver;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        drivetrain.drive(driver.getLeftY(), driver.getLeftX(), driver.getRightX());
    }

    @Override
    public void end(boolean isInterrupted){
        drivetrain.drive(0,0, 0);
    }

    @Override
    public boolean isFinished(){
     return false;
    }

}
