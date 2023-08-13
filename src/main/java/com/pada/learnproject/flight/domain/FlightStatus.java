package com.pada.learnproject.flight.domain;

public enum FlightStatus {
    SCHEDULED {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {
            if(FINISHED.equals(newFlightStatus)){
                throw new RuntimeException("Scheduled flight can't be changed to Finished");
            }
        }
    }, ONGOING {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {
            if(CANCELLED.equals(newFlightStatus)){
                throw new RuntimeException("Ongoing flight can't be changed to Cancelled");
            }
            preventScheduledTransition(newFlightStatus);
        }
    }, FINISHED {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {
            preventScheduledTransition(newFlightStatus);
        }
    }, CANCELLED {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {
            preventScheduledTransition(newFlightStatus);
        }
    }, DELAYED {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {
            preventScheduledTransition(newFlightStatus);
        }

    }, OTHER {
        @Override
        public void changeValue(FlightStatus newFlightStatus) {

        }
    };

    public abstract void changeValue(FlightStatus newFlightStatus);

    private static void preventScheduledTransition(FlightStatus newFlightStatus) {
        if(SCHEDULED.equals(newFlightStatus)){
            throw new RuntimeException("Delayed flight can't be changed to Scheduled");
        }
    }
}
