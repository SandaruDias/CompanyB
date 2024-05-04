package com.example.CompanyB.FinancePayRollModule.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payroll_counters")
public class PayrollCounter {
    @Id
    private String id;
    private int counterValue;

    public PayrollCounter(String id, int counterValue) {
        this.id = id;
        this.counterValue = counterValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCounterValue() {
        return counterValue;
    }

    public void setCounterValue(int counterValue) {
        this.counterValue = counterValue;
    }
}