package com.example.EntertainmentService.tests;

import com.example.ProductService.Entertainment;
import com.example.ProductService.EntertainmentService;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntertainmentServiceTests {
    private EntertainmentService entertainmentService;

    @BeforeEach
    public void setUp() {
        String filePath = "src/main/webapp/WEB-INF/entertainments.xml";
        entertainmentService = new EntertainmentService(filePath);
    }

    @Test
    public void testGetAllEntertainments() {
        List<Entertainment> entertainments = entertainmentService.getAllEntertainments();
        assertNotNull(entertainments);
        assertEquals(7, entertainments.size());
    }

    @Test
    public void testCalculateTotalCost() {
        double expectedTotalCost = 2950.0;
        double actualTotalCost = entertainmentService.calculateTotalCost();
        assertEquals(expectedTotalCost, actualTotalCost, 0.01);

    }

}