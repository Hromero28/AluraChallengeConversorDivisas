package com.alura.conversor.conversion;

public record CambioPar(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {
}
