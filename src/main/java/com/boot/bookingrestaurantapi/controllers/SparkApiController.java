package com.boot.bookingrestaurantapi.controllers;
import static spark.Spark.*;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/spark" + "/v1")
public class SparkApiController {
	public static void main(String[] args) {
		// Configurar la ruta raíz
        get("/hello", (req, res) -> "¡Hola, mundo!");

        // Ruta para obtener datos
        get("/data", (req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Datos obtenidos correctamente\"}";
        });

        // Ruta para manejar solicitudes POST
        post("/submit", (req, res) -> {
            String body = req.body();
            res.type("application/json");
            return "{\"received\":\"" + body + "\"}";
        });

        // Ruta con parámetros
        get("/hello/:name", (req, res) -> {
            String name = req.params(":name");
            return "Hola, " + name;
        });

        // Ruta para manejar errores
        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Ruta no encontrada\"}";
        });

        internalServerError((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Error interno del servidor\"}";
        });
	}
}

