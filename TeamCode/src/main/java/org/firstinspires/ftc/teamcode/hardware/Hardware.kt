package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import java.lang.Double.max
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

open class Hardware(private var opMode: LinearOpMode) {


    //.\adb connect 192.168.43.1:5555


    //declare global objects
    private var myOpMode: LinearOpMode = opMode
    private var frontLeftMotord: DcMotor
    private var backLeftMotord: DcMotor
    private var frontRightMotord: DcMotor
    private var backRightMotord: DcMotor
    private var armBeltMotor: DcMotorEx
    private var pulleyMotor1: DcMotorEx
    private var pulleyMotor2: DcMotorEx
    private var armServo: Servo

    init {
        myOpMode = opMode
        //initialize motors

        //drivetrain motors
        frontLeftMotord = myOpMode.hardwareMap.dcMotor.get("motor0")
        backLeftMotord = myOpMode.hardwareMap.dcMotor.get("motor1") //S
        frontRightMotord = myOpMode.hardwareMap.dcMotor.get("motor2") //S
        backRightMotord = myOpMode.hardwareMap.dcMotor.get("motor3")

        //arm motors
        armBeltMotor = myOpMode.hardwareMap.dcMotor.get("motor0b") as DcMotorEx  //0b motor encoder has sideways odometry pod
        pulleyMotor1 = myOpMode.hardwareMap.dcMotor.get("motor1b") as DcMotorEx //contains odo encoder
        pulleyMotor2 = myOpMode.hardwareMap.dcMotor.get("motor2b") as DcMotorEx
        //motor 3b contains final odo encoder

        frontLeftMotord.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backLeftMotord.mode = DcMotor.RunMode.RUN_USING_ENCODER
        frontRightMotord.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backRightMotord.mode = DcMotor.RunMode.RUN_USING_ENCODER

        //no encoder cables long enough
        //i think some of these motors share an encoder with the dead wheels
        armBeltMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        pulleyMotor1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        pulleyMotor2.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        //servos
        armServo = myOpMode.hardwareMap.servo.get("servo0")
        armServo.scaleRange(0.0,0.75) //DO NOT CHANGE

        //reverse as needed (this may need to be the left wheels rather than the right)
        frontRightMotord.direction = (DcMotorSimple.Direction.REVERSE)
        backRightMotord.direction = (DcMotorSimple.Direction.REVERSE)

        //update telemetry
        val message = "Hardware Initialized"
        myOpMode.telemetry.addData(">", message)
        myOpMode.telemetry.update()
    }

    fun driveRobot(drive: Double, strafe: Double, turn: Double) {
        //magic of trig
        val theta = atan2(drive, strafe)
        val power = hypot(strafe, drive)

        val sin = sin(theta - Math.PI/4)
        val cos = cos(theta - Math.PI/4)
        val max = max(abs(sin), abs(cos))

        //omnidirectional wheel math
        var flp = power * cos/max + turn
        var frp = power * sin/max - turn
        var blp = power * sin/max + turn
        var brp = power * cos/max - turn

        if(power + abs(turn) >1){
            flp /= power + turn
            frp /= power + turn
            blp /= power + turn
            brp /= power + turn
        }

        //send values to motors
        frontLeftMotord.power = flp
        frontRightMotord.power = frp
        backLeftMotord.power = blp
        backRightMotord.power = brp

        //update telemetry
        myOpMode.telemetry.addData("Drive", drive)
        myOpMode.telemetry.addData("Strafe", strafe)
        myOpMode.telemetry.addData("Turn", turn)
        myOpMode.telemetry.update()
    }

    /**create two arm functions??
    one for opmode, one for teleop?
    *op mode arm function has multiple heights?*/

    //open claw servo
    fun testservo(){
        armServo.direction = Servo.Direction.FORWARD
        armServo.position = 0.18 //DO NOT CHANGE
        myOpMode.telemetry.addData("Servo Position", armServo.position)
    }

    //close claw servo
    fun servoreset(){
        armServo.direction = Servo.Direction.REVERSE
        armServo.position = 0.07 //DO NOT CHANGE
        myOpMode.telemetry.addData("Servo Position", armServo.position)
    }

    fun test(){
        testservo()
        myOpMode.sleep(1000)
        servoreset()
    }

    fun autoarm(){
        //fun code
    }

    fun arm(height: Double, belt: Double){
        pulleyMotor1.power = height*0.5
        pulleyMotor2.power = pulleyMotor1.power
        myOpMode.telemetry.addData("Arm Power", pulleyMotor2.power)


        armBeltMotor.power = belt
        myOpMode.telemetry.addData("Belt Power", armBeltMotor.power)

//            1 -> {
//                armBeltMotor.power = 0.5
//                //armBeltMotor.targetPosition = 0
//
//                pulleyMotor1.power = 0.5
//                //pulleyMotor1.targetPosition = 0
//                pulleyMotor2.power = pulleyMotor1.power
//                //pulleyMotor2.targetPosition = pulleyMotor1.targetPosition
//                //lowest height
//            }
//
//            2 -> {
//                armBeltMotor.power = 0.5
//                //armBeltMotor.targetPosition = 0
//
//                pulleyMotor1.power = 0.5
//                //pulleyMotor1.targetPosition = 0
//                pulleyMotor2.power = pulleyMotor1.power
//                //pulleyMotor2.targetPosition = pulleyMotor1.targetPosition
//                //medium height
//            }
//
//            3 -> {
//                armBeltMotor.power = 0.5
//                //armBeltMotor.targetPosition = 0
//
//                pulleyMotor1.power = 0.5
//                //pulleyMotor1.targetPosition = 0
//                pulleyMotor2.power = pulleyMotor1.power
//                //pulleyMotor2.targetPosition = pulleyMotor1.targetPosition
//                //tallest height
//            }

    }
}


