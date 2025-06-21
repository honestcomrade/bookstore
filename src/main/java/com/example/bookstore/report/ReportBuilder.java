package com.example.bookstore.report;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ReportBuilder {

  private String title;
  private final List<String> lines = new ArrayList<>();

  public ReportBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public ReportBuilder addLine(String line) {
    lines.add(line);
    return this;
  }

  public String build() {
    StringBuilder report = new StringBuilder("=== " + title + " ===\n");
    lines.forEach(line -> report.append(line).append("\n"));
    return report.toString();
  }
}
