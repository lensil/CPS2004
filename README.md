# CPS2004 Assignment

This branch contains the source code of the final submission for the CPS2004 assignment.

## Project Structure

- `Task1B`: contains the code for task 1(b) of the assignment
    - `CMakeLists.txt`
    - `main.cpp`: test run of the application
    - The rest of the files are the classes developed to create the management application

- `Task1C`: contains the code for task 1(c) of the assignment
   - `task1c`:
      - `src/main/java/com/cps2004/`:
         - `App.java`: : test run of the application
         - The rest of the files are the classes developed to create the management application 
      - `pom.xml`

- `Task2A_B`: contains the code for both task 2(a) and 2(b) of the assignment 
   - `task2a_b`:
      - `src/main/java/com/cps2004/`:
         - `App.java`: : test run of the application
         - `TransportFactory.java`: implements the transport factory for 2(a)
         - `ProductFactory.java`: implements the product factory for 2(a)
         - `ShipmentDecorator.java`: implements the abtract decorator for 2(b)
         - `GlobalDiscountDecorator.java`: implements the concrete  global discount decorator for 2(b)
         - `DeliveryPlanDecorator.java`: implements the concrete delivery plan decorator for 2(b)
         - The rest of the files are the classes developed to create the management application
      - `pom.xml`

- `Task3A_B`: contains the code for both task 3(a) and 2(b) of the assignment 
   - `task3a_b`:
      - `src/main/`:
         - `java/com/cps2004/`:
            - `Facade.java`: facade for 3(b)
            - The rest of the files are the classes developed to create the management application
            - `DataStructures.java`: protobuf generated class for 3(b)
         - `proto`
            - `data_structures.proto`: protobuf file for 3(a)
      - `pom.xml`

- `Task3C`: contains the code for task 3(c) of the assignment
   - `CMakeLists.txt`
   - `main.cpp`: stock viewer app
   - The rest of the files are the classes developed to create the management application

- `Task4A_B`: contains the code for both task 4(a) and 4(b) of the assignment
   - `task4a_b`:
      - `src/main/`:
         - `java/com/cps2004/`:
            - `Shipment.java`: facade for generated stub for 4(b)
            - `ShipmentServiceOuterClass.java`: protobuf generated class for 3(b)
            - `ShipmentServiceGrpc.java`: protobuf generated class for 3(b)
            - The rest of the files are the classes developed to create the management application
         - `proto`
            - `data_structures.proto`
            - `shipment_service.proto`: protobuf file for 4(a)
      - `pom.xml`

- `Task4C`: contains the code for task 4(c) of the assignment
   - `CMakeLists.txt`
   - `data_structures.pb.cc/.h`: protobuf generated class 
   - `shipment_service.pb.cc/.h`: protobuf generated class 
   - `shipment_service.grpc.pb.cc/.h`: protobuf generated class
   - `serviceImpl.cpp`: service implementation
   - `main.cpp`: gRPC server

## Compilation and Execution

To compile and run this project:

1. Clone the repository
2. For the C++ files, compile using CMake
3. For the Java files, compile using Maven
