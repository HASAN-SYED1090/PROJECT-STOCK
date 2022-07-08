package com.project.projectcrypto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class portfolioController implements Initializable {

    @FXML
    private TableColumn<Portfolio, String> cost;

    @FXML
    private TextField no_of_days;

    @FXML
    private TableColumn<Portfolio, String> order_type;

    @FXML
    private TableColumn<Portfolio, String> quantity;

    @FXML
    private TextField req_profit;

    @FXML
    private Button submit;

    @FXML
    private TableView<Portfolio> table;

    @FXML
    private TableColumn<Portfolio, String> ticker;

    @FXML
    void onButtonSubmit(ActionEvent event) {

    }

    public void changeTickerCellEvent(TableColumn.CellEditEvent editedCell) {
        Portfolio tickerSelected = table.getSelectionModel().getSelectedItem();
        tickerSelected.setTicker(editedCell.getNewValue().toString());
    }

    public void changeQuantityCellEvent(CellEditEvent editedCell)
    {
        Portfolio quantity =  table.getSelectionModel().getSelectedItem();
        quantity.setQuantity(editedCell.getNewValue().toString());
    }

    public void changeOrderTypeCellEvent(CellEditEvent editedCell)
    {
        Portfolio order_type =  table.getSelectionModel().getSelectedItem();
        order_type.setOrder_type(editedCell.getNewValue().toString());
    }

    public void changeCostCellEvent(CellEditEvent editedCell)
    {
        Portfolio cost =  table.getSelectionModel().getSelectedItem();
        cost.setCost(editedCell.getNewValue().toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        ticker.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("ticker"));
        quantity.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("quantity"));
        order_type.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("order_type"));
        cost.setCellValueFactory(new PropertyValueFactory<Portfolio, String>("cost"));

        //load dummy data
        table.setItems(getPortfolio());

        //Update the table to allow for the first and last name fields
        //to be editable
        table.setEditable(true);
        ticker.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setCellFactory(TextFieldTableCell.forTableColumn());
        order_type.setCellFactory(TextFieldTableCell.forTableColumn());
        cost.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select multiple rows at once
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }

    public ObservableList<Portfolio>  getPortfolio()
    {
        ObservableList<Portfolio> portfolio = FXCollections.observableArrayList();
        portfolio.add(new Portfolio("TSLA","12","Market", "$123"));
        portfolio.add(new Portfolio("MSFT","2","Limit", "$234"));
        portfolio.add(new Portfolio("F","3", "Market", "$345"));

        return portfolio;
    }

}
