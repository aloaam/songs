package com.example.songs.performancemeasure;

public record PerformanceDto(
        Long id,
        Long songId,
        PerformanceMeasureType performanceMeasureType,
        String comment
) {
}
