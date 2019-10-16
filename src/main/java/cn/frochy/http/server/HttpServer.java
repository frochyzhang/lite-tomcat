/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HttpServer
 * Author:   zhangyong
 * Date:     2019/10/16 21:49
 * Description:
 * History:
 */
package cn.frochy.http.server;

import cn.frochy.http.constants.HttpStatusEnum;
import cn.frochy.http.response.ResponseHeader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 〈func〉<br>
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/10/16
 * @since 1.0.0
 */
public class HttpServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = server.accept();
                System.out.println(socket.getKeepAlive());
                output = socket.getOutputStream();

                String outStr = "<html> \r\n" +
                        "    <head> \r\n" +
                        "        <title>HTTP Response Example</title> \r\n" +
                        "    </head> \r\n" +
                        "    <body> \r\n" +
                        "        Welcome to Brainy Software \r\n" +
                        "    </body> \r\n" +
                        "</html> \r\n";
                ResponseHeader responseHeader = new ResponseHeader(HttpStatusEnum.OK,
                        outStr.length(),
                        "text/html",
                        new Date(),
                        new Date(),
                        "Microsoft-IIS/4.0 ");
                String res = responseHeader.getHeader() + outStr;
//                System.out.println(res);
                output.write(res.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
