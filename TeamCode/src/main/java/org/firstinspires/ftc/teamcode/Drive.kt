package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.DeclareMotors.*

@TeleOp
class Drive {
    fun main(){
        frontLeftMotor.setPower(drive - strafe - turn)
        backLeftMotor.setPower(drive + strafe + turn)
        frontRightMotor.setPower(drive + strafe + turn)
        backRightMotor.setpower(drive - strafe - turn)
    }
}