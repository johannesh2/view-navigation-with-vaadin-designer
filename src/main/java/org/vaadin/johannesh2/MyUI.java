package org.vaadin.johannesh2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MainLayout layout = new MainLayout();
        setContent(layout);
        Navigator navigator = new Navigator(this, layout.content);
        navigator.addView(DashboardView.VIEW_NAME, DashboardView.class);
        navigator.addView(ReportsView.VIEW_NAME, ReportsView.class);
        navigator.addView(CustomizeView.VIEW_NAME, CustomizeView.class);
        navigator.addView(AdminView.VIEW_NAME, AdminView.class);
        if (navigator.getState().isEmpty()) {
            navigator.navigateTo(DashboardView.VIEW_NAME);
        }        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
