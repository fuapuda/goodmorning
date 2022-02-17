package com.example.website.util;

import com.example.website.ex.FileEmptyException;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<E> {
    private Integer state;
    private String message;
    private E data;

    public static R ok() {
        return new R().setState(State.OK);
    }

    public static <E> R ok(E data) {
        return new R().setState(State.OK).setData(data);
    }

    public static R failure(Integer state, String message) {
        return new R().setState(state).setMessage(message);
    }

    public static R failure(Integer state, Throwable e) {
        return new R().setState(state).setMessage(e.getMessage());
    }

    public interface State {
        int OK = 2000;
        int USERNAME_DUPLICATE_ERR = 2001;
        int USER_NOT_FOUND_ERR = 2002;
        int PASSWORD_NOT_MATCH_ERR = 2003;
        int FILE_EMPTY_ERR = 2004;
        int FILE_SIZE_ERR = 2005;
        int FILE_TYPE_ERR = 2006;
        int FILE_UPLOAD_IO_ERR = 2007;
        int FILE_STATE_ERR = 2008;
        int COMPANY_NAME_DUPLICATE = 2009;
    }
}
