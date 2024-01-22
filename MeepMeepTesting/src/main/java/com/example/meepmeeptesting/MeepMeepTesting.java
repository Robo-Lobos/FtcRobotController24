package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity outerblue1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .splineToConstantHeading(new Vector2d(-44.0, -43.0), Math.toRadians(90))
                                .waitSeconds(1)
                                .splineToConstantHeading(new Vector2d(-34.0, -60.0), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-34.0, 0.0), Math.toRadians(90))
                                /*SLICE HERE!*/
                                .turn(Math.toRadians(-90))
                                /*SLICE HERE!*/
                                .splineTo(new Vector2d(30.84, -8.88), Math.toRadians(0.00))
                                .splineTo(new Vector2d(49.20, -29.00), Math.toRadians(0.00))

//                                .splineToConstantHeading(new Vector2d(36.0, 0.0), Math.toRadians(0))
//                                .splineToConstantHeading(new Vector2d(36.0, -29.0), Math.toRadians(0))
//                                .splineToConstantHeading(new Vector2d(49.2, -29.0), Math.toRadians(0))
                                .build()
                );


        RoadRunnerBotEntity outerblue2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .waitSeconds(2)
                               // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

                                .splineToConstantHeading(new Vector2d(-36.0, -34.5), Math.toRadians(90))
                                .waitSeconds(1)
                                .lineTo(new Vector2d(-36.0, -58.5))
                                .splineToConstantHeading(new Vector2d(-55.0, -23.5), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-34.0, 0.0), Math.toRadians(90))
                                /*SLICE HERE!*/
                                .turn(Math.toRadians(-90))
                                /*SLICE HERE!*/
                                .splineToConstantHeading(new Vector2d(36.0, 0.0), Math.toRadians(0))
                                .splineToConstantHeading(new Vector2d(48.5, -35.0), Math.toRadians(0))
                                //.splineToConstantHeading(new Vector2d(49.2, -29.0), Math.toRadians(0))
                                .build()
                );

        RoadRunnerBotEntity outerblue3 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.0, -58.5, Math.toRadians(90)))
                                .waitSeconds(2)
                                // .splineToConstantHeading(new Vector2d(-36.0, -60.4), Math.toRadians(90))

                                .splineToConstantHeading(new Vector2d(-50.0, -30.0), Math.toRadians(90))
                                .turn(Math.toRadians(-90)) //can't be called in a trajectory
                                .waitSeconds(1)
                                .lineTo(new Vector2d(-34.5, -30.0))
                                .waitSeconds(2)
                                .lineTo(new Vector2d(-39.0, -30.0))
                               // .splineTo(new Vector2d(-45.86, -52.65), Math.toRadians(200.92))
                                //.splineTo(new Vector2d(-55.25, -15.96), Math.toRadians(101.98))
                                //.splineTo(new Vector2d(-34.00, -0.00), Math.toRadians(0.00))
                                .splineToConstantHeading(new Vector2d(-50.00, -4.00), Math.toRadians(0.00))
                                .splineToConstantHeading(new Vector2d(-34.00, -0.00), Math.toRadians(0.00))


                                // .splineTo(new Vector2d(-53.08, -23.61), Math.toRadians(102.28)) //works
                               // .splineTo(new Vector2d(-34.00, -0.00), Math.toRadians(00)) //works
                               // .turn(Math.toRadians(180.0) + 1e-6)
                                .splineTo(new Vector2d(39.36, -22.75), Math.toRadians(270.00))
                                .splineTo(new Vector2d(48.50, -41.96), Math.toRadians(0.00))




                                //.strafeTo(new Vector2d(-34.0, 0.0))
                                .waitSeconds(10)
                                .build()
                );

        RoadRunnerBotEntity innerblue1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(12.0, -58.5, Math.toRadians(90)))
                                        .waitSeconds(1)
                                        .build()
                );

        // LEARN TO SPLIT TRAJECTORIES EVENTUALLY
        // LOTS O' WORK TO DO!!!
        //++++STILL HAVE TO WRITE BACKSTAGE PARK CODE!!!!!///
        ///keep commented out paths to either side of backstage parking (just in case)
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(outerblue3)
                //.addEntity(myBot3)
                .start();
    }
}