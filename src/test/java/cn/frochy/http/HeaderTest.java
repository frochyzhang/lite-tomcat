/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: HeaderTest
 * Author:   zhangyong
 * Date:     2019/10/16 22:32
 * Description:
 * History:
 */
package cn.frochy.http;

import cn.frochy.http.constants.HttpStatusEnum;
import cn.frochy.http.response.ResponseHeader;

import java.util.Date;

/**
 * 〈func〉<br> 
 * 〈〉
 *
 * @author zhangyong
 * @create 2019/10/16
 * @since 1.0.0
 */
public class HeaderTest {

    public static void main(String[] args) {
        ResponseHeader responseHeader = new ResponseHeader(HttpStatusEnum.OK,
                200,
                "text/html",
                new Date(),
                new Date(),
                "Microsoft-IIS/4.0 ");
        System.out.println(responseHeader.getHeader());
    }
}
