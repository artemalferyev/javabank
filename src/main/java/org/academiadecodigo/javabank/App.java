package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        String profile = Config.SPRING_DEFAULT_PROFILE;
        System.out.println("#### Active Profiles " + profile + " ####");

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile);
        ctx.load(Config.SPRING_CONFIG);
        ctx.refresh();

        Controller controller = ctx.getBean(LoginController.class);
        controller.init();
    }

}
