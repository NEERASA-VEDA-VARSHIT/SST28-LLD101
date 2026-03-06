package com.example.tickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;
    private final String description;
    private final String priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    private IncidentTicket(Builder b) {
        this.id = b.id;
        this.reporterEmail = b.reporterEmail;
        this.title = b.title;
        this.description = b.description;
        this.priority = b.priority;
        this.tags = Collections.unmodifiableList(new ArrayList<>(b.tags));
        this.assigneeEmail = b.assigneeEmail;
        this.customerVisible = b.customerVisible;
        this.slaMinutes = b.slaMinutes;
        this.source = b.source;
    }

    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return tags; }
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    public Builder toBuilder() {
        return new Builder(id, reporterEmail, title)
                .description(description)
                .priority(priority)
                .tags(tags)
                .assigneeEmail(assigneeEmail)
                .customerVisible(customerVisible)
                .slaMinutes(slaMinutes)
                .source(source);
    }

    public static class Builder {

        private final String id;
        private final String reporterEmail;
        private final String title;

        private String description;
        private String priority = "MEDIUM";
        private List<String> tags = new ArrayList<>();
        private String assigneeEmail;
        private boolean customerVisible = false;
        private Integer slaMinutes;
        private String source;

        public Builder(String id, String reporterEmail, String title) {
            Validation.requireTicketId(id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireNonBlank(title, "title");

            this.id = id;
            this.reporterEmail = reporterEmail;
            this.title = title;
        }

        public Builder description(String v) {
            this.description = v;
            return this;
        }

        public Builder priority(String v) {
            Validation.requireOneOf(v, "priority", "LOW", "MEDIUM", "HIGH", "CRITICAL");
            this.priority = v;
            return this;
        }

        public Builder tags(List<String> t) {
            this.tags = new ArrayList<>(t);
            return this;
        }

        public Builder addTag(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Builder assigneeEmail(String v) {
            if (v != null) Validation.requireEmail(v, "assigneeEmail");
            this.assigneeEmail = v;
            return this;
        }

        public Builder customerVisible(boolean v) {
            this.customerVisible = v;
            return this;
        }

        public Builder slaMinutes(Integer v) {
            Validation.requireRange(v, 1, 10080, "slaMinutes");
            this.slaMinutes = v;
            return this;
        }

        public Builder source(String v) {
            this.source = v;
            return this;
        }

        public IncidentTicket build() {
            return new IncidentTicket(this);
        }
    }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }
}