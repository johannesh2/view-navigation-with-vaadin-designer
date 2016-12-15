package org.vaadin.johannesh2;

import com.vaadin.ui.UI;

public class MainLayout extends MainLayoutDesign {
	public MainLayout() {
		dashboard.addClickListener(event -> doNavigate(DashboardView.VIEW_NAME));
		reports.addClickListener(event -> doNavigate(ReportsView.VIEW_NAME));
		customize.addClickListener(event -> doNavigate(CustomizeView.VIEW_NAME));
		admin.addClickListener(event -> doNavigate(AdminView.VIEW_NAME));
	}

	private void doNavigate(String viewName) {
		UI.getCurrent().getNavigator().navigateTo(viewName);
	}
}
