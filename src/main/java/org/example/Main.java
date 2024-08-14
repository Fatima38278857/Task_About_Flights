package org.example;

import java.util.List;

import static org.example.FlightBuilder.createFlights;

public class Main {
    public static void main(String[] args) {
        System.out.println("Исключины из тестового набора, вылеты до текущего момента времени");
        List<Flight> flights = createFlights();
        Filter flightFilter = new Filter();
        List<Flight> filteredFlights = flightFilter.testFiltr(flights);
        filteredFlights.forEach(flight -> {
            flight.getSegments().forEach(segment -> {
                System.out.println("Сегмент:");
                System.out.println("Вылет: " + segment.getDepartureDate());
                System.out.println("Прилет: " + segment.getArrivalDate());
            });
            System.out.println("--------------------");
        });

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Исключины из тестового набора, cегменты с датой прилёта раньше даты вылета");
        List<Flight> flights1 = createFlights();
        Filter flightFilter1 = new Filter();
        List<Flight> filteredFlights1 = flightFilter1.testFiltrTwo(flights1);
        filteredFlights1.forEach(flight -> {
            flight.getSegments().forEach(segment -> {
                System.out.println("Сегмент:");
                System.out.println("Вылет: " + segment.getDepartureDate());
                System.out.println("Прилет: " + segment.getArrivalDate());
            });
            System.out.println("--------------------");
        });

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Перелеты, где общее время, проведённое на земле, превышает два часа");
        List<Flight> flights2 = createFlights();

        Filter flightFilter2 = new Filter();
        List<Flight> filteredFlights2 = flightFilter2.testFiltrThree(flights2);
        filteredFlights2.forEach(flight -> {
            System.out.println("Полет:");
            flight.getSegments().forEach(segment -> {
                System.out.println("Сегмент:");
                System.out.println("Вылет: " + segment.getDepartureDate());
                System.out.println("Прилет: " + segment.getArrivalDate());
            });
            System.out.println("--------------------");
        });
    }
}