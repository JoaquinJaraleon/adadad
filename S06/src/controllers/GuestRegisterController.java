package controllers;

import core.Controller;
import views.GuestRegisterView;

public class GuestRegisterController extends Controller {

    private GuestRegisterView registerGuestView;

    public void run() {
        registerGuestView = new GuestRegisterView();
    }

    public GuestRegisterView getView() {
        return registerGuestView;
    }
}
