package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import java.lang.Double.max
import kotlin.math.abs

open class Hardware constructor(myOpMode : opmode) {

    //declare objects
    private var myOpMode: LinearOpMode? = null
    //private val frontLeftDrive: DcMotor? = null
    //private val backLeftDrive: DcMotor? = null
    //private val frontRightDrive: DcMotor? = null
    //private val backRightDrive: DcMotor? = null

    class Hardware(var myOpMode: OpMode){
        var myOpMode = Hardware()
    }

    fun init() {
        var frontLeftMotor = myOpMode!!.hardwareMap.get(DcMotor::class.java, "left_drive")
        var frontRightMotor = myOpMode!!.hardwareMap.get(DcMotor::class.java, "right_drive")
        var backLeftMotor = myOpMode!!.hardwareMap.dcMotor["backLeftMotor"]
        var backRightMotor = myOpMode!!.hardwareMap.dcMotor["backRightMotor"]

        //reverse as needed (this may need to be the left wheels rather than the right)
        frontRightMotor.direction = (DcMotorSimple.Direction.REVERSE)
        backRightMotor.direction = (DcMotorSimple.Direction.REVERSE)
    }

    fun driveRobot(drive: Double, strafe: Double, turn: Double){
        val drivescale = max(abs(drive) + abs(strafe) + abs(turn), 1.0)
        val flp = (drive - strafe - turn) / drivescale
        val frp = (drive + strafe + turn) / drivescale
        val blp = (drive + strafe + turn) / drivescale
        val brp = (drive - strafe - turn) / drivescale

        setDrivePower(flp, frp, blp, brp)
    }

    private fun setDrivePower(flp: Double, frp: Double, blp: Double, brp: Double){
        frontLeftMotor.power= flp


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
