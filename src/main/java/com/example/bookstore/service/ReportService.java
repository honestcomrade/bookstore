package com.example.bookstore.service;

import com.example.bookstore.report.ReportBuilder;
import jakarta.inject.Provider;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

  private final Provider<ReportBuilder> reportBuilderProvider;

  public ReportService(Provider<ReportBuilder> reportBuilderProvider) {
    this.reportBuilderProvider = reportBuilderProvider;
  }

  public String generateDailyReport() {
    ReportBuilder builder = reportBuilderProvider.get(); // new instance
    return builder
        .setTitle("Daily Book Report")
        .addLine("Total books: 5")
        .addLine("Most viewed: 'Spring in Action'")
        .build();
  }
}
