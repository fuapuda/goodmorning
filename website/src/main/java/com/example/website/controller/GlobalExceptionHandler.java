package com.example.website.controller;

import com.example.website.ex.*;
import com.example.website.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public R handleException(Throwable e) {
        R r = new R();
        if (e instanceof UsernameDuplicateException) {
            return R.failure(R.State.USERNAME_DUPLICATE_ERR, e.getMessage());
        } else if (e instanceof UserNotFoundException) {
            return R.failure(R.State.USER_NOT_FOUND_ERR, e.getMessage());
        } else if (e instanceof PasswordNotMatchException) {
            return R.failure(R.State.PASSWORD_NOT_MATCH_ERR, e.getMessage());
        } else if (e instanceof FileEmptyException) {
            return R.failure(R.State.FILE_EMPTY_ERR, e.getMessage());
        } else if (e instanceof FileTypeException) {
            return R.failure(R.State.FILE_TYPE_ERR, e.getMessage());
        } else if (e instanceof FileSizeException) {
            return R.failure(R.State.FILE_SIZE_ERR, e.getMessage());
        } else if (e instanceof FileUploadIOException){
            return R.failure(R.State.FILE_UPLOAD_IO_ERR, e.getMessage());
        } else if (e instanceof FileStateException) {
            return R.failure(R.State.FILE_STATE_ERR, e.getMessage());
        } else if (e instanceof CompanyNameDuplicateException) {
            return R.failure(R.State.COMPANY_NAME_DUPLICATE, e.getMessage());
        }
        return null;
    }
}
