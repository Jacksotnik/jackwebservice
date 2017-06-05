package com.rimassoft;

import com.rimassoft.servlets.BrowserServlets;
import com.rimassoft.servlets.MobileAppServlets;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    private static int getPort() {
        String vPort = System.getenv().get("PORT");
        if (vPort != null) {
            return Integer.parseInt(vPort);
        } else {
            return 8080;
        }
    }

    public static void main(String[] args) throws Exception {
        MobileAppServlets vMobile = new MobileAppServlets();
        BrowserServlets vBrowser = new BrowserServlets();
        Server vServer = new Server(getPort());
        ServletContextHandler vContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        vServer.setHandler(vContext);
        vContext.addServlet(new ServletHolder(vMobile), "/mobile/*");
        vContext.addServlet(new ServletHolder(vBrowser), "");

        vServer.start();
        vServer.join();
    }
}
