package com.rimassoft.servlets;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MobileAppServlets extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            JSONObject vObj = new JSONObject();
            vObj.put("URL", req.getRequestURL().toString());
            vObj.put("SessionId", req.getSession().getId());

            String vData = req.getReader().readLine();
            if (vData != null) {
                JSONObject vInData = new JSONObject(vData);
                JSONObject vBody = vInData.getJSONObject("Body");
                vObj.put("Response", "Device name:"+vBody.getString("Device"));
            } else {
                vObj.put("Response", "Error. Wrong request format");
            }

            resp.setContentType("application/json; charset=UTF-8");
            resp.getOutputStream().write(vObj.toString().getBytes("UTF-8"));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (JSONException jse) {
            throw new JSONException("Error parsing JSON request string: "+jse.toString());
        } catch (IOException ioe) {
            //
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            JSONObject vObj = new JSONObject();
            vObj.put("URL", req.getRequestURL().toString());
            vObj.put("SessionId", req.getSession().getId());

            String vData = req.getReader().readLine();
            if (vData != null) {
                JSONObject vInData = new JSONObject(vData);
                JSONObject vBody = vInData.getJSONObject("Body");
                vObj.put("Response", vBody.getString("Device"));
            } else {
                vObj.put("Response", "Error. Wrong request format");
            }

            resp.setContentType("application/json; charset=UTF-8");
            resp.getOutputStream().write(vObj.toString().getBytes("UTF-8"));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (JSONException jse) {
            throw new JSONException("JSON request parsing error: "+jse.toString());
        } catch (IOException ioe) {
            //
        }
    }
}
