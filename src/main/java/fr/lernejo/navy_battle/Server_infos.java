package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;
import fr.lernejo.navy_battle.handler;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;



public class Server_infos {

    private final String port;
    private final String url;
    private final String message;
    public Server_infos(String port,String url, String message) {
        this.port = port;
        this.url = url;
        this.message = message;
    }

    public String get_port_value(){
        return port;
    }

    public String get_url_value(){
        return url;
    }

    public String get_message_value(){
        return message;
    }

    public JSONObject Write_json()
    {
        JSONObject res = new JSONObject();
        res.put("port",port);
        res.put("url",url);
        res.put("message",message);
        return res;

    }

    public Server_infos Read_json(JSONObject j) {
        Server_infos res = new Server_infos(
                j.getString("port"),
                j.getString("url"),
                j.getString("message")
        );
        return res;
    }


}
