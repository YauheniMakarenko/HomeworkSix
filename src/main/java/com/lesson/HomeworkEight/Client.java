package com.lesson.HomeworkEight;

import java.util.Objects;

public class Client {
    private String name;
    private String address;

    public Client(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
