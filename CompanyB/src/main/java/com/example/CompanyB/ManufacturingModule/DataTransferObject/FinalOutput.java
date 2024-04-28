package com.example.CompanyB.ManufacturingModule.DataTransferObject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "Manufacturing_FinalOutput")
public class FinalOutput {
    @Id
    private String id;
    private int No_Of_Items_Released;
    private int No_Of_Error_Items;
    private boolean QA_Approval;
    private LocalDate Released_Date;

    public FinalOutput(String id, int no_Of_Items_Released, int no_Of_Error_Items, boolean QA_Approval, LocalDate released_Date) {
        this.id = id;
        this.No_Of_Items_Released = no_Of_Items_Released;
        this.No_Of_Error_Items = no_Of_Error_Items;
        this.QA_Approval = QA_Approval;
        this.Released_Date = released_Date;
    }

    public FinalOutput() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNo_Of_Items_Released() {
        return No_Of_Items_Released;
    }

    public void setNo_Of_Items_Released(int no_Of_Items_Released) {
        No_Of_Items_Released = no_Of_Items_Released;
    }

    public int getNo_Of_Error_Items() {
        return No_Of_Error_Items;
    }

    public void setNo_Of_Error_Items(int no_Of_Error_Items) {
        No_Of_Error_Items = no_Of_Error_Items;
    }

    public boolean isQA_Approval() {
        return QA_Approval;
    }

    public void setQA_Approval(boolean QA_Approval) {
        this.QA_Approval = QA_Approval;
    }

    public LocalDate getReleased_Date() {
        return Released_Date;
    }

    public void setReleased_Date(LocalDate released_Date) {
        Released_Date = released_Date;
    }

    @Override
    public String toString() {
        return "FinalOutput{" +
                "id='" + id + '\'' +
                ", No_Of_Items_Released=" + No_Of_Items_Released +
                ", No_Of_Error_Items=" + No_Of_Error_Items +
                ", QA_Approval=" + QA_Approval +
                ", Released_Date=" + Released_Date +
                '}';
    }
}
