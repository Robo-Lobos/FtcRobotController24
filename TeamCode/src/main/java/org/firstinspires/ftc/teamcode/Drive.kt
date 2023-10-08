package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.hardware.Declare
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode

@TeleOp(name = "Drive")
class Drive : LinearOpMode() {
    // using some math to define power variables for each motor (only useful for omnidirectional wheels)
    // this creates a "robot-centric" direction system
    // flp = front left power, brp = back right power, etc.
    private val flp = (Declare.drive - Declare.strafe - Declare.turn) / Declare.drivescale
    private val frp = (Declare.drive + Declare.strafe + Declare.turn) / Declare.drivescale
    private val blp = (Declare.drive + Declare.strafe + Declare.turn) / Declare.drivescale
    private val brp = (Declare.drive - Declare.strafe - Declare.turn) / Declare.drivescale
    override fun runOpMode() {
        while (opModeIsActive()) {
            Declare.frontLeftMotor.power = (flp)
            Declare.frontRightMotor.power = (frp)
            Declare.backLeftMotor.power = (blp)
            Declare.backRightMotor.power = (brp)
            telemetry.addData("Drive", Declare.drive)
            telemetry.addData("Strafe", Declare.strafe)
            telemetry.addData("Turn", Declare.turn)
        }
    }

}
