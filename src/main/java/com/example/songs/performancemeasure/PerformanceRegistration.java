package com.example.songs.performancemeasure;

import java.util.Optional;

public record PerformanceRegistration(
        Long songId,
        PerformanceMeasureType measure,

        Short grade,
        Optional<String> comment
) {
}
