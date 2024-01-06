package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import java.lang.Double.max
import kotlin.math.abs

open class Hardware(private var opMode: LinearOpMode) {

    //declare global objects
    private var myOpMode: LinearOpMode = opMode
    private var frontLeftMotor: DcMotor
    private var backLeftMotor: DcMotor
    private var frontRightMotor: DcMotor
    private var backRightMotor: DcMotor

    init {
        myOpMode = opMode
        //initialize motors
        frontLeftMotor = myOpMode.hardwareMap.dcMotor.get("left_drive")
        backLeftMotor = myOpMode.hardwareMap.dcMotor.get("backLeftMotor")
        frontRightMotor = myOpMode.hardwareMap.dcMotor.get("right_drive")
        backRightMotor = myOpMode.hardwareMap.dcMotor.get("backRightMotor")

        //reverse as needed (this may need to be the left wheels rather than the right)
        frontRightMotor.direction = (DcMotorSimple.Direction.REVERSE)
        backRightMotor.direction = (DcMotorSimple.Direction.REVERSE)

        //update telemetry
        val message = "Hardware Initialized"
        myOpMode.telemetry.addData(">", message)
        myOpMode.telemetry.update()
    }

    fun driveRobot(drive: Double, strafe: Double, turn: Double) {
        val drivescale = max(abs(drive) + abs(strafe) + abs(turn), 1.0) //scale down if needed
        //omnidirectional wheel math
        val flp = (drive - strafe - turn) / drivescale
        val frp = (drive + strafe + turn) / drivescale
        val blp = (drive + strafe + turn) / drivescale
        val brp = (drive - strafe - turn) / drivescale

        //send values to motors
        frontLeftMotor.power = flp
        frontRightMotor.power = frp
        backLeftMotor.power = blp
        backRightMotor.power = brp

        //update telemetry
        myOpMode.telemetry.addData("Drive", drive)
        myOpMode.telemetry.addData("Strafe", strafe)
        myOpMode.telemetry.addData("Turn", turn)
        myOpMode.telemetry.update()
    }

    /**create two arm functions??
    one for opmode, one for teleop?
    *op mode arm function has multiple heights?*/
}

