package http.service;

import exception.CatNotFoundException;

public class HttpStatusChecker {
    private static final int[] VALID_STATUS_CODE = new int[]{
            100, 101, 102, 103, 200, 201,
            202, 203, 204, 205, 206, 207,
            300, 301, 302, 303, 304, 305,
            306, 307, 308, 400, 401, 402,
            403, 404, 405, 406, 407, 408,
            409, 410, 411, 412, 413, 414,
            415, 416, 417, 418, 421, 422,
            423, 424, 425, 426, 428, 429,
            431, 451
    };

    public String getStatusImage(int code) throws Exception {
        if(checkStatusCode(code)) {
            return "https://http.cat/" + code + ".jpg";
        } else {
            throw new CatNotFoundException();
        }
    }

    private boolean checkStatusCode(int statusCode) {
        boolean isFlag = false;
        for (int i : VALID_STATUS_CODE) {
            if (statusCode == i) {
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }
}
