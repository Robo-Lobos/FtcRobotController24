package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
//import org.firstinspires.ftc.teamcode.hardware.Declare
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.teamcode.hardware.Customhwmap
import kotlin.math.abs
import kotlin.math.max

//import org.firstinspires.ftc.teamcode.hardware.customhwmap
//import org.firstinspires.ftc.teamcode.hardware.hwmap

@TeleOp(name = "Drive")
class Drive : LinearOpMode() {
    override fun runOpMode() {
        // using some math to define power variables for each motor (only useful for omnidirectional wheels)
        // this creates a "robot-centric" direction system
        // flp = front left power, brp = back right power, etc.
//        val flp = (Declare.drive - Declare.strafe - Declare.turn) / Declare.drivescale
//        val frp = (Declare.drive + Declare.strafe + Declare.turn) / Declare.drivescale
//        val blp = (Declare.drive + Declare.strafe + Declare.turn) / Declare.drivescale
//        val brp = (Declare.drive - Declare.strafe - Declare.turn) / Declare.drivescale
        //val Declare = Customhwmap()


        val frontLeftMotor: DcMotor =
            hardwareMap.dcMotor.get("left_drive")     // get(DcMotor::class.java, "left_drive")
        val frontRightMotor: DcMotor =
            hardwareMap.dcMotor.get("right_drive")  //get(DcMotor::class.java, "right_drive") //this may need to be set to direction.negative
        val backLeftMotor: DcMotor = hardwareMap.dcMotor.get("backLeftMotor")
        val backRightMotor: DcMotor =
            hardwareMap.dcMotor.get("backRightMotor") //this many need to be set to direction.negative

        //game pad
        //some of these values may need to be negative
        //fix strafing with constant?
//        var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
//        var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
//        var turn = (gamepad1.right_stick_x).toDouble()
//        var one = (1).toDouble()
//        // makes sure power is never >1, will scale all values down if >1
//        var drivescale = max(abs(drive) + abs(strafe) + abs(turn), one)

        waitForStart()

        while (isStarted&&!isStopRequested) {
            var drive = -(gamepad1.left_stick_y).toDouble() //aka forward
            var strafe = (gamepad1.left_stick_x).toDouble() //aka sideways
            var turn = (gamepad1.right_stick_x).toDouble()
            var one = (1).toDouble()
            // makes sure power is never >1, will scale all values down if >1
            var drivescale = max(abs(drive) + abs(strafe) + abs(turn), one)

            var flp: Double = (drive - strafe - turn) / drivescale
            var frp: Double = (drive + strafe + turn) / drivescale
            var blp: Double = (drive + strafe + turn) / drivescale
            var brp: Double = (drive - strafe - turn) / drivescale
            frontLeftMotor.power = (flp)
            frontRightMotor.power = (frp)
            backLeftMotor.power = (blp)
            backRightMotor.power = (brp)
            telemetry.addData("Drive", drive)
            telemetry.addData("Strafe", strafe)
            telemetry.addData("Turn", turn)
            telemetry.addData("flp", flp)
            telemetry.update()
        }
    }
}

