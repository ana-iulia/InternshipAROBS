package week1.lab8.exercise4;

abstract class Event {

    EventType type;

    Event(EventType type) {
        this.type = type;
    }

    EventType getType() {
        return type;
    }

}