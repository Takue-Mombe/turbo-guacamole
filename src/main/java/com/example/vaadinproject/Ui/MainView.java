package com.example.vaadinproject.Ui;

import com.example.vaadinproject.Backend.Models.Accounts;
import com.example.vaadinproject.Backend.Models.Patients;
import com.example.vaadinproject.Backend.ServiceLayer.PatientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;


@Route("")
//@CssImport(value = "style.css")

public class MainView extends VerticalLayout {

    private final PatientService Patientservice;
    private final PatientsForm patientsForm;
    Grid<Patients> grid=new Grid<>(Patients.class);
    TextField filterText=new TextField();
    public MainView(PatientService Patientservice, PatientsForm patientsForm, PatientsForm patientsForm1) {
        this.Patientservice = Patientservice;
        this.patientsForm = patientsForm;

        setClassName("PatientsListView");
        setSizeFull();
        configureGrid();
        configureFilter();
        updateGrid();

      patientsForm=  new PatientsForm();
      Div content=new Div(grid,patientsForm);

      content.addClassName("content");
      content.setSizeFull();
        add(filterText,content);
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filter By Name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e->updateList());
    }

    private void updateList() {
        grid.setItems(Patientservice.getAll(filterText.getValue()));
    }

    private void updateGrid() {
        grid.setItems(Patientservice.getAll());
        grid.addComponentColumn(Patients->{
            Button edit =new Button();
            edit.setIcon(LineAwesomeIcon.EDIT.create());
            return edit;

        }).setHeader("Edit");  grid.addComponentColumn(Patients->{
            Button delete=new Button();
            delete.setIcon(LineAwesomeIcon.REMOVE_FORMAT_SOLID.create());
            return delete;
        }).setHeader("Delete");
        grid.removeColumnByKey("version");
        grid.removeColumnByKey("accounts");
        //a lambda expression to add columns
        grid.addColumn(patients -> {
            setAlignItems(Alignment.CENTER);
            Accounts accounts=patients.getAccounts();
            return accounts==null?"-":accounts.getAccountNumber();

        }).setHeader("Account Number");
        //setting up width of the columns
        grid.getColumns().forEach(patientsColumn -> patientsColumn.setAutoWidth(true));
    }

    private void configureGrid() {

        grid.addClassName("PatientsGrid");
        grid.setSizeFull();

    }
}
