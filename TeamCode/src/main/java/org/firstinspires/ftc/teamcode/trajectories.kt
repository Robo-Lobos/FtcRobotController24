package org.firstinspires.ftc.teamcode
import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive


class Trajectories {
    object rrtraj{
        //call trajectory builder function from drive
        var drive: SampleMecanumDrive  = SampleMecanumDrive(hardwareMap)
        val absYVal: Double = 58.5 //think about where robot will be placed FIX AFTER BOT BUILT

        /**
         * somehow squeeze drive.setPoseEstimate(startPose) in there??
         *
         * RR and meepmeep use a FIELD-centric coordinate system
         * meaning we have to specify where the robot starts with the startpose() command
         * be mindful when making the four separate drive programs (innerblue, outerred, etc.)
         *
         */


        //all possible starting positions (poses)
        var outerblue: Pose2d? = Pose2d(-36.0, -70.0, Math.toRadians(90.0))
        var outerred: Pose2d? = Pose2d(-36.0, 70.0, Math.toRadians(270.0))
        var innerblue: Pose2d? = Pose2d(-36.0, 70.0, Math.toRadians(270.0))
        var innerred: Pose2d? = Pose2d(-36.0, 70.0, Math.toRadians(270.0))


        //pixel backboard trajectories for all possible robot and cat positions
        var innerblue1: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0))) //fix pose
                                //.waitSeconds(1)
                                .splineTo(Vector2d(26.5, -32.00), Math.toRadians(90.0))
                                //.turn(Math.toRadians(90.0))
                                /*SLICE HERE!*/
                                .build()

            //.turn(Math.toRadians(90.0))
        var innerblue1b: Trajectory = drive.trajectoryBuilder(Pose2d(26.5, -32.00), Math.toRadians(0.0))

                                /*SLICE HERE!*/
                                .splineTo(Vector2d(10.00, -32.00), Math.toRadians(180.00))
            .build()
            //.waitSeconds(1)
        var innerblue1c: Trajectory = drive.trajectoryBuilder(innerblue1b.end())
                                //.waitSeconds(1)
                                .splineToConstantHeading(Vector2d(20.00, -32.00), Math.toRadians(180.00))
                                .build()

                                //.waitSeconds(1)
                                //.turn(Math.toRadians(-180.0)
        var innerblue1d: Trajectory = drive.trajectoryBuilder(innerblue1c.end())
                                .splineTo(Vector2d(49.20, -29.00), Math.toRadians(0.00))
            .build()

        var innerblue2: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0)))
                //.waitSeconds(1)
                .splineTo(Vector2d(12.00, -34.50), Math.toRadians(90.00))
            .build()
               // .waitSeconds(3)
                //.splineToConstantHeading(Vector2d(12.00, -58.50), Math.toRadians(90.00))
                //.waitSeconds(1)
                //.splineTo(Vector2d(48.50, -35.00), Math.toRadians(0.00))

        //.build()

        var innerblue3: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, -absYVal, Math.toRadians(90.0)))
            //.waitSeconds(1)

            .splineTo(Vector2d(20.30, -43.50), Math.toRadians(68.05))
            .build()

            //.waitSeconds(1)
        var innerblue3a: Trajectory = drive.trajectoryBuilder(innerblue3.end())
            .splineToConstantHeading(Vector2d(29.08, -60.05), Math.toRadians(-11.67))
            .splineToLinearHeading(Pose2d(48.50, -42.00, Math.toRadians(0.00)), Math.toRadians(0.00))

            .build()

        var outerblue1: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
            .splineToConstantHeading(Vector2d(-44.0, -43.0), Math.toRadians(90.0))
           // .waitSeconds(1)
            .splineToConstantHeading(Vector2d(-34.0, -60.0), Math.toRadians(90.0))
            .splineToConstantHeading(Vector2d(-34.0, 0.0), Math.toRadians(90.0))
        /*SLICE HERE!*/
         //   .turn(Math.toRadians(-90.0))
        /*SLICE HERE!*/
            .splineTo(Vector2d(30.84, -8.88), Math.toRadians(0.00))
            .splineTo(Vector2d(49.20, -29.00), Math.toRadians(0.00))

            .build()

        var outerblue2: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
           // .waitSeconds(2)
            // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

            .splineToConstantHeading(Vector2d(-36.0, -34.5), Math.toRadians(90.0))
            //.waitSeconds(1)
            .lineTo( Vector2d(-36.0, -58.5))
            .splineToConstantHeading( Vector2d(-55.0, -23.5), Math.toRadians(90.0))
            .splineToConstantHeading( Vector2d(-34.0, 0.0), Math.toRadians(90.0))
        /*SLICE HERE!*/
           // .turn(Math.toRadians(-90.0))
        /*SLICE HERE!*/
            .splineToConstantHeading( Vector2d(36.0, 0.0), Math.toRadians(0.0))
            .splineToConstantHeading( Vector2d(48.5, -35.0), Math.toRadians(0.0))
            .build()

        var outerblue3: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, -absYVal, Math.toRadians(90.0)))
            //.waitSeconds(2)
            // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

            .splineToConstantHeading( Vector2d(-50.0, -30.0), Math.toRadians(90.0))
            .build()
        /*SLICE HERE!*/
           // .turn(Math.toRadians(-90.0)) //can't be called in a trajectory
        /*SLICE HERE!*/
            //.waitSeconds(1)
            //.lineTo( Vector2d(-34.5, -30.0))
          ///  .waitSeconds(2)
        /*SLICE HERE!*/
           // .lineTo( Vector2d(-39.0, -30.0))
        /*SLICE HERE!*/
        // .splineTo( Vector2d(-45.86, -52.65), Math.toRadians(200.92))
        //.splineTo( Vector2d(-55.25, -15.96), Math.toRadians(101.98))
        //.splineTo( Vector2d(-34.00, -0.00), Math.toRadians(0.00))


            //.splineToConstantHeading( Vector2d(-50.00, -4.00), Math.toRadians(0.00))
           // .splineToConstantHeading( Vector2d(-34.00, -0.00), Math.toRadians(0.00))


        // .splineTo( Vector2d(-53.08, -23.61), Math.toRadians(102.28)) //works
        // .splineTo( Vector2d(-34.00, -0.00), Math.toRadians(00)) //works
        // .turn(Math.toRadians(180.0) + 1e-6)
         //   .splineTo( Vector2d(39.36, -22.75), Math.toRadians(270.00))
          //  .splineTo( Vector2d(48.50, -41.96), Math.toRadians(0.00))




        //.strafeTo( Vector2d(-34.0, 0.0))
         //   .waitSeconds(10)
          //  .build()

        var innerred1: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //.waitSeconds(1)
            .splineTo(Vector2d(20.30, 43.50), Math.toRadians(-68.05))
            //.waitSeconds(1)
            .build()
        var innerred1b: Trajectory = drive.trajectoryBuilder(innerred1.end())
            .splineToConstantHeading( Vector2d(29.08, 57.05), Math.toRadians(-11.67))
            .splineToLinearHeading( Pose2d(48.50, 42.00, Math.toRadians(0.00)), Math.toRadians(0.00))
        .build()

        var innerred2: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //.waitSeconds(1)
            .splineTo(Vector2d(12.00, 34.50), Math.toRadians(270.00))
            .build()

        //.waitSeconds(3)
        var innerred2b: Trajectory = drive.trajectoryBuilder(innerred2.end())

            .splineToConstantHeading(Vector2d(12.00, 58.50), Math.toRadians(270.00))
            .build()

        //.waitSeconds(1)
        var innerred2c: Trajectory = drive.trajectoryBuilder(innerred2b.end())
            .splineTo(Vector2d(48.50, 35.00), Math.toRadians(0.00))
            .build()

        var innerred3: Trajectory = drive.trajectoryBuilder(Pose2d(12.0, absYVal, Math.toRadians(270.0)))
            //.waitSeconds(1)
            .splineTo(Vector2d(26.5, 32.00), Math.toRadians(270.0))
            /*SLICE HERE!*/
            .build()
            //.turn(Math.toRadians(-90.0))
            /*SLICE HERE!*/
        var innerred3a: Trajectory = drive.trajectoryBuilder(innerred3.end())
            .splineTo(Vector2d(10.00, 32.00), Math.toRadians(180.00))
            .build()
            //.waitSeconds(1)
           // .splineToConstantHeading(Vector2d(20.00, 32.00), Math.toRadians(180.00))
            //.waitSeconds(1)
            //.turn(Math.toRadians(-180.0))
            //.splineTo(Vector2d(49.20, 29.00), Math.toRadians(0.00))
           // .build()
           // .build()

        var outerred1: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var outerred2: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()

        var outerred3: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, absYVal, Math.toRadians(270.0)))
            //blah blah
            .build()
    }
}