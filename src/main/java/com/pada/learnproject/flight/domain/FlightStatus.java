package com.pada.learnproject.flight.domain;

public enum FlightStatus {
    SCHEDULED {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return newStatus != FINISHED;
        }
    },
    ONGOING {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return newStatus != CANCELLED && newStatus != SCHEDULED;
        }
    },
    FINISHED {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return false;
        }
    },
    CANCELLED {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return false;
        }
    },
    DELAYED {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return newStatus != SCHEDULED;

        }
    },
    OTHER {
        @Override
        public boolean isValidTransitionTo(FlightStatus newStatus) {
            return true;
        }
    };

    public abstract boolean isValidTransitionTo(FlightStatus newStatus);
}
