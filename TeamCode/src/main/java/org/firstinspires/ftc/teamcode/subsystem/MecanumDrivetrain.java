package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

public class MecanumDrivetrain {

    // Motors
    public DcMotor frontLeftMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backRightMotor = null;

    // Constants
    public static final double STRAFING_SENSIBILITY = 1.5;

    // Constructor
    public MecanumDrivetrain() {

    }

    public void init(HardwareMap hwMap) {
        /*
         * Motors
         * */

        this.frontLeftMotor = hwMap.get(DcMotor.class, "frontLeftMotor");
        this.backLeftMotor = hwMap.get(DcMotor.class, "backLeftMotor");
        this.frontRightMotor = hwMap.get(DcMotor.class, "frontRightMotor");
        this.backRightMotor = hwMap.get(DcMotor.class, "backRightMotor");

    }

}
