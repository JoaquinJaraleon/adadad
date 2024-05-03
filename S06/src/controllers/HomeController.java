package controllers;

import core.Controller;
import views.*;

public class HomeController extends Controller {

    private HomeView homeView;
    private static EventListController eventListController = new EventListController();
    private NewEventController newEventController = new NewEventController(eventListController);
    private DeleteTableController deleteTableController = new DeleteTableController();
    private GuestRegisterController guestRegisterController = new GuestRegisterController();

    @Override
    public void run() {
        eventListController.run();
        newEventController.run();
        deleteTableController.run();
        guestRegisterController.run();

        homeView = new HomeView(this, mainFrame);
        addView("HomeView", homeView);

        mainFrame.setVisible(true);
    }

    public static EventListView getEventListView() {
        return eventListController.getView();
    }

    public NewEventView getNewEventView() {
        return newEventController.getView();
    }

    public DeleteTableView getDeleteTableView() {
        return deleteTableController.getView();
    }

    public GuestRegisterView getRegisterGuestView() {
        return guestRegisterController.getView();
    }
}
