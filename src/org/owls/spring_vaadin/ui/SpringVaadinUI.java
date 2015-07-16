package org.owls.spring_vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

//ref : https://vaadin.com/wiki?p_p_id=36&p_p_lifecycle=0&p_p_state=pop_up&p_p_mode=view&_36_advancedSearch=false&p_r_p_185834411_title=I+-+Getting+started+with+Vaadin+Spring&_36_keywords=&_36_delta=5&p_r_p_185834411_nodeName=vaadin.com+wiki&p_r_p_564233524_resetCur=false&_36_viewMode=print&_36_struts_action=%2Fwiki%2Fview&_36_andOperator=true&_36_cur=2
/*
 * sv means Spring-Vaadin
 * */
@Theme(value="valo")
@SpringUI
public class SpringVaadinUI extends UI {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void init(VaadinRequest request) {
		//setContent(new Label("This is root UI!"));
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Button btn = new Button("Click!");
		btn.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Hello, Spring-Vaadin!"));
			}
		});
		layout.addComponent(btn);
	}
};