package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrivetrain {

    // Constants
    public static final double STRAFING_SENSIBILITY = 1.5;

    // Motors
    private DcMotor frontLeftMotor = null;
    private DcMotor backLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor backRightMotor = null;

    // Constructor
    public MecanumDrivetrain() {

    }

    public DcMotor getFrontLeftMotor() {
        return frontLeftMotor;
    }

    public DcMotor getBackLeftMotor() {
        return backLeftMotor;
    }

    public DcMotor getFrontRightMotor() {
        return frontRightMotor;
    }

    public DcMotor getBackRightMotor() {
        return backRightMotor;
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
