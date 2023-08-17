# Learnproject Documentation


- [1. About the project](#1-about-the-project)
- [2. Development roadmap](#2-development-roadmap)
- [3. Domain](#3-domain)
    - [3.1. Flight](#31-flight)
    - [3.2. Other](#31-other)
- [4. Architecture](#4-architecture)
- [5. Technology stack](#5-technology-stack)

## 1. About the project
The goals of this project are:
1. Presentation of the translation of my knowledge in the field of developing backend applications
2. Expanding the knowledge of programming techniques and technologies through experimental

As a result of the above objectives, and as is common in software development, the solutions and design decisions presented in this project do not constitute a scheme that I would consider the only right one - I am aware that some aspects of the presented solution could be solved in a different way. However, based on my experience, I know that the shape of the project is determined by a number of different factors that must be taken into account. For this project, the issue of learning lessons to improve the ability to confront different approaches to software development played an important role.

## 2. Development roadmap
| Milestone | Status |
| ------- | ------ |
| Create basic CRUD for entities | DONE |
| Implement business logic |  |
| Refactor project structure |  |

## 3. Domain

### 3.1. Flight
Flight business domain is based on entities: `Flight`, `Airport`, `CrewMember`, `Ticket`, `Passenger`.

Following domain name, `Flight` entity plays a key role and as such should be considered as potential aggregate in future architecture changes in order to follow Domain Driven Design principles (see [4. Architecture](#4-architecture)).

Each `Flight` has its status expressed with a value of `FlightStatus` enum (consisting of the following values: `SCHEDULED`, `ONGOING`, `FINISHED`, `CANCELED`, `DELAYED`, `OTHER`). When changnig its status, `Flight` must comply with following rules:
- `SCHEDULED` cannot be changed directly to `FINISHED`
- `SCHEDULED` cannot be changed to `ONGOING` unless at least two `CrewMember` entities amd two `Airport` entites are binded with it.
- `SCHEDULED` cannot be changed to `ONGOING` unless values for: `flightName`, `flightStart`, `flightEnd`, `maxPassengerCount` are provided
- `ONGOIND` cannot be changed neither to `CANCELLED` nor `SCHEDULED`
- `DELAYED` cannot be changed to `SCHEDULED`

Value of `flightEnd` must not be before `flightStart`.
Number of related `Ticket` objects in `tickets` cannot be greater than value of `maxPassengerCount`. It is possible to remove relation with any entity related to `Flight` as long as it's status is `SCHEDULED`.
It is possible that `airportStart` and `airportEnd` are reffering to the same `Airport` entity.

It is forbidden to bind `CrewMember` with `Flight` if at least one of the rules are not followed:
- `CrewMember` must not be binded with two `Flights` if thier duration timelap overlaps
- `CrewMember` must not be binded with new `Flight` if new `Flight`'s value of `flightStart` is: 
    - sooner than 1 hour after `flightEnd` of the last `Flight` that the `CrewMember` took part in and `startAirport` of a new `Flight` is the same as `endAirport` of his last participed `Flight`
    - sooner than 12 hour if `endAirport` and `startAirport` are different
 
New `Flight` can be added to `Airport`'s `departures` list with the rule of 5 minutes between flight. The same applies to `arrivals`. No `Flight` can be added to neither of list if `WeatherCondition` for an `Airport` has value `HURRICANE`.



### 3.1. Other
No other domain implemented at the moment


## 4. Architecture
TODO

## 5. Technology stack
- Java 17
- Spring Framework
- Gradle
- Lombok
- JUnit
- Postgres
- Testcontainers
