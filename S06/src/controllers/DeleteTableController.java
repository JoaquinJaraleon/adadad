package controllers;

import core.Controller;
import views.DeleteTableView;
import views.EventListView;

public class DeleteTableController extends Controller {

    private DeleteTableView deleteTableView;

    public void run() {
        deleteTableView = new DeleteTableView(this);
    }

    public DeleteTableView getView() {
        return deleteTableView;
    }

    public EventListView getEventListView() {
        return HomeController.getEventListView();
    }
}
