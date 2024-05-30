# Heart Transplant System

The Heart Transplant System is a Java-based application designed to manage patient information and survivability rates for heart transplant procedures. It includes functionalities for adding patients, reading data from files, and retrieving patient information based on various criteria.

## Overview

The system consists of the following main components:

- `HeartTransplant`: Manages patient data and survivability rates.
- `Person`: Represents individual patients with relevant information such as ID, age, gender, etc.
- `SurvivabilityByAge`: Stores survivability rates based on patient age.
- `SurvivabilityByCause`: Stores survivability rates based on the cause of the heart condition.

## Features

- Add a new person to the system.
- Read patient data from a file.
- Read survivability rates by age from a file.
- Read survivability rates by cause from a file.
- Retrieve patients based on age, state of health, or heart condition cause.
- Match a specified number of patients for heart transplant.

## Getting Started

To use the Heart Transplant System, follow these steps:

1. Clone the repository: `git clone https://github.com/yourusername/HeartTransplant.git`
2. Compile the Java files: `javac -d bin src/com/HeartTransplant/*.java`
3. Run the application: `java -cp bin com.HeartTransplant.HeartTransplant`

## Usage

### Adding a Person
#### To add a new person to the system, use the `addPerson` method:

` HeartTransplant ht = new HeartTransplant();
Person p = new Person(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
ht.addPerson(p, arrayIndex); `

### Reading Data from Files
#### To read patient data or survivability rates from files, use the respective methods:

`int numberOfLines = StdIn.readInt();
int numberOfReadings = ht.readPersonsFromFile(numberOfLines);`

### Retrieving Patient Information
#### You can retrieve patient information based on various criteria:

// Get patients with age above a certain threshold
Person[] elderlyPatients = ht.getPatientsWithAgeAbove(ageThreshold);

// Get patients by state of health
Person[] patientsInCriticalCondition = ht.getPatientsByStateOfHealth(criticalState);

// Get patients by heart condition cause
Person[] patientsWithSpecificCondition = ht.getPatientsByHeartConditionCause(conditionCause);

### Matching Patients for Heart Transplant
#### You can match a specified number of patients for heart transplant:

`Person[] selectedPatients = ht.match(numberOfHearts);`
