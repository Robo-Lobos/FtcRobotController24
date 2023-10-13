package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry
import java.lang.Double.max
import kotlin.math.abs

open class Hardware() {

    //declare global objects
    //private var myOpMode: LinearOpMode? = null
    var frontLeftMotor: DcMotor? = null
    var backLeftMotor: DcMotor? = null
    var frontRightMotor: DcMotor? = null
    var backRightMotor: DcMotor? = null

    // Define and Initialize Motors (note: need to use reference to actual OpMode).

    fun init() {
        //initialize motors
        var frontLeftMotor: DcMotor = hardwareMap.dcMotor.get("left_drive")
        var backLeftMotor: DcMotor = hardwareMap.dcMotor.get("backLeftMotor")
        var frontRightMotor: DcMotor = hardwareMap.dcMotor.get("right_drive")
        var backRightMotor: DcMotor = hardwareMap.dcMotor.get("backRightMotor")

        //reverse as needed (this may need to be the left wheels rather than the right)
        frontRightMotor.direction = (DcMotorSimple.Direction.REVERSE)
        backRightMotor.direction = (DcMotorSimple.Direction.REVERSE)

        //update telemetry
        telemetry.addData(">", "Hardware Initialized")
    }

    fun driveRobot(drive: Double, strafe: Double, turn: Double){
        val drivescale = max(abs(drive) + abs(strafe) + abs(turn), 1.0) //scale down if needed
        //omnidirectional wheel math
        val flp = (drive - strafe - turn) / drivescale
        val frp = (drive + strafe + turn) / drivescale
        val blp = (drive + strafe + turn) / drivescale
        val brp = (drive - strafe - turn) / drivescale

        setDrivePower(flp, frp, blp, brp)
    }


    fun setDrivePower(flp: Double, frp: Double, blp: Double, brp: Double){
        var frontLeftMotor: DcMotor = hardwareMap.dcMotor.get("left_drive")
        var backLeftMotor: DcMotor = hardwareMap.dcMotor.get("backLeftMotor")
        var frontRightMotor: DcMotor = hardwareMap.dcMotor.get("right_drive")
        var backRightMotor: DcMotor = hardwareMap.dcMotor.get("backRightMotor")
        frontLeftMotor.power = flp
        frontRightMotor.power = frp
        backLeftMotor.power = blp
        backRightMotor.power = brp
    }



//    init(HardwareMap hwMap) {
//        // motors
//        val frontLeftMotor = hardwareMap.get(DcMotor::class.java, "left_drive")
//        val frontRightMotor = hardwareMap.get(DcMotor::class.java, "right_drive") //this may need to be set to direction.negative
//        val backLeftMotor = hardwareMap.dcMotor["backLeftMotor"]
//        val backRightMotor = hardwareMap.dcMotor["backRightMotor"] //this many need to be set to direction.negative
//
//        //game pad
//        //some of these values may need to be negative
//        //fix strafing with constant?
//        var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
//        var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
//        var turn = (gamepad1.right_stick_x).toDouble()
//        private var one = (1).toDouble()
//        // makes sure power is never >1, will scale all values down if >1
//        var drivescale = max(abs(drive) + abs(strafe) + abs(turn), one)
//    }
}
