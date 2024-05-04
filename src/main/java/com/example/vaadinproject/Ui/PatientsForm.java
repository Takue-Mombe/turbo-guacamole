package com.example.vaadinproject.Ui;

import com.example.vaadinproject.Backend.Models.Patients;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;


@org.springframework.stereotype.Component
public class PatientsForm extends FormLayout {

    private TextField patientNumber = new TextField("Patient Number");
    private TextField fullName = new TextField("Full Name");
    private DatePicker dateOfBirth = new DatePicker("Date of Birth");
    private TextField gender = new TextField("Gender");
    private TextField maritalStatus = new TextField("Marital Status");
    private TextField occupation = new TextField("Occupation");
    private TextField address = new TextField("Address");
    private TextField phoneNumber = new TextField("Phone Number");
    private EmailField emailAddress = new EmailField("Email Address");
    private TextField emergencyContactName = new TextField("Emergency Contact Name");
    private TextField emergencyContactRelationship = new TextField("Emergency Contact Relationship");
    private TextField emergencyContactPhoneNumber = new TextField("Emergency Contact Phone Number");
    private TextField primaryCarePhysician = new TextField("Primary Care Physician");
    private TextField allergies = new TextField("Allergies");
    private TextField chronicCondition = new TextField("Chronic Condition");
    private TextField previousSurgeries = new TextField("Previous Surgeries");
    private TextField accountId = new TextField("Account ID");


    Button save=new Button("Save");

    Button delete=new Button("Delete");
    Button cancel=new Button("Cancel");
    Binder<Patients> binder=new BeanValidationBinder<>(Patients.class);


    public PatientsForm() {
        addClassName("Patients-Form");
        // Disable the accountId field
        accountId.setReadOnly(true);
        binder.bindInstanceFields(this);


        add(patientNumber, fullName, dateOfBirth, gender, maritalStatus, occupation,
                address, phoneNumber, emailAddress, emergencyContactName, emergencyContactRelationship,
                emergencyContactPhoneNumber, primaryCarePhysician, allergies, chronicCondition, previousSurgeries,
                accountId,createButtonsLayout());
    }

    public void setPatient(Patients patients){
        binder.setBean(patients);
    }
    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(clickEvent -> validateAndSave());
        delete.addClickListener(clickEvent -> fireEvent(new DeleteEvent(this,binder.getBean())));
        cancel.addClickListener(clickEvent -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(statusChangeEvent -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save,delete,cancel);
    }

    private void validateAndSave() {
        if (binder.isValid()){
            fireEvent(new SaveEvent((this),binder.getBean()));
        }
    }


    // Events
    public static abstract class PatienceFormEvent extends ComponentEvent<PatientsForm> {
        private Patients patients;
        protected PatienceFormEvent(PatientsForm source, Patients patients) {
            super(source, false);
            this.patients = patients;
        }
        public Patients getPatients() {
            return patients;
        }
    }
    public static class SaveEvent extends PatienceFormEvent {
        SaveEvent(PatientsForm source, Patients patients) {
            super(source, patients);
        }
    }
    public static class DeleteEvent extends PatienceFormEvent {
        DeleteEvent(PatientsForm source, Patients patients) {
            super(source, patients);
        }
    }
    public static class CloseEvent extends PatienceFormEvent {
        CloseEvent(PatientsForm source) {
            super(source, null);
        }
    }
    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
