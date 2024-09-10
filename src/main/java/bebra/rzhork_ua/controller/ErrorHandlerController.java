package bebra.rzhork_ua.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        String errorPage = "error";
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = (Integer) status;
            if (statusCode == 400) {
                errorPage = "errors/400";
            }
            if (statusCode == 403) {
                errorPage = "errors/403";
            }
            if (statusCode == 404) {
                errorPage = "errors/404";
            }
            if (statusCode == 405) {
                errorPage = "errors/405";
            }
            if (statusCode == 500) {
                errorPage = "errors/500";
            }
        }
        return errorPage;
    }
}
