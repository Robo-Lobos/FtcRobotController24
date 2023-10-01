package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.hardware.Declare

//import com.qualcomm.robotcore.eventloop.opmode.Autonomous
//import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
//import com.qualcomm.robotcore.hardware.DcMotor
//import com.qualcomm.robotcore.hardware.DcMotorSimple
//import com.qualcomm.robotcore.util.ElapsedTime


@TeleOp(name = "Drive")
private class Drive : LinearOpMode() {
    // using some math to define power variables for each motor (only useful for omnidirectional wheels)
    // flp = front left power, brp = back right power, etc.
    private val flp = (Declare.drive - Declare.strafe - Declare.turn).toDouble()
    private val frp = (Declare.drive + Declare.strafe + Declare.turn).toDouble()
    private val blp = (Declare.drive + Declare.strafe + Declare.turn).toDouble()
    private val brp = (Declare.drive - Declare.strafe - Declare.turn).toDouble()
    override fun runOpMode() {
        while (opModeIsActive()) {
            Declare.frontLeftMotor.power = (flp)
            Declare.frontRightMotor.power = (frp)
            Declare.backLeftMotor.power = (blp)
            Declare.backRightMotor.power = (brp)
        }
    }

}
