interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    Vehicle createVehicle(){
        Vehicle v=new Car();
        return v;
    }
}

class BikeFactory extends VehicleFactory {
    Vehicle createVehicle(){
        Vehicle v=new Bike();
        return v;
    }
}

class TruckFactory extends VehicleFactory {
    Vehicle createVehicle(){
        Vehicle v=new Truck();
        return v;
    }
}
