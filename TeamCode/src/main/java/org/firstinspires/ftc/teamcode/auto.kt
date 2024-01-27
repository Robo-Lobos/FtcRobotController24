import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.hardware.Hardware
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.tfod.TfodProcessor
import kotlin.system.measureTimeMillis

@Autonomous(name = "Auto")

class Auto : LinearOpMode() {
    /**
     * The variable to store our instance of the TensorFlow Object Detection processor.
     */

    private var hwmap = Hardware(this)

    /**
     * The variable to store our instance of the vision portal.
     */


    //

    override fun runOpMode() {
        hwmap.driveRobot(0.5.toDouble(), 0.0, 0.0)
        sleep(500)
        hwmap.driveRobot(0.0, 0.0, 0.0)
    }
}