/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ResponseHeader
 * Author:   zhangyong
 * Date:     2019/10/16 22:01
 * Description:
 * History:
 */
package cn.frochy.http.response;

import cn.frochy.http.constants.HttpStatusEnum;

import java.util.Date;

/**
 * 〈func〉<br>
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/10/16
 * @since 1.0.0
 */
public class ResponseHeader {
    private HttpStatusEnum statusEnum;
    private int contentLength;
    private String contentType;
    private Date date;
    private Date lastModified;
    private String server;

    private static String HTTP_VERSION = "HTTP/1.1";
    private static String CRLF = "\r\n";

    public ResponseHeader(HttpStatusEnum statusEnum, int contentLength, String contentType, Date date, Date lastModified, String server) {
        this.statusEnum = statusEnum;
        this.contentLength = contentLength;
        this.contentType = contentType;
        this.date = date;
        this.lastModified = lastModified;
        this.server = server;
    }

    public String getHeader() {
        StringBuilder header = new StringBuilder();
        header.append(this.HTTP_VERSION).append(statusEnum.getHttpStatus()).append(CRLF)
                .append("Server: ").append(server).append(CRLF)
                .append("Date: ").append(date).append(CRLF)
                .append("Content-Type: ").append(contentType).append(CRLF)
                .append("Last-Modified: ").append(lastModified).append(CRLF)
                .append("Content-Length: ").append(contentLength).append(CRLF)
                .append(CRLF);
        return header.toString();
    }
}
